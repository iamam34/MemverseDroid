package com.memverse.android.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Holds all sub views that depend on the current item's data.
 * <p>
 * Created by amy on 12/12/17.
 */

class MemverseViewHolder extends RecyclerView.ViewHolder {
    final TextView verseReference;
    final TextView verseText;

    MemverseViewHolder(View itemView) {
        super(itemView);
        verseReference = itemView.findViewById(android.R.id.text1);
        verseText = itemView.findViewById(android.R.id.text2);
    }
}
