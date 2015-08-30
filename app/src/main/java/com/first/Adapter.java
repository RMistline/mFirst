package com.first;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


public class Adapter extends BaseAdapter {

    private Context context;

    private LayoutInflater inflater;

    private List<Movie> movieList;

    public Adapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int position) {
        return movieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
          if(inflater==null){
              inflater=LayoutInflater.from(context);
          }

            if (convertView==null){
                convertView=inflater.inflate(R.layout.list_row,null);
            }

        ImageView thumbNail= (ImageView) convertView.findViewById(R.id.thumbnail);
        TextView title= (TextView) convertView.findViewById(R.id.title);
        TextView rating= (TextView) convertView.findViewById(R.id.rating);
        TextView genre= (TextView) convertView.findViewById(R.id.genre);
        TextView year= (TextView) convertView.findViewById(R.id.releaseYear);

        Movie item=movieList.get(position);

        String imageUrl=item.getImage();
        Picasso.with(context).load(imageUrl).into(thumbNail);

        title.setText(item.getTitle());
        rating.setText("Rating: "+String.valueOf(item.getRating()));
        // genre
        String genreStr = "";
        for (String str : item.getGenre()) {
            genreStr += str + ", ";
        }
        genreStr = genreStr.length() > 0 ? genreStr.substring(0,
                genreStr.length() - 2) : genreStr;
        genre.setText(genreStr);

        // release year
        year.setText(String.valueOf(item.getReleaseYear()));






        return convertView;
    }
}
