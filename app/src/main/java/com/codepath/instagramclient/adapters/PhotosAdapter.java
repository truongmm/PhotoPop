package com.codepath.instagramclient.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.instagramclient.utils.CircleTransform;
import com.codepath.instagramclient.models.Photo;
import com.codepath.instagramclient.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PhotosAdapter extends ArrayAdapter<Photo> {
    public PhotosAdapter(Context context, ArrayList<Photo> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Photo photo = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_photo, parent, false);
        }

        ImageView ivUser = (ImageView) convertView.findViewById(R.id.ivUser);
        ivUser.setImageResource(0);
        Picasso.with(getContext()).load(photo.userImage).transform(new CircleTransform()).into(ivUser);

        TextView tvUsername = (TextView) convertView.findViewById(R.id.tvUsername);
        tvUsername.setText(photo.username);

        ImageView ivPhoto = (ImageView) convertView.findViewById(R.id.ivPhoto);
        ivPhoto.setImageResource(0);
        Picasso.with(getContext()).load(photo.imageUrl).placeholder(R.drawable.loader).into(ivPhoto);

        TextView tvLikes = (TextView) convertView.findViewById(R.id.tvLikes);
        tvLikes.setText(photo.formattedLikesCount());

        TextView tvCaption = (TextView) convertView.findViewById(R.id.tvCaption);
        tvCaption.setText(photo.caption);

        return convertView;
    }
}
