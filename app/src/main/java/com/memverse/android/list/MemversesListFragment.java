package com.memverse.android.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.memverse.android.MemverseApplication;
import com.memverse.android.R;
import com.memverse.android.dagger.ApplicationComponent;

/**
 * Fragment to display a list of verses.
 * .
 * Created by amy on 12/12/17.
 */

public class MemversesListFragment extends Fragment {

    private static final String LOG_TAG = MemversesListFragment.class.getCanonicalName();

    public static MemversesListFragment newInstance() {
        Log.d(LOG_TAG, "calling newInstance()");
        return new MemversesListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ApplicationComponent daggerComponent = MemverseApplication.getInstance().getDaggerComponent();

        View view = inflater.inflate(R.layout.fragment_memverses_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView_memversesList);
        MemversesListAdapter verseListAdapter = daggerComponent.memversesListAdapter();
        recyclerView.setAdapter(verseListAdapter);
        return view;
    }

}
