package csci310.plshireus.org.kindler.objects;

import org.junit.Test;



import static org.junit.Assert.*;

public class ForSaleTest {

    @Test
    public void addBookTest() throws Exception {
        Book b = new Book("owner", "1984", "George Orwell", "fiction", 20, "https://imgmanagercb-a.akamaihd.net/livros/1984-george-orwell-1328869334_300x300-PU43867b95_1.jpg");
        ForSale f = new ForSale();
        f.addBook(b);
    }
}