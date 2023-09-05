package ch.zli.m223;

import ch.zli.m223.model.Message;
import ch.zli.m223.model.Member;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MessageServiceTest {

    @Test
    public void testCreateMessage() {
   
        Member sender = new Member();
        sender.setName("sender_username");

        Member receiver = new Member();
        receiver.setName("receiver_username");

        Message message = new Message();
        message.setSender(sender);
        message.setReceiver(receiver);
        message.setContent("Test message");
        message.setTimestamp(new Date());


        assertNotNull(message);
        assertNotNull(message.getSender());
        assertNotNull(message.getReceiver());
        assertNotNull(message.getContent());
        assertNotNull(message.getTimestamp());
    }
}
