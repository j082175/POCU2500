package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.Movie;
import academy.pocu.comp2500.lab10.pocuflix.NotFoundResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;

import java.util.ArrayList;

public class MovieStore implements IRequestHandler{

    private ArrayList<Movie> movies;

    public MovieStore() {
        movies = new ArrayList<>();
    }

    public void add(Movie movie) {
        this.movies.add(movie);
    }

    public boolean remove(int index) {
        if (index < this.movies.size()) {
            this.movies.remove(index);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ResultBase handle(Request request) {
        // 영화가 있다면 OkResult 없다면 NotFoundResult 반환
        return null;
    }
}
