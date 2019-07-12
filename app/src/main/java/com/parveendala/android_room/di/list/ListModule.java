package com.parveendala.android_room.di.list;

import android.util.Log;

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

    @Provides
    ListRecyclerAdapter listRecyclerAdapter() {
        Log.d(TAG, "listRecyclerAdapter: ");
        return new ListRecyclerAdapter();
    }
}


