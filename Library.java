import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully: " + book.getTitle());
    }

    public boolean removeBook(String bookId) {
        for (Book book : books) {
            if (book.getId().equals(bookId)) {
                books.remove(book);
                System.out.println("Book removed successfully: " + book.getTitle());
                return true;
            }
        }
        System.out.println("Book with ID " + bookId + " not found.");
        return false;
    }

    public boolean borrowBook(String bookId) {
        for (Book book : books) {
            if (book.getId().equals(bookId)) {
                if (!book.isBorrowed()) {
                    book.setBorrowed(true);
                    System.out.println("Book borrowed successfully: " + book.getTitle());
                    return true;
                } else {
                    System.out.println("Book is already borrowed.");
                    return false;
                }
            }
        }
        System.out.println("Book with ID " + bookId + " not found.");
        return false;
    }

    
    public boolean returnBook(String bookId) {
        for (Book book : books) {
            if (book.getId().equals(bookId)) {
                if (book.isBorrowed()) {
                    book.setBorrowed(false);
                    System.out.println("Book returned successfully: " + book.getTitle());
                    return true;
                } else {
                    System.out.println("This book is not currently borrowed.");
                    return false;
                }
            }
        }
        System.out.println("Book with ID " + bookId + " not found.");
        return false;
    }

    
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("\n=== Library Books ===");
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println("====================\n");
    }
}
