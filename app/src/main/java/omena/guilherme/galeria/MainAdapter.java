package omena.guilherme.galeria;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.internal.ViewUtils;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter {

    MainActivity mainActivity;
    List<String> photos;

    public MainAdapter(MainActivity mainActivity, List<String> photos){
        this.mainActivity = mainActivity;
        this.photos = photos;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflador serve para ler arquivo xml do item e criar os elementos de interface
        LayoutInflater inflater = LayoutInflater.from(mainActivity);

        // Recebe o constraint layout
        View v = inflater.inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ImageView imPhoto = holder.itemView.findViewById(R.id.imItem);
        int w = (int)mainActivity.getResources().getDimension(R.dimen.itemWidth);
        int h = (int)mainActivity.getResources().getDimension(R.dimen.itemHeight);
        Bitmap bitmap = Util.getBitmap(photos.get(position), w, h);
        imPhoto.setImageBitmap(bitmap);
        imPhoto.setOnClickListener(new View.OnClickListener(){

            @Override
            // Para dar foco na imagem no centro da tela
            public void onClick(View v) {
                mainActivity.startPhotoActivity(photos.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {

        return photos.size();
    }
}
