package com.pathfinderstattracker.pathfindercharactersheet.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;

/**
 * TODO: document your custom view class.
 */
public class InitiativeReferenceBlockView extends LinearLayout
{
    private TextView initiative;
    private Animation click;

    public InitiativeReferenceBlockView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        initializeViews(context);
        click = AnimationUtils.loadAnimation(context, R.anim.roll_button_click);
    }

    private void initializeViews(Context context)
    {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.initiative_reference_block_view, this);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        initiative = this.findViewById(R.id.InitiativeValue);
    }

    public void setValues(int initiative)
    {
        this.initiative.setText(Integer.toString(initiative));
    }
}
