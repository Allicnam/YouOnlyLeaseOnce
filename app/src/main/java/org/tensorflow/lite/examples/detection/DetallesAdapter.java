package org.tensorflow.lite.examples.detection;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DetallesAdapter extends RecyclerView.Adapter<DetallesAdapter.DepartamentoViewHolder> {

    private ArrayList<String> detallesArrayList;
    private Context context;

    public DetallesAdapter(Context context, ArrayList<String> departamentoArrayList) {
        this.context = context;
        this.detallesArrayList = departamentoArrayList;
    }

    @NonNull
    @Override
    public DepartamentoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detalles_recycler_view, parent, false);
        DepartamentoViewHolder departamentoViewHolder = new DepartamentoViewHolder(view);
        return departamentoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DepartamentoViewHolder holder, int position) {
        String currentItem = detallesArrayList.get(position);

        holder.nombreText.setText(currentItem);

    }

    @Override
    public int getItemCount() {
        return detallesArrayList.size();
    }

    public class DepartamentoViewHolder extends  RecyclerView.ViewHolder{

        TextView nombreText;

        public DepartamentoViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreText = itemView.findViewById(R.id.objetoEncontrado);
        }
    }
}
