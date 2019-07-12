package com.parveendala.android_room.ui.list;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.parveendala.android_room.data.NoteRepository;
import com.parveendala.android_room.models.Note;

import java.util.List;

import javax.inject.Inject;

/*****
 * Parveen Dala
 * Android-ROOM
 */
public class ListViewModel extends ViewModel {

    private NoteRepository noteRepository;
    private LiveData<List<Note>> allNotes;

    @Inject
    public ListViewModel(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
        allNotes = noteRepository.getAllNotes();
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }

    public void insertNote(Note note) {
        noteRepository.insertNote(note);
    }

    public void deleteNote(Note note) {
        noteRepository.delete(note);
    }

    public void deleteAllNotes() {
        noteRepository.deleteAll();
    }

}
