package com.achek.exchangerates.repository.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.achek.exchangerates.R;
import com.achek.exchangerates.repository.model.Valute;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ValuteViewHolder> {

    private List<Valute> valuteList;

    public RVAdapter(List<Valute> valuteList){
        this.valuteList = valuteList;
    }


    @NonNull
    @Override
    public ValuteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_valute, parent, false);
        ValuteViewHolder vVH = new ValuteViewHolder(v);
        return vVH;
    }

    @Override
    public void onBindViewHolder(@NonNull ValuteViewHolder holder, int position) {
        StringBuilder s = new StringBuilder();
        s.append(valuteList.get(position).getNominal());
        s.append(" \u20BD = ");
        s.append(valuteList.get(position).getValue());
        s.append(" ");
        s.append(valuteList.get(position).getCharCode());

        holder.valuteName.setText(valuteList.get(position).getName());
        holder.valuteValue.setText(s);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return valuteList.size();
    }

    public static class ValuteViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView valuteName;
        TextView valuteValue;

        public ValuteViewHolder(@NonNull View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv_valute);
            valuteName = itemView.findViewById(R.id.tv_valute_name);
            valuteValue = itemView.findViewById(R.id.tv_valute_value);
        }
    }

}
