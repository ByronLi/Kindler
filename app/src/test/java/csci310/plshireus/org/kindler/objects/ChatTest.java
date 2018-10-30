package csci310.plshireus.org.kindler.objects;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChatTest {

    @Test
    public void getParticipants() throws Exception {
        User u1 = new User("Joe", "joe@joe.com");
        User u2 = new User("Jim", "jim@joe.com");
        Chat c = new Chat(u1,u2);
    }
}