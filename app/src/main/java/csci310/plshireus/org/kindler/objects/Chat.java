package csci310.plshireus.org.kindler.objects;

import java.util.Set;

public class Chat {

    private Set<User> participants;

    public Chat(User u1, User u2){
        this.participants.add(u1);
        this.participants.add(u2);
    }

    public Set<User> getParticipants(){
        return participants;
    }
}
