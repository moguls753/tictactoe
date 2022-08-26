import java.util.ArrayList;
import java.util.List;

import foo.*;

public class MatchControllerTest {

    public static void main(String[] args) {
//        IPlayer player1 = new IPlayer() {
//
//            @Override
//            public Point getNextMove(String situation) {
//                return new Point(1, 0);
//            }
//        };
//        IPlayer player2 = new IPlayer() {
//
//            @Override
//            public Point getNextMove(String situation) {
//                return new Point(2, 1);
//            }
//        };
        IModel model = new Model();
        IView view = new ConsoleView(model);
        TicTacToeBoardPanel boardView = new TicTacToeBoardPanel(model);
        List<IView> views = new ArrayList<IView>();
        views.add(view);
        views.add(boardView);
        JComponentTestFrame frame = new JComponentTestFrame(boardView);
        // IPlayer player1 = new NetworkPlayer("localhost");
        IPlayer player1 = new HumanPlayer(boardView);
        IPlayer player2 = new NetworkPlayer("localhost");
        MatchController m1 = new MatchController(player1, player2, model, views);
        m1.play();
    }
}
