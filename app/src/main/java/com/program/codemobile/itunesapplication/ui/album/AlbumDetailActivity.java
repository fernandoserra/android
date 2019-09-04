package com.program.codemobile.itunesapplication.ui.album;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.program.codemobile.itunesapplication.R;
import com.program.codemobile.itunesapplication.adapters.RecyclerTrackAdapter;
import com.program.codemobile.itunesapplication.models.SearchResult;
import com.squareup.picasso.Picasso;

import java.util.Arrays;

public class AlbumDetailActivity extends AppCompatActivity {

    private static final String TAG = "AlbumDetailActivity";
    private AlbumDetailModel albumDetailModel;

    private ImageView showImgAlbum;
    private TextView showTitleBand;
    private TextView showTitleAlbum;
    private TextView showGenreName;
    private ProgressBar showProgressBar;

    RecyclerView recyclerView;
    RecyclerTrackAdapter recyclerTrackAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_detail);

        albumDetailModel = ViewModelProviders.of(this).get(AlbumDetailModel.class);
        showImgAlbum  =(ImageView) findViewById(R.id.showImgAlbum);
        showTitleBand =(TextView) findViewById(R.id.showTitleBand);
        showTitleAlbum=(TextView) findViewById(R.id.showTitleAlbum);
        showGenreName=(TextView) findViewById(R.id.showGenreName);
        showProgressBar=(ProgressBar) findViewById(R.id.showProgressBar);
        String collectionId= getIntent().getStringExtra("collectionId");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerviewTrack);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        getInfoAlbum(collectionId);
        getTrackAlbum(collectionId);

    }



    public void getInfoAlbum(String collectionId){
        albumDetailModel.getAlbum(collectionId,"album").observe(this, new Observer<SearchResult>() {
            @Override
            public void onChanged(SearchResult searchResult) {
               Picasso.with(getApplicationContext()).load(searchResult.getResults()[0].getArtworkUrl100()).into(showImgAlbum);
               showTitleBand.setText(searchResult.getResults()[0].getArtistName());
               showTitleAlbum.setText(searchResult.getResults()[0].getCollectionName());
               showGenreName.setText(searchResult.getResults()[0].getPrimaryGenreName());

            }
        });
    }

    public void getTrackAlbum(String collectionId){
        albumDetailModel.getAlbum(collectionId,"song").observe(this, new Observer<SearchResult>() {
            @Override
            public void onChanged(SearchResult searchResult) {
                recyclerTrackAdapter = new RecyclerTrackAdapter(getApplicationContext(), Arrays.asList(searchResult.getResults()));
                recyclerView.setAdapter(recyclerTrackAdapter);
                showProgressBar.setVisibility(View.INVISIBLE);
            }
        });
    }

}