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

public class MainActivity extends AppCompatActivity {

    private SwipeCardsView swipecardsView;
    private List<Model> modelList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipecardsView = (SwipeCardsView)findViewById(R.id.swipeCardsView);
        swipecardsView.retainLastCard(false);
        swipecardsView.enableSwipe(true);
        getData();

        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.addBookButton);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent createBook = new Intent(getApplicationContext(), CreateBook.class);
                startActivity(createBook);
            }
        });

    }

    private void getData(){
        modelList.add(new Model("Harry Potter 1","https://vignette.wikia.nocookie.net/harrypotter/images/0/0e/Philostone.jpg/revision/latest?cb=20180318153750"));
        modelList.add(new Model("50 shades of grey","https://m.media-amazon.com/images/M/MV5BMjE1MTM4NDAzOF5BMl5BanBnXkFtZTgwNTMwNjI0MzE@._V1_.jpg"));
        modelList.add(new Model("To kill a mockingbird", "https://images-na.ssl-images-amazon.com/images/I/71FxgtFKcQL.jpg"));
        modelList.add(new Model("Hunger games", "https://upload.wikimedia.org/wikipedia/en/thumb/3/39/The_Hunger_Games_cover.jpg/220px-The_Hunger_Games_cover.jpg"));
        FeedAdapter cardAdapter = new FeedAdapter(modelList,this);
        swipecardsView.setAdapter(cardAdapter);
    }




}
