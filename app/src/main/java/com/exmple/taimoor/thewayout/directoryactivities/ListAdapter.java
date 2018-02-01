package com.exmple.taimoor.thewayout.directoryactivities;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.exmple.taimoor.thewayout.R;

import java.util.List;

public class ListAdapter implements android.widget.ListAdapter {

    Context context;

    List<Subject> subject_list;

    public ListAdapter(List<Subject> listValue, Context context)
    {
        this.context = context;
        this.subject_list = listValue;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount()
    {
        return this.subject_list.size();
    }

    @Override
    public Object getItem(int position)
    {
        return this.subject_list.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewItem viewItem = null;
        if(convertView == null)
        {
            viewItem = new ViewItem();

            LayoutInflater layoutInfiater = (LayoutInflater)this.context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInfiater.inflate(R.layout.list_view_for_directoriesactivity, null);

            viewItem.SubNameTextView = convertView.findViewById(R.id.SubjectNameTextView);

            viewItem.SubFullFormTextView = convertView.findViewById(R.id.SubjectFullFormTextView);

            viewItem.SubjectFullFormPhoneNumber = convertView.findViewById(R.id.SubjectFullFormPhoneNumber);

            convertView.setTag(viewItem);
        }
        else
        {
            viewItem = (ViewItem) convertView.getTag();
        }

        viewItem.SubNameTextView.setText(subject_list.get(position).userName);

        viewItem.SubFullFormTextView.setText(subject_list.get(position).txt_address);

        viewItem.SubjectFullFormPhoneNumber.setText(subject_list.get(position).int_phoneNumber);

        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }
}

class ViewItem
{
    TextView SubNameTextView;
    TextView SubFullFormTextView;
    TextView SubjectFullFormPhoneNumber;
}
