package com.pathfinderstattracker.pathfindercharactersheet.tools;

import android.view.View;

/**
 * Created by Stephen Hagen on 3/23/2018.
 */

public class VisibilitySwitcher
{
    public static void SwitchVisibility(View in)
    {
        if(in.getVisibility() == View.VISIBLE)
        {
            in.setVisibility(View.GONE);
        }
        else if(in.getVisibility() == View.GONE)
        {
            in.setVisibility(View.VISIBLE);
        }
        //If the view is invisible, we'll just leave it.
    }
}
