package com.pathfinderstattracker.pathfindercharactersheet.models.characters;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */

public class DamageReduction implements  IDamageReduction
{
    private int amount;
    private String type;
    private String source;

    //region Getters and Setters
    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public void setAmount(int amount)
    {
        this.amount = amount;
    }

    @Override
    public String getSource() {
        return source;
    }

    @Override
    public void setSource(String source)
    {
        this.source = source;
    }

    @Override
    public String getType()
    {
        return type;
    }

    @Override
    public void setType(String type)
    {
        this.type = type;
    }
    //endregion

    public DamageReduction()
    {
        //Default Constructor
    }

    public DamageReduction(int amount, String type, String source) {
        setAmount(amount);
        setType(type);
        setSource(source);
    }

    @Override
    public String toString()
    {
        return Integer.toString(amount) + "/" + type;
    }
}
