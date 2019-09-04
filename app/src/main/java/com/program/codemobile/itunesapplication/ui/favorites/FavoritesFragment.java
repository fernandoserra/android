package com.program.codemobile.itunesapplication.ui.favorites;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.program.codemobile.itunesapplication.R;
import com.program.codemobile.itunesapplication.adapters.RecyclerTrackFavoriteAdapter;
import com.program.codemobile.itunesapplication.models.Results;
import com.program.codemobile.itunesapplication.persistence.FavoriteEntity;

import java.util.ArrayList;
import java.util.List;

public class FavoritesFragment extends Fragment {

    private  static  final String TAG="FavoritesFragment";

    private FavoritesViewModel dashboardViewModel;
    private ProgressBar showProgressTrack;
    RecyclerView recyclerView;
    RecyclerTrackFavoriteAdapter recyclerTrackAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel = ViewModelProviders.of(this).get(FavoritesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        showProgressTrack=(ProgressBar) root.findViewById(R.id.showProgressTrack);
        showProgressTrack.setVisibility(View.VISIBLE);
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerviewTrack);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        showHistory();
        setHasOptionsMenu(true);
        return root;
    }


    public void showHistory(){
        dashboardViewModel.getResultsEntity().observe(this, new Observer<List<FavoriteEntity>>() {
            @Override
            public void onChanged(List<FavoriteEntity> favoriteEntities) {
                List<Results> resultsEntities = new ArrayList<>();
                for (int i = 0; i < favoriteEntities.size(); i++) {
                    Results results = new Results(
                            favoriteEntities.get(i).getArtworkUrl100(),
                            favoriteEntities.get(i).getTrackTimeMillis(),
                            favoriteEntities.get(i).getLongDescription(),
                            favoriteEntities.get(i).getCountry(),
                            favoriteEntities.get(i).getPreviewUrl(),
                            favoriteEntities.get(i).getCollectionHdPrice(),
                            favoriteEntities.get(i).getArtistId(),
                            favoriteEntities.get(i).getTrackName(),
                            favoriteEntities.get(i).getCollectionName(),
                            favoriteEntities.get(i).getArtistViewUrl(),
                            favoriteEntities.get(i).getDiscNumber(),
                            favoriteEntities.get(i).getTrackCount(),
                            favoriteEntities.get(i).getArtworkUrl30(),
                            favoriteEntities.get(i).getWrapperType(),
                            favoriteEntities.get(i).getCurrency(),
                            favoriteEntities.get(i).getCollectionId(),
                            favoriteEntities.get(i).getTrackExplicitness(),
                            favoriteEntities.get(i).getCollectionViewUrl(),
                            favoriteEntities.get(i).getTrackHdPrice(),
                            favoriteEntities.get(i).getContentAdvisoryRating(),
                            favoriteEntities.get(i).getTrackNumber(),
                            favoriteEntities.get(i).getReleaseDate(),
                            favoriteEntities.get(i).getKind(),
                            favoriteEntities.get(i).getTrackId(),
                            favoriteEntities.get(i).getCollectionPrice(),
                            favoriteEntities.get(i).getShortDescription(),
                            favoriteEntities.get(i).getDiscCount(),
                            favoriteEntities.get(i).getPrimaryGenreName(),
                            favoriteEntities.get(i).getTrackPrice(),
                            favoriteEntities.get(i).getCollectionExplicitness(),
                            favoriteEntities.get(i).getTrackViewUrl(),
                            favoriteEntities.get(i).getArtworkUrl60(),
                            favoriteEntities.get(i).getTrackCensoredName(),
                            favoriteEntities.get(i).getArtistName(),
                            favoriteEntities.get(i).getCollectionCensoredName()
                    );
                    resultsEntities.add(results);
                }
                recyclerTrackAdapter = new RecyclerTrackFavoriteAdapter(getContext(), resultsEntities);
                recyclerView.setAdapter(recyclerTrackAdapter);
                showProgressTrack.setVisibility(View.INVISIBLE);


                ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                        ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(@NonNull RecyclerView recyclerView,
                                          @NonNull RecyclerView.ViewHolder viewHolder,
                                          @NonNull RecyclerView.ViewHolder target) {
                        return false;
                    }

                    @Override
                    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                        int position = viewHolder.getAdapterPosition();
                        Results results  = recyclerTrackAdapter.getResultsPosition(position);
                        dashboardViewModel.deleteItemFavorite(recyclerTrackAdapter.getResultsPosition(position).getTrackId());
                    }
                });
                helper.attachToRecyclerView(recyclerView);

            }
        });
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_favorites,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.manu_deleteAll:
                dashboardViewModel.deleteAll();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}