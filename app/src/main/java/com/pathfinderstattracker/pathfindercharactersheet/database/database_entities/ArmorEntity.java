package com.pathfinderstattracker.pathfindercharactersheet.database.database_entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.ArmorTypesEnumConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.ArmorWeightCategoryEnumConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.SizeCategoryEnumConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.UUIDConverter;
import com.pathfinderstattracker.pathfindercharactersheet.models.SizeCategoryEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.ArmorTypesEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.ArmorWeightCategoryEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IArmorEnchantment;

import java.util.UUID;

@Entity(tableName = "armor")
@TypeConverters({UUIDConverter.class,
                 SizeCategoryEnumConverter.class,
                 ArmorWeightCategoryEnumConverter.class,
                 ArmorTypesEnumConverter.class})
public class ArmorEntity
{
    @PrimaryKey
    @NonNull
    private UUID armorID;
    @ColumnInfo(name="cost")
    private double cost;
    @ColumnInfo(name="weight")
    private double weight;
    @ColumnInfo(name="name")
    private String name;
    @ColumnInfo(name="description")
    private String description;
    @ColumnInfo(name="ac_bonus")
    private int acBonus;
    @ColumnInfo(name="maximum_dex_bonus")
    private Integer maximumDexBonus;
    @ColumnInfo(name="armor_check_penalty")
    private Integer armorCheckPenalty;
    @ColumnInfo(name="arcane_spell_failure_chance")
    private Integer arcaneSpellFailureChance;
    @ColumnInfo(name="max_speed")
    private Integer maxSpeed;
    @ColumnInfo(name="weight_category")
    private ArmorWeightCategoryEnum weightCategory;
    @ColumnInfo(name="armor_size")
    private SizeCategoryEnum armorSize;
    @ColumnInfo(name="is_fragile")
    private boolean isFragile;
    @ColumnInfo(name = "armor_type")
    private ArmorTypesEnum armorType;

    //region Getters and Setters
    @NonNull
    public UUID getArmorID() {
        return armorID;
    }

    public void setArmorID(@NonNull UUID armorID) {
        this.armorID = armorID;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAcBonus() {
        return acBonus;
    }

    public void setAcBonus(int acBonus) {
        this.acBonus = acBonus;
    }

    public Integer getMaximumDexBonus() {
        return maximumDexBonus;
    }

    public void setMaximumDexBonus(Integer maximumDexBonus) {
        this.maximumDexBonus = maximumDexBonus;
    }

    public Integer getArmorCheckPenalty() {
        return armorCheckPenalty;
    }

    public void setArmorCheckPenalty(Integer armorCheckPenalty) {
        this.armorCheckPenalty = armorCheckPenalty;
    }

    public Integer getArcaneSpellFailureChance() {
        return arcaneSpellFailureChance;
    }

    public void setArcaneSpellFailureChance(Integer arcaneSpellFailureChance) {
        this.arcaneSpellFailureChance = arcaneSpellFailureChance;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public ArmorWeightCategoryEnum getWeightCategory() {
        return weightCategory;
    }

    public void setWeightCategory(ArmorWeightCategoryEnum weightCategory) {
        this.weightCategory = weightCategory;
    }

    public SizeCategoryEnum getArmorSize() {
        return armorSize;
    }

    public void setArmorSize(SizeCategoryEnum armorSize) {
        this.armorSize = armorSize;
    }

    public boolean isFragile(){return isFragile;}

    public void setFragile(boolean isFragile){this.isFragile = isFragile;}

    public ArmorTypesEnum getArmorType(){return armorType;}

    public void setArmorType(ArmorTypesEnum armorType){this.armorType = armorType;}
    //endregion

    private ArmorEntity()
    {
        setCost(0);
        setWeight(0);
        setName("");
        setDescription("");
        setAcBonus(0);
        setMaximumDexBonus(null);
        setArmorCheckPenalty(null);
        setArcaneSpellFailureChance(null);
        setMaxSpeed(null);
        setWeightCategory(ArmorWeightCategoryEnum.Light);
        setArmorSize(SizeCategoryEnum.Medium);
        setFragile(false);
        setArmorType(ArmorTypesEnum.Armor);
    }

    public ArmorEntity(UUID armorID)
    {
        this();
        setArmorID(armorID);
    }
}
