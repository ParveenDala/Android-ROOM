package com.parveendala.android_room.ui.add;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.textfield.TextInputEditText;
import com.parveendala.android_room.R;
import com.parveendala.android_room.models.Note;
import com.parveendala.android_room.viewmodel.ViewModelProviderFactory;

import java.util.Calendar;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

/*****
 * Parveen Dala
 * Android-ROOM
 */
public class AddNoteActivity extends DaggerAppCompatActivity {

    private TextInputEditText etTitle, etBody;

    @Inject
    ViewModelProviderFactory viewModelProviderFactory;
    private AddNoteViewModel addNoteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        etTitle = findViewById(R.id.title);
        etBody = findViewById(R.id.body);

        addNoteViewModel = ViewModelProviders.of(this, viewModelProviderFactory).get(AddNoteViewModel.class);
    }

    public void onAddNoteClicked(View view) {
        if (TextUtils.isEmpty(etTitle.getText().toString().trim())) {
            etTitle.setError("Please enter note title");
            return;
        }

        if (TextUtils.isEmpty(etBody.getText().toString().trim())) {
            etBody.setError("Please enter note body");
            return;
        }

        Note note = new Note(etTitle.getText().toString().trim(), etBody.getText().toString().trim(), String.valueOf(Calendar.getInstance().getTime()));

        addNoteViewModel.insertNote(note);

        finish();
    }
}
