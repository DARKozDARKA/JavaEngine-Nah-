package Services.TickUpdater;

import java.util.ArrayList;

public class TickUpdater implements ITickUpdater {
    private Thread _gameThread;
    private ArrayList<ITickable> _tickables = new ArrayList<>();
    private long _lastTime;

    public void RegisterTickable(ITickable tickable){
        _tickables.add(tickable);
    }

    @Override
    public void Start() {
        _gameThread = new Thread(this);
        _gameThread.start();
    }

    @Override
    public void run() {
        while (_gameThread != null)
            Tick();
    }

    private void Tick() {
        long currentTime = System.nanoTime();
        long deltaTime = currentTime - _lastTime;
        _lastTime = currentTime;

        float deltaTimeInSeconds = deltaTime / 1_000_000_000.0f;

        for (ITickable tickable : _tickables) {
            tickable.Tick(deltaTimeInSeconds);
        }

        try {
            Thread.sleep(16); // ~60 FPS (1000ms / 60 = ~16ms per frame)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
