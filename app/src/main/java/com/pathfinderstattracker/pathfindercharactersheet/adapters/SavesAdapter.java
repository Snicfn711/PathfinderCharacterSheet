package com.pathfinderstattracker.pathfindercharactersheet.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
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
    private Animation click;

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
        return savesArray.length;
    }

    @Override
    public Object getItem(int i)
    {
        return savesArray[i - 1];
    }

    @Override
    public long getItemId(int i)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        click = AnimationUtils.loadAnimation(parent.getContext(), R.anim.roll_button_click);

        View vi = convertView;
        if(vi == null)
        {
            vi = inflater.inflate(R.layout.saves_row_view, null);

            TextView name = vi.findViewById(R.id.Name);
            TextView value = vi.findViewById(R.id.Value);
            final ImageButton rollButton = vi.findViewById(R.id.RollSave);

            switch(position)
            {
                case 0:
                    name.setText(R.string.Fort);
                    break;
                case 1:
                    name.setText(R.string.Ref);
                    break;
                case 2:
                    name.setText(R.string.Will);
                    break;
                default:
                    name.setText(R.string.Error);
                    break;
            }
                value.setText((Integer.toString(savesArray[position])));
                value.setBackgroundResource(R.drawable.field_border);

            rollButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    rollButton.startAnimation(click);
                }
            });
            }
        return vi;
    }
}
