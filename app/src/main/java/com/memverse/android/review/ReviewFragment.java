package com.memverse.android.review;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ReviewViewModel viewModel = ViewModelProviders.of(this).get(ReviewViewModel.class);
        viewModel.verse.observe(this, new Observer<Verse>() {
            @Override
            public void onChanged(@Nullable Verse verse) {
                FragmentActivity activity = getActivity();
                final SwitchCompat switchView = activity.findViewById(R.id.switch_show_full_text);
                final EditText editText = activity.findViewById(R.id.editText_guess);
                final TextView textView = activity.findViewById(R.id.textView_fullText);
                final RatingBar ratingBar = activity.findViewById(R.id.ratingBar);

                switchView.setChecked(false);
                ratingBar.setRating(0);
                editText.setText(null);
                editText.requestFocus();

                if (verse != null) {
                    textView.setText(verse.text);
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_review, container, false);
        final ReviewViewModel viewModel = ViewModelProviders.of(this).get(ReviewViewModel.class);

        final SwitchCompat switchView = view.findViewById(R.id.switch_show_full_text);
        final ViewSwitcher viewSwitcher = view.findViewById(R.id.viewSwitcher_showFullText);
        final RatingBar ratingBar = view.findViewById(R.id.ratingBar);
        final ImageButton goToNextVerseButton = view.findViewById(R.id.button_goToNextVerse);

        switchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                viewSwitcher.showNext();
            }
        });
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                goToNextVerseButton.setVisibility((rating > 0) ? View.VISIBLE : View.INVISIBLE);
            }
        });
        goToNextVerseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.rateVerse((int) ratingBar.getRating());
                viewModel.goToNextVerse();
            }
        });

        return view;
    }
}
