package academy.pocu.comp2500.lab7;

import java.util.ArrayList;

//책꽃이
public class Bookshelf {
    private int maxBookCount;
    private ArrayList<Book> books = new ArrayList<>();

    public Bookshelf(int maxBookCount) {
        this.maxBookCount = maxBookCount;
    }

    public boolean add(Book book) {
        this.books.add(book);
        return true;
    }

    public boolean remove(Book book) {
        if (this.books.remove(book)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
