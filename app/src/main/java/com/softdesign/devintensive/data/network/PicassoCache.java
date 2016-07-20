package com.softdesign.devintensive.data.network;


import android.content.Context;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

public class PicassoCache {
    private Context mContext;
    private Picasso mPicassoInstanse;

    public PicassoCache(Context context) {
        this.mContext = context;
        OkHttp3Downloader okHttp3Downloader = new OkHttp3Downloader(context, Integer.MAX_VALUE);
        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(okHttp3Downloader);

        mPicassoInstanse = builder.build();
        Picasso.setSingletonInstance(mPicassoInstanse);
    }

    public Picasso getPicassoInstance() {
        if (mPicassoInstanse == null){
        new PicassoCache(mContext);
        return mPicassoInstanse;
        }

        return mPicassoInstanse;
    }
}
