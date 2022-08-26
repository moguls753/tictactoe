import de.mpaap.util.com.Communicator;
import de.mpaap.util.com.CommunicatorException;

public class CommunicatorTest {
    public static void main(String[] args) throws CommunicatorException {
        Communicator test = new Communicator("localhost", 7890, "UTF-8");
        String zug = "xxxox_xoo";
        String response = test.communicate(zug + "\n");
        System.out.println(response);
        int responseAsInt = Integer.parseInt(response.trim())-1;
        System.out.println(responseAsInt);
        int row = responseAsInt / 3;
        int column = responseAsInt % 3;
        System.out.println(row + " " + column);
    }
}
