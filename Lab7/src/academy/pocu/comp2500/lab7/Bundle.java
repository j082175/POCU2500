package academy.pocu.comp2500.lab7;

import java.util.ArrayList;

public class Bundle {
    private String bundleName;
    private ArrayList<Book> books = new ArrayList<>();

    public Bundle(String bundleName) {
        this.bundleName = bundleName;
    }

    public boolean add(Book book) {
        if (this.books.contains(book)) {
            return false;
        } else {
            this.books.add(book);
            return true;
        }
    }

    public boolean remove(Book book) {
        if (this.books.contains(book)) {
            this.books.remove(book);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || !(obj instanceof Bundle)) {
            return false;
        }

        Bundle b = (Bundle) obj;
        return this.bundleName.equals(((Bundle) obj).bundleName);
    }

    @Override
    public int hashCode() {
        int hash = 17;
        for (int i = 0; i < this.books.size(); i++) {
            hash = hash * 31 + this.books.get(i).hashCode();
        }
        hash = hash * 31 + this.bundleName.hashCode();
        return hash;
    }
}
