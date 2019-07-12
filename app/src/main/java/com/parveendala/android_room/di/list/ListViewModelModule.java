package com.parveendala.android_room.di.list;

import androidx.lifecycle.ViewModel;

import com.parveendala.android_room.di.ViewModelKey;
import com.parveendala.android_room.ui.list.ListViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/*****
 * Parveen Dala
 * Android-ROOM
 */
@Module
public abstract class ListViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel.class)
    abstract ViewModel listViewModel(ListViewModel listViewModel);


}
