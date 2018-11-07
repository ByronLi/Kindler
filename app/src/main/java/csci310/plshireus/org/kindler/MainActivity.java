package csci310.plshireus.org.kindler;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import com.huxq17.swipecardsview.SwipeCardsView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import csci310.plshireus.org.kindler.objects.Model;

import java.util.List;
import java.util.ArrayList;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.util.Log;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import java.util.concurrent.CountDownLatch;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public SwipeCardsView swipecardsView;
    public FeedAdapter cardAdapter;
    public List<Model> modelList = new ArrayList<>(); // list for the feed
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipecardsView = (SwipeCardsView)findViewById(R.id.swipeCardsView);
        swipecardsView.retainLastCard(false);
        swipecardsView.enableSwipe(true);

        modelList = new ArrayList<>();

        getData();

        swipecardsView.setCardsSlideListener(new SwipeCardsView.CardsSlideListener() {
            @Override
            public void onShow(int index) {
                //curIndex = index;
               // LogUtils.i("test showing index = " + index);
            }

            @Override
            public void onCardVanish(int index, SwipeCardsView.SlideType type) {
                String orientation = "";
                switch (type) {
                    case LEFT:
                        orientation = "向左飞出";
                        System.out.println("HOLY SHET IT WENT LEFT");
                        break;
                    case RIGHT:
                        orientation = "向右飞出";
                        System.out.println("HOLY SHET IT WENT RIGHT");
                        break;
                }
//                toast("test position = "+index+";卡片"+orientation);
            }

            @Override
            public void onItemClick(View cardImageView, int index) {
                //toast("position= " + index);
            }
        });

        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.addBookButton);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent createBook = new Intent(getApplicationContext(), CreateBook.class);
                startActivity(createBook);

            }
        });

        Button refreshButton = (Button) findViewById(R.id.refreshButton);
        refreshButton.setText("Refresh");

        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                swipecardsView.setAdapter(cardAdapter); //this is what shows the feed
            }
        });


    }


    public void getData(){

        //wait until data is retrieved from the database

        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = mDatabase.getReference("books");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated

                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){

                        String tit = (String) snapshot.child("title").getValue();
                        String img = (String) snapshot.child("imageURL").getValue();

                        Model curr_model = new Model(tit, img);
                        System.out.println("-------------@@@@@@--------------");
                        System.out.println(curr_model.title);
                        System.out.println(curr_model.imageURL);

                        modelList.add(curr_model);
                        cardAdapter.updateList(modelList);
                        swipecardsView.postInvalidate();

                    }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                System.out.println("----------########-------" + error);
            }
        });

       // modelList.add(new Model("JKROWLING","fantasy", "https://vignette.wikia.nocookie.net/harrypotter/images/0/0e/Philostone.jpg/revision/latest?cb=20180318153750", "fd", "100", "Harry Potter"));

       // modelList.add(new Model("Harry Potter 1","https://vignette.wikia.nocookie.net/harrypotter/images/0/0e/Philostone.jpg/revision/latest?cb=20180318153750"));

      //  modelList.add(new Model("50 shades of grey","https://m.media-amazon.com/images/M/MV5BMjE1MTM4NDAzOF5BMl5BanBnXkFtZTgwNTMwNjI0MzE@._V1_.jpg"));
       // modelList.add(new Model("To kill a mockingbird", "https://images-na.ssl-images-amazon.com/images/I/71FxgtFKcQL.jpg"));
       // modelList.add(new Model("Hunger games", "https://upload.wikimedia.org/wikipedia/en/thumb/3/39/The_Hunger_Games_cover.jpg/220px-The_Hunger_Games_cover.jpg"));

        cardAdapter = new FeedAdapter(modelList,this);
        swipecardsView.setAdapter(cardAdapter);

    }





}
