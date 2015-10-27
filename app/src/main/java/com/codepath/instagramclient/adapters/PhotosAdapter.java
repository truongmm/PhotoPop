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
    // View lookup cache
    private static class ViewHolder {
        ImageView ivUser;
        TextView tvUsername;
        ImageView ivPhoto;
        TextView tvLikes;
        TextView tvCaption;
    }

    public PhotosAdapter(Context context, ArrayList<Photo> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Photo photo = getItem(position);
        ViewHolder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_photo, parent, false);
            viewHolder.ivUser = (ImageView) convertView.findViewById(R.id.ivUser);
            viewHolder.tvUsername = (TextView) convertView.findViewById(R.id.tvUsername);
            viewHolder.ivPhoto = (ImageView) convertView.findViewById(R.id.ivPhoto);
            viewHolder.tvLikes = (TextView) convertView.findViewById(R.id.tvLikes);
            viewHolder.tvCaption = (TextView) convertView.findViewById(R.id.tvCaption);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.ivUser.setImageResource(0);
        Picasso.with(getContext()).load(photo.userImage).transform(new CircleTransform()).into(viewHolder.ivUser);

        viewHolder.tvUsername.setText(photo.username);

        viewHolder.ivPhoto.setImageResource(0);
        Picasso.with(getContext()).load(photo.imageUrl).placeholder(R.drawable.loader).into(viewHolder.ivPhoto);

        viewHolder.tvLikes.setText(photo.formattedLikesCount());

        viewHolder.tvCaption.setText(photo.caption);

        return convertView;
    }
}
