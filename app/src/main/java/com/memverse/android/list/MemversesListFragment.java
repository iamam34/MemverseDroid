package com.memverse.android.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.memverse.android.R;
import com.memverse.android.Repository;

/**
 * Fragment to display a list of verses.
 * .
 * Created by amy on 12/12/17.
 */

public class MemversesListFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_memverses_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView_memverses_list);
        MemversesListAdapter verseListAdapter = new MemversesListAdapter(Repository.getVerses());
        recyclerView.setAdapter(verseListAdapter);
        return view;
    }
}