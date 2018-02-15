package com.pathfinderstattracker.pathfindercharactersheet.viewmodels;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.adapters.AbilityScoreAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.adapters.ArmorAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.adapters.CombatManueverAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.adapters.HP_BAB_SR_Adapter;
import com.pathfinderstattracker.pathfindercharactersheet.adapters.InitiativeAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.adapters.MovementAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.adapters.SavesAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.ArmorItem;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.CombatManeuver;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.HitPoints;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IArmorItem;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IHitPoints;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.PlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.ArmorTypesEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.races.Movement;
import com.pathfinderstattracker.pathfindercharactersheet.models.races.MovementManeuverabilityEnum;

public class StatsScreen extends Activity
{


    //region Test Ability Scores
    private AbilityScore strength = new AbilityScore(AbilityScoreEnum.STR, 10);
    private AbilityScore dexterity = new AbilityScore(AbilityScoreEnum.DEX, 11);
    private AbilityScore constiution = new AbilityScore(AbilityScoreEnum.CON, 12);
    private AbilityScore intelligence = new AbilityScore(AbilityScoreEnum.INT, 13);
    private AbilityScore wisdom = new AbilityScore(AbilityScoreEnum.WIS, 14);
    private AbilityScore charisma = new AbilityScore(AbilityScoreEnum.CHA, 15);
    private AbilityScore[] tempStats = new AbilityScore[] {strength, dexterity, constiution, intelligence, wisdom, charisma};
    //endregion

    //region Test Movements
    private Movement base = new Movement("Base", 30, MovementManeuverabilityEnum.Perfect);
    private Movement armor = new Movement("Armor", 20, MovementManeuverabilityEnum.Perfect);
    private Movement fly = new Movement("Fly", 30, MovementManeuverabilityEnum.Perfect);
    private Movement swim = new Movement("Swim", 30, MovementManeuverabilityEnum.Perfect);
    private Movement climb = new Movement("Climb", 30, MovementManeuverabilityEnum.Perfect);
    private Movement burrow = new Movement("Burrow", 30, MovementManeuverabilityEnum.Perfect);
    private Movement[] tempMovement = new Movement[]{base,armor,fly,swim,climb,burrow};
    //endregion

    //region Test Character
    private PlayerCharacter tempCharacter = new PlayerCharacter();
    //endregion

    //region Test Armor Items
    private ArmorItem armorBonus = new ArmorItem("armorBonus",ArmorTypesEnum.Armor,5);
    private ArmorItem naturalArmorBonus = new ArmorItem("naturalArmorBonus", ArmorTypesEnum.NaturalArmor,5);
    private ArmorItem shieldArmorBonus = new ArmorItem("shieldArmorBonus", ArmorTypesEnum.Shield,5);
    private ArmorItem dodgeArmorBonus = new ArmorItem("dodgeArmorBonus", ArmorTypesEnum.Dodge, 5);
    private ArmorItem[] tempArmorItems = new ArmorItem[]{armorBonus, naturalArmorBonus, shieldArmorBonus, dodgeArmorBonus};
    //endregion

    //region Temp Hit Points
    private IHitPoints tempHitPoints = new HitPoints(0,30);
    //endregion


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_screen);

        //region Populate Test Character Data
        tempCharacter.setInitiative(3); //TODO: Replace test data
        tempCharacter.setCombatManeuverStats(new CombatManeuver(3,16));
        tempCharacter.setAbilityScores(tempStats);
        tempCharacter.setFortitudeSave(4);
        tempCharacter.setReflexSave(5);
        tempCharacter.setWillSave(6);
        tempCharacter.setTotalAC(35);
        tempCharacter.setEquippedArmor(tempArmorItems);
        tempCharacter.setHitPoints(tempHitPoints);
        tempCharacter.setTotalBaseAttackBonus(5);
        tempCharacter.setSpellResistance(5);
        //endregion

        //Populate and bind our stats list
        ListView statsView = findViewById(R.id.statsList);
        AbilityScoreAdapter abilityScoreAdapter = new AbilityScoreAdapter(this,tempCharacter.getAbilityScores());
        statsView.setAdapter(abilityScoreAdapter);

        //Populate and bind our movement list
        ListView movementView = findViewById(R.id.movementList);
        MovementAdapter movementAdapter = new MovementAdapter(this, tempMovement);
        movementView.setAdapter(movementAdapter);

        //Populate and bind our initiative section
        ListView initiativeView = findViewById(R.id.initiativeList);
        InitiativeAdapter initiativeAdapter = new InitiativeAdapter(this, tempCharacter.getInitiative());
        initiativeView.setAdapter(initiativeAdapter);

        //Populate and bind our combat manuever list
        ListView combatManueverView = findViewById(R.id.combatManueverList);
        CombatManueverAdapter combatManueverAdapter = new CombatManueverAdapter(this, tempCharacter.getCombatManeuverStats());
        combatManueverView.setAdapter(combatManueverAdapter);

        //Populate and bind our saves list
        ListView savesView = findViewById(R.id.savesList);
        SavesAdapter savesAdapter = new SavesAdapter(this, tempCharacter.getFortitudeSave(), tempCharacter.getReflexSave(), tempCharacter.getWillSave());
        savesView.setAdapter(savesAdapter);

        //Populate and bind our AC list
        ListView armorView = findViewById(R.id.armorList);
        ArmorAdapter armorAdapter = new ArmorAdapter(this, tempCharacter.getTotalAC(), tempCharacter.CalculateTouchAC(), tempCharacter.CalculateFlatFootedAC());
        armorView.setAdapter(armorAdapter);

        //Populate and bind our HP, BAB, SR section
        ListView hp_BAB_SRView = findViewById(R.id.hp_bab_srList);
        HP_BAB_SR_Adapter hp_bab_sr_adapter = new HP_BAB_SR_Adapter(this, tempCharacter.getHitPoints(), tempCharacter.getTotalBaseAttackBonus(), tempCharacter.getSpellResistance());
        hp_BAB_SRView.setAdapter(hp_bab_sr_adapter);
    }
}
