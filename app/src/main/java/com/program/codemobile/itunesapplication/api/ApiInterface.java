package com.program.codemobile.itunesapplication.api;

import com.program.codemobile.itunesapplication.models.SearchResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("search")
    Call<SearchResult> getLookup(
            @Query("term") String term,
            @Query("mediaType") String mediaType,
            @Query("limit") String limit
    );

    @GET("lookup")
    Call<SearchResult> getInfoAlbumList(
            @Query("id") String id,
            @Query("entity") String entity
    );

}
