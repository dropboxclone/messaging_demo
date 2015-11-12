package Msg;

import com.hazelcast.config.Config;
import com.hazelcast.core.*;
 
public class MsgPoint implements MessageListener<Point> {
    public void onMessage(Message<Point> message) {
        System.out.println("Got Point : " + message.getMessageObject());
    }
}