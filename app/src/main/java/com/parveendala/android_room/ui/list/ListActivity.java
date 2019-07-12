package com.parveendala.android_room.ui.list;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.parveendala.android_room.R;
import com.parveendala.android_room.ui.add.AddNoteActivity;

import dagger.android.support.DaggerAppCompatActivity;

/*****
 * Parveen Dala
 * Android-ROOM
 */
public class ListActivity extends DaggerAppCompatActivity {

    private RecyclerView recyclerView;
    private TextView tvEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        recyclerView = findViewById(R.id.recycler_view);
        tvEmpty = findViewById(R.id.empty);

    }

    public void onAddNoteClicked(View view) {
        startActivity(new Intent(this, AddNoteActivity.class));
    }
}
