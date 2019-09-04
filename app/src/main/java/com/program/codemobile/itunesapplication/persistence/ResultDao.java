package com.program.codemobile.itunesapplication.persistence;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import java.util.List;

@Dao
public interface ResultDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(FavoriteEntity favoriteEntity);

    @Query("SELECT * from favorite_table")
    LiveData<List<FavoriteEntity>> getAllResults();

    @Query("DELETE FROM favorite_table")
    void deleteAll();

    @Query("DELETE FROM favorite_table WHERE trackId = :arg0")
    void deleteRecord(String arg0);
}
