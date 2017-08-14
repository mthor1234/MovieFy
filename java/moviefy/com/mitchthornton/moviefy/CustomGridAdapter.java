package moviefy.com.mitchthornton.moviefy;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomGridAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<MovieHolder> movies;
    int layoutResourceId;



    public CustomGridAdapter(Context c, ArrayList<MovieHolder> movies, int resource) {
        this.movies = movies;
        mContext = c;
        layoutResourceId = resource;

    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        Holder holder = null;


        if(row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new Holder();
            holder.movie_poster = (ImageView) row.findViewById(R.id.imgview_movie_poster);
            holder.tv_MovieTitle = (TextView) row.findViewById(R.id.tv_movie_title);
            row.setTag(holder);
        }
        else{
            holder = (Holder) row.getTag();
        }

        MovieHolder movie = movies.get(position);
        holder.movie_poster.setImageBitmap(movie.getMoviePoster());
        holder.tv_MovieTitle.setText(movie.getMovieTitle());

        return row;
    }

    private class Holder{
        ImageView movie_poster;
        TextView tv_MovieTitle;

    }
}
