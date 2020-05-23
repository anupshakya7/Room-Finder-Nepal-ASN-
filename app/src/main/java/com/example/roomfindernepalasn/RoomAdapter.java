package com.example.roomfindernepalasn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.Viewholder> {

    List<RentRoomData> roomList1;

    public RoomAdapter(List<RentRoomData> roomList1){
        this.roomList1=roomList1;
    }

    @NonNull
    @Override
    public RoomAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row_item,parent,false);
        Viewholder viewholder=new Viewholder(view);

        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull RoomAdapter.Viewholder holder, int position) {

        holder.roomDescription.setText(roomList1.get(position).getRoomDescription());
        holder.roomLocation.setText(roomList1.get(position).getRoomLocation());
        holder.roomPrice.setText(roomList1.get(position).getRoomPrice());
        holder.roomImage.setImageResource(roomList1.get(position).getRoomImage());

    }

    @Override
    public int getItemCount() {
        return roomList1.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        ImageView roomImage;
        TextView roomDescription,roomLocation,roomPrice;

        public Viewholder(View view) {
            super(view);

            roomDescription=view.findViewById(R.id.tvDescription);
            roomLocation=view.findViewById(R.id.tvLocation);
            roomPrice=view.findViewById(R.id.tvPrice);
            roomImage=view.findViewById(R.id.ivImage);

        }
    }
}
