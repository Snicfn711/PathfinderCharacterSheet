package com.pathfinderstattracker.pathfindercharactersheet.tools.Converters;

/**
 * Created by Stephen Hagen on 3/26/2018.
 */

public class BooleanToEnglishConverter
{
    public static String BooleanToYesNo(Boolean in)
    {
        if(in)
        {
            return "Yes";
        }
        return "No";
    }
}
