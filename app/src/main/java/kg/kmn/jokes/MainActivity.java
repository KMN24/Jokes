package kg.kmn.jokes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import kg.kmn.jokes.ui.Joke;
import kg.kmn.jokes.ui.JokeAdapter;
import kg.kmn.jokes.ui.JokePresenter;
import kg.kmn.jokes.api.JokeService;

public class MainActivity extends AppCompatActivity implements JokePresenter.Listener {

    private RecyclerView mRecyclerView;
    private JokePresenter mJokePresenter;
    private Button mRefreshBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.joke_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRefreshBtn = findViewById(R.id.btn_refresh);

        startService();
        mRefreshBtn.setOnClickListener( v -> startService());
    }

    @Override
    public void onJokesLoaded(List<Joke> jokes) {
        mRecyclerView.setAdapter(new JokeAdapter(this, jokes));
    }

    @Override
    public void onError(String message) {
        Toast.makeText(this, String.format("An error occurred: ", message), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mJokePresenter.stopLoading();
    }

    private void startService(){
        JokeService jokeService = ((JokeApplication) getApplication()).getJokeService();
        mJokePresenter = new JokePresenter(jokeService, this);
        mJokePresenter.loadJokes();
    }

}