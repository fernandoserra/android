package com.program.codemobile.itunesapplication.adapters;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.program.codemobile.itunesapplication.R;
import com.program.codemobile.itunesapplication.models.Results;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.util.List;

public class RecyclerTrackAdapter extends RecyclerView.Adapter<RecyclerTrackAdapter.DataHolder> {

    private static final String TAG = "RecyclerTrackAdapter";
    private Context context;
    List<Results> listResults;

    public RecyclerTrackAdapter(Context context, List<Results> listResults) {
        this.context = context;
        this.listResults = listResults;
    }

    @NonNull
    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_track,parent,false);
        return new RecyclerTrackAdapter.DataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final DataHolder holder, final int position) {

        if(position==0){
                holder.textTrackNameDetail.setText("Lista de canciones");
                holder.showProgressDetail.setVisibility(View.INVISIBLE);
                holder.idPLayIconDetail.setImageResource(R.drawable.ic_queue_music);
                Picasso.with(context).load(R.drawable.ic_queue_music).into(holder.showArtworkUrl100);
        }else{

            holder.textTrackNameDetail.setText(listResults.get(position).getTrackName());
            Picasso.with(context).load(listResults.get(position).getArtworkUrl100()).into(holder.showArtworkUrl100);
            final int p = position;
            final MediaPlayer mPlayer = new MediaPlayer();
            mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            holder.showProgressDetail.setVisibility(View.INVISIBLE);
            holder.idPLayIconDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mPlayer.isPlaying()) {
                        mPlayer.reset();
                        mPlayer.stop();
                        holder.idPLayIconDetail.setImageResource(R.drawable.ic_action_playback_play);
                        holder.showProgressDetail.setVisibility(View.INVISIBLE);
                    }else{
                        try {
                            mPlayer.setDataSource(listResults.get(p).getPreviewUrl());
                            mPlayer.prepare();
                            mPlayer.start();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        holder.showProgressDetail.setVisibility(View.VISIBLE);
                        holder.idPLayIconDetail.setImageResource(R.drawable.ic_action_playback_pause);
                    }
                    mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        public void onCompletion(MediaPlayer mp) {
                            mPlayer.reset();
                            holder.idPLayIconDetail.setImageResource(R.drawable.ic_action_playback_play);
                            holder.showProgressDetail.setVisibility(View.INVISIBLE);
                        }
                    });
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listResults.size();
    }

    public Results getResultsPosition(int position) {
        return listResults.get(position);
    }

    public class DataHolder extends RecyclerView.ViewHolder {
        private TextView textTrackNameDetail;
        private ImageView showArtworkUrl100;
        private ImageView idPLayIconDetail;
        private ProgressBar showProgressDetail;
        public DataHolder(@NonNull View itemView) {
            super(itemView);
            textTrackNameDetail = (TextView)  itemView.findViewById(R.id.textTrackNameDetail);
            idPLayIconDetail    = (ImageView)  itemView.findViewById(R.id.idPLayIconDetail);
            showProgressDetail  = (ProgressBar)  itemView.findViewById(R.id.showProgressDetail);
            showArtworkUrl100   = (ImageView)  itemView.findViewById(R.id.showArtworkUrl100);
        }
    }
}
