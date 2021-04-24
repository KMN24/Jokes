package kg.kmn.jokes.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kg.kmn.jokes.R;

public class JokeAdapter extends RecyclerView.Adapter {

    private List<Joke> jokes;
    private Context mContext;

    public JokeAdapter(Context context, List<Joke> jokes) {
        this.mContext = context;
        this.jokes = jokes;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_joke, parent, false);
        return new JokeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        JokeViewHolder jokeViewHolder = (JokeViewHolder) holder;
        jokeViewHolder.mContainer.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_scale_anim));
        jokeViewHolder.mJokeId.setText("ID: " + jokes.get(position).getJokeId());
        jokeViewHolder.mJokeType.setText("Type: " +  jokes.get(position).getType());
        jokeViewHolder.mJokeSetup.setText(" - " + jokes.get(position).getSetup());
        jokeViewHolder.mJokePunchline.setText(" - " + jokes.get(position).getPunchline());
    }

    @Override
    public int getItemCount() {
        return jokes.size();
    }
}
