package com.shopcode.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.Map;


public class partners_rv_adapter extends RecyclerView.Adapter<partners_rv_adapter.ViewHolder>
{
    ArrayList<Map> partners;
    Context context;
    int resource;

    public partners_rv_adapter(Context context, int resource, ArrayList<Map> partners) {
        this.partners = partners;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(resource, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position)
    {
        holder.name.setText(partners.get(position).get("name").toString());
        holder.area.setText(partners.get(position).get("area").toString());
        holder.touch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,partners.get(position).get("name").toString()+" clicked", Toast.LENGTH_SHORT).show();
            }
        });
        holder.image.setImageDrawable(context.getResources().getDrawable(R.drawable.apple));
    }

    @Override
    public int getItemCount() {
        return partners.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, area;
        ImageView image;
        ConstraintLayout touch;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.partner_name);
            area = (TextView) itemView.findViewById(R.id.partner_area);
            image = (ImageView) itemView.findViewById(R.id.partner_image);
            touch = (ConstraintLayout) itemView.findViewById(R.id.touch);
        }
    }
}

