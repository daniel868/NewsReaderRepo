package com.sincalexandrudaniel.newsreader.binding;

import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class ImageBind {
    private static final String TAG = "ImageBind";
    @BindingAdapter({"parseImage"})
    public static void setImageSrc(ImageView imageView, String uri) {
        Log.d(TAG, "UseImageBindAdapter: Called");
        Uri parseUri = Uri.parse(uri);
        Glide.with(imageView.getContext())
                .load(parseUri)
                .into(imageView);
    }
}
