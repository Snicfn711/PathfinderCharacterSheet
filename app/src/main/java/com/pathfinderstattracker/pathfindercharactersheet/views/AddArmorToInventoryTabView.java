package com.pathfinderstattracker.pathfindercharactersheet.views;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;

import com.pathfinderstattracker.pathfindercharactersheet.R;

public class AddArmorToInventoryTabView extends ConstraintLayout
{
    public AddArmorToInventoryTabView(Context context)
    {
        super(context);
        initializeViews(context);
    }

    private void initializeViews(Context context)
    {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.add_armor_to_inventory_tab_view, this);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
    }
}
