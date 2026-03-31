import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        boolean b = true;

        while(b){
            display();
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    System.out.println("Enter Book title: ");
                    String title1 = sc.nextLine();
                    System.out.println("Enter Book Author: ");
                    String author1 = sc.nextLine();
                    System.out.println("Enter book genre: ");
                    String genre1 = sc.nextLine();
                    Book book1 = new Book(title1, author1, genre1);
                    library.addBook(book1);
                    break;
                
                case 2:
                    System.out.println("Enter book title: ");
                    String title2 = sc.nextLine();
                    System.out.println("Enter book genre: ");
                    String genre2 = sc.nextLine();
                    library.burrowBook(genre2, title2);
                    break;
                
                case 3:
                    System.out.println("Enter Book title: ");
                    String title3 = sc.nextLine();
                    System.out.println("Enter Book Author: ");
                    String author3 = sc.nextLine();
                    System.out.println("Enter book genre: ");
                    String genre3 = sc.nextLine();
                    Book b2 = new Book(title3, author3, genre3);
                    library.returnBook(b2);
                    break;
                
                case 4:
                    library.displayBookShelf();
                    break;
                
                case 5:
                    b = false;
                    break;
            }
        }
    }

    public static void display(){
        System.out.println("---------- BookShelf Library System ----------");
        System.out.println("1. Add Books");
        System.out.println("2. Borrow Book");
        System.out.println("3. Return Book");
        System.out.println("4. Display Books");
        System.out.println("5. Exit");
    }
}
