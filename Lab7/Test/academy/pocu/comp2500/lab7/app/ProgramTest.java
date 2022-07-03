package academy.pocu.comp2500.lab7.app;

import static org.junit.jupiter.api.Assertions.*;

import academy.pocu.comp2500.lab7.Author;
import academy.pocu.comp2500.lab7.Book;
import academy.pocu.comp2500.lab7.Bookshelf;
import academy.pocu.comp2500.lab7.Bundle;
import academy.pocu.comp2500.lab7.Genre;
import academy.pocu.comp2500.lab7.ReadingList;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

class ProgramTest {
    void test1()
    {
        Author author = new Author("James", "Bond");
        Book book0 = new Book("How to be the best", author, 1990, Genre.BIOGRAPHY);
        Bookshelf bookshelf = new Bookshelf(10);

        assert (bookshelf.add(book0));
        assert (bookshelf.remove(book0));
        assert (!bookshelf.remove(book0));

        Book book1 = new Book("C# for dummies", new Author("Jason", "Bourne"), 2005, Genre.ROMANCE);
        Book book2 = new Book("C# for dummies", new Author("Jason", "Bourne"), 2005, Genre.ROMANCE);
        Book book3 = new Book("Java for dummies", new Author("James", "Bond"), 2007, Genre.MYSTERY);

        Bundle bundle = new Bundle("Programming");

        assert (bundle.add(book0));
        assert (bundle.add(book1));
        assert (!bundle.add(book2));
        assert (bundle.add(book3));

        assert (bundle.remove(book3));
        assert (bundle.remove(book0));
        assert (!bundle.remove(book0));

        ReadingList readingList = new ReadingList("Summer Break Homework");

        readingList.add(book0);
        readingList.add(book1);
        readingList.add(book2);
        readingList.add(book3);

        assert (readingList.remove(book3));
        assert (readingList.remove(book0));
        assert (!readingList.remove(book0));
    }

    void test2()
    {
        Author author1 = new Author("same", "author");
        Author author2 = new Author("same", "author");
        Author author3 = new Author("diff", "author");

        assert (author1.toString().equals("same author"));
        assert (author2.toString().equals("same author"));
        assert (author3.toString().equals("diff author"));

        assert (author1.equals(author2));
        assert (author2.equals(author1));
        assert (!author1.equals(author3));
        assert (!author3.equals(author1));
        assert (!author2.equals(author3));
        assert (!author3.equals(author2));

        assert (author1.hashCode() == author2.hashCode());
        assert (author1.hashCode() != author3.hashCode());

        // Book test
        Book book1 = new Book("same book", author1, 2020, Genre.ROMANCE);
        Book book2 = new Book("same book", author1, 2020, Genre.ROMANCE);
        Book book3 = new Book("diff book", author3, 2018, Genre.MYSTERY);

        assert (book1.toString().equals("same book [same author]"));
        assert (book2.toString().equals("same book [same author]"));
        assert (book3.toString().equals("diff book [diff author]"));

        assert (book1.equals(book2));
        assert (book2.equals(book1));
        assert (!book1.equals(book3));
        assert (!book3.equals(book1));
        assert (!book2.equals(book3));
        assert (!book3.equals(book2));

        assert (book1.hashCode() == book2.hashCode());
        assert (book1.hashCode() != book3.hashCode());

        // Bookshelf test
        Bookshelf bookshelf1 = new Bookshelf(3);
        Bookshelf bookshelf2 = bookshelf1;
        Bookshelf bookshelf3 = new Bookshelf(3);

        assert (bookshelf1.equals(bookshelf2));
        assert (bookshelf2.equals(bookshelf1));
        assert (!bookshelf1.equals(bookshelf3));
        assert (!bookshelf3.equals(bookshelf1));
        assert (!bookshelf2.equals(bookshelf3));
        assert (!bookshelf3.equals(bookshelf2));

        assert (bookshelf1.hashCode() == bookshelf2.hashCode());
        assert (bookshelf1.hashCode() != bookshelf3.hashCode());

        // Bundle test
        Bundle bundle1 = new Bundle("same bundle");
        Bundle bundle2 = new Bundle("same bundle");
        Bundle bundle3 = new Bundle("diff bundle");

        bundle1.add(book1);
        bundle1.add(book2);
        bundle1.add(book3);

        bundle2.add(book1);
        bundle2.add(book2);
        bundle2.add(book3);

        bundle3.add(book1);
        bundle3.add(book2);
        bundle3.add(book3);

        assert (bundle1.equals(bundle2));
        assert (bundle2.equals(bundle1));
        assert (!bundle1.equals(bundle3));
        assert (!bundle3.equals(bundle1));
        assert (!bundle2.equals(bundle3));
        assert (!bundle3.equals(bundle2));

        assert (bundle1.hashCode() == bundle2.hashCode());
        assert (bundle1.hashCode() != bundle3.hashCode());

        // ReadingList test
        ReadingList readingList1 = new ReadingList("same list");
        ReadingList readingList2 = new ReadingList("same list");
        ReadingList readingList3 = new ReadingList("diff list");

        readingList1.add(book1);
        readingList1.add(book2);
        readingList1.add(book3);

        readingList2.add(book1);
        readingList2.add(book2);
        readingList2.add(book3);

        readingList3.add(book1);
        readingList3.add(book2);
        readingList3.add(book3);

        String format = String.format("%d. %s%s%d. %s%s%d. %s%s",
                1, book1.toString(), System.lineSeparator(),
                2, book2.toString(), System.lineSeparator(),
                3, book3.toString(), System.lineSeparator());


        assert (readingList1.toString().equals(format));
        assert (readingList2.toString().equals(format));
        assert (readingList3.toString().equals(format));
        assert (readingList1.toString().equals(readingList2.toString()));
        assert (readingList1.toString().equals(readingList3.toString()));

        assert (readingList1.equals(readingList2));
        assert (readingList2.equals(readingList1));
        assert (!readingList1.equals(readingList3));
        assert (!readingList3.equals(readingList1));
        assert (!readingList2.equals(readingList3));
        assert (!readingList3.equals(readingList2));

        assert (readingList1.hashCode() == readingList2.hashCode());
        assert (readingList1.hashCode() != readingList3.hashCode());

    }

