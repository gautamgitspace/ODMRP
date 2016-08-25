package ubcomputerscience.odmrp.constants;

/**
 * Created by Gautam on 8/24/16.
 */
public enum MessageType
{
    JOINQUERY(127),
    JOINREPLY(128);

    private int value;

    private MessageType(int value) {
        this.value = value;
    }
}