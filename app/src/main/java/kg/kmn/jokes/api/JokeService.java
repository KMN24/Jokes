package kg.kmn.jokes.api;

import java.util.List;

import io.reactivex.Single;
import kg.kmn.jokes.ui.Joke;
import retrofit2.http.GET;

public interface JokeService {
    @GET("random_ten")
    Single<List<Joke>> listJokes();
}
