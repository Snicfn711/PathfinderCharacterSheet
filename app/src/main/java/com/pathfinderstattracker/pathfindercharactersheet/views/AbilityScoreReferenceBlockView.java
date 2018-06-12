package com.pathfinderstattracker.pathfindercharactersheet.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.tools.Dialogs.EditAbilityScoresDialog;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.StatsReferenceFragment;

import java.util.List;

public class AbilityScoreReferenceBlockView extends LinearLayout
{
    private TextView strengthScore;
    private TextView strengthModifier;
    private TextView dexterityScore;
    private TextView dexterityModifier;
    private TextView constitutionScore;
    private TextView constitutionModifier;
    private TextView intelligenceScore;
    private TextView intelligenceModifier;
    private TextView wisdomScore;
    private TextView wisdomModifier;
    private TextView charismaScore;
    private TextView charismaModifier;
    private Animation click;

    public AbilityScoreReferenceBlockView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        initializeViews(context);
        click = AnimationUtils.loadAnimation(context, R.anim.roll_button_click);
    }

    private void initializeViews(Context context)
    {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.ability_score_reference_block_view, this);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        strengthScore = this.findViewById(R.id.StrengthScoreValue);
        strengthModifier = this.findViewById(R.id.StrengthModifierValue);
        final ImageButton rollStrengthButton = this.findViewById(R.id.RollStrengthCheck);
        rollStrengthButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                rollStrengthButton.startAnimation(click);
            }
        });
        dexterityScore = this.findViewById(R.id.DexterityScoreValue);
        dexterityModifier = this.findViewById(R.id.DexterityModifierValue);
        final ImageButton rollDexterityButton = this.findViewById(R.id.RollDexterityCheck);
        rollDexterityButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                rollDexterityButton.startAnimation(click);
            }
        });
        constitutionScore = this.findViewById(R.id.ConstitutionScoreValue);
        constitutionModifier = this.findViewById(R.id.ConstitutionModifierValue);
        final ImageButton rollConstitutionButton = this.findViewById(R.id.RollConstitutionCheck);
        rollConstitutionButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                rollConstitutionButton.startAnimation(click);
            }
        });
        intelligenceScore = this.findViewById(R.id.IntelligenceScoreValue);
        intelligenceModifier = this.findViewById(R.id.IntelligenceModifierValue);
        final ImageButton rollIntelligenceButton = this.findViewById(R.id.RollIntelligenceCheck);
        rollIntelligenceButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                rollIntelligenceButton.startAnimation(click);
            }
        });
        wisdomScore = this.findViewById(R.id.WisdomScoreValue);
        wisdomModifier = this.findViewById(R.id.WisdomModifierValue);
        final ImageButton rollWisdomButton = this.findViewById(R.id.RollWisdomCheck);
        rollWisdomButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                rollWisdomButton.startAnimation(click);
            }
        });
        charismaScore = this.findViewById(R.id.CharismaScoreValue);
        charismaModifier = this.findViewById(R.id.CharismaModifierValue);
        final ImageButton rollCharismaButton = this.findViewById(R.id.RollCharismaCheck);
        rollCharismaButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                rollCharismaButton.startAnimation(click);
            }
        });
    }

    public void setValues(List<IAbilityScore> abilityScoreList)
    {
        for(IAbilityScore abilityScore:abilityScoreList)
        {
            switch(abilityScore.getStat())
            {
                case STR:
                    strengthScore.setText(Integer.toString(abilityScore.getAmount()));
                    strengthModifier.setText(Integer.toString(abilityScore.calculateModifier()));
                    break;
                case DEX:
                    dexterityScore.setText(Integer.toString(abilityScore.getAmount()));
                    dexterityModifier.setText(Integer.toString(abilityScore.calculateModifier()));
                    break;
                case CON:
                    constitutionScore.setText(Integer.toString(abilityScore.getAmount()));
                    constitutionModifier.setText(Integer.toString(abilityScore.calculateModifier()));
                    break;
                case INT:
                    intelligenceScore.setText(Integer.toString(abilityScore.getAmount()));
                    intelligenceModifier.setText(Integer.toString(abilityScore.calculateModifier()));
                    break;
                case WIS:
                    wisdomScore.setText(Integer.toString(abilityScore.getAmount()));
                    wisdomModifier.setText(Integer.toString(abilityScore.calculateModifier()));
                    break;
                case CHA:
                    charismaScore.setText(Integer.toString(abilityScore.getAmount()));
                    charismaModifier.setText(Integer.toString(abilityScore.calculateModifier()));
                    break;
            }
        }
    }
}

