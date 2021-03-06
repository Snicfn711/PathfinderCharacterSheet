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

public class SavesReferenceBlockView extends LinearLayout
{
    private TextView fortitudeSave;
    private TextView reflexSave;
    private TextView willSave;
    private Animation click;

    public SavesReferenceBlockView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        initializeViews(context);
        click = AnimationUtils.loadAnimation(context, R.anim.roll_button_click);
    }

    private void initializeViews(Context context)
    {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.saves_reference_block_view, this);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        fortitudeSave = this.findViewById(R.id.FortSaveValue);
        reflexSave = this.findViewById(R.id.ReflexSaveValue);
        willSave = this.findViewById(R.id.WillSaveValue);
    }

    public void setValues(int fortitudeSave, int reflexSave, int willSave)
    {
        this.fortitudeSave.setText(Integer.toString(fortitudeSave));
        this.reflexSave.setText(Integer.toString(reflexSave));
        this.willSave.setText(Integer.toString(willSave));
    }
}
