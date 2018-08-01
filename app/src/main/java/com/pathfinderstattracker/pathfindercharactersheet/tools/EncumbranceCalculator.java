package com.pathfinderstattracker.pathfindercharactersheet.tools;

import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.EncumbranceEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IPlayerCharacter;

import java.util.List;

public class EncumbranceCalculator
{
    public static EncumbranceEnum calculateEncumbrance(IPlayerCharacter characterToCheck, float currentWeightLoad)
    {
        List<IAbilityScore> characterAbilityScores = characterToCheck.getAbilityScores();
        int characterStrengthScore = 1;
        int heavyLoad;
        for(IAbilityScore score:characterAbilityScores)
        {
             if(score.getStat() == AbilityScoreEnum.STR)
             {
                 characterStrengthScore = score.getAmount();
             }
        }
        //Unfortunately carrying capacity doesn't have a formula that perfectly determines its value at all strength scores.
        //There are a few stretches where the number is easier to determine, however for most points determining the proper score requires copious use of magic numbers.
        //Since we're stuck with magic numbers anyways, we went with a switch-case to return the maximum carrying capacity.
        switch(characterStrengthScore)
        {
            case 1:
                heavyLoad = 10;
                break;
            case 2:
                heavyLoad = 20;
                break;
            case 3:
                heavyLoad = 30;
                break;
            case 4:
                heavyLoad = 40;
                break;
            case 5:
                heavyLoad = 50;
                break;
            case 6:
                heavyLoad = 60;
                break;
            case 7:
                heavyLoad = 70;
                break;
            case 8:
                heavyLoad = 80;
                break;
            case 9:
                heavyLoad = 90;
                break;
            case 10:
                heavyLoad = 100;
                break;
            case 11:
                heavyLoad = 115;
                break;
            case 12:
                heavyLoad = 130;
                break;
            case 13:
                heavyLoad = 150;
                break;
            case 14:
                heavyLoad = 175;
                break;
            case 15:
                heavyLoad = 200;
                break;
            case 16:
                heavyLoad = 230;
                break;
            case 17:
                heavyLoad = 260;
                break;
            case 18:
                heavyLoad = 300;
                break;
            case 19:
                heavyLoad = 350;
                break;
            case 20:
                heavyLoad = 400;
                break;
            case 21:
                heavyLoad = 460;
                break;
            case 22:
                heavyLoad = 520;
                break;
            case 23:
                heavyLoad = 600;
                break;
            case 24:
                heavyLoad = 700;
                break;
            case 25:
                heavyLoad = 800;
                break;
            case 26:
                heavyLoad = 920;
                break;
            case 27:
                heavyLoad = 1040;
                break;
            case 28:
                heavyLoad = 1200;
                break;
            case 29:
                heavyLoad = 1400;
                break;
            case 30:
                heavyLoad = 1600;
                break;
            case 31:
                heavyLoad = 1840;
                break;
            case 32:
                heavyLoad = 2080;
                break;
            case 33:
                heavyLoad = 2400;
                break;
            case 34:
                heavyLoad = 2800;
                break;
            case 35:
                heavyLoad = 3200;
                break;
            case 36:
                heavyLoad = 3680;
                break;
            case 37:
                heavyLoad = 4160;
                break;
            case 38:
                heavyLoad = 4800;
                break;
            case 39:
                heavyLoad = 5600;
                break;
            case 40:
                heavyLoad = 6400;
                break;
            case 41:
                heavyLoad = 7360;
                break;
            case 42:
                heavyLoad = 8320;
                break;
            case 43:
                heavyLoad = 9600;
                break;
            case 44:
                heavyLoad = 11200;
                break;
            case 45:
                heavyLoad = 12800;
                break;
            case 46:
                heavyLoad = 14720;
                break;
            case 47:
                heavyLoad = 16640;
                break;
            case 48:
                heavyLoad = 19200;
                break;
            case 49:
                heavyLoad = 22400;
                break;
            case 50:
                heavyLoad = 25600;
                break;
            default:
                throw new RuntimeException("EncumbranceCalculator was given an invalid strength score");
            //If the player has a strength score over 50, they've already broken the rules long ago and our tool won't be much use
            //(the max attainable score in a single stat without abusing the system in some way is ~32-38)
        }
        if(currentWeightLoad > (2*heavyLoad)/3)
        {
            return EncumbranceEnum.Heavy;
        }
        else if(currentWeightLoad > heavyLoad/3)
        {
            return EncumbranceEnum.Medium;
        }
        return EncumbranceEnum.Light;
    }
}
