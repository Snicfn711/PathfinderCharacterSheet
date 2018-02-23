package com.pathfinderstattracker.pathfindercharactersheet.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.models.ISkill;

/**
 * Created by Stephen Hagen on 2/22/2018.
 */

public class SkillsAdapter extends BaseAdapter
{
    private Activity context = null;
    public void setContext(Activity context)
    {
        this.context = context;
    }
    private ISkill[] skillList = null;
    public void setSkillList(ISkill[] skillList)
    {
        this.skillList = skillList;
    }

    private static LayoutInflater inflater;

    public SkillsAdapter(Activity context, ISkill[] skillList)
    {
        setContext(context);
        setSkillList(skillList);
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        return skillList.length + 1;
    }

    @Override
    public Object getItem(int i)
    {
        return skillList[i];
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
            vi = inflater.inflate(R.layout.skill_row_view, null);

            if(position != 0)
            {
                CheckBox isClassSkill = vi.findViewById(R.id.IsClassSkill);
                TextView skillName = vi.findViewById(R.id.SkillName);
                TextView skillStat = vi.findViewById(R.id.SkillStat);
                TextView skillTotal = vi.findViewById(R.id.SkillTotal);

                isClassSkill.setChecked(skillList[position].isProficiency());
                skillName.setText(skillList[position].getSkillName());
                skillStat.setText(skillList[position].getAddedStat().toString());
                skillTotal.setText(Integer.toString(skillList[position].getPointsInvested()));
            }
        }
        return vi;
    }
}
