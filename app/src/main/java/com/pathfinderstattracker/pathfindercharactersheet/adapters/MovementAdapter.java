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
import com.pathfinderstattracker.pathfindercharactersheet.models.races.Movement;
import com.pathfinderstattracker.pathfindercharactersheet.views.StatRowView;

import org.w3c.dom.Text;

/**
 * Created by Stephen Hagen on 2/6/2018.
 */

public class MovementAdapter extends BaseAdapter
{
    private Activity context = null;
    public void setContext(Activity context)
    {
        this.context = context;
    }
    private Movement[] movementList = null;
    public void setAbilityScoreList(Movement[] movementList)
    {
        this.movementList = movementList;
    }

    private static LayoutInflater inflater;

    public MovementAdapter(Activity context, Movement[] abilityScore)
    {
        setAbilityScoreList(abilityScore);
        setContext(context);
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount()
    {
        return (movementList.length + 1);
    }

    @Override
    public Object getItem(int i)
    {
        return movementList[i];
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
            vi = inflater.inflate(R.layout.movement_row_view, null);
            if(position != 0)
            {
                TextView name = vi.findViewById(R.id.Name);
                TextView feet = vi.findViewById(R.id.Feet);
                TextView squares = vi.findViewById(R.id.Squares);

                name.setText(movementList[position - 1].getName());

                feet.setText((Integer.toString(movementList[position - 1].getSpeed())));
                feet.setBackgroundResource(R.drawable.field_border);

                squares.setText(Integer.toString(calculateSquares(position)));
                squares.setBackgroundResource(R.drawable.field_border);
            }
        }

        return vi;
    }

    private int calculateSquares(int row)
    {
        int temp = movementList[row - 1].getSpeed();
        return (temp/5);
    }
}
