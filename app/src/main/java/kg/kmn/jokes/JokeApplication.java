package kg.kmn.jokes;

import android.app.Application;

import kg.kmn.jokes.api.JokeService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class JokeApplication extends Application {
    private JokeService mJokeService;

    @Override
    public void onCreate() {
        super.onCreate();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://official-joke-api.appspot.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mJokeService = retrofit.create(JokeService.class);
    }

    public JokeService getJokeService(){
        return mJokeService;
    }

}
