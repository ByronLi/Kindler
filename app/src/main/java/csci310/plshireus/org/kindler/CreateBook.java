package csci310.plshireus.org.kindler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import csci310.plshireus.org.kindler.objects.Book;

public class CreateBook extends AppCompatActivity {

    Button createListing;
    EditText bookTitle;
    EditText bookAuthor;
    Spinner genreSpinner;
    EditText bookPrice;
    EditText bookImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_book);

        genreSpinner = (Spinner) findViewById(R.id.spinnerGenres);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.genres, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        genreSpinner.setAdapter(adapter);

        bookTitle = (EditText) findViewById(R.id.bookName);
        bookAuthor = (EditText) findViewById(R.id.authorName);
        bookPrice = (EditText) findViewById(R.id.bookPrice);
        bookImage = (EditText) findViewById(R.id.bookImageUrlEditText);

        createListing = (Button) findViewById(R.id.createBookButton);
        createListing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{

                    String title = bookTitle.getText().toString();
                    String author = bookAuthor.getText().toString();
                    String genre = genreSpinner.getSelectedItem().toString();
                    String uid = FirebaseAuth.getInstance().getUid();
                    double price = Double.valueOf(bookPrice.getText().toString());
                    String url = bookImage.getText().toString();

                    //**added current users email to the book so we can search
                    String creatorsEmail =  FirebaseAuth.getInstance().getCurrentUser().getEmail();

                    Book b = new Book(uid, title, author, genre, price, url, creatorsEmail);
                    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                    DatabaseReference ref = firebaseDatabase.getReference("books");
                    DatabaseReference bookRef = ref.push();
                    bookRef.setValue(b);

                    finish();
                }
                catch (Exception e){

                }
            }
        });


    }


}
