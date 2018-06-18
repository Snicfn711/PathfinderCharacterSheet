package com.pathfinderstattracker.pathfindercharactersheet.tools;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.pathfinderstattracker.pathfindercharactersheet.database.PathfinderDatabase;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.SkillEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.WeaponEnchantmentEntity;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.Damage;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IWeaponEnchantment;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.WeaponEnchantment;

import java.util.UUID;

/**
 * Created by Stephen Hagen on 5/4/2018.
 */

public class DatabaseInitializer
{
    public static void populateAsync(@NonNull final PathfinderDatabase db)
    {
        populateDbAsync task = new populateDbAsync(db);
        task.execute();
    }

    private static class populateDbAsync extends AsyncTask<Void,Void,Void>
    {
        private final PathfinderDatabase mDb;

        populateDbAsync(PathfinderDatabase db)
        {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params)
        {
            populateWithSkills(mDb);
            return null;
        }
    }

    private static void populateWithSkills(PathfinderDatabase db)
    {
        //region Initialize Skills
        SkillEntity acrobatics = new SkillEntity();
        acrobatics.setSkillID(UUID.randomUUID());
        acrobatics.setSkillName("Acrobatics");
        acrobatics.setArmorCheckPenaltyApplied(true);
        acrobatics.setAddedStat(AbilityScoreEnum.DEX);

        SkillEntity appraise = new SkillEntity();
        appraise.setSkillID(UUID.randomUUID());
        appraise.setSkillName("Appraise");
        appraise.setArmorCheckPenaltyApplied(false);
        appraise.setAddedStat(AbilityScoreEnum.INT);

        SkillEntity bluff  = new SkillEntity();
        bluff.setSkillID(UUID.randomUUID());
        bluff.setSkillName("Bluff");
        bluff.setArmorCheckPenaltyApplied(false);
        bluff.setAddedStat(AbilityScoreEnum.CHA);

        SkillEntity climb = new SkillEntity();
        climb.setSkillID(UUID.randomUUID());
        climb.setSkillName("Climb");
        climb.setArmorCheckPenaltyApplied(true);
        climb.setAddedStat(AbilityScoreEnum.STR);

        SkillEntity craft = new SkillEntity();
        craft.setSkillID(UUID.randomUUID());
        craft.setSkillName("Craft");
        craft.setArmorCheckPenaltyApplied(false);
        craft.setAddedStat(AbilityScoreEnum.INT);

        SkillEntity diplomacy = new SkillEntity();
        diplomacy.setSkillID(UUID.randomUUID());
        diplomacy.setSkillName("Diplomacy");
        diplomacy.setArmorCheckPenaltyApplied(false);
        diplomacy.setAddedStat(AbilityScoreEnum.CHA);

        SkillEntity disableDevice = new SkillEntity();
        disableDevice.setSkillID(UUID.randomUUID());
        disableDevice.setSkillName("Disable Device");
        disableDevice.setArmorCheckPenaltyApplied(true);
        disableDevice.setAddedStat(AbilityScoreEnum.DEX);

        SkillEntity disguise = new SkillEntity();
        disguise.setSkillID(UUID.randomUUID());
        disguise.setSkillName("Disguise");
        disguise.setArmorCheckPenaltyApplied(false);
        disguise.setAddedStat(AbilityScoreEnum.CHA);

        SkillEntity escapeArtist = new SkillEntity();
        escapeArtist.setSkillID(UUID.randomUUID());
        escapeArtist.setSkillName("Escape Artist");
        escapeArtist.setArmorCheckPenaltyApplied(true);
        escapeArtist.setAddedStat(AbilityScoreEnum.DEX);

        SkillEntity fly = new SkillEntity();
        fly.setSkillID(UUID.randomUUID());
        fly.setSkillName("Fly");
        fly.setArmorCheckPenaltyApplied(true);
        fly.setAddedStat(AbilityScoreEnum.DEX);

        SkillEntity handleAnimal = new SkillEntity();
        handleAnimal.setSkillID(UUID.randomUUID());
        handleAnimal.setSkillName("Handle Animal");
        handleAnimal.setArmorCheckPenaltyApplied(false);
        handleAnimal.setAddedStat(AbilityScoreEnum.CHA);

        SkillEntity heal = new SkillEntity();
        heal.setSkillID(UUID.randomUUID());
        heal.setSkillName("Heal");
        heal.setArmorCheckPenaltyApplied(false);
        heal.setAddedStat(AbilityScoreEnum.WIS);

        SkillEntity intimidate = new SkillEntity();
        intimidate.setSkillID(UUID.randomUUID());
        intimidate.setSkillName("Intimidate");
        intimidate.setArmorCheckPenaltyApplied(false);
        intimidate.setAddedStat(AbilityScoreEnum.CHA);

        SkillEntity knowledge = new SkillEntity();
        knowledge.setSkillID(UUID.randomUUID());
        knowledge.setSkillName("Knowledge");
        knowledge.setArmorCheckPenaltyApplied(false);
        knowledge.setAddedStat(AbilityScoreEnum.INT);

        SkillEntity linguistics = new SkillEntity();
        linguistics.setSkillID(UUID.randomUUID());
        linguistics.setSkillName("Linguistics");
        linguistics.setArmorCheckPenaltyApplied(false);
        linguistics.setAddedStat(AbilityScoreEnum.INT);

        SkillEntity perception = new SkillEntity();
        perception.setSkillID(UUID.randomUUID());
        perception.setSkillName("Perception");
        perception.setArmorCheckPenaltyApplied(false);
        perception.setAddedStat(AbilityScoreEnum.WIS);

        SkillEntity perform = new SkillEntity();
        perform.setSkillID(UUID.randomUUID());
        perform.setSkillName("Perform");
        perform.setArmorCheckPenaltyApplied(false);
        perform.setAddedStat(AbilityScoreEnum.CHA);

        SkillEntity profession = new SkillEntity();
        profession.setSkillID(UUID.randomUUID());
        profession.setSkillName("Profession");
        profession.setArmorCheckPenaltyApplied(false);
        profession.setAddedStat(AbilityScoreEnum.WIS);

        SkillEntity ride = new SkillEntity();
        ride.setSkillID(UUID.randomUUID());
        ride.setSkillName("Ride");
        ride.setArmorCheckPenaltyApplied(true);
        ride.setAddedStat(AbilityScoreEnum.DEX);

        SkillEntity senseMotive = new SkillEntity();
        senseMotive.setSkillID(UUID.randomUUID());
        senseMotive.setSkillName("Sense Motive");
        senseMotive.setArmorCheckPenaltyApplied(false);
        senseMotive.setAddedStat(AbilityScoreEnum.WIS);

        SkillEntity sleightOfHand = new SkillEntity();
        sleightOfHand.setSkillID(UUID.randomUUID());
        sleightOfHand.setSkillName("Sleight Of Hand");
        sleightOfHand.setArmorCheckPenaltyApplied(true);
        sleightOfHand.setAddedStat(AbilityScoreEnum.DEX);

        SkillEntity spellcraft = new SkillEntity();
        spellcraft.setSkillID(UUID.randomUUID());
        spellcraft.setSkillName("Spellcraft");
        spellcraft.setArmorCheckPenaltyApplied(false);
        spellcraft.setAddedStat(AbilityScoreEnum.INT);

        SkillEntity stealth = new SkillEntity();
        stealth.setSkillID(UUID.randomUUID());
        stealth.setSkillName("Stealth");
        stealth.setArmorCheckPenaltyApplied(true);
        stealth.setAddedStat(AbilityScoreEnum.DEX);

        SkillEntity survival = new SkillEntity();
        survival.setSkillID(UUID.randomUUID());
        survival.setSkillName("Survival");
        survival.setArmorCheckPenaltyApplied(false);
        survival.setAddedStat(AbilityScoreEnum.WIS);

        SkillEntity swim = new SkillEntity();
        swim.setSkillID(UUID.randomUUID());
        swim.setSkillName("Swim");
        swim.setArmorCheckPenaltyApplied(true);
        swim.setAddedStat(AbilityScoreEnum.STR);

        SkillEntity useMagicDevice = new SkillEntity();
        useMagicDevice.setSkillID(UUID.randomUUID());
        useMagicDevice.setSkillName("Use Magice Device");
        useMagicDevice.setArmorCheckPenaltyApplied(false);
        useMagicDevice.setAddedStat(AbilityScoreEnum.CHA);
        //endregion

        //region Insert Skills
        db.SkillsDao().insertSkill(acrobatics);
        db.SkillsDao().insertSkill(appraise);
        db.SkillsDao().insertSkill(bluff);
        db.SkillsDao().insertSkill(climb);
        db.SkillsDao().insertSkill(craft);
        db.SkillsDao().insertSkill(diplomacy);
        db.SkillsDao().insertSkill(disableDevice);
        db.SkillsDao().insertSkill(disguise);
        db.SkillsDao().insertSkill(escapeArtist);
        db.SkillsDao().insertSkill(fly);
        db.SkillsDao().insertSkill(handleAnimal);
        db.SkillsDao().insertSkill(heal);
        db.SkillsDao().insertSkill(intimidate);
        db.SkillsDao().insertSkill(knowledge);
        db.SkillsDao().insertSkill(linguistics);
        db.SkillsDao().insertSkill(perception);
        db.SkillsDao().insertSkill(perform);
        db.SkillsDao().insertSkill(profession);
        db.SkillsDao().insertSkill(ride);
        db.SkillsDao().insertSkill(senseMotive);
        db.SkillsDao().insertSkill(sleightOfHand);
        db.SkillsDao().insertSkill(spellcraft);
        db.SkillsDao().insertSkill(stealth);
        db.SkillsDao().insertSkill(survival);
        db.SkillsDao().insertSkill(swim);
        db.SkillsDao().insertSkill(useMagicDevice);
        //endregion
    }
}
