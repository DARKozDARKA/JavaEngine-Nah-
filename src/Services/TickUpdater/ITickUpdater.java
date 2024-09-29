package Services.TickUpdater;

import FakeDIContainer.IService;

public interface ITickUpdater extends IService, Runnable {
     void RegisterTickable(ITickable tickable);
     void Start();
}
