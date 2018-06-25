package com.pathfinderstattracker.pathfindercharactersheet.database.database_entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.UUIDConverter;

import java.util.UUID;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(primaryKeys = {"playerCharacterID", "skillID"},
        foreignKeys = {@ForeignKey(entity=PlayerCharacterEntity.class,
                                   parentColumns = "playerCharacterID",
                                   childColumns = "playerCharacterID" ,
                                   onDelete=CASCADE),
                       @ForeignKey(entity=SkillEntity.class,
                                   parentColumns = "skillID",
                                   childColumns = "skillID",
                                   onDelete = CASCADE)},
        indices = {@Index("playerCharacterID"),
                   @Index("skillID")})
@TypeConverters(UUIDConverter.class)
public class PlayerSkillsEntity
{
    @NonNull
    @ColumnInfo(name="playerCharacterID")
    private UUID playerID;
    @NonNull
    @ColumnInfo(name="skillID")
    private UUID skillID;
    @ColumnInfo(name="level_up_points_invested")
    private int levelUpPointsInvested;
    @ColumnInfo(name="favored_class_points_invested")
    private int favoredClassPointsInvested;

    //region Getters and Setters
    public UUID getPlayerID()
    {
        return playerID;
    }

    public void setPlayerID(UUID playerID)
    {
        this.playerID = playerID;
    }

    public UUID getSkillID()
    {
        return skillID;
    }

    public void setSkillID(UUID skillID)
    {
        this.skillID = skillID;
    }

    public int getLevelUpPointsInvested()
    {
        return levelUpPointsInvested;
    }

    public void setLevelUpPointsInvested(int levelUpPointsInvested)
    {
        this.levelUpPointsInvested = levelUpPointsInvested;
    }

    public int getFavoredClassPointsInvested()
    {
        return favoredClassPointsInvested;
    }

    public void setFavoredClassPointsInvested(int favoredClassPointsInvested)
    {
        this.favoredClassPointsInvested = favoredClassPointsInvested;
    }
    //endregion

    public PlayerSkillsEntity()
    {
        //Default Constructor
    }
}
