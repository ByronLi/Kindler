package csci310.plshireus.org.kindler.objects;

public class UserProfile {
    private User mUser;

    public void setUser(User u) { mUser = u; }
    public User getUser() { return mUser; }

    public String displayProfile() {
        String toDisplay = displayName() + "\n" + displayEmail() + "\n" + displayBio();
        return toDisplay;
    }

    public String displayEmail() {
        return mUser.getEmail();
    }

    public String displayName() {
        return mUser.getName();
    }

    public String displayBio() {
        return mUser.getBio();
    }

}
