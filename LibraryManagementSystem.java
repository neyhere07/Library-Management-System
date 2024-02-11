// Import necessary classes from Java library
import java.util.ArrayList;
import java.util.Scanner;

// Define a class for Book
class Book {
    // Declare private fields for book details
    private String title;
    private String author;
    private String genre;

    // Constructor to initialize book details
    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    // Getter methods for accessing book details
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    // Override toString method to return book details as a string
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Genre: " + genre;
    }
}

// Define a class for Library
class Library {
    // Declare private fields for library name and list of books
    private String libraryName;
    private ArrayList<Book> books;

    // Constructor to initialize library name and list of books
    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.books = new ArrayList<>();
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    // Method to display all books in the library
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Books available in the library:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    // Method to search for a book by title
    public void searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found:");
                System.out.println(book);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Method to delete a book by title
    public void deleteBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                books.remove(book);
                System.out.println("Book deleted successfully!");
                return;
            }
        }
        System.out.println("Book not found.");
    }
}

// Main class containing the main method
public class LibraryManagementSystem {
    // Main method where execution starts
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter the name of the library
        System.out.print("Enter the name of the library: ");
        String libraryName = scanner.nextLine();
        
        // Create a Library object with the given name
        Library library = new Library(libraryName);

        // Main loop for interacting with the library management system
        while (true) {
            // Display menu options
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Quit");

            // Prompt the user to enter their choice
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            // Perform actions based on user's choice
            switch (choice) {
                case 1:
                    // Add a book to the library
                    System.out.print("Enter the title of the book: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter the author of the book: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter the genre of the book: ");
                    String genre = scanner.nextLine();
                    Book book = new Book(title, author, genre);
                    library.addBook(book);
                    break;
                case 2:
                    // Display all books in the library
                    library.displayBooks();
                    break;
                case 3:
                    // Search for a book by title
                    System.out.print("Enter the title of the book to search: ");
                    String searchTitle = scanner.nextLine();
                    library.searchBook(searchTitle);
                    break;
                case 4:
                    // Delete a book by title
                    System.out.print("Enter the title of the book to delete: ");
                    String deleteTitle = scanner.nextLine();
                    library.deleteBook(deleteTitle);
                    break;
                case 5:
                    // Exit the program
                    System.out.println("Exiting...");
                    scanner.close(); // Close the Scanner object to prevent resource leak
                    System.exit(0); // Exit the program with status code 0
                default:
                    // Invalid choice
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}