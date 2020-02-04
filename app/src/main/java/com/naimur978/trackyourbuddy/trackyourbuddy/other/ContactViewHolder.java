package com.naimur978.trackyourbuddy.trackyourbuddy.other;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.naimur978.trackyourbuddy.trackyourbuddy.R;


public abstract class ContactViewHolder extends RecyclerView.ViewHolder {

    public TextView mTextViewName, mTextViewMobileNo;

    public ContactViewHolder(View itemView) {
        super(itemView);
        mTextViewName = (TextView) itemView.findViewById(R.id.listItemContactName);
        mTextViewMobileNo = (TextView) itemView.findViewById(R.id.listItemMobileNo);
    }

    abstract void onDoneChanged(boolean isDone);
}
