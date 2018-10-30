package csci310.plshireus.org.kindler;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;
import android.content.Context;
import csci310.plshireus.org.kindler.objects.Model;
import java.util.List;
import java.util.ArrayList;

public class ModelUnitTest {

    @Test
    public void getTitleTest() throws Exception {
        //makes sure we get the correct title
        Model m = new Model("Harry Potter", "1010");

        assertEquals("Harry Potter", m.getTitle());

    }

    @Test
    public void getImageTest() throws Exception {
        //makes sure we get the correct image
        Model m = new Model("Harry Potter","1010");

        assertEquals("1010",m.getImage());
    }

    @Test
    public void setTitleTest() throws Exception{
        //makes sure our setTitle sets the title correctly
        Model m = new Model("Harry Potter","1010");

        m.setTitle("Not Harry Potter");
        assertEquals("Not Harry Potter", m.getTitle());
    }
}
