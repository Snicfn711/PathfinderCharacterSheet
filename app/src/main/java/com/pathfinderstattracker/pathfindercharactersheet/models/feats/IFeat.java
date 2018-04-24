package com.pathfinderstattracker.pathfindercharactersheet.models.feats;

import com.pathfinderstattracker.pathfindercharactersheet.models.IAbility;
import com.pathfinderstattracker.pathfindercharactersheet.models.IBonus;
import com.pathfinderstattracker.pathfindercharactersheet.models.IPenalty;

import java.util.List;

/**
 * Created by Stephen Hagen on 1/5/2018.
 */

public interface IFeat
{
    List<IPrerequisite> getPrerequisites();
    void setPrerequisites(List<IPrerequisite> prerequisites);
    String getEffectText();
    void setEffectText(String effectText);
    List<IAbility> getAbilities();
    void setAbilities(List<IAbility> abilities);
    List<IBonus> getBonuses();
    void setBonuses(List<IBonus> bonuses);
    List<IPenalty> getPenalties();
    void setPenalties(List<IPenalty> penalties);
}
