package com.parveendala.android_room.ui.add;

import androidx.lifecycle.ViewModel;

import com.parveendala.android_room.data.NoteRepository;
import com.parveendala.android_room.models.Note;

import javax.inject.Inject;

/*****
 * Parveen Dala
 * Android-ROOM
 */
public class AddNoteViewModel extends ViewModel {

    private NoteRepository noteRepository;

    @Inject
    public AddNoteViewModel(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public void insertNote(Note note) {
        noteRepository.insertNote(note);
    }

}
