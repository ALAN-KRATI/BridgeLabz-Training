import java.util.*;


public class Library {
    Map<String, LinkedList<Book>> bookshelf = new HashMap<>();
    Set<Book> books = new HashSet<>();

    public void addBook(Book book){
        if(books.add(book)){
            bookshelf.computeIfAbsent(book.getGenre(), g -> new LinkedList<>()).add(book);
            System.out.println("Book Added successfully!");
        }
        else{
            System.out.println("No duplicates allowed!");
        }
    }

    public void burrowBook(String genre, String title){
        LinkedList<Book> shelf = bookshelf.get(genre);
        if(shelf == null){
            System.out.println("No such genre.");
            return;
        }

        for (int i = 0; i < shelf.size(); i++) {
            Book b = shelf.get(i);

            if (b.getTitle().equalsIgnoreCase(title)) {
                shelf.remove(i);   
                books.remove(b);   
                System.out.println("Book borrowed");
                return;
            }
        }

        System.out.println("No book found!");
    }

    public void returnBook(Book book){
        addBook(book);
        System.out.println("Book returned!");
    }

    public void displayBookShelf(){
        for(String genre: bookshelf.keySet()){
            System.out.println("Genre: " + genre);
            for(Book b : bookshelf.get(genre)){
                System.out.println(b);
            }
        }
    }

}
