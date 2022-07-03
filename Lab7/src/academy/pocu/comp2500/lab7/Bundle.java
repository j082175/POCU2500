package academy.pocu.comp2500.lab7;

import java.util.ArrayList;
import java.util.HashSet;

public class Bundle {
    private String bundleName;
    private HashSet<Book> books = new HashSet<>();
    private final int MAX_VALUE = 4;
    private int currentCount;

    public Bundle(String bundleName) {
        this.bundleName = bundleName;
        this.currentCount = 0;
    }

    public boolean add(Book book) {
        if (this.books.contains(book)) {
            return false;
        } else {
            if (this.currentCount >= MAX_VALUE) {
                return false;
            }
            this.books.add(book);
            this.currentCount++;
            return true;
        }
    }

    public boolean remove(Book book) {
        if (this.books.contains(book)) {
            this.books.remove(book);
            this.currentCount--;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }

        if (obj == this) {
            return true;
        }

        if (obj == null || !(obj instanceof Bundle)) {
            return false;
        }

        boolean check = false;
        Bundle b = (Bundle) obj;
        if (this.bundleName.equals(b.bundleName)) {
            for (var list : this.books) {
                if (list.equals(b.books.iterator().next())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        for (var list : this.books) {
            hash = hash * 31 + list.hashCode();
        }
        hash = hash * 31 + this.bundleName.hashCode();
        return hash;
    }
}
