import java.util.*;

public class Book {
    private String title;
    private String author;
    private String genre;

    public Book(String title, String author, String genre){
        this.title = title;
        this.author = author;
        this.genre = genre;
    }
    
    public void setTitle(String newTitle){
        this.title = newTitle;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }
    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getGenre(){
        return genre;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(!(obj instanceof Book)) {
            return false;
        }

        Book book = (Book) obj;
        return (title.equals(book.title) && author.equals(book.author) && genre.equals(book.genre));
    }

    @Override
    public int hashCode(){
        return Objects.hash(title, author, genre);
    }

    @Override
    public String toString(){
        return title + " by " + author;
    }

}
