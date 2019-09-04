package com.program.codemobile.itunesapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.program.codemobile.itunesapplication.ui.album.AlbumDetailActivity;
import com.program.codemobile.itunesapplication.R;
import com.program.codemobile.itunesapplication.models.Results;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.DataHolder> {

    private static final String TAG = "RecyclerAdapter";
    private Context context;
    List<Results> listResults;
    private OnItemClickListener listener;

    public RecyclerAdapter(Context context, List<Results> listResults) {
        this.context = context;
        this.listResults = listResults;
    }

    @NonNull
    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_show,parent,false);
        return new RecyclerAdapter.DataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final DataHolder holder, final int position) {

        Picasso.with(context).load(listResults.get(position).getArtworkUrl100()).into(holder.showArtworkUrl100);
        holder.textArtistName.setText(listResults.get(position).getArtistName());
        holder.textArtistName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(context, AlbumDetailActivity.class);
                intent.putExtra("collectionId", listResults.get(position).getCollectionId());
                context.startActivity(intent);
            }
        });

        holder.textTrackName.setText(listResults.get(position).getTrackName());

        final int p = position;
        final MediaPlayer mPlayer = new MediaPlayer();
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        holder.showProgress.setVisibility(View.INVISIBLE);
        holder.idPLayIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPlayer.isPlaying()) {
                    mPlayer.reset();
                    mPlayer.stop();
                    holder.idPLayIcon.setImageResource(R.drawable.ic_action_playback_play);
                    holder.showProgress.setVisibility(View.INVISIBLE);
                }else{
                    try {
                        mPlayer.setDataSource(listResults.get(p).getPreviewUrl());
                        mPlayer.prepare();
                        mPlayer.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    holder.showProgress.setVisibility(View.VISIBLE);
                    holder.idPLayIcon.setImageResource(R.drawable.ic_action_playback_pause);
                }

                mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        mPlayer.reset();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return listResults.size();
    }
    public class DataHolder extends RecyclerView.ViewHolder {
        private ImageView showArtworkUrl100;
        private TextView textArtistName;
        private TextView textTrackName;
        private ImageView idPLayIcon;
        private ImageView idFavorite;
        private ProgressBar showProgress;

        public DataHolder(@NonNull View itemView) {
            super(itemView);
            showArtworkUrl100 = (ImageView)  itemView.findViewById(R.id.showArtworkUrl100);
            textArtistName    = (TextView)  itemView.findViewById(R.id.textArtistName);
            textTrackName     = (TextView)  itemView.findViewById(R.id.textTrackName);
            idPLayIcon        = (ImageView)  itemView.findViewById(R.id.idPLayIcon);
            idFavorite        = (ImageView)  itemView.findViewById(R.id.idFavorite);
            showProgress      = (ProgressBar)  itemView.findViewById(R.id.showProgress);
            idFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if(listener !=null && position !=RecyclerView.NO_POSITION){
                        listener.onItemClick(listResults.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener{
        void onItemClick(Results results);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

}