/*
 * Sapayth Hossain
 */
package AddressBook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/*
 * @author sapaythhossain
 */
class Contact {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String email;

    private int counter = 0;

    // blank constructor
    public Contact() {
    }

    // constructor
    public Contact(String firstName, String lastName, String phoneNumber,
            String address, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;

        counter++;
    }

    @Override
    public String toString() {
        return String.format("First name: %s%n"
                + "Last name: %s%n"
                + "Phone number: %s%n"
                + "Address: %s%n"
                + "Email: %s%n",
                getFirstName(),
                getLastName(),
                getPhoneNumber(),
                getAddress(),
                getEmail());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public static Comparator<Contact> ContactNameComparator
            = new Comparator<Contact>() {

        @Override
        public int compare(Contact contact1, Contact contact2) {

            String contactName1 = contact1.getFirstName().toUpperCase();
            String contactName2 = contact2.getFirstName().toUpperCase();

            //ascending order
            return contactName1.compareTo(contactName1);

            //descending order
            //return fruitName2.compareTo(fruitName1);
        }

    };
}

public class AddressBook {

    private static final int LIMIT = 250;
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Contact> contacts = new ArrayList<>();
    static Contact c = new Contact();

    public static void main(String[] args) {
        contacts.add(new Contact("Sapayth", "Hossain", "01313223344",
                "asdjldsakjf asl", "mail@testmail.com"));
        askForInput();
    } // end of main class

    // ask for input
    public static void askForInput() {
        int input;
        do {
            System.out.println("1) Add an entry\n"
                    + "2) Remove an entry\n"
                    + "3) Edit an existing entry\n"
                    + "4) Sort the address book by first name\n"
                    + "5) Search for a specific entry\n"
                    + "6) Show all entry\n"
                    + "8) Quit\n"
                    + "\n"
                    + "Please choose what you'd like to do with the database:");
            input = sc.nextInt();
            sc.nextLine();

            callInputs(input);

        } while (input != 8);
    }

    // work with the inputs
    public static void callInputs(int input) {
        switch (input) {
            case 1:
                addNewEntry();
                break;
            case 2:
                removeEntry();
                break;
            case 3:
                editEntry();
                break;
            case 4:
                sortByFirstName();
                break;
            case 5:
                searchForEntry();
                break;
            case 6:
                showAllEntry();
                break;

        }
    }

    // add new entry
    public static void addNewEntry() {
        System.out.println("First name:");
        String firstName = sc.nextLine();
        System.out.println("Last name:");
        String lastName = sc.nextLine();
        System.out.println("Phone number:");
        String phoneNumber = sc.nextLine();
        System.out.println("Address:");
        String address = sc.nextLine();
        System.out.println("Email:");
        String email = sc.nextLine();

        contacts.add(
                new Contact(firstName, lastName, phoneNumber, address, email));
    }

    // remove an entry
    public static void removeEntry() {
        System.out.println("Type first name to remove:");
        String name = sc.nextLine();

        for (int i = 0; i < contacts.size(); i++) {
            if (name.equals(contacts.get(i).getFirstName())) {
                contacts.remove(contacts.get(i));
            }
        }

    }

    // edit an entry
    public static void editEntry() {
        System.out.println("Type first name to edit:");
        String name = sc.nextLine();

        for (Contact contact : contacts) {
            if (name.equals(contact.getFirstName())) {
                System.out.println("First name:");
                contact.setFirstName(sc.nextLine());
                System.out.println("Last name:");
                contact.setLastName(sc.nextLine());
                System.out.println("Phone number:");
                contact.setPhoneNumber(sc.nextLine());
                System.out.println("Address:");
                contact.setAddress(sc.nextLine());
                System.out.println("Email:");
                contact.setEmail(sc.nextLine());
            } else {
                System.out.println("Contact not found!");
            }
        }
    }

    // sort address book by first name
    public static void sortByFirstName() {
        //Arrays.sort( Contact, Contact.ContactNameComparator );

    }

    // search for an entry
    public static void searchForEntry() {
        
    }
    
    // show all entry
    public static void showAllEntry() {
        if (contacts.isEmpty()) {
            System.out.println("There is no contact to show!");
        } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

}
