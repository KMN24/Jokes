package kg.kmn.jokes.ui;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Joke {
    // SerializedName
    @SerializedName("id")
    private String mJokeId;
    @SerializedName("type")
    private String mType;
    @SerializedName("setup")
    private String mSetup;
    @SerializedName("punchline")
    private String mPunchline;

    public Joke(String jokeId, String type, String setup, String punchline) {
        mJokeId = jokeId;
        mType = type;
        mSetup = setup;
        this.mPunchline = punchline;
    }

    public String getJokeId() {
        return mJokeId;
    }

    public String getType() {
        return mType;
    }

    public String getSetup() {
        return mSetup;
    }

    public String getPunchline() {
        return mPunchline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joke joke = (Joke) o;
        return mJokeId == joke.mJokeId &&
                Objects.equals(mType, joke.mType) &&
                Objects.equals(mSetup, joke.mSetup) &&
                Objects.equals(mPunchline, joke.mPunchline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mJokeId, mType, mSetup, mPunchline);
    }

    @Override
    public String toString() {
        return "Joke{" +
                "mJokeId=" + mJokeId +
                ", mType='" + mType + '\'' +
                ", mSetup='" + mSetup + '\'' +
                ", punchline='" + mPunchline + '\'' +
                '}';
    }
}
