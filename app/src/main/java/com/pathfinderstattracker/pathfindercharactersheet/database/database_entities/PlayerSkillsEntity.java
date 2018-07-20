package com.pathfinderstattracker.pathfindercharactersheet.database.database_entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.AbilityScoreConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.AbilityScoreEnumConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.UUIDConverter;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.ISkill;
import com.pathfinderstattracker.pathfindercharactersheet.models.Skill;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "player_skills",
        primaryKeys = {"playerCharacterID", "skillID"},
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
@TypeConverters({UUIDConverter.class,
                 AbilityScoreEnumConverter.class})
public class PlayerSkillsEntity implements Serializable, Comparable<PlayerSkillsEntity>
{
    @NonNull
    @ColumnInfo(name="playerCharacterID")
    private UUID playerID;
    @NonNull
    @ColumnInfo(name="skillID")
    private UUID skillID;
    @ColumnInfo(name = "added_stat")
    private AbilityScoreEnum AddedStat;
    @ColumnInfo(name = "armor_check_penalty_applied")
    private boolean ArmorCheckPenaltyApplied;
    @ColumnInfo(name = "skill_name")
    private String SkillName;
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

    public String getSkillName()
    {
        return SkillName;
    }

    public void setSkillName(String skillName)
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
        PlayerSkillsEntity temp = (PlayerSkillsEntity)o;
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
