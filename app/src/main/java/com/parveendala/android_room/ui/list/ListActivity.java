package com.parveendala.android_room.ui.list;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.parveendala.android_room.R;
import com.parveendala.android_room.models.Note;
import com.parveendala.android_room.ui.add.AddNoteActivity;
import com.parveendala.android_room.viewmodel.ViewModelProviderFactory;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

/*****
 * Parveen Dala
 * Android-ROOM
 */
public class ListActivity extends DaggerAppCompatActivity {
    private static final String TAG = "ListActivity";
    private RecyclerView recyclerView;
    private TextView tvEmpty;

    @Inject
    ViewModelProviderFactory viewModelProviderFactory;
    private ListViewModel listViewModel;

    @Inject
    ListRecyclerAdapter listRecyclerAdapter;

    @Inject
    LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        recyclerView = findViewById(R.id.recycler_view);
        tvEmpty = findViewById(R.id.empty);
        listViewModel = ViewModelProviders.of(this, viewModelProviderFactory).get(ListViewModel.class);
        setRecyclerView();
        getAllNotes();
    }

    private void setRecyclerView() {
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(listRecyclerAdapter);


        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, new RecyclerItemTouchHelper.RecyclerItemTouchHelperListener() {
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {

                final int notePosition = viewHolder.getAdapterPosition();
                final Note note = listRecyclerAdapter.getItem(notePosition);

                listRecyclerAdapter.removeNote(notePosition);

                Snackbar snackbar = Snackbar.make(recyclerView, "Note Deleted !", Snackbar.LENGTH_LONG);
                snackbar.setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listRecyclerAdapter.addNote(note, notePosition);
                    }
                });
                snackbar.setActionTextColor(Color.YELLOW);
                snackbar.show();
            }
        });
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);

    }

    private void getAllNotes() {
        listViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                Log.d(TAG, "onChanged: ");
                if (notes != null && notes.size() > 0) {
                    listRecyclerAdapter.setList(notes);
                    showData(true);
                } else {
                    showData(false);
                }
            }
        });
    }

    private void showData(boolean isShowing) {
        if (isShowing) {
            recyclerView.setVisibility(View.VISIBLE);
            tvEmpty.setVisibility(View.GONE);
        } else {
            recyclerView.setVisibility(View.GONE);
            tvEmpty.setVisibility(View.VISIBLE);
            tvEmpty.setText("Empty list");
        }
    }

    public void onAddNoteClicked(View view) {
        startActivity(new Intent(this, AddNoteActivity.class));
    }
}
