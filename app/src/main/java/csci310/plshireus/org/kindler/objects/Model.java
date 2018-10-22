package csci310.plshireus.org.kindler.objects;

public class Model {
    public String author, genre, imageURL, ownerUID, price, title;

    public Model(String author, String genre, String imageURL, String ownerUID, String price, String title){
        this.author = author;
        this.genre = genre;
        this.imageURL = imageURL;
        this.ownerUID = ownerUID;
        this.price = price;
        this.title = title;
    }
    public Model(String title, String imageURL){
        this.title = title;
        this.imageURL = imageURL;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getImage(){
        return imageURL;
    }


}
