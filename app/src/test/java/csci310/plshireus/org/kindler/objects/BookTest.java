package csci310.plshireus.org.kindler.objects;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void getAndSetOwnerUIDTest() throws Exception {
        Book b = new Book("owner", "1984", "George Orwell", "fiction", 20, "https://imgmanagercb-a.akamaihd.net/livros/1984-george-orwell-1328869334_300x300-PU43867b95_1.jpg");
        assertEquals("owner",b.getOwnerUID());
        b.setOwnerUID("54822");
        assertEquals("54822",b.getOwnerUID());
    }

    @Test
    public void getAndSetAuthorTest() throws Exception {
        Book b = new Book("owner", "1984", "George Orwell", "fiction", 20, "https://imgmanagercb-a.akamaihd.net/livros/1984-george-orwell-1328869334_300x300-PU43867b95_1.jpg");
        assertEquals("George Orwell",b.getAuthor());
        b.setAuthor("Ernest Hemingway");
        assertEquals("Ernest Hemingway",b.getAuthor());
    }

    @Test
    public void getAndSetTitleTest() {
        Book b = new Book("owner", "1984", "George Orwell", "fiction", 20, "https://imgmanagercb-a.akamaihd.net/livros/1984-george-orwell-1328869334_300x300-PU43867b95_1.jpg");
        assertEquals("1984",b.getTitle());
        b.setTitle("Animal Farm");
        assertEquals("Animal Farm",b.getTitle());
    }

    @Test
    public void getAndSetPriceTest() {
        Book b = new Book("owner", "1984", "George Orwell", "fiction", 20, "https://imgmanagercb-a.akamaihd.net/livros/1984-george-orwell-1328869334_300x300-PU43867b95_1.jpg");
        assertEquals(20,b.getPrice(),0);
        b.setPrice(40.1);
        assertEquals(40.1,b.getPrice(),0);
    }

    @Test
    public void getAndSetGenreTest() throws Exception {
        Book b = new Book("owner", "1984", "George Orwell", "fiction", 20, "https://imgmanagercb-a.akamaihd.net/livros/1984-george-orwell-1328869334_300x300-PU43867b95_1.jpg");
        assertEquals("fiction",b.getGenre());
        b.setGenre("fantasy");
        assertEquals("fantasy",b.getGenre());
    }
}