package com.example.ggrascantou.gonzaapp.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ggrascantou.gonzaapp.R;
import com.example.ggrascantou.gonzaapp.adapter.PictureAdapterRecyclerView;
import com.example.ggrascantou.gonzaapp.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        showToolbar("", true, view);
        RecyclerView picturesRecycler = (RecyclerView) view.findViewById(R.id.pictureProfileRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        picturesRecycler.setLayoutManager(linearLayoutManager);
        PictureAdapterRecyclerView pictureAdapterRecyclerView = new PictureAdapterRecyclerView(this.buildPictures(), R.layout.cardview_picture, getActivity());
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);
        return view;
    }

    public ArrayList<Picture> buildPictures() {
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("https://lamenteesmaravillosa.com/wp-content/uploads/2017/12/los-simpson-en-el-sofa.jpg", "Gonzalo gras cantou", "4 dias", "10 me gusta"));
        pictures.add(new Picture("https://lamenteesmaravillosa.com/wp-content/uploads/2017/12/los-simpson-en-el-sofa.jpg", "Nicolas medela", "5 dias", "0 me gusta"));
        pictures.add(new Picture("https://lamenteesmaravillosa.com/wp-content/uploads/2017/12/los-simpson-en-el-sofa.jpg", "Nicolas espindola", "20 dias", "120 me gusta"));
        return pictures;
    }

    public void showToolbar(String title, boolean upButton, View view) {

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}
