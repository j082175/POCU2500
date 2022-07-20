package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.User;

public class Request {
    protected String title;
    protected User user;

    public Request(String title) {
        this.title = title;
        this.user = new User("", "");
    }

    public void setUser(User user) {
        this.user = user;
    }

/*    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null
                || !(obj instanceof User)
                || this.hashCode() != obj.hashCode()) {
            return false;
        }

        Request other = (Request) obj;
        return this.title.equals(other.title) && this.user.equals(other.user);
    }*/
}
