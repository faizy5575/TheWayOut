package com.exmple.taimoor.thewayout.homeservicesactivities.mason;

import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.exmple.taimoor.thewayout.R;

public class ListAdapter extends BaseAdapter
{
    Context context;

    List<Subject> subject_list;

    public ListAdapter(List<Subject> listValue, Context context)
    {
        this.context = context;
        this.subject_list = listValue;
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
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewItem viewItem = null;
        if(convertView == null)
        {
            viewItem = new ViewItem();

            LayoutInflater layoutInfiater = (LayoutInflater)this.context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInfiater.inflate(R.layout.mass, null);

            viewItem.SubNameTextView = convertView.findViewById(R.id.massText1);

            viewItem.SubFullFormTextView = convertView.findViewById(R.id.massText2);

            viewItem.SubFullFormPhoneNumber = convertView.findViewById(R.id.massText3);
            convertView.setTag(viewItem);
        }
        else
        {
            viewItem = (ViewItem) convertView.getTag();
        }

        viewItem.SubNameTextView.setText(subject_list.get(position).Subject_Name);

        viewItem.SubFullFormTextView.setText(subject_list.get(position).Subject_Full_Form);

        viewItem.SubFullFormPhoneNumber.setText(subject_list.get(position).Subject_Full_Form_PhoneNumber);


        return convertView;
    }

    @Override
    public int getItemViewType(int position) {return 0;}

    @Override
    public int getViewTypeCount() {return 1;}

    @Override
    public boolean isEmpty() {return false;}

    @Override
    public boolean areAllItemsEnabled() {return false;}

    @Override
    public boolean isEnabled(int position) {return false;}
}

class ViewItem
{
    TextView SubNameTextView;
    TextView SubFullFormTextView;
    TextView SubFullFormPhoneNumber;
}
