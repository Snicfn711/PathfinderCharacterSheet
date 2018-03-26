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

import static com.pathfinderstattracker.pathfindercharactersheet.tools.BooleanToEnglishConverter.BooleanToYesNo;

/**
 * TODO: document your custom view class.
 */
public class SpellDetailView extends ConstraintLayout
{
    private TextView spellName;
    private TextView castingTime;
    private TextView spellRange;
    private TextView spellTargets;
    private TextView spellArea;
    private TextView spellDuration;
    private TextView requiresSavingThrow;//Even though the name implies this could be a boolean, it's also being used to tell the user the effects of a successful save, thus it's a string
    private TextView targetsSpellResistance;
    private TextView requiredSpellComponents;
    private TextView spellSchoolAndDescriptors;
    private TextView longSpellDescription;

    public SpellDetailView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        initializeViews(context);
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
        spellArea = this.findViewById(R.id.SpellArea);
        spellDuration = this.findViewById(R.id.SpellDuration);
        requiresSavingThrow = this.findViewById(R.id.RequiresSavingThrow);
        targetsSpellResistance = this.findViewById(R.id.TargetsSpellResistance);
        requiredSpellComponents = this.findViewById(R.id.RequiredSpellComponents);
        spellSchoolAndDescriptors = this.findViewById(R.id.SpellSchoolAndDescriptors);
        longSpellDescription = this.findViewById(R.id.SpellLongDescription);
    }

    public void setValues(ISpell spell)
    {
        //Todo:A lot of these values are terribly formatted, we'll have to come back and fix them up.
        spellName.setText(String.format("Name: %s", spell.getSpellName()));
        castingTime.setText(String.format("Casting Time: %s", spell.getCastingTime().toString()));
        spellRange.setText(String.format("Range: %s", spell.getSpellRange().toString()));
        spellTargets.setText(String.format("Target(s): %s", spell.getTarget()));
        spellDuration.setText(String.format("Duration: %s", spell.getSpellDuration().toString()));
        requiresSavingThrow.setText(String.format("Saving Throw: %s", spell.getSavingThrow()));
        targetsSpellResistance.setText(String.format("Spell Resistance: %s", BooleanToYesNo(spell.targetsSpellResistance())));
        requiredSpellComponents.setText(String.format("Material Components: %s", spell.getMaterialComponents()));
        spellSchoolAndDescriptors.setText(String.format("Spell School: %s", spell.getSchool().toString()));
        longSpellDescription.setText(String.format("Description: %s", spell.getFullDescription()));

        if(spell.getSpellArea() == null)
        {
            spellArea.setVisibility(GONE);
        }
        else if(spell.getSpellArea() != null)
        {
            spellArea.setText(String.format("Area: %s", spell.getSpellArea().toString()));
        }
    }
}
