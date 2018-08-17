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
        primaryKeys = {"playerArmorID"},
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
    @ColumnInfo(name="playerArmorID")
    private UUID playerArmorID = new UUID(0,0);

    @ColumnInfo(name="playerCharacterID")
    private UUID playerID = new UUID(0,0);

    @ColumnInfo(name="armorID")
    private UUID armorID = new UUID(0,0);

    @ColumnInfo(name = "is_equipped")
    private boolean isEquipped;

    //region Getters and Setters
    @NonNull
    public UUID getPlayerArmorID(){return playerArmorID;}

    public void setPlayerArmorID(@NonNull UUID playerArmorID) {this.playerArmorID = playerArmorID;}

    public UUID getPlayerID(){return playerID;}

    public void setPlayerID(UUID playerID)
    {
        this.playerID = playerID;
    }

    public UUID getArmorID()
    {
        return armorID;
    }

    public void setArmorID(UUID armorID)
    {
        this.armorID = armorID;
    }

    public boolean isEquipped(){return isEquipped;}

    public void setIsEquipped(boolean isEquipped){this.isEquipped = isEquipped;}
    //endregion

    public PlayerArmorEntity()
    {
        //Default Constructor
    }
}
