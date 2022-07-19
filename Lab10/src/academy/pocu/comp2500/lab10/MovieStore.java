package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.*;

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
        for (int i = 0; i < movies.size(); i++) {
            if (this.movies.get(i).getTitle().equals(request.title)) {
                return new OkResult(this.movies.get(i));
            }
        }

        return new NotFoundResult();
    }
}
