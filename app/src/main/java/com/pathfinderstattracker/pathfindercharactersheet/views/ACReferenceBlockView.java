package com.pathfinderstattracker.pathfindercharactersheet.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;

/**
 * TODO: document your custom view class.
 */
public class ACReferenceBlockView extends LinearLayout
{
    private TextView totalAC;
    private TextView touchAC;
    private TextView flatFootedAC;

    public ACReferenceBlockView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        initializeViews(context);
    }

    private void initializeViews(Context context)
    {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.ac_reference_block_view, this);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        totalAC = this.findViewById(R.id.TotalACValue);
        touchAC = this.findViewById(R.id.TouchACValue);
        flatFootedAC = this.findViewById(R.id.FlatFootedACValue);
    }

    public void setValues(int totalAC, int touchAC, int flatFootedAC)
    {
        this.totalAC.setText(Integer.toString(totalAC));
        this.touchAC.setText(Integer.toString(touchAC));
        this.flatFootedAC.setText(Integer.toString(flatFootedAC));
    }
}
