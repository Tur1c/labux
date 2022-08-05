package com.example.projeklab.adapter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projeklab.R;
import com.example.projeklab.adapter.recyclerview.OtherRecyclerViewAdapter;
import com.example.projeklab.model.Other;

import java.util.Vector;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentOther#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentOther extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View v;
    private RecyclerView recyclerView;
    private Vector<Other> VOther;

    public FragmentOther() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentOther.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentOther newInstance(String param1, String param2) {
        FragmentOther fragment = new FragmentOther();
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

        VOther = new Vector<>();
        VOther.add(new Other(R.drawable.other_1,"Stray Kids",
                "Official Light Stick (NACHIMBONG)\n",
                "1,249,092"));
        VOther.add(new Other(R.drawable.other_2,"BTS Pop Up",
                "BTS CHARACTER MINI FIGURE\n",
                "371,231"));
        VOther.add(new Other(R.drawable.other_3,"BT21",
                "COOKY STANDING DOLL (MEDIUM)",
                "891,996"));
        VOther.add(new Other(R.drawable.other_4,"AESPA",
                "Official Light Stick\n",
                "1,025,907"));
        VOther.add(new Other(R.drawable.other_5,"BTS",
                "HOLIDAY COLLECTION LITTLE WISHES",
                "475,384"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_other,container,false);
        recyclerView = v.findViewById(R.id.rv_other);
        OtherRecyclerViewAdapter otherRecyclerViewAdapter = new OtherRecyclerViewAdapter(
            getContext(), VOther
        );
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerView.setAdapter(otherRecyclerViewAdapter);
        return v;
    }
}