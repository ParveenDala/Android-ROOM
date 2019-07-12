package com.parveendala.android_room.di.add;

import androidx.lifecycle.ViewModel;

import com.parveendala.android_room.di.ViewModelKey;
import com.parveendala.android_room.ui.add.AddNoteViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/*****
 * Parveen Dala
 * Android-ROOM
 */
@Module
public abstract class AddNoteViewModelModule {

    @AddScope
    @Binds
    @IntoMap
    @ViewModelKey(AddNoteViewModel.class)
    abstract ViewModel addNoteViewModel(AddNoteViewModel addNoteViewModel);

}
