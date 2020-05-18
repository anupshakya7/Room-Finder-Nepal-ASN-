package com.example.roomfindernepalasn;







import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class Rent_Fragment extends Fragment {


    public Rent_Fragment(){

    }


    List<RentRoomData> roomList;
    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.rent_fragment,container,false);

        recyclerView=(RecyclerView)view.findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //initData();

        recyclerView.setAdapter(new RoomAdapter(initData()));


        return view;
    }

    private List<RentRoomData> initData() {

        roomList=new ArrayList<>();
        roomList.add(new RentRoomData("Room 1","Kathmandu","Rs. 12000",R.drawable.room2));
        roomList.add(new RentRoomData("Room 2","Lalitpur","10000",R.drawable.room3));

        return roomList;
    }
}
