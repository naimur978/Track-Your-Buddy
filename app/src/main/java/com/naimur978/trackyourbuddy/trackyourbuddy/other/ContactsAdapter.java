package com.naimur978.trackyourbuddy.trackyourbuddy.other;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;
import androidx.recyclerview.widget.SortedListAdapterCallback;

import com.naimur978.trackyourbuddy.trackyourbuddy.R;


public class ContactsAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private Context mContext;

    final LayoutInflater mLayoutInflater;
    SortedList<Contact> mContacts;

    public ContactsAdapter(Context context, LayoutInflater layoutInflater, Contact... items) {
        mContext = context;

        mLayoutInflater = layoutInflater;
        mContacts = new SortedList<Contact>(Contact.class, new SortedListAdapterCallback<Contact>(this) {
            @Override
            public int compare(Contact t0, Contact t1) {
                return t0.getName().compareTo(t1.getName());
            }

            @Override
            public boolean areContentsTheSame(Contact oldItem,
                                              Contact newItem) {
                return oldItem.getName().equals(newItem.getName());
            }

            @Override
            public boolean areItemsTheSame(Contact item1, Contact item2) {
                return item1.getMobileNo() == item2.getMobileNo();
            }
        });

        if (items != null) {
            for (Contact item : items) {
                mContacts.add(item);
            }
        }
    }

    public void addItem(Contact item) {
        mContacts.add(item);
    }

    @Override
    public ContactViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        return new ContactViewHolder(
                mLayoutInflater.inflate(R.layout.contact_list_item, parent, false)) {
            @Override
            void onDoneChanged(boolean isDone) {
                int adapterPosition = getAdapterPosition();
                if (adapterPosition == RecyclerView.NO_POSITION) {
                    return;
                }
                mContacts.recalculatePositionOfItemAt(adapterPosition);
            }
        };
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        ContactViewHolder contactViewHolder = (ContactViewHolder) holder;
        Contact contact = mContacts.get(position);
        contactViewHolder.mTextViewName.setText(contact.getName());
        contactViewHolder.mTextViewMobileNo.setText(contact.getMobileNo());
    }

    @Override
    public int getItemCount() {
        if (mContacts != null) {
            return mContacts.size();
        } else {
            return 0;
        }
    }
}

