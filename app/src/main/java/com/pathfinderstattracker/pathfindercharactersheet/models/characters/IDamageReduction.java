package com.pathfinderstattracker.pathfindercharactersheet.models.characters;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */

public interface IDamageReduction
{
    int getAmount();
    void setAmount(int Amount);
    String getSource();
    void setSource(String source);
    String getType();
    void setType(String type);
}
