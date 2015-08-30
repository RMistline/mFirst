package com.first;


import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Movie {


        /**
         * title : Dawn of the Planet of the Apes
         * image : http://api.androidhive.info/json/movies/1.jpg
         * rating : 8.3
         * releaseYear : 2014
         * genre : ["Action","Drama","Sci-Fi"]
         */

        @SerializedName("title")
        private String title;
        @SerializedName("image")
        private String image;
        @SerializedName("rating")
        private double rating;
        @SerializedName("releaseYear")
        private int releaseYear;
        @SerializedName("genre")
        private List<String> genre;

        public Movie() {
        }

        public Movie(String title, String image, double rating, int releaseYear, List<String> genre) {
        this.title = title;
        this.image = image;
        this.rating = rating;
        this.releaseYear = releaseYear;
        this.genre = genre;
        }

    public static List<Movie> arrayConEntityFromData(String str) {

            Type listType = new TypeToken<ArrayList<Movie>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public void setReleaseYear(int releaseYear) {
            this.releaseYear = releaseYear;
        }

        public void setGenre(List<String> genre) {
            this.genre = genre;
        }

        public String getTitle() {
            return title;
        }

        public String getImage() {
            return image;
        }

        public double getRating() {
            return rating;
        }

        public int getReleaseYear() {
            return releaseYear;
        }

        public List<String> getGenre() {
            return genre;
        }
    }

