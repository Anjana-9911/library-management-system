import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonManager {
    private List<Person> personList;
    private int nextId;

    public PersonManager() {
        this.personList = new ArrayList<>();
        this.nextId = 1;
    }

    public void createPerson(String personName, String aadharCard) {
        if(!aadharCard.equals(""))
            if (!isAadharCardExists(aadharCard)) {
                String id = String.valueOf(nextId++);
                Person person = new Person(personName, id, aadharCard);
                personList.add(person);
            } else {
                System.out.println("Aadhar card number already exists.");
            }
        else
        System.out.println("Aadhar cannot be Empty");
    }

    private boolean isAadharCardExists(String aadharCard) {
        for (Person person : personList) {
            if (person.getAadharCard().equals(aadharCard)) {
                return true;
            }
        }
        return false;
    }

    public void deletePerson(String id) {
        personList.removeIf(person -> person.getId().equals(id));
    }

    public void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("personList.txt"))) {
            for (Person person : personList) {
                writer.println(person.getId() + "," + person.getPersonName() + "," + person.getAadharCard());
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("personList.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Person person = new Person(parts[1], parts[0], parts[2]);
                personList.add(person);
                if (Integer.parseInt(parts[0]) >= nextId) {
                    nextId = Integer.parseInt(parts[0]) + 1;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
    PersonManager mgr = new PersonManager();
    Scanner sc = new Scanner(System.in);
    mgr.loadFromFile();

    while (true) {
        System.out.println("\f1. Add new user");
        System.out.println("2. Remove existing user");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();1

        switch (choice) {
            case 1:
                System.out.print("Enter person name: ");
                String personName = sc.nextLine();
                System.out.print("Enter aadhar card number: ");
                String aadharCard = sc.nextLine();
                mgr.createPerson(personName, aadharCard);
                mgr.saveToFile();
                break;
            case 2:
                System.out.print("Enter person id to remove: ");
                String id = sc.nextLine();
                mgr.deletePerson(id);
                mgr.saveToFile();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.\n------------------------------------\n\n");
        }
    }
}

}
