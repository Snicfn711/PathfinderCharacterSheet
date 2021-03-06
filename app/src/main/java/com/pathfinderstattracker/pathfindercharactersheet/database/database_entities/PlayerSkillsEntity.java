package com.pathfinderstattracker.pathfindercharactersheet.database.database_entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.AbilityScoreEnumConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.UUIDConverter;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "player_skills",
        primaryKeys = {"playerCharacterID", "skill_name"},
        foreignKeys = {@ForeignKey(entity=PlayerCharacterEntity.class,
                                   parentColumns = "playerCharacterID",
                                   childColumns = "playerCharacterID" ,
                                   onDelete=CASCADE)},
        indices = {@Index("playerCharacterID"),
                   @Index("skill_name")})
@TypeConverters({UUIDConverter.class,
                 AbilityScoreEnumConverter.class})
public class PlayerSkillsEntity implements Serializable, Comparable<PlayerSkillsEntity>
{
    @NonNull
    @ColumnInfo(name="playerCharacterID")
    private UUID playerID = new UUID(0,0);
    @NonNull
    @ColumnInfo(name="skillID")
    private UUID skillID = new UUID(0,0);
    @ColumnInfo(name = "added_stat")
    private AbilityScoreEnum AddedStat;
    @ColumnInfo(name = "armor_check_penalty_applied")
    private boolean ArmorCheckPenaltyApplied;
    @NonNull
    @ColumnInfo(name = "skill_name")
    private String SkillName = "";
    @ColumnInfo(name="level_up_points_invested")
    private int levelUpPointsInvested;
    @ColumnInfo(name="favored_class_points_invested")
    private int favoredClassPointsInvested;

    //region Getters and Setters
    @NonNull
    public UUID getPlayerID()
    {
        return playerID;
    }

    public void setPlayerID(@NonNull UUID playerID)
    {
        this.playerID = playerID;
    }

    @NonNull
    public UUID getSkillID()
    {
        return skillID;
    }

    public void setSkillID(@NonNull UUID skillID)
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

    public AbilityScoreEnum getAddedStat()
    {
        return AddedStat;
    }

    public void setAddedStat(AbilityScoreEnum addedStat)
    {
        AddedStat = addedStat;
    }

    public boolean isArmorCheckPenaltyApplied()
    {
        return ArmorCheckPenaltyApplied;
    }

    public void setArmorCheckPenaltyApplied(boolean armorCheckPenaltyApplied)
    {
        ArmorCheckPenaltyApplied = armorCheckPenaltyApplied;
    }

    @NonNull
    public String getSkillName()
    {
        return SkillName;
    }

    public void setSkillName(@NonNull String skillName)
    {
        SkillName = skillName;
    }

    //endregion

    public PlayerSkillsEntity()
    {
        //Default Constructor
    }

    @Override
    public int compareTo(@NonNull PlayerSkillsEntity o)
    {
        PlayerSkillsEntity temp = o;
        return this.SkillName.compareTo(temp.getSkillName());
    }

    public static Comparator<PlayerSkillsEntity> compareByTotalRanks = new Comparator<PlayerSkillsEntity>()
    {
        public int compare(PlayerSkillsEntity s1, PlayerSkillsEntity s2)
        {
            Integer p1 = s1.getTotalInvestedPoints();
            Integer p2 = s2.getTotalInvestedPoints();
            return p2.compareTo(p1);
        }
    };

    public static boolean checkIfSortedByTotalRanks(List<PlayerSkillsEntity> listToCheck)
    {
        for(int i = 0; i < listToCheck.size() - 1; i++)
        {
            if(listToCheck.get(i).getTotalInvestedPoints() < listToCheck.get(i + 1).getTotalInvestedPoints())
            {
                return false;
            }
        }
        return true;
    }

    public int getTotalInvestedPoints()
    {
        return levelUpPointsInvested + favoredClassPointsInvested;
    }
}
