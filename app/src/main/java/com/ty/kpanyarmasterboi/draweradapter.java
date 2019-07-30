package com.ty.kpanyarmasterboi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.List;

public class draweradapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

        private List<iconsicon> mlist;
        private Context mcontext;
        private LayoutInflater minflater;
        private iconsicon miconsicon;
        private boolean isplay;
        MediaPlayer mediaPlayer;
        int a = 1;

        public draweradapter(Context context, List<iconsicon> list) {
            mlist = list;
            mcontext = context;
            minflater = LayoutInflater.from(context);
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View v = minflater.inflate(R.layout.snackbarrecycler, parent, false);

            return new MyHolder(v);

        }

        @Override
        public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {

            final MyHolder myholder = (MyHolder) holder;
            miconsicon = mlist.get(position);
            final int soundid = miconsicon.getSoundmap();

            myholder.nmicon.setText(miconsicon.descicon);
            myholder.fotoicon.setImageResource(miconsicon.icons);

            mediaPlayer = MediaPlayer.create(mcontext,soundid);

            myholder.btniconsound.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (a == 1)
                    {
                        mediaPlayer.start();
                        mediaPlayer.release();
                        mediaPlayer = MediaPlayer.create(mcontext,soundid);
                    }

                        if ( mediaPlayer.isPlaying()) {

                            mediaPlayer.release();
                            mediaPlayer = MediaPlayer.create(mcontext,soundid);

                        }
                        

                            mediaPlayer.start ();

                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {

                            mediaPlayer.release();

                        }
                    });
                }
            });
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    miconsicon.mapFragment.updateMap(-8.099070549011174,115.09654998779297);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mlist.size();
        }

class MyHolder extends RecyclerView.ViewHolder {
    ImageView fotoicon;
    TextView nmicon;
    Button btniconsound;

    public MyHolder(@NonNull View itemView) {
        super(itemView);

        nmicon = (TextView) itemView.findViewById(R.id.textdrawer);
        fotoicon = (ImageView) itemView.findViewById(R.id.images);
        btniconsound = itemView.findViewById(R.id.playson);

    }
}

public void createsound(int position)
{

}

}
