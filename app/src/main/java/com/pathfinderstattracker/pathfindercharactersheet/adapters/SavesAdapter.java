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
 * Created by Stephen Hagen on 2/14/2018.
 */

public class SavesAdapter extends BaseAdapter
{
    private Activity context = null;
    public void setContext(Activity context)
    {
        this.context = context;
    }
    private int fortSave = 0;
    public void setFortSave(int fortSave)
    {
        this.fortSave = fortSave;
    }
    private int refSave = 0;
    public void setRefSave(int refSave)
    {
        this.refSave = refSave;
    }
    private int willSave = 0;
    public void setWillSave(int willSave)
    {
        this.willSave = willSave;
    }

    private int[] savesArray;
    private static LayoutInflater inflater;

    public SavesAdapter()
    {
        //Default Constructor
    }

    public SavesAdapter(Activity context, int fortSave, int refSave, int willSave)
    {
        setContext(context);
        setFortSave(fortSave);
        setRefSave(refSave);
        setWillSave(willSave);
        savesArray = new int[] {fortSave, refSave, willSave};
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        return savesArray.length + 1;
    }

    @Override
    public Object getItem(int i)
    {
        return savesArray[i];
    }

    @Override
    public long getItemId(int i)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View vi = convertView;
        if(vi == null)
        {
            vi = inflater.inflate(R.layout.saves_row_view, null);
            if(position != 0)
            {
                TextView name = vi.findViewById(R.id.Name);
                TextView value = vi.findViewById(R.id.Value);
                TextView roll = vi.findViewById(R.id.Roll);

                switch(position)
                {
                    case 1:
                        name.setText(R.string.Fort);
                        break;
                    case 2:
                        name.setText(R.string.Ref);
                        break;
                    case 3:
                        name.setText(R.string.Will);
                        break;
                    default:
                        name.setText(R.string.Error);
                        break;
                }

                value.setText((Integer.toString(savesArray[position - 1])));
                value.setBackgroundResource(R.drawable.field_border);

                roll.setBackgroundResource(R.drawable.field_border);
            }
        }

        return vi;
    }
}
