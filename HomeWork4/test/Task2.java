import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Task2 {
    @Test
    void findOne() {
        BookRepository repo = mock(BookRepository.class);
        BookService service = new BookService(repo);
        Book book = new Book("111", "Book1", "Author1");
        when(repo.findById("111")).thenReturn(book);
        assertThat(service.findBookById("111")).isEqualTo(book);
    }

    @Test
    void findAll() {
        BookRepository repo = mock(BookRepository.class);
        BookService service = new BookService(repo);
        List<Book> bookList = List.of(
                new Book("111", "Book1", "Author1"),
                new Book("222", "Book2", "Author2"),
                new Book("333", "Book3", "Author3")
        );
        when(repo.findAll()).thenReturn(bookList);
        assertThat(service.findAllBooks()).isEqualTo(bookList);
    }
}
