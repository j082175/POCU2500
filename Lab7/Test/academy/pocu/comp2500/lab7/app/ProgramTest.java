package academy.pocu.comp2500.lab7.app;

import static org.junit.jupiter.api.Assertions.*;

import academy.pocu.comp2500.lab7.Author;
import academy.pocu.comp2500.lab7.Book;
import academy.pocu.comp2500.lab7.Bookshelf;
import academy.pocu.comp2500.lab7.Bundle;
import academy.pocu.comp2500.lab7.Genre;
import academy.pocu.comp2500.lab7.ReadingList;
import org.junit.jupiter.api.Test;

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

    @Test
    void main()
    {
        test1();
    }
}