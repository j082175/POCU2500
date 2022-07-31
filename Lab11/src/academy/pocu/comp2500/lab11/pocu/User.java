package academy.pocu.comp2500.lab11.pocu;

public class User {
    private String firstName;
    private String lastName;
    private Department department;

    public User() {
        loadUserMock();
    }

    // mock
    User(final String firstName, final String lastName, final Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public Department getDepartment() {
        return this.department;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null
                || !(obj instanceof academy.pocu.comp2500.lab11.pocu.User)
                || this.hashCode() != obj.hashCode()) {
            return false;
        }

        User other = (User) obj;
        return this.firstName.equals(other.firstName)
                && this.lastName.equals(other.lastName)
                && this.department == other.department;
    }

    @Override
    public int hashCode() {
        int hash = this.firstName.hashCode() ^ (this.lastName.hashCode() << 16);
        hash += this.department.hashCode();

        return hash;
    }

    //mock
    private void loadUserMock() {
/*        this.firstName = "John";
        this.lastName = "Doe";
        this.department = Department.ENGINEERING;*/

        this.firstName = "Jane";
        this.lastName = "Many1";
        this.department = Department.ENGINEERING;

        /*User user1 = new User("JUNSOO","CHO", Department.PROGRAMMING);
        User user2 = new User("ONE","1", Department.OPERATION);
        User user3 = new User("TWO","2", Department.HUMAN_RESOURCES);
        User user4 = new User("Jane","Many", Department.ENGINEERING);*/
    }
}
