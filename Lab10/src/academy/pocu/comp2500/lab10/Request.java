package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.User;

public class Request {
    protected String title;
    protected User user;

    public Request(String title) {
        this.title = title;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
