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
        if (book == null) {
            return false;
        }
        for (int i = 0; i < this.books.size(); i++) {
            if (this.books.get(i).equals(book)) {
                this.books.remove(i);
                return true;
            }
        }

        return false;
    }

    // 1. <첫번째 책>
    // 2. <두번째 책>
    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        int count = 1;
        for (int i = 0; i < this.books.size(); i++) {
            buffer.append(count + ". " + this.books.get(i).toString() + System.lineSeparator());
            count++;
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

        boolean check = false;
        ReadingList readingList = (ReadingList) obj;
        if (this.name.equals(readingList.name) && (this.books.size() == readingList.books.size())) {
            for (int i = 0; i < this.books.size(); i++) {
                if (this.books.get(i).equals(readingList.books.get(i))) {
                    check = true;
                } else {
                    check = false;
                    break;
                }
            }
        }

        if (check) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = this.name.hashCode() * 5381 * 5381;
        for (int i = 0; i < this.books.size(); i++) {
            hash = hash ^ this.books.get(i).hashCode() * 5381 * 5381;
        }

        return hash;
    }
}
