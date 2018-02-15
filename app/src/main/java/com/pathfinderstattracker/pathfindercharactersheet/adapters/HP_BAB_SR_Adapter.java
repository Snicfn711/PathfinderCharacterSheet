package com.pathfinderstattracker.pathfindercharactersheet.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IHitPoints;

/**
 * Created by Stephen Hagen on 2/15/2018.
 */

//TODO: IF performance is an issue, come back and see if a list view is necessary here, or if we can avoid using an adapter
public class HP_BAB_SR_Adapter extends BaseAdapter
{
    private IHitPoints hitPoints;
    public void setHitPoints(IHitPoints hitPoints)
    {
        this.hitPoints = hitPoints;
    }
    private int baseAttackBonus;
    public void setBaseAttackBonus(int baseAttackBonus)
    {
        this.baseAttackBonus = baseAttackBonus;
    }
    private int spellResistance;
    public void setSpellResistance(int spellResistance)
    {
        this.spellResistance = spellResistance;
    }
    private static LayoutInflater inflater;

    public HP_BAB_SR_Adapter()
    {
        //Default Constructor
    }

    public HP_BAB_SR_Adapter(Activity context, IHitPoints hitPoints, int baseAttackBonus, int spellResistance)
    {
        setHitPoints(hitPoints);
        setBaseAttackBonus(baseAttackBonus);
        setSpellResistance(spellResistance);
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
            vi = inflater.inflate(R.layout.hp_bab_sr_view, null);
            TextView hitPointValue = vi.findViewById(R.id.HitPointValue);
            TextView baseAttackBonusValue = vi.findViewById(R.id.BaseAttackBonusValue);
            TextView spellResistanceValue = vi.findViewById(R.id.SpellResistanceValue);

            hitPointValue.setText((Integer.toString(hitPoints.getValue())));
            baseAttackBonusValue.setText(Integer.toString(baseAttackBonus));
            spellResistanceValue.setText(Integer.toString(spellResistance));
        }
        return vi;
    }
}
