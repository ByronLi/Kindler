package csci310.plshireus.org.kindler;
import android.view.View;
import com.huxq17.swipecardsview.BaseCardAdapter;
import java.util.List;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import csci310.plshireus.org.kindler.objects.Model;
import android.widget.BaseAdapter;

public class FeedAdapter extends BaseCardAdapter{
    private List<Model> modelList;
    private Context context;

    public FeedAdapter(List<Model> modelList, Context context){
        this.modelList = modelList;
        this.context = context;

    }
    public void updateList(List<Model> modelList){
        this.modelList = modelList;

    }
    public int getCount(){
        return modelList.size();

    }

    public int getCardLayoutId(){
        return R.layout.feed_item;
    }

    public void onBindData(int position, View cardview){
        if(modelList == null|| modelList.size() ==0){
            return;
        }
        ImageView imageview = (ImageView) cardview.findViewById(R.id.imageView);
        TextView textview = (TextView) cardview.findViewById(R.id.textView);
        Model model = modelList.get(position);
        textview.setText(model.getTitle());
        Picasso.with(context).load(model.getImage()).into(imageview);

    }

}
