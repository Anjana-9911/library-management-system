
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class BookShelf {
    private List<Book> books;
    private String filename;

    public BookShelf() {
        this.books = new ArrayList<>();
        this.filename = "bookshelf.txt";
    }

    public void addBook(Book book) {
        readFromFile();
        books.add(book);
        writeToFile();
        books.clear();
    }

    public void removeBook(Book book) {
        readFromFile();
        books.remove(book);
        writeToFile();
        books.clear();
    }

    public void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                Book book = new Book(fields[0], fields[1], fields[2], Double.parseDouble(fields[3]), fields[4]);
                books.add(book);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }

    public void writeToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Book book : books) {
                writer.write(book.getBookName() + "," + book.getAuthor() + "," + book.getPublisher() + ","
                        + book.getPrice() + "," + book.getIsbn() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public List<Book> getBookList() {
        readFromFile();
        return new ArrayList<>(books);
    }


    // public static void main(String[] args) {
    //     BookShelf bookshelf = new BookShelf();

    //     // Add some books
    //     Book book1 = new Book("", "", "", 69.69, "2345678901");
    //     // Book book2 = new Book("Python Crash Course", "Jane Smith", "O'Reilly", 39.99,
    //     // "2345678901");
    //     // bookshelf.addBook(book1);
    //     // bookshelf.addBook(book2);

    //     bookshelf.removeBook(book1);
    //     bookshelf.printBookshelf();
    // }

}
