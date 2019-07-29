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

import java.util.List;

public class draweradapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

        private List<iconsicon> mlist;
        private Context mcontext;
        private LayoutInflater minflater;
        private iconsicon miconsicon;
        private boolean isplay;

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

            myholder.nmicon.setText(miconsicon.descicon);
            myholder.fotoicon.setImageResource(miconsicon.icons);

            myholder.btnicon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                  MediaPlayer mediaPlayer = MediaPlayer.create(mcontext, mlist.get(position).soundmap);
                  mediaPlayer.start();
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
    Button btnicon;

    public MyHolder(@NonNull View itemView) {
        super(itemView);

        nmicon = (TextView) itemView.findViewById(R.id.textdrawer);
        fotoicon = (ImageView) itemView.findViewById(R.id.images);
        btnicon = itemView.findViewById(R.id.moveto);

    }
}
}
