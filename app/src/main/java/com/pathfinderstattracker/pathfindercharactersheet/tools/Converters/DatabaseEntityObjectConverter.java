package com.pathfinderstattracker.pathfindercharactersheet.tools.Converters;

import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerCharacterEntity;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IPlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.PlayerCharacter;

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
        EntityToReturn.setTotalHitPoints(playerCharacter.getTotalHitPoints());
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
        ObjectToReturn.setTotalHitPoints(playerCharacterEntity.getTotalHitPoints());
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
}
