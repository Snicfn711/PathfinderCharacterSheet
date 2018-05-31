package com.pathfinderstattracker.pathfindercharactersheet.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.models.races.IMovement;

import java.util.List;

public class MovementReferenceBlockView extends LinearLayout
{
    private TextView baseMovementFeet;
    private TextView baseMovementSquares;
    private TextView armorMovementFeet;
    private TextView armorMovementSquares;
    private TextView flyMovementFeet;
    private TextView flyMovementSquares;    
    private TextView swimMovementFeet;
    private TextView swimMovementSquares;
    private TextView climbMovementFeet;
    private TextView climbMovementSquares;
    private TextView burrowMovementFeet;
    private TextView burrowMovementSquares;

    public MovementReferenceBlockView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        initializeViews(context);
    }

    private void initializeViews(Context context)
    {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.movement_reference_block_view, this);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        baseMovementFeet = this.findViewById(R.id.BaseMovmentSpeedFeetValue);
        baseMovementSquares = this.findViewById(R.id.BaseMovmentSpeedSquaresValue);
        armorMovementFeet = this.findViewById(R.id.ArmorMovmentSpeedFeetValue);
        armorMovementSquares = this.findViewById(R.id.ArmorMovementSpeedSquaresValue);
        flyMovementFeet = this.findViewById(R.id.FlyMovmentSpeedFeetValue);
        flyMovementSquares = this.findViewById(R.id.FlyMovmentSpeedSquaresValue);
        swimMovementFeet = this.findViewById(R.id.SwimMovmentSpeedFeetValue);
        swimMovementSquares = this.findViewById(R.id.SwimMovmentSpeedSquaresValue);
        climbMovementFeet = this.findViewById(R.id.ClimbMovmentSpeedFeetValue);
        climbMovementSquares = this.findViewById(R.id.ClimbMovmentSpeedSquaresValue);
        burrowMovementFeet = this.findViewById(R.id.BurrowMovmentSpeedFeetValue);
        burrowMovementSquares = this.findViewById(R.id.BurrowMovmentSpeedSquaresValue);
    }

    public void setValues(List<IMovement> movementList)
    {
        for(IMovement movement:movementList)
        {
            switch(movement.getName())
            {
                case "Base":
                    baseMovementFeet.setText(Integer.toString(movement.getSpeed()));
                    baseMovementSquares.setText(Integer.toString(movement.getSpeed()/5));
                    break;
                case "Armor":
                    armorMovementFeet.setText(Integer.toString(movement.getSpeed()));
                    armorMovementSquares.setText(Integer.toString(movement.getSpeed()/5));
                    break;
                case "Fly":
                    flyMovementFeet.setText(Integer.toString(movement.getSpeed()));
                    flyMovementSquares.setText(Integer.toString(movement.getSpeed()/5));
                    break;
                case "Swim":
                    swimMovementFeet.setText(Integer.toString(movement.getSpeed()));
                    swimMovementSquares.setText(Integer.toString(movement.getSpeed()/5));
                    break;
                case "Climb":
                    climbMovementFeet.setText(Integer.toString(movement.getSpeed()));
                    climbMovementSquares.setText(Integer.toString(movement.getSpeed()/5));
                    break;
                case "Burrow":
                    burrowMovementFeet.setText(Integer.toString(movement.getSpeed()));
                    burrowMovementSquares.setText(Integer.toString(movement.getSpeed()/5));
                    break;
            }
        }
    }

}
