package com.memverse.android.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.memverse.android.Repository;
import com.memverse.datacontracts.Verse;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

/**
 * Wraps the data set and creates views for individual verses.
 * <p>
 * Created by amy on 12/12/17.
 */

public class MemversesListAdapter extends RecyclerView.Adapter<MemverseViewHolder> {

    private List<Verse> verses;

    @Inject
    MemversesListAdapter(Repository repository) {
        this.verses = repository.getVerses();
    }

    @Override
    public MemverseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.two_line_list_item, parent, false);
        return new MemverseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MemverseViewHolder viewHolder, int position) {
        Verse model = verses.get(position);
        viewHolder.verseReference.setText(formatReference(model));
        viewHolder.verseText.setText(model.text);
    }

    @Override
    public int getItemCount() {
        return verses.size();
    }

    private static String formatReference(Verse model) {
        return String.format(Locale.getDefault(), "%s %s:%d", model.book, model.chapter, model.versenum);
    }
}
