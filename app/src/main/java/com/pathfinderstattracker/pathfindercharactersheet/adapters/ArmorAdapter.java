package com.pathfinderstattracker.pathfindercharactersheet.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;

/**
 * Created by Stephen Hagen on 2/15/2018.
 */

public class ArmorAdapter extends BaseAdapter
{
    private int[] acArray;
    private static LayoutInflater inflater;

    public ArmorAdapter()
    {
        //Default Adapter
    }

    public ArmorAdapter(Activity context, int totalAC, int touchAC, int flatFootedAC)
    {
        acArray = new int[]{totalAC, touchAC, flatFootedAC};
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        return acArray.length + 1;
    }

    @Override
    public Object getItem(int i)
    {
        return acArray[i - 1];
    }

    @Override
    public long getItemId(int i)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent)
    {
        View vi = convertview;
        if(vi == null)
        {
            vi = inflater.inflate(R.layout.ac_row_view, null);
            if(position != 0)
            {
                TextView name = vi.findViewById(R.id.Name);
                TextView value = vi.findViewById(R.id.Value);

                switch(position)
                {
                    case 1:
                        name.setText(R.string.TotalAC);
                        break;
                    case 2:
                        name.setText(R.string.TouchAC);
                        break;
                    case 3:
                        name.setText(R.string.FlatFootedAC);
                        break;
                    default:
                        name.setText(R.string.Error);
                        break;
                }

                value.setText((Integer.toString(acArray[position - 1])));
                value.setBackgroundResource(R.drawable.field_border);
            }
        }
        return vi;
    }
}
