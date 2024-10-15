package Services.Input;

import Engine.FakeDIContainer.IService;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

public interface IInputDetector extends KeyListener, MouseListener, IService {
    void AddInputListener(IInputListener listener);
}