    void test3()
    {
        Book book1 = new Book("book1", new Author("a", "b"), 1 , Genre.BIOGRAPHY);
        Book book2 = new Book("book2", new Author("a", "b"), 1 , Genre.BIOGRAPHY);
        Book book3 = new Book("book3", new Author("a", "b"), 1 , Genre.BIOGRAPHY);

        HashSet<Book> books1 = new HashSet<>();
        books1.add(book1);
        books1.add(book2);
        books1.add(book3);
        HashSet<Book> books2 = new HashSet<>();
        books2.add(book2);
        books2.add(book3);
        books2.add(book1);
        HashSet<Book> books3 = new HashSet<>();
        books3.add(book1);
        books3.add(book1);

        System.out.println(books1.hashCode() == books2.hashCode()); // true
        System.out.println(books1.hashCode() == books3.hashCode()); // false
    }
    @Test
    void main()
    {
        test1();
        test2();
        test3();

        ReadingList r1 = new ReadingList("A");
        ReadingList r2 = new ReadingList("A");
        ReadingList r3 = new ReadingList("B");
        ReadingList r4 = new ReadingList("C");
        ReadingList r5 = new ReadingList("D");


        Author a1 = new Author("abc","def");
        Book b1 = new Book("a",a1,2000,Genre.FANTASY);
        Book b2 = new Book("b",a1,2222,Genre.FANTASY);
        Book b3 = new Book("b",a1,2222,Genre.FANTASY);
        Book b4 = new Book("b",a1,2222,Genre.FANTASY);
        Book b5 = new Book("b",a1,2222,Genre.FANTASY);

        r1.add(b1);
        r1.add(b2);
        r1.add(b3);
        r1.add(b4);
        r1.add(b5);

        r2.add(b1);
        r2.add(b2);
        r2.add(b3);
        r2.add(b4);
        r2.add(b5);

        r3.add(b4);


        int a = r1.hashCode();
        int b = r2.hashCode();
        int c = r3.hashCode();
        int d =r4.hashCode();
        int e = r5.hashCode();

        assert (r2.equals(r1));
    }
}