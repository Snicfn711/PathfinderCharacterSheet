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
//TODO: IF performance is an issue, come back and see if a list view is necessary here, or if we can avoid using an adapter
public class InitiativeAdapter extends BaseAdapter
{
    private Activity context = null;
    public void setContext(Activity context)
    {
        this.context = context;
    }
    private int initiative = 0;
    public void setInitiative(int initiative)
    {
        this.initiative = initiative;
    }

    private static LayoutInflater inflater;

    public InitiativeAdapter()
    {
        //Default constructor
    }

    public InitiativeAdapter(Activity context, int initiative)
    {
        setContext(context);
        setInitiative(initiative);
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        return 1; //A character can only ever have one initiative score
    }

    @Override
    public Object getItem(int i)
    {
        return initiative;
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
            vi = inflater.inflate(R.layout.initiative_view, null);
            TextView value = vi.findViewById(R.id.Value);

            value.setText(Integer.toString(initiative));
        }
        return vi;
    }
}
