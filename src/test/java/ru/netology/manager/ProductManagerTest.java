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

    private Product first = new Book(0, "Book1", 456, "Pushkin");
    private Product second = new Book(1, "Book2", 855, "Pushkin");
    private Product third = new Book(2, "Book3", 384, "Tolstoy");
    private Product fourth = new Book(3, "Book4", 289, "Dostoevsky");
    private Product fifth = new Smartphone(4, "Phone1", 1026, "Nokia");
    private Product sixth = new Smartphone(5, "Phone2", 5698, "Huawei");
    private Product seventh = new Smartphone(6, "Phone3", 8962, "Nokia");
    private Product eighth = new Smartphone(7, "Phone4", 4025, "Xiaomi");
    private Product ninth = new Product(8, "Product", 355);
    private Product tenth = new Smartphone(9, "Phone5", 7825, "Sony");

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
        Product[] actual = new Product[]{first, second};
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
        Product[] actual = new Product[]{fifth, seventh};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchProductOutOfRepository() {
        Product[] expected = manager.searchBy ("20");
        Product[] actual = new Product[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddNewProduct() {
        manager.add(ninth);

        Product[] expected = new Product[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth};
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOneMorePhone() {
        manager.add(tenth);
        Product[] actual = manager.searchBy("Sony");
        Product[] expected = new Product[]{tenth};
        assertArrayEquals(expected, actual);
    }
}