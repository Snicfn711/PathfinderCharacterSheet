package com.pathfinderstattracker.pathfindercharactersheet.tools.Converters;

import android.arch.persistence.room.ColumnInfo;

import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.ArmorEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerCharacterEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.SkillEntity;
import com.pathfinderstattracker.pathfindercharactersheet.models.ISkill;
import com.pathfinderstattracker.pathfindercharactersheet.models.SizeCategoryEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.Skill;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IPlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.PlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.Armor;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.ArmorTypesEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.ArmorWeightCategoryEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IArmor;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IArmorEnchantment;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IProtection;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IShield;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.Shield;

import java.util.List;
import java.util.UUID;

public class DatabaseEntityObjectConverter
{
    public static PlayerCharacterEntity ConvertPlayerCharacterObjectToPlayerCharacterEntity(IPlayerCharacter playerCharacter)
    {
        PlayerCharacterEntity EntityToReturn = new PlayerCharacterEntity(playerCharacter.getPlayerCharacterID());
        EntityToReturn.setPlayerCharacterID(playerCharacter.getPlayerCharacterID());
        EntityToReturn.setPlayerCharacterName(playerCharacter.getPlayerCharacterName());
        EntityToReturn.setCharacterLevel(playerCharacter.getCharacterLevel());
        EntityToReturn.setConcentrationCheck(playerCharacter.getConcentrationCheck());
        EntityToReturn.setCharacterAlignment(playerCharacter.getCharacterAlignment());
        EntityToReturn.setTotalBaseAttackBonus(playerCharacter.getTotalBaseAttackBonus());
        EntityToReturn.setBaseHitPoints(playerCharacter.getBaseHitPoints());
        EntityToReturn.setTotalAC(playerCharacter.getTotalAC());
        EntityToReturn.setDamageReduction(playerCharacter.getDamageReduction());
        EntityToReturn.setLanguagesKnown(playerCharacter.getLanguagesKnown());
        EntityToReturn.setAbilityScores(playerCharacter.getAbilityScores());
        EntityToReturn.setCombatManeuverStats(playerCharacter.getCombatManeuverStats());
        EntityToReturn.setSpellResistance(playerCharacter.getSpellResistance());
        EntityToReturn.setFortitudeSave(playerCharacter.getFortitudeSave());
        EntityToReturn.setReflexSave(playerCharacter.getReflexSave());
        EntityToReturn.setWillSave(playerCharacter.getWillSave());
        return EntityToReturn;
    }
    
    public static IPlayerCharacter ConverterPlayerCharacterEntityToPlayerCharacterObject(PlayerCharacterEntity playerCharacterEntity)
    {
        IPlayerCharacter ObjectToReturn = new PlayerCharacter();
        ObjectToReturn.setPlayerCharacterID(playerCharacterEntity.getPlayerCharacterID());
        ObjectToReturn.setPlayerCharacterName(playerCharacterEntity.getPlayerCharacterName());
        ObjectToReturn.setCharacterLevel(playerCharacterEntity.getCharacterLevel());
        ObjectToReturn.setConcentrationCheck(playerCharacterEntity.getConcentrationCheck());
        ObjectToReturn.setCharacterAlignment(playerCharacterEntity.getCharacterAlignment());
        ObjectToReturn.setTotalBaseAttackBonus(playerCharacterEntity.getTotalBaseAttackBonus());
        ObjectToReturn.setBaseHitPoints(playerCharacterEntity.getBaseHitPoints());
        ObjectToReturn.setTotalAC(playerCharacterEntity.getTotalAC());
        ObjectToReturn.setDamageReduction(playerCharacterEntity.getDamageReduction());
        ObjectToReturn.setLanguagesKnown(playerCharacterEntity.getLanguagesKnown());
        ObjectToReturn.setCombatManeuverStats(playerCharacterEntity.getCombatManeuverStats());
        ObjectToReturn.setSpellResistance(playerCharacterEntity.getSpellResistance());
        ObjectToReturn.setFortitudeSave(playerCharacterEntity.getFortitudeSave());
        ObjectToReturn.setReflexSave(playerCharacterEntity.getReflexSave());
        ObjectToReturn.setWillSave(playerCharacterEntity.getWillSave());
        ObjectToReturn.setAbilityScores(playerCharacterEntity.getAbilityScores());
        return ObjectToReturn;
    }

    public static ISkill ConvertSkillEntityToSkillObject(SkillEntity skillEntity)
    {
        ISkill ObjectToReturn = new Skill();
        ObjectToReturn.setSkillID(skillEntity.getSkillID());
        ObjectToReturn.setAddedStat(skillEntity.getAddedStat());
        ObjectToReturn.setArmorCheckPenaltyApplied(skillEntity.isArmorCheckPenaltyApplied());
        ObjectToReturn.setSkillName(skillEntity.getSkillName());
        return ObjectToReturn;
    }

