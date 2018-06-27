package com.pathfinderstattracker.pathfindercharactersheet.models;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */

public class Skill implements ISkill, Comparable<ISkill>, Serializable
{
    private UUID SkillID;
    private AbilityScoreEnum AddedStat;
    private boolean ArmorCheckPenaltyApplied;
    private String SkillName;

    //region Getters and Setters
    public UUID getSkillID(){return SkillID;}
    public void setSkillID(UUID skillID){SkillID = skillID;}
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

    @Override
    public void setSkillName(String skillName)
    {
        SkillName = skillName;
    }

    @Override
    public String getSkillName()
    {
        return SkillName;
    }
    //endregion

    public Skill()
    {
        //Default constructor
    }

    public Skill(String skillName, AbilityScoreEnum addedStat, boolean armorCheckPenaltyApplied)
    {
        setAddedStat(addedStat);
        setArmorCheckPenaltyApplied(armorCheckPenaltyApplied);
        setSkillName(skillName);
    }

    @Override
    public int compareTo(@NonNull ISkill o)
    {
        Skill temp = (Skill)o;
        return this.SkillName.compareTo(temp.getSkillName());
    }
//TODO:We're moving proficiency to the classes and points invested to...somewhere else. So we'll have to reexamine  how sorting works.
//    public static Comparator<ISkill> compareByIsClassSkill = new Comparator<ISkill>()
//    {
//        public int compare(ISkill s1, ISkill s2)
//        {
//            int b1 = s1.isProficiency() ? 1 : 0;
//            int b2 = s2.isProficiency() ? 1 : 0;
//            return b2 - b1;
//        }
//    };
//
//    public static Comparator<ISkill> compareByTotalRanks = new Comparator<ISkill>()
//    {
//        public int compare(ISkill s1, ISkill s2)
//        {
//            Integer p1 = s1.getPointsInvested();
//            Integer p2 = s2.getPointsInvested();
//            return p2.compareTo(p1);
//        }
//    };
//
//    public static boolean checkIfSortedByProficiency(List<ISkill> listToCheck)
//    {
//        for(int i = 0; i < listToCheck.size() - 1; i++)
//        {
//            if(!listToCheck.get(i).isProficiency() && listToCheck.get(i + 1).isProficiency())
//            {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static boolean checkIfSortedByTotalRanks(List<ISkill> listToCheck)
//    {
//        for(int i = 0; i < listToCheck.size() - 1; i++)
//        {
//            if(listToCheck.get(i).getPointsInvested() < listToCheck.get(i + 1).getPointsInvested())
//            {
//                return false;
//            }
//        }
//        return true;
//    }
}
