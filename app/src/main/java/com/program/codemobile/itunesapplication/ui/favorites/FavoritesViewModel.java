package com.program.codemobile.itunesapplication.ui.favorites;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.program.codemobile.itunesapplication.persistence.FavoriteEntity;
import com.program.codemobile.itunesapplication.repository.Repository;
import java.util.List;

public class FavoritesViewModel extends AndroidViewModel {

    private static final String TAG="FavoritesViewModel";

    Repository repository;

    private MutableLiveData<String> mText;

    private  LiveData<List<FavoriteEntity>> getFavoriteEntity;

    public FavoritesViewModel(@NonNull Application application) {
        super(application);
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
        repository = Repository.getInstance(application);
        getFavoriteEntity = repository.getResultsEntity();
    }


    public LiveData<List<FavoriteEntity>> getResultsEntity(){
        return getFavoriteEntity;
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteItemFavorite(String trackId) {
        repository.deleteItemFavorite(trackId);
    }

    public LiveData<String> getText() {
        return mText;
    }
}