package ubcomputerscience.odmrp.nodemessaging;
import java.net.UnknownHostException;

import ubcomputerscience.odmrp.constants.Constants;
import ubcomputerscience.odmrp.exceptions.NotSupportedException;
import ubcomputerscience.odmrp.exceptions.PacketFormatException;

import java.net.UnknownHostException;

/**
 * Created by Gautam on 8/24/16.
 */

 public class Message
{

        /**
         *  Size of the Message, in bytes
         */
        protected int _messageLength;


        public int getMessageLength() {
            return _messageLength;
        }

        protected int _type;

        public int getType() {
            return _type;
        }

        public Message()
        {

        }

        public Message(byte[] payload, int start)
        {

        }

        public void encodeAddress(byte[] fromArray, byte[] toArray, int start) {
            for (int i = 0; i < fromArray.length; i++) {
                toArray[start + i] = fromArray[i];
            }
        }


        public static Message Parse(byte[] payload, int start) throws PacketFormatException, UnknownHostException, NotSupportedException {
            System.out.println("Parsing message from payload, start = " + start);
            switch (payload[start]) {
                case Constants.JOINQUERY_TYPE:
                    return new JoinQuery(payload, start);
                case Constants.JOINREPLY_TYPE:
                    return new JoinReply(payload, start);
                default:
                    throw new PacketFormatException("Unknown message type: " + payload[start]);
            }
        }

        public byte[] toBytes() {
            return null;
        }
    }
}
