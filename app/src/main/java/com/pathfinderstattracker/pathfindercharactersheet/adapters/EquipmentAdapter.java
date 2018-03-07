package com.pathfinderstattracker.pathfindercharactersheet.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IEquipment;

/**
 * Created by Stephen Hagen on 3/7/2018.
 */

public class EquipmentAdapter extends BaseAdapter
{
    private Activity context = null;
    public void setContext(Activity context)
    {
        this.context = context;
    }
    private IEquipment[] equipmentList = null;
    public void setEquipmentList(IEquipment[] equipmentList)
    {
        this.equipmentList = equipmentList;
    }

    private static LayoutInflater inflater;

    public EquipmentAdapter(Activity context, IEquipment[] equipmentList)
    {
        setContext(context);
        setEquipmentList(equipmentList);
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        return equipmentList.length + 1;
    }

    @Override
    public Object getItem(int i)
    {
        return equipmentList[i];
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
            vi = inflater.inflate(R.layout.equipment_row_view, null);

            if(position != 0)
            {
                TextView magicBonus = vi.findViewById(R.id.MagicBonus);
                TextView equipmentAbilities = vi.findViewById(R.id.EquipmentAbilities);
                TextView equipmentName = vi.findViewById(R.id.EquipmentName);

                magicBonus.setText(Integer.toString(equipmentList[position].getMagicBonus()));
                equipmentAbilities.setText("None");//Same as with the recycler view, we're coping out here until abilities are actually implemented
                equipmentName.setText(equipmentList[position].getName());
            }
        }
        return vi;
    }
}
