package com.pathfinderstattracker.pathfindercharactersheet.models.items;

/**
 * Created by Stephen Hagen on 12/26/2017.
 */

public interface IWeapon extends IEquipment
{
    WeaponFamilyEnum family = WeaponFamilyEnum.Simple;
    int range = 0;
    boolean reach = false;
    boolean thrown = false;
    boolean doubleheaded = false;
    boolean projectile = false;
    WeaponWeightClassEnum weightClass = WeaponWeightClassEnum.Light;
    boolean improvised = false;
    int magicBonus = 0;
    double cost = 0;
    Damage damage = new Damage(0,0);
    int criticalMultiplier = 2;
    int criticalRange = 1;
    boolean brace = false;
    WeaponDamageTypeEnum damageType = WeaponDamageTypeEnum.Slashing;
    boolean disarm = false;
    boolean monk = false;
    boolean trip = false;
    boolean nonLethal = false;
    String material = "";
    boolean masterwork = false;
}
