package academy.pocu.comp2500.lab7;

import java.util.ArrayList;

public class ReadingList {
    private String name;
    private ArrayList<Book> books = new ArrayList<>();

    public ReadingList(String name) {
        this.name = name;
    }

    public void add(Book book) {
        books.add(book);
    }

    public boolean remove(Book book) {
        if (books.remove(book)) {
            return true;
        } else {
            return false;
        }
    }

    // 1. <첫번째 책>
    // 2. <두번째 책>
    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < this.books.size(); i++) {
            buffer.append(i + 1 + ". <" + this.books.get(i).toString() + ">\n");
        }

        return buffer.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || !(obj instanceof ReadingList)) {
            return false;
        }

        ReadingList readingList = (ReadingList) obj;
        if (this.name.equals(readingList.name)) {
            for (int i = 0; i < this.books.size(); i++) {
                if (!this.books.get(i).equals(readingList.books.get(i))) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = hash * 31 + this.name.hashCode();
        hash = hash * 31 + this.name.hashCode();
        return hash;
    }
}
