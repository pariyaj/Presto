package com.example.np.presto.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.np.presto.Pojo.Instrument;
import com.example.np.presto.R;

import java.util.ArrayList;
import java.util.List;

public class InstrumentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Instrument> list;
    private List<Instrument> icart = new ArrayList<>();


    public InstrumentAdapter(Context context, List<Instrument> list) {
        this.context = context;
        this.list = list;

    }


    private class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgPersonAvatar;
        private TextView name,desc, price;
        private ImageButton addToCartBtn,removeOfCartBtn;

        public ViewHolder(View itemView) {
            super(itemView);

            imgPersonAvatar = itemView.findViewById(R.id.img_product);
            name = itemView.findViewById(R.id.name_product);
            desc = itemView.findViewById(R.id.lvl_product);
            addToCartBtn = itemView.findViewById(R.id.add);
            removeOfCartBtn = itemView.findViewById(R.id.remove);
            price = itemView.findViewById(R.id.price_product);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.imgPersonAvatar.setImageResource(list.get(position).getImage());
        viewHolder.name.setText(list.get(position).getTitle());
        viewHolder.desc.setText(list.get(position).getModel());
        viewHolder.price.setText(list.get(position).getPrice());
        viewHolder.addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icart.add(list.get(position));
                Log.d("added", String.valueOf(list.get(position)));
                Toast.makeText(context, R.string.addcart, Toast.LENGTH_LONG).show();
            }
        });
        viewHolder.removeOfCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icart.remove(list.get(position));
                Log.d("removed", String.valueOf(list.get(position)));
                Toast.makeText(context, R.string.removecart, Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void clearList(){
        list.clear();

    }

    public Instrument getInstrument(int position){

        return list.get(position);
    }
    public int getPosition(Instrument instrument){

        return instrument.getId();
    }
}
