package com.program.codemobile.itunesapplication.repository;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.program.codemobile.itunesapplication.api.ApiClient;
import com.program.codemobile.itunesapplication.api.ApiInterface;
import com.program.codemobile.itunesapplication.models.Results;
import com.program.codemobile.itunesapplication.models.SearchResult;
import com.program.codemobile.itunesapplication.persistence.FavoriteEntity;
import com.program.codemobile.itunesapplication.persistence.ResultDao;
import com.program.codemobile.itunesapplication.persistence.RoomDatabase;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    private static final String TAG = "Repository";
    private static Repository instance;

    private ResultDao resultsDao;
    private LiveData<List<FavoriteEntity>> mFavoriteEntity;


    public Repository(Context context) {
        RoomDatabase db = RoomDatabase.getDatabase(context);
        resultsDao = db.resultsDao();
        mFavoriteEntity = resultsDao.getAllResults();
    }

    public LiveData<List<FavoriteEntity>> getResultsEntity() {
        return mFavoriteEntity;
    }

    public static Repository getInstance(Context context){
        if(instance == null){
            instance = new Repository(context);
        }
        return instance;
    }

    public MutableLiveData<SearchResult> getSearchResult(String term, String mediaType, String limit) {

        final MutableLiveData<SearchResult> refferSearchResult = new MutableLiveData<>();
        ApiInterface apiInterface =  ApiClient.getClient().create(ApiInterface.class);
        Call<SearchResult> call = apiInterface.getLookup(term,mediaType,limit);
        call.enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                for (int i = 0; i < response.body().getResults().length; i++) {
                    Log.i(TAG,"getArtistName: " + response.body().getResults()[i].getArtistName());
                }
                refferSearchResult.setValue(response.body());
            }
            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {
                Log.i(TAG,"Throwable t: " + t.toString() );
            }
        });
        return refferSearchResult;
    }


    public MutableLiveData<SearchResult> getAlbum(String id, String entity) {
        final MutableLiveData<SearchResult> refAlbumResul = new MutableLiveData<>();
        ApiInterface apiInterface =  ApiClient.getClient().create(ApiInterface.class);
        Call<SearchResult> call = apiInterface.getInfoAlbumList(id,entity);
        call.enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                refAlbumResul.setValue(response.body());
            }
            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {
                Log.i(TAG,"Throwable t: " + t.toString() );
            }
        });
        return refAlbumResul;
    }


    public void insert (Results results) {
        FavoriteEntity  favoriteEntity = new FavoriteEntity(
                results.getTrackId(),
                results.getArtworkUrl100(),
                results.getTrackTimeMillis(),
                results.getLongDescription(),
                results.getCountry(),
                results.getPreviewUrl(),
                results.getCollectionHdPrice(),
                results.getArtistId(),
                results.getTrackName(),
                results.getCollectionName(),
                results.getArtistViewUrl(),
                results.getDiscNumber(),
                results.getTrackCount(),
                results.getArtworkUrl30(),
                results.getWrapperType(),
                results.getCurrency(),
                results.getCollectionId(),
                results.getTrackExplicitness(),
                results.getCollectionViewUrl(),
                results.getTrackHdPrice(),
                results.getContentAdvisoryRating(),
                results.getTrackNumber(),
                results.getReleaseDate(),
                results.getKind(),
                results.getCollectionPrice(),
                results.getShortDescription(),
                results.getDiscCount(),
                results.getPrimaryGenreName(),
                results.getTrackPrice(),
                results.getCollectionExplicitness(),
                results.getTrackViewUrl(),
                results.getArtworkUrl60(),
                results.getTrackCensoredName(),
                results.getArtistName(),
                results.getCollectionCensoredName()
        );

        new insertAsyncTask(resultsDao).execute(favoriteEntity);
    }

    private static class insertAsyncTask extends AsyncTask<FavoriteEntity, Void, Void> {
        private ResultDao mAsyncTaskDao;
        insertAsyncTask(ResultDao dao) {
            mAsyncTaskDao = dao;
        }
        @Override
        protected Void doInBackground(final FavoriteEntity... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    public void deleteAll() {
        new deleteAllFavoritesAsyncTask(resultsDao).execute();
    }

    private static class deleteAllFavoritesAsyncTask extends AsyncTask<Void, Void, Void> {
        private ResultDao mAsyncTaskDao;
        deleteAllFavoritesAsyncTask(ResultDao dao) {
            mAsyncTaskDao = dao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.deleteAll();
            return null;
        }
    }



    public void deleteItemFavorite(String trackId) {
        new deleteWordAsyncTask2(resultsDao).execute(trackId);
    }
    private static class deleteWordAsyncTask2 extends AsyncTask<String, Void, Void> {
        private ResultDao mAsyncTaskDao;
        deleteWordAsyncTask2(ResultDao dao) {
            mAsyncTaskDao = dao;
        }
        @Override
        protected Void doInBackground(String... strings) {
            mAsyncTaskDao.deleteRecord(strings[0]);
            return null;
        }
    }

}
