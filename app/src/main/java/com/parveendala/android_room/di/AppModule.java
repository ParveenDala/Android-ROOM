package com.parveendala.android_room.di;

import android.app.Application;
import android.util.Log;

import androidx.room.Room;

import com.parveendala.android_room.data.NoteRepository;
import com.parveendala.android_room.data.database.NoteDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/*****
 * Parveen Dala
 * Android-ROOM
 */
@Module
public class AppModule {
    private static final String TAG = "AppModule";

    @Singleton
    @Provides
    static NoteDatabase noteDatabase(Application application) {
        Log.d(TAG, "noteDatabase: ");
        return Room.databaseBuilder(application, NoteDatabase.class, "note_database").build();
    }

    @Singleton
    @Provides
    static NoteRepository noteRepository(NoteDatabase noteDatabase) {
        Log.d(TAG, "noteRepository: ");
        return new NoteRepository(noteDatabase.noteDao());
    }

}
