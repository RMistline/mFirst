package com.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Adapter adapter;
    String url="http://api.androidhive.info/json/movies.json";
    Gson gson;
    AsyncHttpClient client;
    Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        listView= (ListView) findViewById(R.id.list);

        client=new AsyncHttpClient();
        client.get(MainActivity.this, url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String responceStr=new String(responseBody);
                List<Movie> responce=new ArrayList<Movie>();


                gson=new Gson();
                Type type=new TypeToken<List<Movie>>(){}.getType();
                responce=gson.fromJson(responceStr,type);
                adapter=new Adapter(MainActivity.this,responce);
                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }


}
