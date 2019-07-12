package com.parveendala.android_room.di.list;

import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.parveendala.android_room.ui.list.ListActivity;
import com.parveendala.android_room.ui.list.ListRecyclerAdapter;

import dagger.Module;
import dagger.Provides;

/*****
 * Parveen Dala
 * Android-ROOM
 */
@Module
public class ListModule {
    private static final String TAG = "ListModule";

    @ListScope
    @Provides
    LinearLayoutManager linearLayoutManager(ListActivity listActivity) {
        Log.d(TAG, "linearLayoutManager: ");
        return new LinearLayoutManager(listActivity);
    }


    @ListScope
    @Provides
    ListRecyclerAdapter listRecyclerAdapter() {
        Log.d(TAG, "listRecyclerAdapter: ");
        return new ListRecyclerAdapter();
    }
}