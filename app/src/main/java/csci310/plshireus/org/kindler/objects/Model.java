package csci310.plshireus.org.kindler.objects;

import com.google.firebase.auth.FirebaseAuth;

public class Model {
    public String author, genre, imageURL, ownerUID, price, title;

    public Model(String author, String price, String imageURL, String genre, String ownerUID, String title){
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
    public Model(){
        this.author = "dummmy";
        this.genre = "dummy";
        this.imageURL = "https://vignette.wikia.nocookie.net/starwars/images/0/07/Yoda_cartoon.jpg/revision/latest?cb=20050421025718";
        this.ownerUID = "dummy";
        this.price = "1000000";
        this.title = "dummy title";
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
