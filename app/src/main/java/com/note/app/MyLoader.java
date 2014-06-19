package com.note.app;

import android.content.Context;
import android.content.CursorLoader;

/**
 * Created by student on 6/16/14.
 */
public class MyLoader extends CursorLoader {
    /**
     * Stores away the application context associated with context.
     * Since Loaders can be used across multiple activities it's dangerous to
     * store the context directly; always use {@link #getContext()} to retrieve
     * the Loader's Context, don't use the constructor argument directly.
     * The Context returned by {@link #getContext} is safe to use across
     * Activity instances.
     *
     * @param context used to retrieve the application context.
     */
    public MyLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        //Форсируем загрузку
        super.onStartLoading();
    }

    @Override
    protected void onStopLoading() {
        super.onStopLoading();
    }




}
