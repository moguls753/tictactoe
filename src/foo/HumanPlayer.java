package foo;

import java.awt.Point;

public class HumanPlayer implements IPlayer, IMoveListener {

    private Point move;
    private IInputDevice inputDevice;

    public HumanPlayer(IInputDevice inputDevice) {
        this.inputDevice = inputDevice;
    }

    @Override
    public void moveOccurred(int row, int column) {
        move = new Point(row, column);
    }

    @Override
    public Point getNextMove(String situation) throws PlayerException {
        move = null;
        inputDevice.setMoveListener(this);
        while (move == null) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return move;
    }

}
