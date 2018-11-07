package csci310.plshireus.org.kindler.objects;

public class Book {

    private String ownerUID;
    private String title;
    private String author;
    private String genre;
    private double price;
    private String imageURL;
    private String ownerEmail;

    public Book(String ownerUID, String title, String author, String genre, double price, String imageURL, String ownerEmail) {
        this.ownerUID = ownerUID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.imageURL = imageURL;
        this.ownerEmail = ownerEmail;
    }

    public String getOwnerUID() {
        return ownerUID;
    }

    public void setOwnerUID(String ownerUID) {
        this.ownerUID = ownerUID;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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

    public String getOwnerEmail(){ return ownerEmail; }
}
