package com.pathfinderstattracker.pathfindercharactersheet.database.database_entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.UUIDConverter;

import java.util.UUID;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "player_armor",
        primaryKeys = {"playerCharacterID", "armorID"},
        foreignKeys = {@ForeignKey(entity=PlayerCharacterEntity.class,
                                   parentColumns = "playerCharacterID",
                                   childColumns = "playerCharacterID" ,
                                   onDelete=CASCADE),
                       @ForeignKey(entity=ArmorEntity.class,
                                   parentColumns = "armorID",
                                   childColumns = "armorID",
                                   onDelete = CASCADE)},
        indices = {@Index("playerCharacterID"),
                   @Index("armorID")})
@TypeConverters({UUIDConverter.class})

public class PlayerArmorEntity
{
    @NonNull
    @ColumnInfo(name="playerCharacterID")
    private UUID playerID = new UUID(0,0);

    @NonNull
    @ColumnInfo(name="armorID")
    private UUID armorID = new UUID(0,0);

    @ColumnInfo(name = "is_equipped")
    private boolean isEquipped;

    //We used to simply track each item individually by using a PlayerArmorID for each item.
    //However, when it came time to equip specific armor pieces, this no longer worked.
    //This was because we had no way to track which specific piece was being equipped without letting our repository entities out to pollute the rest of the code base.
    //This means we now keep track of the number of each item in the characters inventory and if an item is equipped,
    //we're working under the assumption that only a single item of a given type can be equipped at a time.
    //We'll need to figure out a solution for weapons and shields equipped in both hands though, as this won't work for those.
    @ColumnInfo(name="number_in_inventory")
    private int numberInInventory;

    //region Getters and Setters
    @NonNull
    public UUID getPlayerID(){return playerID;}

    public void setPlayerID(@NonNull UUID playerID)
    {
        this.playerID = playerID;
    }

    @NonNull
    public UUID getArmorID()
    {
        return armorID;
    }

    public void setArmorID(@NonNull UUID armorID)
    {
        this.armorID = armorID;
    }

    public boolean isEquipped(){return isEquipped;}

    public void setIsEquipped(boolean isEquipped){this.isEquipped = isEquipped;}

    public int getNumberInInventory(){return numberInInventory;}

    public void setNumberInInventory(int numberInInventory){this.numberInInventory = numberInInventory;}
    //endregion

    public PlayerArmorEntity()
    {
        //Default Constructor
    }
}
