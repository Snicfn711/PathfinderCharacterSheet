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
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.CombatManeuver;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.ICombatManeuver;

public class CombatManueverReferenceBlockView extends LinearLayout
{
    private TextView combatManueverBonus;
    private TextView combatManueverDefense;
    private Animation click;

    public CombatManueverReferenceBlockView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        initializeViews(context);
        click = AnimationUtils.loadAnimation(context, R.anim.roll_button_click);
    }

    private void initializeViews(Context context)
    {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.combat_manuever_reference_block_view, this);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        combatManueverBonus = this.findViewById(R.id.CMBValue);
        final ImageButton rollCombatManueverButton = this.findViewById(R.id.RollCombatManuever);
        rollCombatManueverButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                rollCombatManueverButton.startAnimation(click);
            }
        });
        combatManueverDefense = this.findViewById(R.id.CMDValue);
    }

    public void setValues(ICombatManeuver combatManeuverStats)
    {
        this.combatManueverBonus.setText(Integer.toString(combatManeuverStats.getCombatManeuverCheck()));
        this.combatManueverDefense.setText(Integer.toString(combatManeuverStats.getCombatManeuverDefense()));
    }
}
