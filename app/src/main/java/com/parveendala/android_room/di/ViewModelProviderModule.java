package com.parveendala.android_room.di;

import androidx.lifecycle.ViewModelProvider;

import com.parveendala.android_room.viewmodel.ViewModelProviderFactory;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

/*****
 * Parveen Dala
 * Android-ROOM
 */

@Module
public abstract class ViewModelProviderModule {

    @Singleton
    @Binds
    abstract ViewModelProvider.Factory viewModuleProviderFactory(ViewModelProviderFactory viewModelProviderFactory);

}
