package academy.pocu.comp2500.lab7;

import java.util.ArrayList;

public class Bundle {
    private String bundleName;
    private ArrayList<Book> books = new ArrayList<>();

    public Bundle(String bundleName) {
        this.bundleName = bundleName;
    }

    public boolean add(Book book) {
        books.add(book);
        return true;
    }

    public boolean remove(Book book) {
        if (books.remove(book)) {
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
