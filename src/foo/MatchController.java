package foo;

import java.awt.Point;
import java.util.List;

public class MatchController {

    private IPlayer firstPlayer, secondPlayer;
    private IModel model;
    private List<IView> views;

    public MatchController(IPlayer firstPlayer, IPlayer secondPlayer, IModel model, List<IView> views) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.model = model;
        this.views = views;
    }

    public void play() {
        for (int i = 0; i < 9; i++) {
            boolean even = i % 2 == 0;
            IPlayer currentPlayer = even ? firstPlayer : secondPlayer;
            try {
                Point move = currentPlayer.getNextMove(model.toServerString());
                model.setFieldState(move.x, move.y, even ? EFieldState.CROSS : EFieldState.CIRCLE);
                for (IView view : views) {
                    view.refresh();
                }
            } catch (PlayerException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.exit(0);
            }
        }
    }
}
