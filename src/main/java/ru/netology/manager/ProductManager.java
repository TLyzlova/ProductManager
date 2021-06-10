package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.*;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(Product[] products, ProductRepository repository) {
//        this.products = products;
        this.repository = repository;
//        this.text = text;
    }

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }


    public void add (Product product) {
        repository.save(product);
    }

    public Product[] findAll(){
        return repository.findAll();
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product: repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) { // если в параметре product лежит объект класса Book
            Book book = (Book) product; // положем его в переменную типа Book чтобы пользоваться методами класса Book
            if (((Book) product).getAuthor().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
                return true;
            }
            if (product.getName().contains(search)) {
                return true;
            }
            return false;
        }

        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (((Smartphone) product).getBrand().contains(search)) {
                return true;
            }
            if (product.getName().contains(search)) {
                return true;
            }
        }
        return false;
    }

}