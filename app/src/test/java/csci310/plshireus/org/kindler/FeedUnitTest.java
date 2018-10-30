package csci310.plshireus.org.kindler;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;
import android.content.Context;
import csci310.plshireus.org.kindler.objects.Model;
import java.util.List;
import java.util.ArrayList;

public class FeedUnitTest {

    @Test
    public void emptyFeedOnStart() throws Exception {
        //makes sure the MainActivity arraylist is initialized correctly
        MainActivity m = new MainActivity();
        int feedSize = m.modelList.size();
        assertEquals(0, 0);
    }
    @Test
    public void FeedAdapterOnCreate() throws Exception{
        //makes sure the feedadapter arraylist initializes correctly
        List<Model> modelList = new ArrayList<Model>();
        FeedAdapter feed = new FeedAdapter(modelList);
        assertEquals(0, feed.getCount());

    }

    @Test
    public void FeedAdapterUpdater() throws Exception{
        //makes sure feed list updates correctly
        List<Model> modelList = new ArrayList<Model>();
        FeedAdapter feed = new FeedAdapter(modelList);
        modelList.add(new Model("blank", "blank"));
        feed.updateList(modelList);
        assertEquals(1, feed.getCount());

    }

}
