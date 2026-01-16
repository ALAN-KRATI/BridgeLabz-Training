import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddressBookManager {

    // hashmap for associating an addressbook with it's certain name.
    private Map<String, AddressBook> addressBooks = new HashMap<>(); 
    private AddressBook addressBook = new AddressBook();
    private Scanner scanner = new Scanner(System.in);

    // Create or get existing address book
    public AddressBook getOrCreateAddressBook(String name) {
        return addressBooks.computeIfAbsent(name, AddressBook::new);
    }

    // creates Contact
    public Contact createContact() {

        System.out.println("\nEnter Contact Details");

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Address: ");
        String address = scanner.nextLine();

        System.out.print("City: ");
        String city = scanner.nextLine();

        System.out.print("State: ");
        String state = scanner.nextLine();

        System.out.print("Zip: ");
        String zip = scanner.nextLine();

        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        return new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
    }

    // ONLY adds contact to address book
    public void addContact(String addressBookName, Contact contact) {
        AddressBook book = getOrCreateAddressBook(addressBookName);
        boolean done = book.addContact(contact);
        
        if(done) System.out.println("Contact added to Address Book: " + addressBookName);
        else System.out.println("Duplicate contact found!");
    }

    // method to add multiple people contacts
    public void addMultiplePeopleContacts(String addressBookName){
        AddressBook book = getOrCreateAddressBook(addressBookName);

        while(true){

            Contact contact = createContact();
            book.addContact(contact);

            System.out.println("Do you want to add more contact?(Y/N): ");
            String ans = sc.nextLine();

            if(!ans.equalsIgnoreCase("Y")){
                break;
            }
        }

        System.out.println("Contacts saved succesfully!");
    }

    // Edit an existing contact
    public void editContact(String addressBookName) {
        AddressBook book = addressBooks.get(addressBookName);

        if (book == null) {
            System.out.println("Address Book not found.");
            return;
        }

        System.out.print("Enter First Name to edit: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name to edit: ");
        String lastName = scanner.nextLine();

        Contact contact = book.findContactByName(firstName, lastName);

        if (contact == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.println("\nEnter new details");

        System.out.print("New Address: ");
        contact.setAddress(scanner.nextLine());

        System.out.print("New City: ");
        contact.setCity(scanner.nextLine());

        System.out.print("New State: ");
        contact.setState(scanner.nextLine());

        System.out.print("New Zip: ");
        contact.setZip(scanner.nextLine());

        System.out.print("New Phone Number: ");
        contact.setPhoneNumber(scanner.nextLine());

        System.out.print("New Email: ");
        contact.setEmail(scanner.nextLine());

        System.out.println("Contact updated successfully!");
    }

    // deleting a contact by name
    public void deleteContacts(String addressBookName){
        AddressBook book = addressBook.get(addressBookName);

        if(book == null){
            System.out.println("Address Book not found.");
            return;
        }

        System.out.print("Enter First Name to delete: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name to delete: ");
        String lastName = scanner.nextLine();

        book.removeContact(firstName, lastName);
    }

    // method to search a person in city/state
    public void searchPersonByCityOrState(){
        System.out.println("Enter the criteria for your search(city/state): ");
        String choice = sc.nextLine();
        System.out.println("Enter " + choice + " name: ");
        String name = sc.nextLine();

        List<Contact> result = new ArrayList<>();

        for(AddressBook book : addressBooks.values()){
            for(Contact contact: book.getContacts()){
                if(choice.equalsIgnoreCase("city") && contact.getCity().equalsIgnoreCase(name)){
                    result.add(contact);
                }
                else if(choice.equalsIgnoreCase("state") && contact.getState().equalsIgnoreCase(name)){
                    result.add(contact);
                }
            }
        }

        if(result == null){
            System.out.println("No contacts found!");
        }
        else{
            System.out.println("\nResults: ");
            for(Contact c : result){
                System.out.println(c);
            }
        }
    }

    // view a person via state/city and also grouping them together
    public void viewPersonByCityOrState(){
        Map<String, List<Contact>> city = new HashMap<>();
        Map<String, List<Contact>> state = new HashMap<>();

        for(AddressBook book : addressBooks.value()){
            for(Contact c : book.getContacts()){
                city.computeIfAbsent(c.getCity(), k -> new ArrayList<>()).addContact(c);
                state.computeIfAbsent(c.getState(), k -> new ArrayList<>()).addContact(c);
            }
        }

        System.out.println("View Person by(city/state): ");
        String choice = sc.nextLine();

        if(choice.equalsIgnoreCase("city")){
            displayMap(city, "city");
        }
        else if(choice.equalsIgnoreCase("state")){
            displayMap(state, "state");
        }
        else{
            System.out.println("Invalid Choice!");
        }
    }

    // method to display maps
    public void displayMap(Map<String, List<Contact>> map, String criteria){
        if(map.isEmpty()){
            System.out.println("No data found!");
            return;
        }

        System.out.println("\nView Person by " + criteria + " : ");

        for(Map.Entry<String, List<Contact>> entry : map.entrySet()){
            System.out.println("\n" + criteria + " : " + entry.getkey());
            for(Contact c : entry.getValue()){
                System.out.println(" " + c);
            }
        }
    }

    // method to count persons in city/state
    public void countPersonByCityOrState(){
        Map<String, Integer> cityCount = new HashMap<>();
        Map<String, Integer> stateCount = new HashMap<>();

        for(AddressBook book : addressBooks.value()){
            for(Contact c : book.getContacts()){
                cityCount.put(c.getCity(), cityCount.getOrDefault(c.getCity(), 0) + 1);
                stateCount.put(c.getState(), stateCount.getOrDefault(c.getState(), 0) + 1);
            }
        }

        System.out.println("Count Person by(city/state): ");
        String choice = sc.nextLine();

        if(choice.equalsIgnoreCase("city")){
            displayCount(cityCount, "city");
        }
        else if(choice.equalsIgnoreCase("state")){
            displayCount(stateCount, "state");
        }
        else{
            System.out.println("Invalid Choice!");
        }
    }

    // method to display count grouped by city/state
    public void displayCount(Map<String, Integer> map, String criteria){
        if(map.isEmpty()){
            System.out.println("No data found!");
            return;
        }

        System.out.println("\nCount Person by " + criteria + " : ");

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println("Count of persons in:" + entry.getKey() + "is: " + entry.getValue());
        }
    }

    // method to sort addressbook based on names
    public void sortContacts(){
        System.out.println("Enter Address Book Name: ");
        String bookname = sc.nextLine();

        AddressBook book = addressBooks.get(bookname);

        if(book == null){
            System.out.println("Book not found!");
            return;
        }

        book.sortContactsByName();

        System.out.println("Sorted contact by names: ");
        for(Contact c : book.getContacts()){
            System.out.println(c);
        }
    }
}
