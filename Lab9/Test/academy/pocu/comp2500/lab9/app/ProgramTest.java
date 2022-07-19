package academy.pocu.comp2500.lab9.app;

import academy.pocu.comp2500.lab9.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;

class ProgramTest {

    void test0() {
        SkyIsTheLimit model0 = new SkyIsTheLimit(50);
        SkyIsTheLimit model1 = new SkyIsTheLimit(100);
        SkyIsTheLimit model2 = new SkyIsTheLimit(150);

        Book book0 = new Book(UUID.randomUUID(), "Hello", 10, 1991);
        Book book1 = new Book(UUID.randomUUID(), "Hello", 15, 1995);
        Book book2 = new Book(UUID.randomUUID(), "Hello", 20, 1996);
        Book book3 = new Book(UUID.randomUUID(), "Hello", 25, 2011);
        Book book4 = new Book(UUID.randomUUID(), "Hello", 30, 2003);

        ArrayList<Book> books1 = new ArrayList<>();
        books1.add(book0);
        books1.add(book1);
        books1.add(book2);
        books1.add(book3);

        assert (model0.getTotalPrice(books1) == 70);
        assert (model1.getTotalPrice(books1) == 70);
        assert (model2.getTotalPrice(books1) == 70);

        ArrayList<Book> books2 = new ArrayList<>();
        books2.add(book0);
        books2.add(book1);
        books2.add(book2);
        books2.add(book3);
        books2.add(book4);

        assert (model0.getTotalPrice(books2) == 72);
        assert (model1.getTotalPrice(books2) == 72);
        assert (model2.getTotalPrice(books2) == 100);

    }
    void test1() {
        UUID sku0 = UUID.randomUUID();

        Book book0 = new Book(sku0, "Hello", 10, 1980);
        Book book1 = new Book(sku0, "Hello", 10, 1980);
        Book book2 = new Book(sku0, "Hello", 10, 1980);
        Book book3 = new Book(sku0, "Hello", 10, 1980);
        Book book4 = new Book(sku0, "Hello", 10, 1980);
        Book book5 = new Book(UUID.randomUUID(), "Millenium", 15, 2001);
        Book book6 = new Book(UUID.randomUUID(), "Halfway Millenium", 21, 2005);
        Book book7 = new Book(UUID.randomUUID(), "Decade almost over", 17, 2009);
        Book book8 = new Book(UUID.randomUUID(), "FIFA", 17, 2002);
        Book book9 = new Book(UUID.randomUUID(), "University", 5, 2008);

        ArrayList<Book> books = new ArrayList<>();

        books.add(book0);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        books.add(book8);
        books.add(book9);

        HashSet<UUID> skus = new HashSet<>();
        skus.add(sku0);

        BuyOneGetOneFree model0 = new BuyOneGetOneFree(skus);
        DecadeMadness model1 = new DecadeMadness();
        SkyIsTheLimit model2 = new SkyIsTheLimit(100);

        assert (model0.getTotalPrice(books) == 105);
        assert (model1.getTotalPrice(books) == 100);
        assert (model2.getTotalPrice(books) == 106);
    }

    void testSelf() {
        UUID sku0 = UUID.randomUUID();
        UUID sku1 = UUID.randomUUID();
        UUID sku2 = UUID.randomUUID();

        Book book0 = new Book(sku0, "Hello", 10, 1980);
        Book book1 = new Book(sku1, "Hello", 10, 1980);
        Book book2 = new Book(sku2, "Hello", 10, 1980);
        Book book3 = new Book(sku2, "Hello", 10, 1980);
        Book book4 = new Book(sku1, "Hello", 10, 1980);
        Book book5 = new Book(sku0, "Millenium", 15, 2001);
        Book book6 = new Book(sku1, "Halfway Millenium", 21, 2005);
        Book book7 = new Book(sku2, "Decade almost over", 17, 2009);
        Book book8 = new Book(sku0, "FIFA", 17, 2002);


        ArrayList<Book> books = new ArrayList<>();

        books.add(book0);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        books.add(book8);

        HashSet<UUID> skus = new HashSet<>();
        skus.add(sku0);
        skus.add(sku1);
        skus.add(sku2);

        Cart cart = new Cart();
        cart.addBooks(books);


        BuyOneGetOneFree model0 = new BuyOneGetOneFree(skus);
        int a = model0.getTotalPrice(books);
    }

    @Test
    void main() {
        HashSet<UUID> hashSet = new HashSet<>();
        UUID uuid = UUID.randomUUID();
        hashSet.add(uuid);
        BuyOneGetOneFree buyOneGetOneFree = new BuyOneGetOneFree(hashSet);
        ArrayList<Book> books = new ArrayList<>();
        Book book = new Book(uuid, "few", 22, 2000);
        books.add(book);
        int a = buyOneGetOneFree.getTotalPrice(books);

        int b;
    }
}