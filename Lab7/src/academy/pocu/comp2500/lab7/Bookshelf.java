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
        if (this == obj) {
            return true;
        }

        if (obj == null || !(obj instanceof Bookshelf)) {
            return false;
        }

        Bookshelf b = (Bookshelf) obj;
        if (this.maxBookCount == b.maxBookCount) {
            for (int i = 0; i < this.books.size(); i++) {
                if (this.books.get(i).equals(b.books.get(i))) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        int hash = 17 + super.hashCode();
        for (int i = 0; i < this.books.size(); i++) {
            hash = hash * 31 + this.books.get(i).hashCode();
        }
        return hash;
    }
}
