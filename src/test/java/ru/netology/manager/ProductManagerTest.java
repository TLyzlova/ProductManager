package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Book first = new Book(0, "Book1", 456, "Pushkin");
    private Book second = new Book(1, "Book2", 855, "Lermontov");
    private Book third = new Book(2, "Book3", 384, "Tolstoy");
    private Book fourth = new Book(3, "Book4", 289, "Dostoevsky");
    private Smartphone fifth = new Smartphone(4, "Phone1", 1026, "Samsung");
    private Smartphone sixth = new Smartphone(5, "Phone2", 5698, "Sony");
    private Smartphone seventh = new Smartphone(6, "Phone3", 8962, "Nokia");
    private Smartphone eighth = new Smartphone(7, "Phone4", 4025, "Xiaomi");

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eighth);
    }


    @Test
    void searchBookByName() {
        Product[] expected = manager.searchBy ("Book2");
        Product[] actual = new Product[]{second};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBookByAuthor() {
        Product[] expected = manager.searchBy ("Pushkin");
        Product[] actual = new Product[]{first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchPhoneByName() {
        Product[] expected = manager.searchBy ("Phone4");
        Product[] actual = new Product[]{eighth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchPhoneByBrand() {
        Product[] expected = manager.searchBy ("Nokia");
        Product[] actual = new Product[]{seventh};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchProductOutOfRepository() {
        Product[] expected = manager.searchBy ("20");
        Product[] actual = new Product[]{};
        assertArrayEquals(expected, actual);
    }

//    @Test
//    void searchAll() {
//        Product[] expected = manager.searchBy ("Pone 1" + "Samsung");
//        Product[] actual = new Product[]{fifth};
//        assertArrayEquals(expected, actual);
//    }

}