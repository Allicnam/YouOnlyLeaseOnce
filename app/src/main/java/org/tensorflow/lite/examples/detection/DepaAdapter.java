package org.tensorflow.lite.examples.detection;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DepaAdapter extends RecyclerView.Adapter<DepaAdapter.DepartamentoViewHolder> {

    private ArrayList<Departamento> departamentoArrayList;
    private Context context;

    public DepaAdapter(Context context, ArrayList<Departamento> departamentoArrayList) {
        this.context = context;
        this.departamentoArrayList = departamentoArrayList;
    }

    @NonNull
    @Override
    public DepartamentoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_departamento, parent, false);
        DepartamentoViewHolder departamentoViewHolder = new DepartamentoViewHolder(view);
        return departamentoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DepartamentoViewHolder holder, int position) {
        Departamento currentItem = departamentoArrayList.get(position);

        holder.nombreText.setText(currentItem.getNombre());

        holder.cardDepaLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, Detalles.class);
                intent.putExtra("departamento", (Parcelable) departamentoArrayList.get(position));
                intent.putExtra("objetosEncontrados", departamentoArrayList.get(position).getObjetosEncontrados());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return departamentoArrayList.size();
    }

    public class DepartamentoViewHolder extends  RecyclerView.ViewHolder{

        TextView nombreText;

        ConstraintLayout cardDepaLayout;

        public DepartamentoViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreText = itemView.findViewById(R.id.nombreText);

            cardDepaLayout = itemView.findViewById(R.id.card_depa_layout);
        }
    }
}
