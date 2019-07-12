package com.parveendala.android_room.ui.add;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.parveendala.android_room.R;

import dagger.android.support.DaggerAppCompatActivity;

/*****
 * Parveen Dala
 * Android-ROOM
 */
public class AddNoteActivity extends DaggerAppCompatActivity {

    private TextInputEditText etTitle, etBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        etTitle = findViewById(R.id.title);
        etBody = findViewById(R.id.body);

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

    }
}
