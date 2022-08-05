package com.example.projeklab.adapter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projeklab.R;
import com.example.projeklab.adapter.recyclerview.AlbumRecyclerViewAdapter;
import com.example.projeklab.model.Album;

import java.util.Vector;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentAlbum#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentAlbum extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View v;
    private RecyclerView recyclerView;
    private Vector<Album> VAlbum;

    public FragmentAlbum() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentAlbum.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentAlbum newInstance(String param1, String param2) {
        FragmentAlbum fragment = new FragmentAlbum();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        VAlbum = new Vector<>();
        VAlbum.add(new Album(R.drawable.album_1,"TRI.BE","3RD Single Album Leviosa\n",
                "490,263"));
        VAlbum.add(new Album(R.drawable.album_2,"CIX","5TH Ep Album OK Episode 1\n" +
                "OK Not Jewel Case Ver.", "445,626"));
        VAlbum.add(new Album(R.drawable.album_3,"Twice","DICON DFESTA Special Photobook\n" +
                "3D Lenticular Cover", "1,308,608"));
        VAlbum.add(new Album(R.drawable.album_4,"Aespa","Glass Magazine(UK) 2021 Summer\n" +
                "ISSUE AESPA COVER", "534,900"));
        VAlbum.add(new Album(R.drawable.album_5,"NCT127","DICON DFESTA Special Photobook\n" +
                "3D Lenticular Cover", "1,308,608"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_album, container, false);
        recyclerView = v.findViewById(R.id.rv_album);
        AlbumRecyclerViewAdapter albumRecyclerViewAdapter = new AlbumRecyclerViewAdapter(getContext()
        , VAlbum);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setAdapter(albumRecyclerViewAdapter);
        return v;
    }
}