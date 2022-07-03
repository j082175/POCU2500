package academy.pocu.comp2500.lab7;

public class Author {
    private String firstName;
    private String lastName;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // <firstName> <lastName>
    @Override
    public String toString() {
        return new String(this.firstName + " " + this.lastName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || !(obj instanceof Author)) {
            return false;
        }

        Author author = (Author) obj;
        if (this.firstName.equals(author.firstName) && this.lastName.equals(author.lastName)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = hash * 31 + this.firstName.hashCode();
        hash = hash * 31 + this.lastName.hashCode();
        return hash;
    }
}