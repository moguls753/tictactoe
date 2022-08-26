import foo.*;

public class ComponentTest {

    public static void main(String[] args) {
        IModel model = new Model();
        model.setFieldState(2, 1, EFieldState.CIRCLE);
        model.setFieldState(0, 2, EFieldState.CROSS);
        TicTacToeBoardPanel comp = new TicTacToeBoardPanel(model);
        JComponentTestFrame frame = new JComponentTestFrame(comp);
        System.out.println(model);
        comp.setMoveListener(new IMoveListener() {

            @Override
            public void moveOccurred(int row, int column) {
                System.out.println(row + " " + column);
            }
        });
    }
}
