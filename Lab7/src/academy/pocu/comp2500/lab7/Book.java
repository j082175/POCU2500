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
        this.genre = genre;
    }

    // <title> [<author>]
    @Override
    public String toString() {
        return new String(this.title + " [" + this.author.toString() + "]");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || !(obj instanceof Book)) {
            return false;
        }

        Book b = (Book) obj;
        if (this.title.equals(b.title) && this.genre == b.genre && this.publicationYear == b.publicationYear && this.author.equals(b.author)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = hash * 31 + this.title.hashCode();
        hash = hash * 31 + this.author.hashCode();
        hash = hash * 31 + this.publicationYear;
        hash = hash * 31 + this.genre.hashCode();
        return hash;
    }
}
