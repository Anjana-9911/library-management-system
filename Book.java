import java.util.Objects;

public class Book {
    private String isbn;
    private String bookName;
    private String author;
    private String publisher;
    private Double price;

    public Book(String bookName, String author, String publisher, Double price, String isbn) {
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.isbn = isbn;
    }

    public Book() {
        this.bookName = "";
        this.author = "";
        this.publisher = "";
        this.price = 0.0;
        this.isbn = "";
    }

    // Getters
    public String getIsbn() {
        return isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public Double getPrice() {
        return price;
    }

    // Setters
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Book book = (Book) obj;
        return Objects.equals(isbn, book.isbn) ;
                // &&
                // Objects.equals(bookName, book.bookName) &&
                // Objects.equals(author, book.author) &&
                // Objects.equals(publisher, book.publisher) &&
                // Objects.equals(price, book.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, bookName, author, publisher, price);
    }

}
