package com.example.projeklab.adapter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projeklab.R;

import com.example.projeklab.adapter.recyclerview.ClothRecyclerViewAdapter;
import com.example.projeklab.model.Cloth;

import java.util.Vector;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentCloth#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentCloth extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View v;
    private RecyclerView recyclerView;
    private Vector<Cloth> VCloth;

    public FragmentCloth() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentCloth.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentCloth newInstance(String param1, String param2) {
        FragmentCloth fragment = new FragmentCloth();
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

        VCloth = new Vector<>();
        VCloth.add(new Cloth(R.drawable.cloth_1,"PPGIRL",
                "Sleeves A-Line-Madness",
                1096537));
        VCloth.add(new Cloth(R.drawable.cloth_2,"Popplebonk",
                "Lace Trim A-Line Mini Dress",
                412444));
        VCloth.add(new Cloth(R.drawable.cloth_3,"Cafamo",
                "High-Waist Drawstring Plain \n" +
                        "Straight-Leg Pants",
                275625));
        VCloth.add(new Cloth(R.drawable.cloth_4,"Giuliana",
                "Rabbit Print Hoodie",
                574771));
        VCloth.add(new Cloth(R.drawable.cloth_5,"Oceanid",
                "Set: Swim Top + Bottom",
                356126));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_cloth, container, false);
        recyclerView = v.findViewById(R.id.rv_cloth);
        ClothRecyclerViewAdapter clothRecyclerViewAdapter = new ClothRecyclerViewAdapter(
                getContext(), VCloth);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerView.setAdapter(clothRecyclerViewAdapter);
        return v;
    }
}