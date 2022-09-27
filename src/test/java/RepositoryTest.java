import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    @Test
    public void deleteProduct() {
        Repository repo = new Repository();
        BookService book1 = new BookService(1, "book 1", 100, "author 1");
        BookService book2 = new BookService(2, "book 2", 200, "author 2");
        SmartphoneService phone1 = new SmartphoneService(3, "phone 1", 300, "factory 1");

        repo.add(book1);
        repo.add(book2);
        repo.add(phone1);

        repo.delete(2);

        ProductService[] actual = repo.findAll();
        ProductService[] expected = { book1, phone1 };

        Assertions.assertArrayEquals(expected, actual);
    }
}