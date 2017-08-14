package moviefy.com.mitchthornton.moviefy;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    ArrayList<MovieHolder> movies = new ArrayList<>();

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.main_fragment, container, false);

        Bitmap icon = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.test_bitmap);

        movies.add(new MovieHolder("Back to the Future", icon));
        movies.add(new MovieHolder("Forest Gump", icon));
        movies.add(new MovieHolder("Jaws", icon));
        movies.add(new MovieHolder("Star Wars", icon));
        movies.add(new MovieHolder("Indiana Jones", icon));
        movies.add(new MovieHolder("Batman: The Dark Knight", icon));
        movies.add(new MovieHolder("Lord of the Rings", icon));
        movies.add(new MovieHolder("Saving Private Ryan", icon));


        GridView gv_movies = (GridView) view.findViewById(R.id.gv_movies);

        CustomGridAdapter adapter = new CustomGridAdapter(this.getActivity(), movies, R.layout.customgrid);

        gv_movies.setAdapter(adapter);

        gv_movies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra(Intent.EXTRA_TEXT, movies.get(position).getMovieTitle().toString());

                getActivity().startActivity(intent);
            }
        });


        return view;
    }


    public class FetchMoviesTask extends AsyncTask<String, Void, String[]> {

        @Override
        protected String[] doInBackground(String... params) {
            return new String[0];
        }
    }

}
