package com.example.sleep.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.sleep.MediaVideoPack.MediaVideoActivity;
import com.example.sleep.R;

import java.io.IOException;
import java.util.ArrayList;

import pl.droidsonroids.gif.GifDrawable;

public class RecyclerViewSatisfatorio extends RecyclerView.Adapter<RecyclerViewSatisfatorio.ViewHolder> {
        Context mContext;
        ArrayList<ModelSatisfatorio> mList;
        RequestOptions options;

    public RecyclerViewSatisfatorio(Context mContext, ArrayList<ModelSatisfatorio> mList) {
        this.mContext = mContext;
        this.mList = mList;

        try {
            GifDrawable gifFromResource = new GifDrawable(mContext.getResources(),R.drawable.gif_loading_shape);
            options = new RequestOptions().centerCrop().placeholder(gifFromResource).error(gifFromResource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.item_videos,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextView titulo;
        final ModelSatisfatorio itemSatisfatorio = mList.get(position);
        CardView cardView;
        ImageView imageView;
        cardView = holder.cardView;

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MediaVideoActivity.class);
                intent.putExtra("video",itemSatisfatorio.getVideo());
                intent.putExtra("nome_video",itemSatisfatorio.getNome());
                mContext.startActivity(intent);
            }
        });

        titulo = holder.titulo;

        imageView = holder.imageView;
        imageView.setImageResource(itemSatisfatorio.getImg());

        titulo.setText(itemSatisfatorio.getNome());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView titulo;
        ImageView imageView;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardview);
            titulo = itemView.findViewById(R.id.textsatisfatorioItem);
            imageView = itemView.findViewById(R.id.ImagemVídeoItem);
        }
    }
}
