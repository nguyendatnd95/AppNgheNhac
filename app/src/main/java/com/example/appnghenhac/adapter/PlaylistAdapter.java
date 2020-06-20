package com.example.appnghenhac.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appnghenhac.R;
import com.example.appnghenhac.model.PlayList;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlaylistAdapter extends ArrayAdapter<PlayList> {
    public PlaylistAdapter(@NonNull Context context, int resource, @NonNull List<PlayList> objects) {
        super(context, resource, objects);
    }
    private class ViewHolder{
        TextView tvTenPlaylist;
        ImageView imgBackground, imgPlaylist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.dong_playlist,null);
            viewHolder = new ViewHolder();
            viewHolder.tvTenPlaylist = convertView.findViewById(R.id.textviewtemplaylist);
            viewHolder.imgPlaylist = convertView.findViewById(R.id.imageviewplaylist);
            viewHolder.imgBackground = convertView.findViewById(R.id.imageviewbackgroundplaylist);
            convertView.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        PlayList playList = getItem(position);
        Picasso.get().load(playList.getHinhPlaylist()).into(viewHolder.imgBackground);
        Picasso.get().load(playList.getIcon()).into(viewHolder.imgPlaylist);
        viewHolder.tvTenPlaylist.setText(playList.getTen());



        return convertView;
    }
}
