package kg.kmn.jokes.ui;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kg.kmn.jokes.api.JokeService;

public class JokePresenter {

    public interface Listener{
        public void onJokesLoaded(List<Joke> jokes);

        public void onError(String message);
    }

    private JokeService mJokeService;
    private Listener mListener;
    private Disposable mDisposable; // мы можем остановить запрос на интернет после остановки активити

    public JokePresenter(JokeService jokeService, Listener listener) {
        mJokeService = jokeService;
        mListener = listener;
    }

    public void loadJokes(){
        mDisposable =  mJokeService.listJokes()
                .subscribeOn(Schedulers.io()) // на ассинхронном потоке будет работать чтобы не убить главный поток
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(jokes -> mListener.onJokesLoaded(jokes), error -> mListener.onError(error.getMessage()));
    }

    public void stopLoading(){
        if (mDisposable != null){
            mDisposable.dispose();
        }
    }
}
