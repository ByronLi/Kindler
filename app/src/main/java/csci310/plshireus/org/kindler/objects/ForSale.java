package csci310.plshireus.org.kindler.objects;

import java.util.List;

public class ForSale {

    private List<Book> forSale;

    public void addBook(Book b){
        forSale.add(b);
    }
    public void deleteBook(Book b){
        forSale.remove(b);
    }
    public String displayForSale(){
        String temp = "";
        for(Book b:forSale){
            temp += b.getTitle() + ", ";
        }
        return temp;
    }
    public String displayTagForSale(String tag){
        String temp = "";
        for(Book b:forSale){
            if (b.getAuthor().equals(tag) || b.getTitle().equals(tag) || b.getGenre().equals(tag) || b.getOwnerUID().equals(tag)){
                temp += b.getTitle() + ", ";
            }
        }
        return temp;
    }
}
