package com.pathfinderstattracker.pathfindercharactersheet.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
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
        final ImageButton rollFortButton = this.findViewById(R.id.RollFortSave);
        rollFortButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                rollFortButton.startAnimation(click);
            }
        });
        reflexSave = this.findViewById(R.id.ReflexSaveValue);
        final ImageButton rollReflexButton = this.findViewById(R.id.RollReflexSave);
        rollReflexButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                rollReflexButton.startAnimation(click);
            }
        });
        willSave = this.findViewById(R.id.WillSaveValue);
        final ImageButton rollWillButton = this.findViewById(R.id.RollWillSave);
        rollWillButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                rollWillButton.startAnimation(click);
            }
        });
        final ImageButton editSavesButton = this.findViewById(R.id.EditsSavesButton);
        editSavesButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                editSavesButton.startAnimation(click);
            }
        });
    }

    public void setValues(int fortitudeSave, int reflexSave, int willSave)
    {
        this.fortitudeSave.setText(Integer.toString(fortitudeSave));
        this.reflexSave.setText(Integer.toString(reflexSave));
        this.willSave.setText(Integer.toString(willSave));
    }
}
