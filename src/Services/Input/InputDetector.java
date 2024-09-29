package Services.Input;

import FakeDIContainer.IService;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class InputDetector implements IInputDetector {

    private ArrayList<IKeyInputListener> _keyListeners = new ArrayList<IKeyInputListener>();
    private ArrayList<IMouseInputListener> _mouseListeners = new ArrayList<IMouseInputListener>();

    public void AddKeyListener(IKeyInputListener listener){
        _keyListeners.add(listener);
    }

    public void AddMouseListener(IMouseInputListener listener){
        _mouseListeners.add(listener);
    }

    @Override
    public void AddInputListener(IInputListener listener){
        AddMouseListener(listener);
        AddKeyListener(listener);
    }

    private void BroadcastMousePressed(MouseEvent mouseEvent){
        for (IMouseInputListener listener : _mouseListeners) {
            listener.OnMouseInput(mouseEvent);
        }
    }

    private void BroadcastKeyPressed(KeyEvent keyEvent){
        for (IKeyInputListener listener : _keyListeners) {
            listener.OnKeyInput(keyEvent);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        BroadcastKeyPressed(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        BroadcastMousePressed(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
