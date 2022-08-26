package foo;

public class Model implements IModel {

    private EFieldState[][] fieldStates = new EFieldState[3][3];

    public Model() {
        for (int i = 0; i < fieldStates.length; i++) {
            for (int j = 0; j < fieldStates[i].length; j++) {
                fieldStates[i][j] = EFieldState.EMPTY;
            }
        }
    }

    @Override
    public EFieldState getFieldState(int row, int column) {
        return fieldStates[row][column];
    }

    @Override
    public void setFieldState(int row, int column, EFieldState state) {
        fieldStates[row][column] = state;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < fieldStates.length; i++) {
            for (int j = 0; j < fieldStates[i].length; j++) {
                s += fieldStates[i][j].getSymbol();
            }
            s += "\n";
        }
        return s;

    }

    @Override
    public String toServerString() {
        String s = "";
        for (int i = 0; i < fieldStates.length; i++) {
            for (int j = 0; j < fieldStates[i].length; j++) {
                s += fieldStates[i][j].getSymbol();
            }
        }
        return s + "\n";
    }
}
