package com.sincalexandrudaniel.newsreader.binding;

import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class ImageBind {
    private static final String TAG = "ImageBind";
    private final static String DEFAULT_IMAGE_URL = "https://files.betamax.raywenderlich.com/attachments/collections/127/467591fe-b1b1-4ceb-af4d-543a54163d01.png";

    @BindingAdapter({"parseImage"})
    public static void setImageSrc(ImageView imageView, String uri) {
        Log.d(TAG, "UseImageBindAdapter: Called");
        if (uri == null) {
            uri = DEFAULT_IMAGE_URL;
        }
        Uri parseUri = Uri.parse(uri);
        Glide.with(imageView.getContext())
                .load(parseUri)
                .into(imageView);
    }
}
