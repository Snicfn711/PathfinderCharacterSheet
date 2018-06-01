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

public class CombatManeuverReferenceBlockView extends LinearLayout
{
    private TextView combatManeuverBonus;
    private TextView combatManeuverDefense;
    private Animation click;

    public CombatManeuverReferenceBlockView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        initializeViews(context);
        click = AnimationUtils.loadAnimation(context, R.anim.roll_button_click);
    }

    private void initializeViews(Context context)
    {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.combat_maneuever_reference_block_view, this);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        combatManeuverBonus = this.findViewById(R.id.CMBValue);
        final ImageButton rollCombatManeuverButton = this.findViewById(R.id.RollCombatManeuver);
        rollCombatManeuverButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                rollCombatManeuverButton.startAnimation(click);
            }
        });
        combatManeuverDefense = this.findViewById(R.id.CMDValue);
    }

    public void setValues(ICombatManeuver combatManeuverStats)
    {
        this.combatManeuverBonus.setText(Integer.toString(combatManeuverStats.getCombatManeuverCheck()));
        this.combatManeuverDefense.setText(Integer.toString(combatManeuverStats.getCombatManeuverDefense()));
    }
}
