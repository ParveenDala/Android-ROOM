package com.parveendala.android_room.data.database;

import android.util.Log;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.parveendala.android_room.models.Note;

/*****
 * Parveen Dala
 * Android-ROOM
 */
@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {
    private static final String TAG = "NoteDatabase";

    NoteDatabase() {
        Log.d(TAG, "NoteDatabase: ");
    }

    public abstract NoteDao noteDao();

}
