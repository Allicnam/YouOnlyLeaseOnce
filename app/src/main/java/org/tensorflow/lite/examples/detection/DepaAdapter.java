package org.tensorflow.lite.examples.detection;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import org.tensorflow.lite.examples.detection.Database.Departamento;

import java.util.ArrayList;

public class DepaAdapter extends RecyclerView.Adapter<DepaAdapter.DepartamentoViewHolder> {

    private ArrayList<Departamento> departamentoArrayList;
    private Context context;
    private DepartamentoController mDepaController;

    public DepaAdapter(Context context, ArrayList<Departamento> departamentoArrayList, DepartamentoController mDepaC) {
        this.context = context;
        this.departamentoArrayList = departamentoArrayList;
        this.mDepaController = mDepaC;
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

        byte[] depaImage = currentItem.getImage();

        holder.nombreText.setText(currentItem.getNombre());
        if(depaImage != null)
            holder.imageDepa.setImageBitmap(BitmapFactory.decodeByteArray(depaImage, 0, depaImage.length));
        holder.cardDepaLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, Detalles.class);
                intent.putExtra("departamento", (Parcelable) departamentoArrayList.get(position));
                intent.putExtra("objetosEncontrados", departamentoArrayList.get(position).getObjetosEncontrados());
                intent.putExtra("image", depaImage);
                context.startActivity(intent);
            }
        });
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDepaController.deleteDepa(currentItem);
                departamentoArrayList.remove(position);
                notifyDataSetChanged();
            }
        });;
    }

    @Override
    public int getItemCount() {
        return departamentoArrayList.size();
    }

    public class DepartamentoViewHolder extends  RecyclerView.ViewHolder{

        TextView nombreText;

        ConstraintLayout cardDepaLayout;
        ImageButton deleteButton;
        ImageView imageDepa;

        public DepartamentoViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreText = itemView.findViewById(R.id.nombreText);
            deleteButton = itemView.findViewById(R.id.deleteButton);
            cardDepaLayout = itemView.findViewById(R.id.card_depa_layout);
            imageDepa = itemView.findViewById(R.id.imageView);
        }
    }
}
