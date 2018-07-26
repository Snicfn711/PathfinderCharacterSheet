package com.pathfinderstattracker.pathfindercharactersheet.adapters;

import android.content.Context;
import android.graphics.Color;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;

import org.w3c.dom.Text;

import java.util.List;

public class AddArmorToInventorySpinnerAdapter extends ArrayAdapter<Object>
{
    public AddArmorToInventorySpinnerAdapter(@NonNull Context context, int resource, @NonNull List<Object> items)
    {
        super(context, resource, items);
    }

    @Override
    public boolean isEnabled(int position)
    {
        //We don't our section headers to be selectable, so they're getting disabled here
        return !(this.getItem(position) instanceof String);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        TextView view = (TextView)inflater.inflate(R.layout.dropdown_item_view, null);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100);
        params.setMargins(0,10,0,10);
        view.setLayoutParams(params);
        if(position == 0)
        {
            view.setText((String)this.getItem(position));
            view.setGravity(Gravity.CENTER);
            view.setTextColor(getContext().getResources().getColor(R.color.colorGrayedText));
        }
        else
        {
            view.setText(this.getItem(position).toString());
            view.setGravity(Gravity.CENTER);
            view.setTextColor(getContext().getResources().getColor(R.color.colorPlainText));
        }
        return view;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        TextView view = (TextView)inflater.inflate(R.layout.dropdown_item_view, null);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100);
        params.setMargins(0,10,0,10);
        view.setLayoutParams(params);

        //Since the only way we could figure out to get Section Headers into our list was a Strings from the fragment, we have to check for them here and modify our views here.
        if(position == 0)
        {
            //The spinner widget doesn't have a default implementation for default text, so we simply added a "Select an Item" text option at the beginning of our items
            //This means then that we have to handle it separately here.
            view.setText((String)this.getItem(position));
            view.setGravity(Gravity.START|Gravity.CENTER_VERTICAL);
            view.setTextColor(getContext().getResources().getColor(R.color.colorLightGrayedText));
        }
        else if(this.getItem(position) instanceof String)
        {
            view.setText((String)this.getItem(position));
            view.setGravity(Gravity.START|Gravity.CENTER_VERTICAL);
            view.setTextColor(getContext().getResources().getColor(R.color.colorWarning));
            view.setBackgroundColor(getContext().getResources().getColor(R.color.colorTransparentHeader));
        }
        else
        {
            view.setText(this.getItem(position).toString());
            view.setGravity(Gravity.CENTER);
            view.setTextColor(getContext().getResources().getColor(R.color.colorPlainText));
        }
        return view;
    }
}

