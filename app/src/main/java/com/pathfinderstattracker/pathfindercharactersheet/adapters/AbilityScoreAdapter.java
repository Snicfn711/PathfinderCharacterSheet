package com.pathfinderstattracker.pathfindercharactersheet.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.models.Ability;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.views.StatRowView;

import org.w3c.dom.Text;

/**
 * Created by Stephen Hagen on 2/6/2018.
 */

public class AbilityScoreAdapter extends BaseAdapter
{
    private Activity context = null;
    public void setContext(Activity context)
    {
        this.context = context;
    }
    private IAbilityScore[] abilityScoreList = null;
    public void setAbilityScoreList(IAbilityScore[] abilityScoreList)
    {
        this.abilityScoreList = abilityScoreList;
    }

    private static LayoutInflater inflater;

    public AbilityScoreAdapter(Activity context, IAbilityScore[] abilityScore)
    {
        setAbilityScoreList(abilityScore);
        setContext(context);
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount()
    {
        return (abilityScoreList.length + 1);
    }

    @Override
    public Object getItem(int i)
    {
        return abilityScoreList[i];
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
            vi = inflater.inflate(R.layout.stat_row_view, null);
            if(position != 0)
            {
                TextView name = vi.findViewById(R.id.Name);
                TextView value = vi.findViewById(R.id.Value);
                TextView modifier = vi.findViewById(R.id.Modifier);
                TextView roll = vi.findViewById(R.id.Roll);

                name.setText(abilityScoreList[position - 1].getStat().toString());

                value.setText((Integer.toString(abilityScoreList[position - 1].getAmount())));
                value.setBackgroundResource(R.drawable.field_border);

                modifier.setText(Integer.toString(calculateModifier(position)));
                modifier.setBackgroundResource(R.drawable.field_border);

                roll.setBackgroundResource(R.drawable.field_border);
            }
        }

        return vi;
    }

    private int calculateModifier(int row)
    {
        int temp = abilityScoreList[row - 1].getAmount();
        return ((temp - 10) / 2);
    }
}
