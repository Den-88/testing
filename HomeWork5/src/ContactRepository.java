import java.util.ArrayList;
import java.util.List;

public class ContactRepository {
    List<Contact> data = new ArrayList<>();

    public void addContact(Contact contact) {
        data.add(contact);
    }

    public boolean editPhone(String name, String phone) {
        for (Contact contact :
                data) {
            if (contact.getName().contains(name)) {
                contact.setPhone(phone);
                return true;
            }
        }
        return false;
    }

    public boolean editName(String name, String phone) {
        for (Contact contact :
                data) {
            if (contact.getPhone().contains(phone)) {
                contact.setName(name);
                return true;
            }
        }
        return false;
    }

    public boolean delContact(String name) {
        for (Contact contact :
                data) {
            if (contact.getName().contains(name)) {
                data.remove(contact);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Contact contact :
                data) {
            result.append(contact.getName()).append(": ").append(contact.getPhone()).append("\n");
        }
        return result.toString();
    }
}
