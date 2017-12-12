package com.memverse.android.review;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.memverse.android.R;
import com.memverse.datacontracts.Verse;

/**
 * Fragment to display the verse Review screen.
 * <p>
 * Created by amy on 10/12/17.
 */

public class ReviewFragment extends Fragment {

    public static final String KEY_VERSEID = ReviewFragment.class.getCanonicalName() + ".verseid";

    private TextView textView;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle arguments = getArguments();
        long verseId = arguments.getLong(KEY_VERSEID);
        ReviewViewModel viewModel = ViewModelProviders.of(this).get(ReviewViewModel.class);
        viewModel.init(verseId);
        viewModel.getVerse().observe(this, new Observer<Verse>() {
            @Override
            public void onChanged(@Nullable Verse verse) {
                textView.setText(verse.text);
            }
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_review, container, false);
        textView = view.findViewById(R.id.textView_fullText);
        final SwitchCompat switchView = view.findViewById(R.id.switch_show_full_text);
        final ViewSwitcher viewSwitcher = view.findViewById(R.id.viewSwitcher_showFullText);
        switchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                viewSwitcher.showNext();
            }
        });
        return view;
    }
}
