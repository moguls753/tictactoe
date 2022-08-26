package foo;

public interface IModel {
    
    public EFieldState getFieldState(int row, int column);
    
    public void setFieldState(int row, int column, EFieldState state);

    String toServerString();
    
}
