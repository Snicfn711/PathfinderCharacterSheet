package com.pathfinderstattracker.pathfindercharactersheet.tools;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.pathfinderstattracker.pathfindercharactersheet.database.PathfinderDatabase;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.ArmorEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.SkillEntity;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.ArmorTypesEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.ArmorWeightCategoryEnum;

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
        useMagicDevice.setSkillName("Use Magic Device");
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
        //region Initialize Light Armor
        ArmorEntity armoredKilt = new ArmorEntity(UUID.randomUUID());
        armoredKilt.setCost(20);
        armoredKilt.setWeight(10);
        armoredKilt.setName("Armored Kilt");
        armoredKilt.setDescription("The armored kilt is made of a thick cloth skirt with bars of steel hanging down from the waist and a ring of horizontal steel plates just above the hem. An armored kilt can be worn separately as light armor, or it can be added to other suits of light or medium armor. Adding an armored kilt increases a suit of armor’s armor bonus by +1, but it adds 15 pounds to the armor, lowers the maximum Dex bonus by 1, and increases the armor’s weight category (from light to medium and from medium to heavy). Adding an armored kilt to heavy armor does not provide an armor bonus increase.");
        armoredKilt.setAcBonus(1);
        armoredKilt.setMaximumDexBonus(6);

        ArmorEntity dancingScarves = new ArmorEntity(UUID.randomUUID());
        dancingScarves.setCost(150);
        dancingScarves.setWeight(8);
        dancingScarves.setName("Dancing Scarves");
        dancingScarves.setDescription("As you move, they flutter and flow, obscuring your shape and protecting against enemy attacks. Dancing scarves provide no benefit while you are standing still. Whenever you move at least 10 feet during your turn, you gain a +2 armor bonus to AC until the beginning of your next turn. Dancing scarves add their enhancement bonus to this armor bonus instead of providing a constant benefit; other magical enhancements (such as light fortification) apply whether or not you are moving. In addition, dancing scarves provide a +2 circumstance bonus on Bluff checks made to feint in combat.");
        dancingScarves.setAcBonus(0);

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

        //region Initialize Medium Armors
        ArmorEntity armoredCoat = new ArmorEntity(UUID.randomUUID());
        armoredCoat.setCost(50);
        armoredCoat.setWeight(20);
        armoredCoat.setName("Armored Coat");
        armoredCoat.setDescription("This sturdy leather coat is reinforced with metal plates sewn into the lining. An armored coat is more cumbersome than light armor but less effective than most medium armors. The advantage of it is that a person can don it or remove it as a move action (there is no “don hastily” option for an armored coat). If worn over other armor, use the better AC bonus and worse value in all other categories; an armored coat has no effect if worn with heavy armor. The only magic effects that apply are those of armor, clothing, or items worn on top.");
        armoredCoat.setAcBonus(4);
        armoredCoat.setMaximumDexBonus(3);
        armoredCoat.setArmorCheckPenalty(2);
        armoredCoat.setArcaneSpellFailureChance(20);
        armoredCoat.setMaxSpeed(20);
        armoredCoat.setWeightCategory(ArmorWeightCategoryEnum.Medium);

        ArmorEntity chainCoat = new ArmorEntity(UUID.randomUUID());
        chainCoat.setCost(75);
        chainCoat.setWeight(40);
        chainCoat.setName("Chain Coat");
        chainCoat.setDescription("This relatively simple armor consists of heavy chains that wrap around your body and limbs. While it weighs more and provides less protection than other medium armors, it is also less of a hindrance. In addition, if you are wielding a spiked chain, you can affix it to one hand. This functions as a locked gauntlet, and if you are proficient with spiked chains, you can treat the spiked chain as a one-handed weapon while it is attached. You can affix a spiked chain to each hand this way, but you can’t wear locked gauntlets while wearing a chain coat, and you can’t attach any weapon to a chain coat except spiked chains.");
        chainCoat.setAcBonus(4);
        chainCoat.setMaximumDexBonus(5);
        chainCoat.setArmorCheckPenalty(2);
        chainCoat.setArcaneSpellFailureChance(30);
        chainCoat.setMaxSpeed(20);
        chainCoat.setWeightCategory(ArmorWeightCategoryEnum.Medium);

        ArmorEntity hide = new ArmorEntity(UUID.randomUUID());
        hide.setCost(15);
        hide.setWeight(25);
        hide.setName("Hide");
        hide.setDescription("Hide armor is made from the tanned skin of particularly thick-hided beasts, stitched with either multiple overlapping layers of crude leather or exterior pieces of leather stuffed with padding or fur. Damage to the armor is typically repaired by restitching gashes or adding new pieces of hide, giving the most heavily used suits a distinctively patchwork quality.");
        hide.setAcBonus(4);
        hide.setMaximumDexBonus(4);
        hide.setArmorCheckPenalty(3);
        hide.setArcaneSpellFailureChance(20);
        hide.setMaxSpeed(20);
        hide.setWeightCategory(ArmorWeightCategoryEnum.Medium);

        ArmorEntity iceCoat = new ArmorEntity(UUID.randomUUID());
        iceCoat.setCost(80);
        iceCoat.setWeight(24);
        iceCoat.setName("Ice Coat");
        iceCoat.setDescription("Used by natives to the arctic tundra, this heavy parka is treated as an armored coat. It provides the benefits of a cold-weather outfit, and it can be donned or removed as a move action. In addition, the fluffy white fur of the parka blends into arctic landscapes, providing a +2 circumstance bonus on Stealth checks in snowy environments.");
        iceCoat.setAcBonus(4);
        iceCoat.setMaximumDexBonus(3);
        iceCoat.setArmorCheckPenalty(2);
        iceCoat.setArcaneSpellFailureChance(20);
        iceCoat.setMaxSpeed(20);
        iceCoat.setWeightCategory(ArmorWeightCategoryEnum.Medium);

        ArmorEntity doMaru = new ArmorEntity(UUID.randomUUID());
        doMaru.setCost(200);
        doMaru.setWeight(30);
        doMaru.setName("Do-Maru");
        doMaru.setDescription("The lightest of armors typically favored by samurai, do-maru wraps around the wearer’s body like a short armored coat. It consists primarily of lamellar and lacks a solid breastplate or sleeves, leaving the shoulders and upper body somewhat exposed, but permitting the wearer greater flexibility than do the majority of heavier armors.");
        doMaru.setAcBonus(5);
        doMaru.setMaximumDexBonus(4);
        doMaru.setArmorCheckPenalty(4);
        doMaru.setArcaneSpellFailureChance(25);
        doMaru.setMaxSpeed(20);
        doMaru.setWeightCategory(ArmorWeightCategoryEnum.Medium);

        ArmorEntity kikko = new ArmorEntity(UUID.randomUUID());
        kikko.setCost(250);
        kikko.setWeight(25);
        kikko.setName("Kikko");
        kikko.setDescription("Kikko armor consists of a clever arrangement of hexagonal plates made from iron and sewn to cloth, granting the wearer greater flexibility than that provided by many armors that afford similar defense. The plates may be left exposed or hidden by a layer of cloth.");
        kikko.setAcBonus(5);
        kikko.setMaximumDexBonus(4);
        kikko.setArmorCheckPenalty(3);
        kikko.setArcaneSpellFailureChance(20);
        kikko.setMaxSpeed(20);
        kikko.setWeightCategory(ArmorWeightCategoryEnum.Medium);

        ArmorEntity hornLamellar = new ArmorEntity(UUID.randomUUID());
        hornLamellar.setCost(100);
        hornLamellar.setWeight(30);
        hornLamellar.setName("Horn Lamellar");
        hornLamellar.setDescription("Lamellar is a type of armor in which small plates of various types of materials are strung together in parallel rows using fine cord. Lamellar plates can be constructed from lacquered leather, horn, or even stone, though suits of iron and steel are the most common. Lamellar armor can be crafted into various shapes, including partial pieces such as breastplates, greaves, or even entire coats. The properties of specific suits and pieces of lamellar armor are determined by their material.");
        hornLamellar.setAcBonus(5);
        hornLamellar.setMaximumDexBonus(3);
        hornLamellar.setArmorCheckPenalty(4);
        hornLamellar.setArcaneSpellFailureChance(25);
        hornLamellar.setMaxSpeed(20);
        hornLamellar.setWeightCategory(ArmorWeightCategoryEnum.Medium);

        ArmorEntity scaleMail = new ArmorEntity(UUID.randomUUID());
        scaleMail.setCost(50);
        scaleMail.setWeight(30);
        scaleMail.setName("Scale Mail");
        scaleMail.setDescription("Scale mail is made up of dozens of small, overlapping metal plates. Similar to both splint mail and banded mail, scalemail has a flexible arrangement of scales in an attempt to avoid hindering the wearer’s mobility, but at the expense of omitting additional protective layers of armor. A suit of scale mail includes gauntlets.");
        scaleMail.setAcBonus(5);
        scaleMail.setMaximumDexBonus(3);
        scaleMail.setArmorCheckPenalty(4);
        scaleMail.setArcaneSpellFailureChance(25);
        scaleMail.setMaxSpeed(20);
        scaleMail.setWeightCategory(ArmorWeightCategoryEnum.Medium);

        ArmorEntity breastplate = new ArmorEntity(UUID.randomUUID());
        breastplate.setCost(200);
        breastplate.setWeight(30);
        breastplate.setName("Breastplate");
        breastplate.setDescription("A breastplate protects a wearer’s torso with a single piece of sculpted metal, similar to the core piece of a suit of full plate. Despite its sturdiness, its inflexibility and open back make it inferior to complete suits of metal armor, but still an improvement over most non-metal armors.");
        breastplate.setAcBonus(6);
        breastplate.setMaximumDexBonus(3);
        breastplate.setArmorCheckPenalty(4);
        breastplate.setArcaneSpellFailureChance(25);
        breastplate.setMaxSpeed(20);
        breastplate.setWeightCategory(ArmorWeightCategoryEnum.Medium);

        ArmorEntity agileBreastplate = new ArmorEntity(UUID.randomUUID());
        agileBreastplate.setCost(400);
        agileBreastplate.setWeight(25);
        agileBreastplate.setName("Agile Breastplate");
        agileBreastplate.setDescription("This breastplate is specially crafted in a manner that allows extra maneuverability for some physical activities. The armor check penalty for Climb checks and Acrobatics checks made to jump is only –1 (masterwork and mithral versions of this armor reduce this penalty as well as the normal penalty).");
        agileBreastplate.setAcBonus(6);
        agileBreastplate.setMaximumDexBonus(3);
        agileBreastplate.setArmorCheckPenalty(4);
        agileBreastplate.setArcaneSpellFailureChance(25);
        agileBreastplate.setMaxSpeed(20);
        agileBreastplate.setWeightCategory(ArmorWeightCategoryEnum.Medium);

        ArmorEntity chainmail = new ArmorEntity(UUID.randomUUID());
        chainmail.setCost(150);
        chainmail.setWeight(40);
        chainmail.setName("Chainmail");
        chainmail.setDescription("Unlike a chain shirt, which covers only the chest, chainmail protects the wearer with a complete mesh of chain links that cover the torso and arms, and extends below the waist. Multiple interconnected pieces offer additional protection over vital areas. The suit includes gauntlets.");
        chainmail.setAcBonus(6);
        chainmail.setMaximumDexBonus(2);
        chainmail.setArmorCheckPenalty(5);
        chainmail.setArcaneSpellFailureChance(30);
        chainmail.setMaxSpeed(20);
        chainmail.setWeightCategory(ArmorWeightCategoryEnum.Medium);

        ArmorEntity fourMirrorArmor = new ArmorEntity(UUID.randomUUID());
        fourMirrorArmor.setCost(125);
        fourMirrorArmor.setWeight(45);
        fourMirrorArmor.setName("Four-Mirror Armor");
        fourMirrorArmor.setDescription("This armor consists of four plates harnessed together with leather shoulder straps. Two round plates protect your front and back, while two smaller rectangular plates cover the sides of the torso. Four-mirror armor is worn over chainmail to provide added protection, and comes with a spiked helmet with a chainmail hood.");
        fourMirrorArmor.setAcBonus(6);
        fourMirrorArmor.setMaximumDexBonus(2);
        fourMirrorArmor.setArmorCheckPenalty(5);
        fourMirrorArmor.setArcaneSpellFailureChance(30);
        fourMirrorArmor.setMaxSpeed(20);
        fourMirrorArmor.setWeightCategory(ArmorWeightCategoryEnum.Medium);

        ArmorEntity steelLamellar = new ArmorEntity(UUID.randomUUID());
        steelLamellar.setCost(150);
        steelLamellar.setWeight(35);
        steelLamellar.setName("Steel Lamellar");
        steelLamellar.setDescription("Lamellar is a type of armor in which small plates of various types of materials are strung together in parallel rows using fine cord. Lamellar plates can be constructed from lacquered leather, horn, or even stone, though suits of iron and steel are the most common. Lamellar armor can be crafted into various shapes, including partial pieces such as breastplates, greaves, or even entire coats. The properties of specific suits and pieces of lamellar armor are determined by their material.");
        steelLamellar.setAcBonus(6);
        steelLamellar.setMaximumDexBonus(3);
        steelLamellar.setArmorCheckPenalty(5);
        steelLamellar.setArcaneSpellFailureChance(25);
        steelLamellar.setMaxSpeed(20);
        steelLamellar.setWeightCategory(ArmorWeightCategoryEnum.Medium);

        ArmorEntity mountainPattern = new ArmorEntity(UUID.randomUUID());
        mountainPattern.setCost(250);
        mountainPattern.setWeight(40);
        mountainPattern.setName("Mountain Pattern Armor");
        mountainPattern.setDescription("This medium armor consists of hundreds of small, interlocking pieces of steel shaped to resemble an ancient symbol for the word “mountain.” The mail is then riveted to a cloth or leather backing. It is worn like a mail coat and covers your torso, shoulders, and thighs.");
        mountainPattern.setAcBonus(6);
        mountainPattern.setMaximumDexBonus(3);
        mountainPattern.setArmorCheckPenalty(4);
        mountainPattern.setArcaneSpellFailureChance(30);
        mountainPattern.setMaxSpeed(20);
        mountainPattern.setWeightCategory(ArmorWeightCategoryEnum.Medium);
        //endregion

        //region Initialize Heavy Armors
        ArmorEntity bandedMail = new ArmorEntity(UUID.randomUUID());
        bandedMail.setCost(250);
        bandedMail.setWeight(35);
        bandedMail.setName("Banded Mail");
        bandedMail.setDescription("");
        bandedMail.setAcBonus(7);
        bandedMail.setMaximumDexBonus(1);
        bandedMail.setArmorCheckPenalty(6);
        bandedMail.setArcaneSpellFailureChance(35);
        bandedMail.setMaxSpeed(20);
        bandedMail.setWeightCategory(ArmorWeightCategoryEnum.Heavy);

        ArmorEntity fieldPlate = new ArmorEntity(UUID.randomUUID());
        fieldPlate.setCost(1200);
        fieldPlate.setWeight(50);
        fieldPlate.setName("Field Plate");
        fieldPlate.setDescription("This heavy armor is similar to full plate but lighter in construction, sacrificing a bit of protection for greater flexibility and mobility.");
        fieldPlate.setAcBonus(7);
        fieldPlate.setMaximumDexBonus(1);
        fieldPlate.setArmorCheckPenalty(5);
        fieldPlate.setArcaneSpellFailureChance(35);
        fieldPlate.setMaxSpeed(20);
        fieldPlate.setWeightCategory(ArmorWeightCategoryEnum.Heavy);

        ArmorEntity kusariGusoku = new ArmorEntity(UUID.randomUUID());
        kusariGusoku.setCost(350);
        kusariGusoku.setWeight(45);
        kusariGusoku.setName("Kusari Gusoku");
        kusariGusoku.setDescription("Kusari gusoku is similar to tatami-do armor; however, a katabira— a type of chain jacket—is worn in place of the chest armor.");
        kusariGusoku.setAcBonus(7);
        kusariGusoku.setMaximumDexBonus(1);
        kusariGusoku.setArmorCheckPenalty(7);
        kusariGusoku.setArcaneSpellFailureChance(35);
        kusariGusoku.setMaxSpeed(20);
        kusariGusoku.setWeightCategory(ArmorWeightCategoryEnum.Heavy);

        ArmorEntity ironLamellar = new ArmorEntity(UUID.randomUUID());
        ironLamellar.setCost(200);
        ironLamellar.setWeight(50);
        ironLamellar.setName("Iron Lamellar");
        ironLamellar.setDescription("Lamellar is a type of armor in which small plates of various types of materials are strung together in parallel rows using fine cord. Lamellar plates can be constructed from lacquered leather, horn, or even stone, though suits of iron and steel are the most common. Lamellar armor can be crafted into various shapes, including partial pieces such as breastplates, greaves, or even entire coats. The properties of specific suits and pieces of lamellar armor are determined by their material.");
        ironLamellar.setAcBonus(7);
        ironLamellar.setMaximumDexBonus(0);
        ironLamellar.setArmorCheckPenalty(7);
        ironLamellar.setArcaneSpellFailureChance(40);
        ironLamellar.setMaxSpeed(20);
        ironLamellar.setWeightCategory(ArmorWeightCategoryEnum.Heavy);

        ArmorEntity splintMail = new ArmorEntity(UUID.randomUUID());
        splintMail.setCost(200);
        splintMail.setWeight(45);
        splintMail.setName("Splint Mail");
        splintMail.setDescription("Splint mail is made up of overlapping layers of metal strips attached to a backing of leather or sturdy fabric. These splints are of greater size and durability than those that compose a suit of scale mail, improving the protection they afford the wearer, but at the cost of flexibility. A suit of splint mail includes gauntlets.");
        splintMail.setAcBonus(7);
        splintMail.setMaximumDexBonus(0);
        splintMail.setArmorCheckPenalty(7);
        splintMail.setArcaneSpellFailureChance(40);
        splintMail.setMaxSpeed(20);
        splintMail.setWeightCategory(ArmorWeightCategoryEnum.Heavy);

        ArmorEntity tatamiDo = new ArmorEntity(UUID.randomUUID());
        tatamiDo.setCost(1000);
        tatamiDo.setWeight(45);
        tatamiDo.setName("Tatami-Do");
        tatamiDo.setDescription("Worn by samurai as a lighter-weight alternative to o-yoroi, tatami-do is a full-body field armor that combines both metal lamellar and kikko components into a suit of mail with a cloth backing. It typically includes a collapsible kabuto helmet or an armored hood, as well as arm, shoulder, and thigh guards.");
        tatamiDo.setAcBonus(7);
        tatamiDo.setMaximumDexBonus(3);
        tatamiDo.setArmorCheckPenalty(6);
        tatamiDo.setArcaneSpellFailureChance(35);
        tatamiDo.setMaxSpeed(20);
        tatamiDo.setWeightCategory(ArmorWeightCategoryEnum.Heavy);

        ArmorEntity fortressPlate = new ArmorEntity(UUID.randomUUID());
        fortressPlate.setCost(2100);
        fortressPlate.setWeight(75);
        fortressPlate.setName("Fortress Plate");
        fortressPlate.setDescription("This dwarf-forged armor features layers of overlapping plates molded to deflect projectiles—especially those from firearms. Whenever you are the target of a ranged weapon attack that would ignore your armor bonus to AC, you add half the fortress plate’s armor bonus (including enhancement bonuses) to your AC against that attack. This benefit does not apply to energy attacks or magical touch attacks such as rays. Because the armor is designed with dwarves in mind, If you have the dwarf’s weapon familiarity racial trait, you increase this projectile-only bonus by 1. Fortress plate is incredibly bulky, and its armor category can’t be reduced by any effect (including by special materials, such as mithral). Fortress plate includes gauntlets and a helm.");
        fortressPlate.setAcBonus(8);
        fortressPlate.setMaximumDexBonus(0);
        fortressPlate.setArmorCheckPenalty(7);
        fortressPlate.setArcaneSpellFailureChance(40);
        fortressPlate.setMaxSpeed(20);
        fortressPlate.setWeightCategory(ArmorWeightCategoryEnum.Heavy);

        ArmorEntity halfPlate = new ArmorEntity(UUID.randomUUID());
        halfPlate.setCost(600);
        halfPlate.setWeight(50);
        halfPlate.setName("Half-Plate");
        halfPlate.setDescription("Half-plate armor combines elements of full plate and chainmail, incorporating several sizable plates of sculpted metal with an underlying mesh of chain links. While this suit protects vital areas with several layers of armor, it is not sculpted to a single individual’s frame, reducing its wearer’s mobility even more than a suit of full plate. Half-plate armor includes gauntlets and a helm.");
        halfPlate.setAcBonus(8);
        halfPlate.setMaximumDexBonus(0);
        halfPlate.setArmorCheckPenalty(7);
        halfPlate.setArcaneSpellFailureChance(40);
        halfPlate.setMaxSpeed(20);
        halfPlate.setWeightCategory(ArmorWeightCategoryEnum.Heavy);

        ArmorEntity agileHalfPlate = new ArmorEntity(UUID.randomUUID());
        agileHalfPlate.setCost(850);
        agileHalfPlate.setWeight(55);
        agileHalfPlate.setName("Agile Half-Plate");
        agileHalfPlate.setDescription("This style of half-plate is specially crafted in a manner that allows extra maneuverability for some physical activities. The armor check penalty for Climb checks and jump checks is only –4 (masterwork and mithral versions of this armor reduce this penalty as well as the normal penalty). In addition, unlike with most heavy armors, the wearer can still run at quadruple speed instead of triple speed.");
        agileHalfPlate.setAcBonus(8);
        agileHalfPlate.setMaximumDexBonus(0);
        agileHalfPlate.setArmorCheckPenalty(7);
        agileHalfPlate.setArcaneSpellFailureChance(40);
        agileHalfPlate.setMaxSpeed(20);
        agileHalfPlate.setWeightCategory(ArmorWeightCategoryEnum.Heavy);

        ArmorEntity hellKnightHalfPlate = new ArmorEntity(UUID.randomUUID());
        hellKnightHalfPlate.setCost(850);
        hellKnightHalfPlate.setWeight(50);
        hellKnightHalfPlate.setName("Hell Knight Half-Plate");
        hellKnightHalfPlate.setDescription("The armor worn by a Hell Knight signifer is a vestment of armored plates, chain, and dark fabric. It functions as half-plate, but it can be donned and removed as though it were medium armor. Any spellcaster who wears this armor is treated as if he were wearing Hell Knight plate for the purposes of any feats and effects that require it. This armor includes a signifer mask, though signifer masks can also be purchased separately.");
        hellKnightHalfPlate.setAcBonus(8);
        hellKnightHalfPlate.setMaximumDexBonus(0);
        hellKnightHalfPlate.setArmorCheckPenalty(7);
        hellKnightHalfPlate.setArcaneSpellFailureChance(40);
        hellKnightHalfPlate.setMaxSpeed(20);
        hellKnightHalfPlate.setWeightCategory(ArmorWeightCategoryEnum.Heavy);

        ArmorEntity stoneCoatLamellar = new ArmorEntity(UUID.randomUUID());
        stoneCoatLamellar.setCost(500);
        stoneCoatLamellar.setWeight(45);
        stoneCoatLamellar.setName("Stone Coat Lamellar");
        stoneCoatLamellar.setDescription("Lamellar is a type of armor in which small plates of various types of materials are strung together in parallel rows using fine cord. Lamellar plates can be constructed from lacquered leather, horn, or even stone, though suits of iron and steel are the most common. Lamellar armor can be crafted into various shapes, including partial pieces such as breastplates, greaves, or even entire coats. The properties of specific suits and pieces of lamellar armor are determined by their material. This weighty breastplate consists of lamellar crafted from stones. It is worn in conjunction with kikko leg protectors.");
        stoneCoatLamellar.setAcBonus(8);
        stoneCoatLamellar.setMaximumDexBonus(0);
        stoneCoatLamellar.setArmorCheckPenalty(7);
        stoneCoatLamellar.setArcaneSpellFailureChance(40);
        stoneCoatLamellar.setMaxSpeed(20);
        stoneCoatLamellar.setWeightCategory(ArmorWeightCategoryEnum.Heavy);

        ArmorEntity oYoroi = new ArmorEntity(UUID.randomUUID());
        oYoroi.setCost(1700);
        oYoroi.setWeight(45);
        oYoroi.setName("O-Yoroi");
        oYoroi.setDescription("Worn almost exclusively by high ranking samurai, o-yoroi—or “great armor”—is a heavy combat armor that consists of various supplementary components that include both plate and lamellar elements. Each suit is crafted for a specific individual and displays the owner’s aesthetic. Upon completion, the suit is colored and sealed with a final lacquer finish. The centerpiece of o-yoroi is a cuirass consisting of two parts—a separate reinforcement for the right side called a waidate, and a kikko cuirass. The upper part of the waidate consists of a leather-covered iron plate. The cuirass’s leather shoulder straps—called watagami—are likewise armored with metal plates. Affixed to the cuirass are a number of supplementary pieces, including wide lamellar shoulder guards, a kikko sleeve for the shield arm, lacquered iron greaves worn over padded silk leggings, and a groin protector. The signature component of each suit of armor is the tiered kabuto helmet and its accompanying ho-ate mask. Ho-ate masks can be made of hardened leather or metal and are fashioned into fearsome visages such as oni, dragons, or other mythical beings.");
        oYoroi.setAcBonus(8);
        oYoroi.setMaximumDexBonus(2);
        oYoroi.setArmorCheckPenalty(6);
        oYoroi.setArcaneSpellFailureChance(35);
        oYoroi.setMaxSpeed(20);
        oYoroi.setWeightCategory(ArmorWeightCategoryEnum.Heavy);

        ArmorEntity fullPlate = new ArmorEntity(UUID.randomUUID());
        fullPlate.setCost(1500);
        fullPlate.setWeight(50);
        fullPlate.setName("Full Plate");
        fullPlate.setDescription("This metal suit comprises multiple pieces of interconnected and overlaying metal plates, incorporating the benefits of numerous types of lesser armor. A complete suit of full plate (or platemail, as it is often called) includes gauntlets, heavy leather boots, a visored helmet, and a thick layer of padding that is worn underneath the armor. Each suit of full plate must be individually fitted to its owner by a master armorsmith, although a captured suit can be resized to fit a new owner at a cost of 200 to 800 (2d4 100) gold pieces.");
        fullPlate.setAcBonus(9);
        fullPlate.setMaximumDexBonus(1);
        fullPlate.setArmorCheckPenalty(6);
        fullPlate.setArcaneSpellFailureChance(35);
        fullPlate.setMaxSpeed(20);
        fullPlate.setWeightCategory(ArmorWeightCategoryEnum.Heavy);

        ArmorEntity grayMaidenPlate = new ArmorEntity(UUID.randomUUID());
        grayMaidenPlate.setCost(1500);
        grayMaidenPlate.setWeight(50);
        grayMaidenPlate.setName("Gray Maiden Plate");
        grayMaidenPlate.setDescription("The Gray Maidens’ distinctive armor is one of their most iconic identifiers. Gray Maiden plate is mechanically identical to full plate, and any effect that functions with full plate functions with Gray Maiden plate. Certain options for Gray Maidens function only when they wear Gray Maiden plate.");
        grayMaidenPlate.setAcBonus(9);
        grayMaidenPlate.setMaximumDexBonus(1);
        grayMaidenPlate.setArmorCheckPenalty(6);
        grayMaidenPlate.setArcaneSpellFailureChance(35);
        grayMaidenPlate.setMaxSpeed(20);
        grayMaidenPlate.setWeightCategory(ArmorWeightCategoryEnum.Heavy);

        ArmorEntity hellKnightPlate = new ArmorEntity(UUID.randomUUID());
        hellKnightPlate.setCost(2000);
        hellKnightPlate.setWeight(50);
        hellKnightPlate.setName("Hell Knight Plate");
        hellKnightPlate.setDescription("These distinctive suits of armor are a special type of masterwork full plate that grant additional effects when worn by a character with levels in the Hell Knight prestige class. Apart from its distinctive look (each order of Hell Knights has its own style of armor), a suit of Hell Knight plate functions the same as a suit of masterwork full plate.");
        hellKnightPlate.setAcBonus(9);
        hellKnightPlate.setMaximumDexBonus(1);
        hellKnightPlate.setArmorCheckPenalty(5);
        hellKnightPlate.setArcaneSpellFailureChance(35);
        hellKnightPlate.setMaxSpeed(20);
        hellKnightPlate.setWeightCategory(ArmorWeightCategoryEnum.Heavy);

        ArmorEntity stonePlate = new ArmorEntity(UUID.randomUUID());
        stonePlate.setCost(1800);
        stonePlate.setWeight(75);
        stonePlate.setName("Stone Plate");
        stonePlate.setDescription("This armor is crafted by dwarven stonesmiths from alchemically strengthened plates of basalt. Stoneplate is heavy and unwieldy, but offers incredible protection to its wearer. It is primarily used by dwarven druids who cannot wear metal armor.");
        stonePlate.setAcBonus(9);
        stonePlate.setMaximumDexBonus(1);
        stonePlate.setArmorCheckPenalty(6);
        stonePlate.setArcaneSpellFailureChance(35);
        stonePlate.setMaxSpeed(15);
        stonePlate.setWeightCategory(ArmorWeightCategoryEnum.Heavy);
        //endregion

        //region Initialize Shields
        ArmorEntity buckler = new ArmorEntity(UUID.randomUUID());
        buckler.setCost(5);
        buckler.setWeight(5);
        buckler.setName("Buckler");
        buckler.setDescription("This small metal shield is worn strapped to your forearm. You can use a bow or crossbow without penalty while carrying it. You can also use your shield arm to wield a weapon (whether you are using an offhand weapon or using your off hand to help wield a two-handed weapon), but you take a –1 penalty on attack rolls while doing so. This penalty stacks with those that may apply for fighting with your off hand and for fighting with two weapons. In any case, if you use a weapon in your off hand, you lose the buckler’s Armor Class bonus until your next turn. You can cast a spell with somatic components using your shield arm, but you lose the buckler’s Armor Class bonus until your next turn. You can’t make a shield bash with a buckler.");
        buckler.setAcBonus(1);
        buckler.setArmorCheckPenalty(1);
        buckler.setArcaneSpellFailureChance(5);
        buckler.setArmorType(ArmorTypesEnum.Shield);

        ArmorEntity klar = new ArmorEntity(UUID.randomUUID());
        klar.setCost(12);
        klar.setWeight(6);
        klar.setName("Klar");
        klar.setDescription("A traditional klar counts as a light wooden shield with armor spikes. A metal klar counts as a light steel shield with armor spikes.");
        klar.setAcBonus(1);
        klar.setArmorCheckPenalty(1);
        klar.setArcaneSpellFailureChance(5);
        klar.setArmorType(ArmorTypesEnum.Shield);

        ArmorEntity leatherMadu = new ArmorEntity(UUID.randomUUID());
        leatherMadu.setCost(30);
        leatherMadu.setWeight(5);
        leatherMadu.setName("Leather Madu");
        leatherMadu.setDescription("If you are proficient with the madu, you may wield it and fight defensively with a –2 penalty instead of the normal–4 penalty for fighting defensively, and your attack penalty for using Combat Expertise improves by +1 (minimum –1 penalty). You cannot hold anything else in the hand that bears a madu. If you are not proficient in madu, treat it as a light spiked shield.");
        leatherMadu.setAcBonus(1);
        leatherMadu.setArmorCheckPenalty(2);
        leatherMadu.setArcaneSpellFailureChance(5);
        leatherMadu.setArmorType(ArmorTypesEnum.Shield);

        ArmorEntity steelMadu = new ArmorEntity(UUID.randomUUID());
        steelMadu.setCost(40);
        steelMadu.setWeight(6);
        steelMadu.setName("Steel Madu");
        steelMadu.setDescription("If you are proficient with the madu, you may wield it and fight defensively with a –2 penalty instead of the normal–4 penalty for fighting defensively, and your attack penalty for using Combat Expertise improves by +1 (minimum –1 penalty). You cannot hold anything else in the hand that bears a madu. If you are not proficient in madu, treat it as a light spiked shield.");
        steelMadu.setAcBonus(1);
        steelMadu.setArmorCheckPenalty(2);
        steelMadu.setArcaneSpellFailureChance(5);
        steelMadu.setArmorType(ArmorTypesEnum.Shield);

        ArmorEntity steelLightShield = new ArmorEntity(UUID.randomUUID());
        steelLightShield.setCost(9);
        steelLightShield.setWeight(6);
        steelLightShield.setName("Light Steel Shield");
        steelLightShield.setDescription("Wooden or Steel: Wooden and steel shields offer the same basic protection, though they respond differently to some spells and effects. Shield Bash Attacks: You can bash an opponent with a light shield. See “shield, light” on Table: Weapons for the damage dealt by a shield bash. Used this way, a light shield is a martial bludgeoning weapon. For the purpose of penalties on attack rolls, treat a light shield as a light weapon. If you use your shield as a weapon, you lose its Armor Class bonus until your next turn. An enhancement bonus on a shield does not improve the effectiveness of a shield bash made with it, but the shield can be made into a magic weapon in its own right.");
        steelLightShield.setAcBonus(1);
        steelLightShield.setArmorCheckPenalty(1);
        steelLightShield.setArcaneSpellFailureChance(5);
        steelLightShield.setArmorType(ArmorTypesEnum.Shield);

        ArmorEntity quickdrawLightSteelShield = new ArmorEntity(UUID.randomUUID());
        quickdrawLightSteelShield.setCost(59);
        quickdrawLightSteelShield.setWeight(7);
        quickdrawLightSteelShield.setName("Quickdraw Light Steel Shield");
        quickdrawLightSteelShield.setDescription("If you have a base attack bonus of +1 or higher, you may don or put away a quickdraw shield as a swift action combined with a regular move. If you have the Two-Weapon Fighting feat, you can draw a light or one-handed weapon with one hand and a quickdraw shield with the other in the time it would normally take you to draw one weapon. If you have the Quick Draw feat, you may don or put away a quickdraw shield as a free action.");
        quickdrawLightSteelShield.setAcBonus(1);
        quickdrawLightSteelShield.setArmorCheckPenalty(1);
        quickdrawLightSteelShield.setArcaneSpellFailureChance(5);
        quickdrawLightSteelShield.setArmorType(ArmorTypesEnum.Shield);

        ArmorEntity woodenLightShield = new ArmorEntity(UUID.randomUUID());
        woodenLightShield.setCost(3);
        woodenLightShield.setWeight(5);
        woodenLightShield.setName("Light Wooden Shield");
        woodenLightShield.setDescription("Wooden or Steel: Wooden and steel shields offer the same basic protection, though they respond differently to some spells and effects. Shield Bash Attacks: You can bash an opponent with a light shield. See “shield, light” on Table: Weapons for the damage dealt by a shield bash. Used this way, a light shield is a martial bludgeoning weapon. For the purpose of penalties on attack rolls, treat a light shield as a light weapon. If you use your shield as a weapon, you lose its Armor Class bonus until your next turn. An enhancement bonus on a shield does not improve the effectiveness of a shield bash made with it, but the shield can be made into a magic weapon in its own right.");
        woodenLightShield.setAcBonus(1);
        woodenLightShield.setArmorCheckPenalty(1);
        woodenLightShield.setArcaneSpellFailureChance(5);
        woodenLightShield.setArmorType(ArmorTypesEnum.Shield);

        ArmorEntity quickdrawLightWoodenShield = new ArmorEntity(UUID.randomUUID());
        quickdrawLightWoodenShield.setCost(53);
        quickdrawLightWoodenShield.setWeight(6);
        quickdrawLightWoodenShield.setName("Quickdraw Light Wooden Shield");
        quickdrawLightWoodenShield.setDescription("If you have a base attack bonus of +1 or higher, you may don or put away a quickdraw shield as a swift action combined with a regular move. If you have the Two-Weapon Fighting feat, you can draw a light or one-handed weapon with one hand and a quickdraw shield with the other in the time it would normally take you to draw one weapon. If you have the Quick Draw feat, you may don or put away a quickdraw shield as a free action.");
        quickdrawLightWoodenShield.setAcBonus(1);
        quickdrawLightWoodenShield.setArmorCheckPenalty(1);
        quickdrawLightWoodenShield.setArcaneSpellFailureChance(5);
        quickdrawLightWoodenShield.setArmorType(ArmorTypesEnum.Shield);

        ArmorEntity heavySteelShield = new ArmorEntity(UUID.randomUUID());
        heavySteelShield.setCost(20);
        heavySteelShield.setWeight(15);
        heavySteelShield.setName("Heavy Steel Shield");
        heavySteelShield.setDescription("Wooden or Steel: Wooden and steel shields offer the same basic protection, though they respond differently to spells and effects. Shield Bash Attacks: You can bash an opponent with a heavy shield. See “shield, heavy” on Table: Weapons for the damage dealt by a shield bash. Used this way, a heavy shield is a martial bludgeoning weapon. For the purpose of penalties on attack rolls, treat a heavy shield as a one-handed weapon. If you use your shield as a weapon, you lose its Armor Class bonus until your next turn. An enhancement bonus on a shield does not improve the effectiveness of a shield bash made with it, but the shield can be made into a magic weapon in its own right.");
        heavySteelShield.setAcBonus(2);
        heavySteelShield.setArmorCheckPenalty(2);
        heavySteelShield.setArcaneSpellFailureChance(15);
        heavySteelShield.setArmorType(ArmorTypesEnum.Shield);

        ArmorEntity heavyWoodenShield = new ArmorEntity(UUID.randomUUID());
        heavyWoodenShield.setCost(7);
        heavyWoodenShield.setWeight(10);
        heavyWoodenShield.setName("Heavy Wooden Shield");
        heavyWoodenShield.setDescription("Wooden or Steel: Wooden and steel shields offer the same basic protection, though they respond differently to spells and effects. Shield Bash Attacks: You can bash an opponent with a heavy shield. See “shield, heavy” on Table: Weapons for the damage dealt by a shield bash. Used this way, a heavy shield is a martial bludgeoning weapon. For the purpose of penalties on attack rolls, treat a heavy shield as a one-handed weapon. If you use your shield as a weapon, you lose its Armor Class bonus until your next turn. An enhancement bonus on a shield does not improve the effectiveness of a shield bash made with it, but the shield can be made into a magic weapon in its own right.");
        heavyWoodenShield.setAcBonus(2);
        heavyWoodenShield.setArmorCheckPenalty(2);
        heavyWoodenShield.setArcaneSpellFailureChance(15);
        heavyWoodenShield.setArmorType(ArmorTypesEnum.Shield);

        ArmorEntity towerShield = new ArmorEntity(UUID.randomUUID());
        towerShield.setCost(30);
        towerShield.setWeight(45);
        towerShield.setName("Tower Shield");
        towerShield.setDescription("");
        towerShield.setAcBonus(4);
        towerShield.setArmorCheckPenalty(10);
        towerShield.setArcaneSpellFailureChance(50);
        towerShield.setMaximumDexBonus(2);
        towerShield.setArmorType(ArmorTypesEnum.Shield);

        ArmorEntity steelSnarlShield = new ArmorEntity(UUID.randomUUID());
        steelSnarlShield.setCost(50);
        steelSnarlShield.setWeight(20);
        steelSnarlShield.setName("Steel Snarl Shield");
        steelSnarlShield.setDescription("The snarlshield is a heavy shield that features a dozen rods protruding from its surface. When used as a weapon to bash an opponent, a snarlshield has the disarm quality.");
        steelSnarlShield.setAcBonus(2);
        steelSnarlShield.setArmorCheckPenalty(3);
        steelSnarlShield.setArcaneSpellFailureChance(15);
        steelSnarlShield.setArmorType(ArmorTypesEnum.Shield);

        ArmorEntity woodenSnarlShield = new ArmorEntity(UUID.randomUUID());
        woodenSnarlShield.setCost(37);
        woodenSnarlShield.setWeight(15);
        woodenSnarlShield.setName("Wooden Snarl Shield");
        woodenSnarlShield.setDescription("The snarlshield is a heavy shield that features a dozen rods protruding from its surface. When used as a weapon to bash an opponent, a snarlshield has the disarm quality.");
        woodenSnarlShield.setAcBonus(2);
        woodenSnarlShield.setArmorCheckPenalty(3);
        woodenSnarlShield.setArcaneSpellFailureChance(15);
        woodenSnarlShield.setArmorType(ArmorTypesEnum.Shield);

        ArmorEntity dwarvenWarShield = new ArmorEntity(UUID.randomUUID());
        dwarvenWarShield.setCost(50);
        dwarvenWarShield.setWeight(8);
        dwarvenWarShield.setName("Dwarven War-Shield");
        dwarvenWarShield.setDescription("This shield’s sides are cut into jagged angles and honed to razor sharpness. Dwarven skirmishers often wield these shields in pairs, savagely hacking opponents to pieces, while some dwarven scoundrels enjoy the shields’ imposing appearance and ease of use. If you have the Two-Weapon Fighting feat and are wielding two dwarven war-shields, increase the higher of the two shield bonuses by 1. You lose this benefit for 1 round when you make a shield bash with one or both dwarven war-shields (unless you have the Improved Shield Bash feat or a similar benefit). A hand holding a dwarven war-shield can’t be used for anything else. A dwarven war-shield gains no benefit from shield spikes.");
        dwarvenWarShield.setAcBonus(1);
        dwarvenWarShield.setArmorCheckPenalty(1);
        dwarvenWarShield.setArcaneSpellFailureChance(20);
        dwarvenWarShield.setArmorType(ArmorTypesEnum.Shield);
        //endregion

        //region Insert Armors
        db.ArmorDao().insertArmor(armoredKilt);
        db.ArmorDao().insertArmor(dancingScarves);
        db.ArmorDao().insertArmor(haramaki);
        db.ArmorDao().insertArmor(padded);
        db.ArmorDao().insertArmor(quiltedCloth);
        db.ArmorDao().insertArmor(reinforcedTunic);
        db.ArmorDao().insertArmor(silkenCeremonialArmor);
        db.ArmorDao().insertArmor(lamellarCuirass);
        db.ArmorDao().insertArmor(leather);
        db.ArmorDao().insertArmor(rosewoodArmor);
        db.ArmorDao().insertArmor(hellKnightLeather);
        db.ArmorDao().insertArmor(hideShirt);
        db.ArmorDao().insertArmor(leafArmor);
        db.ArmorDao().insertArmor(paradeArmor);
        db.ArmorDao().insertArmor(spiderSilkBodysuit);
        db.ArmorDao().insertArmor(studdedLeather);
        db.ArmorDao().insertArmor(wooden);
        db.ArmorDao().insertArmor(chainShirt);
        db.ArmorDao().insertArmor(lamellarLeather);
        db.ArmorDao().insertArmor(armoredCoat);
        db.ArmorDao().insertArmor(chainCoat);
        db.ArmorDao().insertArmor(hide);
        db.ArmorDao().insertArmor(iceCoat);
        db.ArmorDao().insertArmor(doMaru);
        db.ArmorDao().insertArmor(kikko);
        db.ArmorDao().insertArmor(hornLamellar);
        db.ArmorDao().insertArmor(scaleMail);
        db.ArmorDao().insertArmor(breastplate);
        db.ArmorDao().insertArmor(agileBreastplate);
        db.ArmorDao().insertArmor(chainmail);
        db.ArmorDao().insertArmor(fourMirrorArmor);
        db.ArmorDao().insertArmor(steelLamellar);
        db.ArmorDao().insertArmor(mountainPattern);
        db.ArmorDao().insertArmor(bandedMail);
        db.ArmorDao().insertArmor(fieldPlate);
        db.ArmorDao().insertArmor(kusariGusoku);
        db.ArmorDao().insertArmor(ironLamellar);
        db.ArmorDao().insertArmor(splintMail);
        db.ArmorDao().insertArmor(tatamiDo);
        db.ArmorDao().insertArmor(fortressPlate);
        db.ArmorDao().insertArmor(halfPlate);
        db.ArmorDao().insertArmor(agileHalfPlate);
        db.ArmorDao().insertArmor(hellKnightHalfPlate);
        db.ArmorDao().insertArmor(stoneCoatLamellar);
        db.ArmorDao().insertArmor(oYoroi);
        db.ArmorDao().insertArmor(fullPlate);
        db.ArmorDao().insertArmor(grayMaidenPlate);
        db.ArmorDao().insertArmor(hellKnightPlate);
        db.ArmorDao().insertArmor(stonePlate);
        db.ArmorDao().insertArmor(buckler);
        db.ArmorDao().insertArmor(klar);
        db.ArmorDao().insertArmor(leatherMadu);
        db.ArmorDao().insertArmor(steelMadu);
        db.ArmorDao().insertArmor(steelLightShield);
        db.ArmorDao().insertArmor(quickdrawLightSteelShield);
        db.ArmorDao().insertArmor(woodenLightShield);
        db.ArmorDao().insertArmor(quickdrawLightWoodenShield);
        db.ArmorDao().insertArmor(heavySteelShield);
        db.ArmorDao().insertArmor(heavyWoodenShield);
        db.ArmorDao().insertArmor(towerShield);
        db.ArmorDao().insertArmor(steelSnarlShield);
        db.ArmorDao().insertArmor(woodenSnarlShield);
        db.ArmorDao().insertArmor(dwarvenWarShield);
        //endregion
    }
}
