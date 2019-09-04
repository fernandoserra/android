package com.program.codemobile.itunesapplication.ui.home;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.program.codemobile.itunesapplication.models.Results;
import com.program.codemobile.itunesapplication.models.SearchResult;
import com.program.codemobile.itunesapplication.repository.Repository;

public class HomeViewModel extends AndroidViewModel {

    private Repository repository;
    private MutableLiveData<String> mText;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
        repository = Repository.getInstance(application);
        //getResultsEntity= repository.getResultsEntity();
    }

    public MutableLiveData<SearchResult> getSearchResult(String term, String mediaType, String limit) {
        return  repository.getSearchResult(term, mediaType, limit);
    }

    public void insert(Results results) {
        repository.insert(results);
    }

    public LiveData<String> getText() {
        return mText;
    }


}