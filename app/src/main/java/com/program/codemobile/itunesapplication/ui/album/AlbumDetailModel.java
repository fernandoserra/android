package com.program.codemobile.itunesapplication.ui.album;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.program.codemobile.itunesapplication.models.SearchResult;
import com.program.codemobile.itunesapplication.repository.Repository;

public class AlbumDetailModel extends AndroidViewModel {

    private static final String TAG = "AlbumDetailModel";
    private Repository repository;

    public AlbumDetailModel(@NonNull Application application) {
        super(application);
        repository = Repository.getInstance(application);
    }


    public MutableLiveData<SearchResult> getAlbum(String id, String entity) {
        return  repository.getAlbum(id,entity);
    }
}