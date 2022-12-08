package com.example.mytube;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytube.R;

import java.util.ArrayList;
import java.util.List;


public class FragmentSingle extends Fragment implements SingleListAdapter.OnGridItemSelectedListener{

    private RecyclerView lvSingle;
    private GridLayoutManager gridLayoutManager;
    private SingleListAdapter singleListAdapter;
    private Context context;

    public static Fragment newInstance() {
        return new FragmentSingle();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_single, container, false);
        lvSingle = (RecyclerView) rootView.findViewById(R.id.lvSingle);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        singleListAdapter = new SingleListAdapter(this);
        // grid 2 kolom
        gridLayoutManager = new GridLayoutManager(context, 2);
        lvSingle.setLayoutManager(gridLayoutManager);

        // set margin 2 dp
        lvSingle.addItemDecoration(new GridMarginDecoration(context, 2, 2, 2, 2));
        lvSingle.setAdapter(singleListAdapter);
        loadData();
    }

    private void loadData(){
        List<Single> singleList = new ArrayList<>();
        Single single;
        int img[] = {R.drawable.img1, R.drawable.img2,
                R.drawable.img3, R.drawable.img4,
                R.drawable.img5};
        String title[] = {"Image 1", "Image 2",
                "Image 3", "Image 4",
                "Image 5"};
        for (int i = 0; i < img.length; i++){
            single = new Single();
            single.setImg(img[i]);
            single.setTitle(title[i]);
            singleList.add(single);
        }
        singleListAdapter.addAll(singleList);
    }

    @Override
    public void onGridItemClick(View v, int position) {
        Toast.makeText(context, singleListAdapter.getItem(position).getTitle(), Toast.LENGTH_SHORT).show();
    }

}
