package com.example.mytube.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.mytube.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ListView myListView;
        SearchView searchview;

        ArrayList<String>arrayList;
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        searchview = view.findViewById(R.id.searchView);
        myListView = view.findViewById(R.id.listView);

        myListView.setVisibility(View.GONE);

        arrayList=new ArrayList<>();
        arrayList.add("PewDepie");
        arrayList.add("ChocoTaco");
        arrayList.add("MiauwAug");
        arrayList.add("Pokopow");
        arrayList.add("JessNoLimit");
        arrayList.add("SischaKohl");
        arrayList.add("Chatez");
        arrayList.add("Mayden");
        arrayList.add("AlexPubg");
        arrayList.add("Milyhya");
        arrayList.add("BocahKematian");
        arrayList.add("JackSepticEye");
        arrayList.add("KSI");
        arrayList.add("Sabda");
        arrayList.add("freeCodecamp");
        arrayList.add("John Hammond");
        arrayList.add("Kevin Powel");

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,arrayList);
        myListView.setAdapter(adapter);
        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                myListView.setVisibility(View.VISIBLE);
                adapter.getFilter().filter(s);
                return false;
            }
        });

        return view;
    }

}