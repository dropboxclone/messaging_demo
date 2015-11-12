package Msg;

import com.hazelcast.config.Config;
import com.hazelcast.core.*;
 
public class BroadMess implements MessageListener<String> {
    public static void main(String[] args) {
        Config config = new Config();
        HazelcastInstance h = Hazelcast.newHazelcastInstance(config);
        ITopic<String> topic = h.getTopic("my-distributed-topic");
        topic.addMessageListener(new BroadMess());
        topic.publish("Hello to distributed world");

        ITopic<Point> tp = h.getTopic("Points");
        tp.addMessageListener(new MsgPoint());
        tp.publish(new Point(10,15));
    }
 
    @Override
    public void onMessage(Message<String> message) {
        System.out.println("Got message " + message.getMessageObject());
    }
}