    public static SkillEntity ConvertSkillObjectToSkillEntity(ISkill skillObject)
    {
        SkillEntity ObjectToReturn = new SkillEntity();
        ObjectToReturn.setSkillID(skillObject.getSkillID());
        ObjectToReturn.setAddedStat(skillObject.getAddedStat());
        ObjectToReturn.setArmorCheckPenaltyApplied(skillObject.isArmorCheckPenaltyApplied());
        ObjectToReturn.setSkillName(skillObject.getSkillName());
        return ObjectToReturn;
    }

    public static ArmorEntity ConvertProtectionObjectToArmorEntity(IProtection protection)
    {
        ArmorEntity ObjectToReturn = new ArmorEntity(protection.getItemID());
        ObjectToReturn.setCost(protection.getCost());
        ObjectToReturn.setWeight(protection.getCurrentWeight());
        ObjectToReturn.setName(protection.getName());
        ObjectToReturn.setDescription(protection.getDescription());
        ObjectToReturn.setAcBonus(protection.getACBonus());
        ObjectToReturn.setMaximumDexBonus(protection.getMaximumDexBonus());
        ObjectToReturn.setArmorCheckPenalty(protection.getArmorCheckPenalty());
        ObjectToReturn.setArcaneSpellFailureChance(protection.getArcaneSpellFailureChance());
        if(protection instanceof IArmor)
        {
            ObjectToReturn.setMaxSpeed(((IArmor) protection).getMaxSpeed());
            ObjectToReturn.setWeightCategory(((IArmor) protection).getWeightCategory());
        }
        else
        {
            ObjectToReturn.setMaxSpeed(null);
            ObjectToReturn.setWeightCategory(null);
        }
        ObjectToReturn.setArmorSize(protection.getSizeCategory());
        ObjectToReturn.setFragile(protection.isFragile());
        ObjectToReturn.setArmorType(protection.getArmorType());
        ObjectToReturn.setMagicBonus(protection.getMagicBonus());
        return ObjectToReturn;
    }

    public static IArmor ConvertArmorEntityToArmorObject(ArmorEntity armorEntity)
    {
        IArmor ObjectToReturn = new Armor();

        ObjectToReturn.setItemID(armorEntity.getArmorID());
        ObjectToReturn.setCost(armorEntity.getCost());
        ObjectToReturn.setWeightAtMediumSize(armorEntity.getWeight());
        ObjectToReturn.setName(armorEntity.getName());
        ObjectToReturn.setDescription(armorEntity.getDescription());
        ObjectToReturn.setACBonus(armorEntity.getAcBonus());
        ObjectToReturn.setMagicBonus(armorEntity.getMagicBonus());
        ObjectToReturn.setMaxSpeed(armorEntity.getMaxSpeed());
        ObjectToReturn.setWeightCategory(armorEntity.getWeightCategory());
        ObjectToReturn.setMaximumDexBonus(armorEntity.getMaximumDexBonus());
        ObjectToReturn.setArmorCheckPenalty(armorEntity.getArmorCheckPenalty());
        ObjectToReturn.setArcaneSpellFailureChance(armorEntity.getArcaneSpellFailureChance());
        ObjectToReturn.setSizeCategory(armorEntity.getArmorSize());
        //This next line isn't strictly necessary since the getter always returns "Armor" but if we create weird custom amrors it'll be useful
        ObjectToReturn.setArmorType(armorEntity.getArmorType());
        ObjectToReturn.setIsFragile(armorEntity.isFragile());

        return ObjectToReturn;
    }

    public static IShield ConvertArmorEntityToShieldObject(ArmorEntity armorEntity)
    {
        IShield ObjectToReturn = new Shield();

        ObjectToReturn.setItemID(armorEntity.getArmorID());
        ObjectToReturn.setCost(armorEntity.getCost());
        ObjectToReturn.setWeightAtMediumSize(armorEntity.getWeight());
        ObjectToReturn.setName(armorEntity.getName());
        ObjectToReturn.setDescription(armorEntity.getDescription());
        ObjectToReturn.setACBonus(armorEntity.getAcBonus());
        ObjectToReturn.setMagicBonus(armorEntity.getMagicBonus());
        ObjectToReturn.setMaximumDexBonus(armorEntity.getMaximumDexBonus());
        ObjectToReturn.setArmorCheckPenalty(armorEntity.getArmorCheckPenalty());
        ObjectToReturn.setArcaneSpellFailureChance(armorEntity.getArcaneSpellFailureChance());
        ObjectToReturn.setSizeCategory(armorEntity.getArmorSize());
        //This next line isn't strictly necessary since the getter always returns "Shield" but if we create weird custom shields it'll be useful
        ObjectToReturn.setArmorType(armorEntity.getArmorType());
        ObjectToReturn.setIsFragile(armorEntity.isFragile());
        //No shield affects either a player's max speed nor do they have armor weight categories, so those two fields are omitted here

        return ObjectToReturn;
    }
}
