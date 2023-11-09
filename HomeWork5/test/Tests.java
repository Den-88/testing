import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Tests {
    @Test
    void addContact() {
        ContactRepository repo = new ContactRepository();
        Contact contact = new Contact("Ivan Ivanov", "7-988-888-88-88");
        repo.addContact(contact);
        assertThat(repo.data).contains(contact);
    }

    @Test
    void delContact() {
        ContactRepository repo = new ContactRepository();
        Contact contact = new Contact("Ivan Ivanov", "7-988-888-88-88");
        repo.addContact(contact);
        repo.delContact("Ivan Ivanov");
        assertThat(repo.data).doesNotContain(contact);
    }

    @Test
    void printContacts() {
        ContactRepository repo = new ContactRepository();
        Contact contact = new Contact("Ivan Ivanov", "7-988-888-88-88");
        Contact contact2 = new Contact("Petr Petrov", "7-955-555-55-55");
        repo.addContact(contact);
        repo.addContact(contact2);
        assertThat(repo.toString()).contains("Ivan Ivanov: 7-988-888-88-88");
        assertThat(repo.toString()).contains("Petr Petrov: 7-955-555-55-55");
    }

    @Test
    void editPhone() {
        ContactRepository repo = new ContactRepository();
        Contact contact = new Contact("Ivan Ivanov", "7-988-888-88-88");
        repo.addContact(contact);
        repo.editPhone("Ivan Ivanov", "7-000-000-00-00");
        assertThat(repo.data.getFirst().getName()).isEqualTo("Ivan Ivanov");
        assertThat(repo.data.getFirst().getPhone()).isEqualTo("7-000-000-00-00");
    }

    @Test
    void editName() {
        ContactRepository repo = new ContactRepository();
        Contact contact = new Contact("Ivan Ivanov", "7-988-888-88-88");
        repo.addContact(contact);
        repo.editName("Sergey Sergeev", "7-988-888-88-88");
        assertThat(repo.data.getFirst().getName()).isEqualTo("Sergey Sergeev");
        assertThat(repo.data.getFirst().getPhone()).isEqualTo("7-988-888-88-88");
    }

    @Test
    void dataLength() {
        ContactRepository repo = new ContactRepository();
        Contact contact = new Contact("Ivan Ivanov", "7-988-888-88-88");
        Contact contact2 = new Contact("Petr Petrov", "7-955-555-55-55");
        repo.addContact(contact);
        repo.addContact(contact2);
        assertThat(repo.data.size()).isEqualTo(2);
    }

    @Test
    void allCicle() {
        ContactRepository repo = new ContactRepository();
        Contact contact = new Contact("Ivan Ivanov", "7-988-888-88-88");
        Contact contact2 = new Contact("Petr Petrov", "7-955-555-55-55");
        Contact contact3 = new Contact("Roman Romanov", "7-933-333-33-33");
        repo.addContact(contact);
        repo.addContact(contact2);
        repo.addContact(contact3);
        assertThat(repo.toString()).contains("Petr Petrov: 7-955-555-55-55");
        repo.editPhone("Petr Petrov", "7-000-000-00-00");
        repo.editName("Sergey Sergeev", "7-933-333-33-33");
        assertThat(repo.toString()).contains("Petr Petrov: 7-000-000-00-00");
        repo.delContact("Petr Petrov");
        assertThat(repo.toString()).doesNotContain("Petr Petrov: 7-000-000-00-00");
        assertThat(repo.toString()).contains("Ivan Ivanov: 7-988-888-88-88");
        assertThat(repo.toString()).contains("Sergey Sergeev: 7-933-333-33-33");
    }
}
