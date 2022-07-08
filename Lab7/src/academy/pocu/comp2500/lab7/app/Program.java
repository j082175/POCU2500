package academy.pocu.comp2500.lab7.app;

import academy.pocu.comp2500.lab7.Author;
import academy.pocu.comp2500.lab7.Book;
import academy.pocu.comp2500.lab7.Bookshelf;
import academy.pocu.comp2500.lab7.Bundle;
import academy.pocu.comp2500.lab7.Genre;
import academy.pocu.comp2500.lab7.ReadingList;

public class Program {

    public static void main(String[] args) {
        Book a1 = new Book("title1", new Author("hoho","fuck"), 4000, Genre.ROMANCE);
        Book a2 = new Book("title2", new Author("hoho","fuck"), 4000, Genre.ROMANCE);
        Book a3 = new Book("title3", new Author("hoho","fuck"), 4000, Genre.ROMANCE);
        Book a4 = new Book("title4", new Author("hoho","fuck"), 4000, Genre.ROMANCE);


        ReadingList r = new ReadingList("first");
        r.add(a1);
        r.add(a2);
        r.add(a3);
        r.add(a4);

        System.out.println(r.toString());
    }
}