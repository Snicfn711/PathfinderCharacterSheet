package com.pathfinderstattracker.pathfindercharactersheet.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.ICombatManeuver;

/**
 * Created by Stephen Hagen on 2/14/2018.
 */
//TODO: IF performance is an issue, come back and see if a list view is necessary here, or if we can avoid using an adapter
public class CombatManueverAdapter extends BaseAdapter
{
    private Activity context = null;
    public void setContext(Activity context)
    {
        this.context = context;
    }
    private ICombatManeuver combatManuever = null;
    public void setCombatManuever(ICombatManeuver combatManuever)
    {
        this.combatManuever = combatManuever;
    }

    private static LayoutInflater inflater;

    public CombatManueverAdapter(Activity context, ICombatManeuver combatManuever)
    {
        setCombatManuever(combatManuever);
        setContext(context);
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount()
    {
        return 1;
    }

    @Override
    public Object getItem(int i)
    {
        return null;
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
            vi = inflater.inflate(R.layout.combat_manuever_view, null);
            TextView CMBValue = vi.findViewById(R.id.CMBValue);
            TextView CMDValue = vi.findViewById(R.id.CMDValue);

            CMBValue.setText((Integer.toString(combatManuever.getCombatManeuverCheck())));

            CMDValue.setText(Integer.toString(combatManuever.getCombatManeuverDefense()));
        }
        return vi;
    }
}
