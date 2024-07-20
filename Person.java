
import java.time.LocalDate;

public class Person {
    private String personName;
    private String id;
    private String aadharCard;

    public Person(String personName, String id, String aadharCard) {
        this.personName = personName;
        this.id = id;
        this.aadharCard = aadharCard;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAadharCard() {
        return aadharCard;
    }

    public void setAadharCard(String aadharCard) {
        this.aadharCard = aadharCard;
    }
    String borrowBook(Book book){
        LocalDate currentDate = LocalDate.now();
        BookShelf bookShelf = new BookShelf();
        bookShelf.removeBook(book);
        return this.id+","+currentDate+","+book.getIsbn();
    }
    String returnBook(Book book){
        LocalDate currentDate = LocalDate.now();
        BookShelf bookShelf = new BookShelf();
        bookShelf.addBook(book);
        return this.id+","+currentDate+","+book.getIsbn();
    }
    
}
