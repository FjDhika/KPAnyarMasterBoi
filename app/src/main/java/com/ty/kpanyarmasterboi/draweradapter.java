package com.ty.kpanyarmasterboi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class draweradapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

        private List<iconsicon> mlist;
        private Context mcontext;
        private LayoutInflater minflater;
        private iconsicon miconsicon;

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
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            MyHolder myholder = (MyHolder) holder;
            miconsicon = mlist.get(position);

            myholder.nmicon.setText(miconsicon.descicon);
            myholder.fotoicon.setImageResource(miconsicon.icons);

        }

        @Override
        public int getItemCount() {
            return mlist.size();
        }

class MyHolder extends RecyclerView.ViewHolder {
    ImageView fotoicon;
    TextView nmicon;

    public MyHolder(@NonNull View itemView) {
        super(itemView);

        nmicon = (TextView) itemView.findViewById(R.id.textdrawer);
        fotoicon = (ImageView) itemView.findViewById(R.id.images);

    }
}
}
