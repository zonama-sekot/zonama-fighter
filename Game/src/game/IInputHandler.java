package game;

/**
 * Created by gngeorgiev on 15.05.14.
 */
public interface IInputHandler {

    public void LeftArrowPressed();

    public void RightArrowPressed();

    public void UpArrowPressed();

    public void DownArrowPressed();

    public void KeyPressed(int keyCode);
}
