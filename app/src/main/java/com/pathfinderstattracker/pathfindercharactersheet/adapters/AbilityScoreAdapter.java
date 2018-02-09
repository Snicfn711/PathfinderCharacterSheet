package com.pathfinderstattracker.pathfindercharactersheet.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.models.Ability;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScore;

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
    private AbilityScore[] abilityScoreList = null;
    public void setAbilityScoreList(AbilityScore[] abilityScoreList)
    {
        this.abilityScoreList = abilityScoreList;
    }

    public AbilityScoreAdapter(Activity context, AbilityScore[] abilityScore)
    {
        setAbilityScoreList(abilityScore);
        setContext(context);
    }
    @Override
    public int getCount()
    {
        return (abilityScoreList.length + 1) * 4;
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
        TextView textView;

        int row = getRow(position);
        int column = getColumn(position);

        if(convertView == null)
        {
            textView = new TextView(context);
            if (row == 0)
            {
                textView.setBackgroundColor(Color.argb(50, 0, 0, 0));
                textView.setTextColor(Color.rgb(255, 215, 0));
            }
            else if (column == 0 && row > 0)
            {
                textView.setText(abilityScoreList[row - 1].getStat().toString());
            }
            else if (column == 1 && row > 0)
            {
                textView.setText((abilityScoreList[row - 1].getAmount()));
            }
            else if (column == 2 && row > 0)
            {
                textView.setText(calculateModifier(row));
            }
            else if(column == 3 && row > 0)
            {
                textView.setBackgroundColor(Color.RED);
            }
        }
        else
        {
            textView  = (TextView)convertView;
        }

        return textView;

    }

    private int getRow(int pos)
    {
        return pos / 4; //So what if it's hardcoded? Pathfinder isn't going to add any new stats
    }

    private int getColumn(int pos)
    {
        return pos % 4;//Yeah it's hardcoded, but the grid shouldn't change any time soon
    }

    private int calculateModifier(int row)
    {
        return ((abilityScoreList[row - 1].getAmount() - 10) / 2);
    }
}
