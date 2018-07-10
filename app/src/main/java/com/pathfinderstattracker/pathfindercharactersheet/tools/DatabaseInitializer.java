package com.pathfinderstattracker.pathfindercharactersheet.tools;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.pathfinderstattracker.pathfindercharactersheet.database.PathfinderDatabase;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.ArmorEntity;
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
            populateWithArmor(mDb);
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

    private static void populateWithArmor(PathfinderDatabase db)
    {
        //region Initialize Skills
        ArmorEntity haramaki = new ArmorEntity(UUID.randomUUID());
        haramaki.setCost(3);
        haramaki.setWeight(1);
        haramaki.setName("Haramaki");
        haramaki.setDescription("Also called a belly-warmer, a haramaki is a simple silken sash lined with chainmail or articulated metal plates and tied about the stomach to protect it");
        haramaki.setAcBonus(1);

        ArmorEntity padded = new ArmorEntity(UUID.randomUUID());
        padded.setCost(5);
        padded.setWeight(10);
        padded.setName("Padded");
        padded.setDescription("More than simple clothing, padded armor combines heavy, quilted cloth and layers of densely packed stuffing to create a cheap and basic protection. It is typically worn by those not intending to face lethal combat or those who wish their maneuverability to be impacted as little as possible");
        padded.setAcBonus(1);
        padded.setMaximumDexBonus(8);
        padded.setArcaneSpellFailureChance(5);

        ArmorEntity quiltedCloth = new ArmorEntity(UUID.randomUUID());
        quiltedCloth.setCost(100);
        quiltedCloth.setWeight(15);
        quiltedCloth.setName("Quilted Cloth");
        quiltedCloth.setDescription("This enhanced form of padded armor has internal layers specifically designed to trap arrows, bolts, darts, shuriken, thrown daggers, and other small ranged piercing weapons. When these kinds of weapons strike you, they tend to become snagged in these layers and fail to harm you. Wearing quilted cloth armor gives you DR 3/— against attacks of this kind. The special layers of the armor have no effect on other kinds of weapons.");
        quiltedCloth.setAcBonus(1);
        quiltedCloth.setMaximumDexBonus(8);
        quiltedCloth.setArcaneSpellFailureChance(10);

        ArmorEntity reinforcedTunic = new ArmorEntity(UUID.randomUUID());
        reinforcedTunic.setCost(1);
        reinforcedTunic.setWeight(5);
        reinforcedTunic.setName("Reinforced Tunic");
        reinforcedTunic.setDescription("Sometimes called a leine, this belted tunic has thick cords woven through it that cover vital areas. A reinforced tunic’s armor bonus is increased by 2 against attack rolls made to confirm critical hits against the wearer.");
        reinforcedTunic.setMaximumDexBonus(5);
        reinforcedTunic.setArcaneSpellFailureChance(5);

        ArmorEntity silkenCeremonialArmor = new ArmorEntity(UUID.randomUUID());
        silkenCeremonialArmor.setCost(30);
        silkenCeremonialArmor.setWeight(4);
        silkenCeremonialArmor.setName("Silken Ceremonial Armor");
        silkenCeremonialArmor.setDescription("Used for ceremonial displays or occasionally worn (albeit with no additional benefit) over heavier armor, these robes consist of several layers of cloth and an outer layer of silk intricately woven with gold brocade designs and covered with metal studs.");
        silkenCeremonialArmor.setAcBonus(1);

        ArmorEntity lamellarCuirass = new ArmorEntity(UUID.randomUUID());
        lamellarCuirass.setCost(15);
        lamellarCuirass.setWeight(8);
        lamellarCuirass.setName("Lamellar Cuirass");
        lamellarCuirass.setDescription("Lamellar is a type of armor in which small plates of various types of materials are strung together in parallel rows using fine cord. Lamellar plates can be constructed from lacquered leather, horn, or even stone, though suits of iron and steel are the most common. Lamellar armor can be crafted into various shapes, including partial pieces such as breastplates, greaves, or even entire coats. The properties of specific suits and pieces of lamellar armor are determined by their material. This armor consists of a light breastplate and shoulder guards made from lacquered leather plates bound together and fitted over a silk shirt.");
        lamellarCuirass.setAcBonus(2);
        lamellarCuirass.setMaximumDexBonus(4);
        lamellarCuirass.setArcaneSpellFailureChance(5);

        ArmorEntity leather = new ArmorEntity(UUID.randomUUID());
        leather.setCost(10);
        leather.setWeight(15);
        leather.setName("Leather");
        leather.setDescription("Leather armor is made up of multiple overlapping pieces of leather, boiled to increase their natural toughness and then deliberately stitched together. Although not as sturdy as metal armor, the flexibility it allows wearers makes it among the most widely used types of armor.");
        leather.setAcBonus(2);
        leather.setMaximumDexBonus(6);
        leather.setArcaneSpellFailureChance(10);

        ArmorEntity rosewoodArmor = new ArmorEntity(UUID.randomUUID());
        rosewoodArmor.setCost(50);
        rosewoodArmor.setWeight(15);
        rosewoodArmor.setName("Rosewood Armor");
        rosewoodArmor.setDescription("This suit of leather armor is wrapped in special rose vines. Treat this as leather armor with armor spikes. The vines must be watered with at least 1 gallon of water each day or they wither and die, turning the armor into normal leather armor.");
        rosewoodArmor.setAcBonus(2);
        rosewoodArmor.setMaximumDexBonus(6);
        rosewoodArmor.setArcaneSpellFailureChance(10);

        ArmorEntity hellKnightLeather = new ArmorEntity(UUID.randomUUID());
        hellKnightLeather.setCost(30);
        hellKnightLeather.setWeight(25);
        hellKnightLeather.setName("Hell Knight Leather");
        hellKnightLeather.setDescription("There are instances where wearing full plate armor can jeopardize a Hell Knight’s life. Primarily worn by Hell Knight sailors, this studded leather armor includes heavy gloves and a helm of sculpted leather designed to look like a skull-either a human’s or that of some aquatic creature. Hell Knight leather’s statistics are identical to those of studded leather, except it costs 5 gp more and weighs 5 pounds more.");
        hellKnightLeather.setAcBonus(3);
        hellKnightLeather.setMaximumDexBonus(5);
        hellKnightLeather.setArmorCheckPenalty(1);
        hellKnightLeather.setArcaneSpellFailureChance(15);

        ArmorEntity hideShirt = new ArmorEntity(UUID.randomUUID());
        hideShirt.setCost(20);
        hideShirt.setWeight(18);
        hideShirt.setName("Hide Shirt");
        hideShirt.setDescription("Made from animal hide and giant lizard scales over a shirt of interwoven cords, these chest and shoulder coverings protect without restricting mobility. The wearer of a hide shirt can make a DC 15 Strength check as a standard action. If he succeeds, the armor gains the broken condition and drops to the ground rather than requiring the usual 1 minute it would take to remove it. The armor must be repaired as though it had taken 8 points of damage before it can be used again; a broken hide shirt grants no bonus to Armor Class.");
        hideShirt.setAcBonus(3);
        hideShirt.setMaximumDexBonus(4);
        hideShirt.setArmorCheckPenalty(1);
        hideShirt.setArcaneSpellFailureChance(15);

        ArmorEntity leafArmor = new ArmorEntity(UUID.randomUUID());
        leafArmor.setCost(500);
        leafArmor.setWeight(20);
        leafArmor.setName("Leaf Armor");
        leafArmor.setDescription("Using alchemical compounds, elves or druidic orders treat special leaves for use in crafting armor. These leaves are stitched together in an overlapping pattern to create a leathery armor as strong and deflective as metal counterparts. Leaf armor jerkins, bracers, and leggings have been made through this process.");
        leafArmor.setAcBonus(3);
        leafArmor.setMaximumDexBonus(5);
        leafArmor.setArcaneSpellFailureChance(15);

        ArmorEntity paradeArmor = new ArmorEntity(UUID.randomUUID());
        paradeArmor.setCost(25);
        paradeArmor.setWeight(20);
        paradeArmor.setName("Parade Armor");
        paradeArmor.setDescription("Most wealthy countries with standing armies have a different uniform for use in showy noncombat situations such as parades, coronation ceremonies, and so on. The appearance of this armor varies by the country of origin and the branch of the military, but still provides some protection in case the soldier needs to fight while in parade dress. For example, one country’s parade armor may be a chain shirt, tabard, leather greaves, and a winged helm. If you’re wearing a country’s parade armor, you gain a +2 circumstance bonus on Diplomacy and Intimidate checks to influence a person from that country. Depending on the country, parade armor may be crafted from leather, metal, or a mixture of both.");
        paradeArmor.setAcBonus(3);
        paradeArmor.setMaximumDexBonus(5);
        paradeArmor.setArmorCheckPenalty(1);
        paradeArmor.setArcaneSpellFailureChance(15);

        ArmorEntity spiderSilkBodysuit = new ArmorEntity(UUID.randomUUID());
        spiderSilkBodysuit.setCost(850);
        spiderSilkBodysuit.setWeight(4);
        spiderSilkBodysuit.setName("Spider-Silk Bodysuit");
        spiderSilkBodysuit.setDescription("This exotic form-fitting garment is woven entirely from alchemically treated silk harvested from giant spiders or other arachnid creatures. If you have the drow’s weapon familiarity racial trait, you treat the spider-silk bodysuit’s maximum Dexterity bonus as 2 higher.");
        spiderSilkBodysuit.setAcBonus(3);
        spiderSilkBodysuit.setMaximumDexBonus(6);
        spiderSilkBodysuit.setArmorCheckPenalty(1);
        spiderSilkBodysuit.setArcaneSpellFailureChance(10);

        ArmorEntity studdedLeather = new ArmorEntity(UUID.randomUUID());
        studdedLeather.setCost(25);
        studdedLeather.setWeight(20);
        studdedLeather.setName("Studded Leather");
        studdedLeather.setDescription("An improved form of leather armor, studded leather armor is covered with dozens of metal protuberances. While these rounded studs offer little defense individually, in the numbers they are arrayed in upon such armor, they help catch lethal edges and channel them away from vital spots. The rigidity caused by the additional metal does, however, result in less mobility than is afforded by a suit of normal leather armor.");
        studdedLeather.setAcBonus(3);
        studdedLeather.setMaximumDexBonus(5);
        studdedLeather.setArmorCheckPenalty(1);
        studdedLeather.setArcaneSpellFailureChance(15);

        ArmorEntity wooden = new ArmorEntity(UUID.randomUUID());
        wooden.setCost(20);
        wooden.setWeight(25);
        wooden.setName("Wooden");
        wooden.setDescription("This suit of leather armor has plates of fire-treated wood sewn over vital areas. Though not as effective as metal armor, it offers better protection than leather alone. Unlike metal armor, the wood is slightly buoyant, and the armor check penalty for swimming in this armor is 0.");
        wooden.setAcBonus(3);
        wooden.setMaximumDexBonus(3);
        wooden.setArmorCheckPenalty(1);
        wooden.setArcaneSpellFailureChance(15);

        ArmorEntity chainShirt = new ArmorEntity(UUID.randomUUID());
        chainShirt.setCost(100);
        chainShirt.setWeight(25);
        chainShirt.setName("Chain Shirt");
        chainShirt.setDescription("Covering the torso, this shirt is made up of thousands of interlocking metal rings.");
        chainShirt.setAcBonus(4);
        chainShirt.setMaximumDexBonus(4);
        chainShirt.setArmorCheckPenalty(2);
        chainShirt.setArcaneSpellFailureChance(20);

        ArmorEntity lamellarLeather = new ArmorEntity(UUID.randomUUID());
        lamellarLeather.setCost(60);
        lamellarLeather.setWeight(25);
        lamellarLeather.setName("Leather Lamellar");
        lamellarLeather.setDescription("Lamellar is a type of armor in which small plates of various types of materials are strung together in parallel rows using fine cord. Lamellar plates can be constructed from lacquered leather, horn, or even stone, though suits of iron and steel are the most common. Lamellar armor can be crafted into various shapes, including partial pieces such as breastplates, greaves, or even entire coats. The properties of specific suits and pieces of lamellar armor are determined by their material.");
        lamellarLeather.setAcBonus(4);
        lamellarLeather.setMaximumDexBonus(3);
        lamellarLeather.setArmorCheckPenalty(2);
        lamellarLeather.setArcaneSpellFailureChance(20);
        //endregion
    }
}
