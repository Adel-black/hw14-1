import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    @Test
    public void searchFewProducts() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        BookService book1 = new BookService(1, "book 1", 100, "author 1");
        BookService book2 = new BookService(2, "book 2", 200, "author 2");
        SmartphoneService phone1 = new SmartphoneService(3, "phone 1", 300, "factory 1");
        SmartphoneService phone2 = new SmartphoneService(4, "phone 2", 400, "factory 2");

        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);

        ProductService[] actual = manager.searchBy("book");
        ProductService[] expected = { book1, book2 };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchNothing() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        BookService book1 = new BookService(1, "book 1", 100, "author 1");
        BookService book2 = new BookService(2, "book 2", 200, "author 2");
        SmartphoneService phone1 = new SmartphoneService(1, "phone 1", 300, "factory 1");
        SmartphoneService phone2 = new SmartphoneService(2, "phone 2", 400, "factory 2");

        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);

        ProductService[] actual = manager.searchBy("home");
        ProductService[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchOneProduct() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        BookService book1 = new BookService(1, "book 1", 100, "author 1");
        BookService book2 = new BookService(2, "book 2", 200, "author 2");
        SmartphoneService phone1 = new SmartphoneService(1, "phone 1", 300, "factory 1");
        SmartphoneService phone2 = new SmartphoneService(2, "phone 2", 400, "factory 2");

        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);

        ProductService[] actual = manager.searchBy("phone 2");
        ProductService[] expected = { phone2 };

        Assertions.assertArrayEquals(expected, actual);
    }
}