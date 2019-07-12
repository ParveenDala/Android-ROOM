package com.parveendala.android_room.data.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.parveendala.android_room.models.Note;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert
    public void insert(Note note);

    @Delete
    public void delete(Note note);

    @Query("DELETE FROM NOTE")
    void deleteAll();

    @Query("SELECT * FROM NOTE ORDER BY ID")
    LiveData<List<Note>> getAllNotes();

}
