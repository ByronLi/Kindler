package csci310.plshireus.org.kindler;

import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import csci310.plshireus.org.kindler.objects.User;

public class ViewProfile extends AppCompatActivity {
    private User mUser;

    public void DisplayProfile() {
        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = mDatabase.getReference("Users");

    }

}