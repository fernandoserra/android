package com.program.codemobile.itunesapplication.persistence;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;

@Database(entities = {FavoriteEntity.class}, version = 1, exportSchema = false)
public abstract class RoomDatabase extends androidx.room.RoomDatabase {

    public abstract ResultDao resultsDao();
    private static RoomDatabase INSTANCE;

    public static RoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RoomDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RoomDatabase.class, "favorite_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}