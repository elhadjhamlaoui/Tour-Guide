package com.app_republic.tourguide;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class listAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Attraction> list;


    listAdapter(Context context, ArrayList<Attraction> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        ((viewHolder) holder).title.setText(list.get(position).getName());
        ((viewHolder) holder).picture.setImageResource(list.get(position).getPicture());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    class viewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView picture;
        RelativeLayout layout;

        viewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            picture = itemView.findViewById(R.id.picture);
            layout = itemView.findViewById(R.id.layout);

            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    attraction_dialog dialog = new attraction_dialog();
                    Bundle argumants = new Bundle();
                    argumants.putParcelable(context.getString(R.string.attraction),list.get(getAdapterPosition()));
                    dialog.setArguments(argumants);

                    AppCompatActivity activity = (AppCompatActivity) context;
                    if(!activity.isFinishing())
                        activity.getSupportFragmentManager().beginTransaction().add(dialog, activity.getString(R.string.video)).commitAllowingStateLoss();

                }
            });
        }
    }
}