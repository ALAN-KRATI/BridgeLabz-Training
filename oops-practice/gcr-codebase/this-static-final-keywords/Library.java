import java.util.*;

public class Library{
    private static String libraryName = "Book Haven";
    private String bookName;
    private String author;
    private final String isbn;

    Library(String bookName, String author, String isbn){
        this.bookName = bookName;
        this.author = author;
        this.isbn = isbn;
    }

    public String getBookName() {return bookName;}
    public String getAuthor() {return author;}
    public String getIsbn() {return isbn;}
    public void displayLibraryName() {System.out.println(libraryName);}
    public void displayBookDetails(){
       if (this instanceof Library) {
           System.out.println("Title: " + bookName);
           System.out.println("Author: " + author);
           System.out.println("ISBN: " + isbn);
        } 
        else {
           System.out.println("The object is not an instance of the Book class.");
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        String author = sc.nextLine();
        String isbn = sc.nextLine();

        Library book1 = new Library(title, author, isbn);
        System.out.println();
        System.out.println();
        book1.displayLibraryName();
        book1.displayBookDetails();
    }

}