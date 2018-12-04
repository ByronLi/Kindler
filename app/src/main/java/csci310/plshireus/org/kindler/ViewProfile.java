package csci310.plshireus.org.kindler;

import android.support.v7.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import csci310.plshireus.org.kindler.objects.User;
import android.os.Bundle;
import android.widget.EditText;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class ViewProfile extends AppCompatActivity {
    private User mUser;
    EditText nameText;
    EditText emailText;
    EditText matchesText;
    public static HashMap<String,List<String>> allMatches = new HashMap<String, List<String>>();
    public static ArrayList<String> shit = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //nameText = (EditText) findViewById(R.id.Name);
        emailText = (EditText) findViewById(R.id.Email);
        matchesText = (EditText) findViewById(R.id.Matches);

        try{
            MainActivity.checkMatch();
            String matchString = "";
            String creatorsEmail =  FirebaseAuth.getInstance().getCurrentUser().getEmail();

            System.out.println(creatorsEmail + " ----- " + MainActivity.matches.size());

               if(shit.size()>0){
                   for(int i=0;i<shit.size();i++){
                       matchString += shit.get(i) + " ";
                   }
               }





            matchesText.setText("Matches: " + matchString);
            emailText.setText("Email: " + creatorsEmail);

        }catch(Exception e){
            System.out.println("Couldn't show profile because " + e);
        }

    }


    public void DisplayProfile() {
        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = mDatabase.getReference("Users");

    }


}