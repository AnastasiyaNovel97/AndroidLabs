//package com.example.androidlabs;
//
//
//import android.content.Context;
//import android.provider.ContactsContract;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.List;
//
//class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
//
//    private LayoutInflater inflater;
//    private List<Cosplay> cosplays;
//
//    DataAdapter(Context context, List<Cosplay> cosplays) {
//        this.cosplays = cosplays;
//        this.inflater = LayoutInflater.from(context);
//    }
//    @Override
//    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//
//        View view = inflater.inflate(R.layout.list_item, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
//        Cosplay cosplay = cosplays.get(position);
//        holder.imageView.setImageResource(cosplay.getImage());
//        holder.animeView.setText(cosplay.getAnime());
//        holder.characterView.setText(cosplay.getCharacter());
//    }
//
//    @Override
//    public int getItemCount() {
//        return cosplays.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        final ImageView imageView;
//        final TextView animeView, characterView;
//        ViewHolder(View view){
//            super(view);
//            imageView = (ImageView)view.findViewById(R.id.image);
//            animeView = (TextView) view.findViewById(R.id.anime);
//            characterView = (TextView) view.findViewById(R.id.character);
//        }
//    }
//}