package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.Movie;
import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.User;

import java.util.HashSet;

public class AuthorizationMiddleware implements IRequestHandler{
    private IRequestHandler iRequestHandler;
    public HashSet<User> users;

    public AuthorizationMiddleware(IRequestHandler iRequestHandler, HashSet<User> users) {
        this.iRequestHandler = iRequestHandler;
        this.users = users;
    }


    @Override
    public ResultBase handle(Request request) {


        if (this.users.contains(request.user)) {
            return iRequestHandler.handle(request);
        }

        return new UnauthorizedResult();
    }
}
