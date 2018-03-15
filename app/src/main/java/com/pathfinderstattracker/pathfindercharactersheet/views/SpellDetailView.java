package com.pathfinderstattracker.pathfindercharactersheet.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.ICastingTime;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.ISpell;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.ISpellDuration;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.ISpellRange;

/**
 * TODO: document your custom view class.
 */
public class SpellDetailView extends ConstraintLayout
{
    private TextView spellName;
    private TextView castingTime;
    private TextView spellRange;
    private TextView spellTargets;
    private TextView spellDuration;
    private TextView requiresSavingThrow;//Even though the name implies this could be a boolean, it's also being used to tell the user the effects of a successful save, thus it's a string
    private TextView targetsSpellResistance;
    private TextView requiredSpellComponents;
    private TextView spellSchoolAndDescriptors;
    private TextView longSpellDescription;

    public SpellDetailView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    private void initializeViews(Context context)
    {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.spell_detail_view, this);
    }
    protected void onFinishInflate()
    {
        super.onFinishInflate();
        spellName = this.findViewById(R.id.SpellName);
        castingTime = this.findViewById(R.id.SpellCastingTime);
        spellRange = this.findViewById(R.id.SpellRange);
        spellTargets= this.findViewById(R.id.SpellTargets);
        spellDuration = this.findViewById(R.id.SpellDuration);
        requiresSavingThrow = this.findViewById(R.id.RequiresSavingThrow);
        targetsSpellResistance = this.findViewById(R.id.TargetsSpellResistance);
        requiredSpellComponents = this.findViewById(R.id.RequiredSpellComponents);
        spellSchoolAndDescriptors = this.findViewById(R.id.SpellSchoolAndDescriptors);
        longSpellDescription = this.findViewById(R.id.SpellLongDescription);
    }

    public void setValues(ISpell spell)
    {
        spellName.setText(spell.getSpellName());
        castingTime.setText(spell.getCastingTime().toString());
        spellTargets.setText(spell.getTarget());
    }



}
