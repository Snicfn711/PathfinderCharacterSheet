package com.pathfinderstattracker.pathfindercharactersheet.models.items;

/**
 * Created by Stephen Hagen on 12/27/2017.
 */

public class Weapon implements IWeapon
{
    public WeaponFamilyEnum family;
    public int range;
    public boolean reach;
    public boolean thrown;
    public boolean doubleheaded;
    public boolean projectile;
    public WeaponWeightClassEnum weightClass;
    public boolean improvised;
    public double cost;
    public Damage damage;
    public int criticalMultiplier;
    public int criticalRange;
    public boolean brace;
    public WeaponDamageTypeEnum damageType;
    public boolean disarm;
    public boolean monk;
    public boolean trip;
    public boolean nonLethal;
    public String material;
    public boolean masterwork;
    public boolean isMagic;
    public int magicBonus;
}
