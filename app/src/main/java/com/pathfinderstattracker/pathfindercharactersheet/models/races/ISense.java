package com.pathfinderstattracker.pathfindercharactersheet.models.races;

/**
 * Created by Stephen Hagen on 1/5/2018.
 */
import java.io.Serializable;

public interface ISense extends Serializable
{
    String getName();
    void setName(String name);
    int getDistance();
    void setDistance(int distance);
    String getEffectText();
    void setEffectText(String effectText);
}
