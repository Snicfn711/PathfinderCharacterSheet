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
    List<Object> itemsInSpinner;

    public AddArmorToInventorySpinnerAdapter(@NonNull Context context, int resource, @NonNull List<Object> items)
    {
        super(context, resource, items);
        itemsInSpinner = items;
    }

    @Override
    public boolean isEnabled(int position)
    {
        if(itemsInSpinner.get(position) instanceof String)
        {
            return false;
        }
        else
        {
            return true;
        }
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
            view.setText((String)itemsInSpinner.get(position));
            view.setGravity(Gravity.CENTER);
            view.setTextColor(getContext().getResources().getColor(R.color.colorGrayedText));
        }
        else
        {
            view.setText(itemsInSpinner.get(position).toString());
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

        if(position == 0)
        {
            view.setText((String)itemsInSpinner.get(position));
            view.setGravity(Gravity.START|Gravity.CENTER_VERTICAL);
            view.setTextColor(getContext().getResources().getColor(R.color.colorLightGrayedText));
        }
        else if(itemsInSpinner.get(position) instanceof String)
        {
            view.setText((String)itemsInSpinner.get(position));
            view.setGravity(Gravity.START|Gravity.CENTER_VERTICAL);
            view.setTextColor(getContext().getResources().getColor(R.color.colorWarning));
            view.setBackgroundColor(getContext().getResources().getColor(R.color.colorTransparentHeader));
        }
        else
        {
            view.setText(itemsInSpinner.get(position).toString());
            view.setGravity(Gravity.CENTER);
            view.setTextColor(getContext().getResources().getColor(R.color.colorPlainText));
        }
        return view;
    }
}

