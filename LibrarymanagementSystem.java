import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private boolean checkedOut;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.checkedOut = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
}

class LibraryCatalog {
    private ArrayList<Book> books;

    public LibraryCatalog() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        System.out.println("\nLibrary Books:");
        System.out.println("------------------\n");
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() + ",\nAuthor: " + book.getAuthor());
            System.out.println("-----------------------------------");
        }
    }

    public void searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found:");
                System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor());
                System.out.println("Status: " + (book.isCheckedOut() ? "Checked out" : "Available"));
                return;
            }
        }
        System.out.println("Book with title \"" + title + "\" not found.");
    }

    public void searchByAuthor(String author) {
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println("Book found:");
                System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor());
                System.out.println("Status: " + (book.isCheckedOut() ? "Checked out" : "Available"));
                return;
            }
        }
        System.out.println("Book by author \"" + author + "\" not found.");
    }

    public void checkOutBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isCheckedOut()) {
                    System.out.println("Sorry, the book is already checked out.");
                } else {
                    book.setCheckedOut(true);
                    System.out.println("You have successfully checked out the book: " + title);
                }
                return;
            }
        }
        System.out.println("Book with title \"" + title + "\" not found.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isCheckedOut()) {
                    book.setCheckedOut(false);
                    System.out.println("You have successfully returned the book: " + title);
                } else {
                    System.out.println("This book is not checked out.");
                }
                return;
            }
        }
        System.out.println("Book with title \"" + title + "\" not found.");
    }
}

public class LibrarymanagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryCatalog libraryCatalog = new LibraryCatalog();

        libraryCatalog.addBook(new Book("Java Programming", "John Doe"));
        libraryCatalog.addBook(new Book("Introduction to Algorithms", "Thomas Cormen"));
        libraryCatalog.addBook(new Book("Clean Code", "Robert C. Martin"));
        libraryCatalog.addBook(new Book("Head First Java", "Kathy Sierra"));
        libraryCatalog.addBook(new Book("Design Patterns", "Erich Gamma"));

        libraryCatalog.displayBooks();

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Search by Title");
            System.out.println("2. Search by Author");
            System.out.println("3. Check Out Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    libraryCatalog.searchByTitle(searchTitle);
                    break;
                case 2:
                    System.out.print("Enter author to search: ");
                    String searchAuthor = scanner.nextLine();
                    libraryCatalog.searchByAuthor(searchAuthor);
                    break;
                case 3:
                    System.out.print("Enter title to check out: ");
                    String checkOutTitle = scanner.nextLine();
                    libraryCatalog.checkOutBook(checkOutTitle);
                    break;
                case 4:
                    System.out.print("Enter title to return: ");
                    String returnTitle = scanner.nextLine();
                    libraryCatalog.returnBook(returnTitle);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}
