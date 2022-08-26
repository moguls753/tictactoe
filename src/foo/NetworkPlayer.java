package foo;

import java.awt.Point;

import de.mpaap.util.com.Communicator;
import de.mpaap.util.com.CommunicatorException;

public class NetworkPlayer implements IPlayer {

    private Communicator comm;
    private final String ENCODING = "UTF-8";
    private final int PORT = 7890;

    public NetworkPlayer(String host) {
        comm = new Communicator(host, PORT, ENCODING);
    }

    @Override
    public Point getNextMove(String situation) throws PlayerException {
        try {
            String response = comm.communicate(situation);
            if (response.startsWith("Error")) {
                throw new PlayerException(response);
            }
            int responseAsInt = Integer.parseInt(response.trim()) - 1;
            int row = responseAsInt / 3;
            int column = responseAsInt % 3;
            return new Point(row, column);
        } catch (CommunicatorException | NumberFormatException e) {
            throw new PlayerException(e);
        }
    }

}
