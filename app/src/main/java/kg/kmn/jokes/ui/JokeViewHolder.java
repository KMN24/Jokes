package kg.kmn.jokes.ui;


import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import kg.kmn.jokes.R;


public class JokeViewHolder extends RecyclerView.ViewHolder {

    public TextView mJokeId;
    public TextView mJokeType;
    public TextView mJokeSetup;
    public TextView mJokePunchline;
    public LinearLayout mContainer;


    public JokeViewHolder(@NonNull View itemView) {
        super(itemView);
        mContainer = itemView.findViewById(R.id.container);
        mJokeId = itemView.findViewById(R.id.joke_id);
        mJokeType = itemView.findViewById(R.id.joke_type);
        mJokeSetup = itemView.findViewById(R.id.joke_setup);
        mJokePunchline = itemView.findViewById(R.id.joke_punchline);

    }
}
