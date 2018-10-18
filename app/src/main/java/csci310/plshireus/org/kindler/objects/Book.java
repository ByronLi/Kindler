package csci310.plshireus.org.kindler.objects;

public class Book {

    private int bookID;
    private User owner;
    private String title;
    private String author;
    private String genre;
    private double price;

    public Book(int bookID, User owner, String title, String author, String genre, double price) {
        this.bookID = bookID;
        this.owner = owner;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
