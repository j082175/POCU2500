package academy.pocu.comp2500.lab7;

public class Book {
    private String title;
    private Author author;
    private int publicationYear;
    private Genre genre;

    public Book(String title, Author author, int publicationYear, Genre genre) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.genre= genre;
    }

    // <title> [<author>]
    @Override
    public String toString() {
        return super.toString();
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
