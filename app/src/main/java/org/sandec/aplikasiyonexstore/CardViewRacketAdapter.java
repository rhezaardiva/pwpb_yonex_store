package org.sandec.aplikasiyonexstore;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewRacketAdapter extends RecyclerView.Adapter<CardViewRacketAdapter.ViewHolder>{
    private ArrayList<Racket> listRacket;

    public CardViewRacketAdapter(ArrayList<Racket> listRacket){
        this.listRacket = listRacket;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_racket, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int i) {

        final Racket racket = listRacket.get(i);
        Glide.with(holder.itemView.getContext())
                .load(racket.getPhoto())
                .apply(new RequestOptions().override(800,800))
                .into(holder.imgPhoto);

        holder.tvName.setText(racket.getName());
        holder.tvPrice.setText(racket.getPrice());
        holder.tvFrom.setText(racket.getFrom());

        holder.card_View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                DetailActivity detail = new DetailActivity();
                intent.putExtra(detail.EXTRA_PHOTO, racket.getPhoto());
                intent.putExtra(detail.EXTRA_NAME, racket.getName());
                intent.putExtra(detail.EXTRA_PRICE, racket.getPrice());
                intent.putExtra(detail.EXTRA_FROM, racket.getFrom());

                holder.itemView.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return listRacket.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView card_View;
        ImageView imgPhoto;
        TextView tvName, tvPrice, tvFrom;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvFrom = itemView.findViewById(R.id.tv_item_from);
            tvPrice = itemView.findViewById(R.id.tv_item_price);
            card_View = itemView.findViewById(R.id.card_view);
        }
    }
}
