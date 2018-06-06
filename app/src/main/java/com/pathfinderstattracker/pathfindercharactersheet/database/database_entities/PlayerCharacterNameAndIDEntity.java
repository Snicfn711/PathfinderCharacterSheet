package com.pathfinderstattracker.pathfindercharactersheet.database.database_entities;

import android.arch.persistence.room.ColumnInfo;

import java.util.UUID;

public class PlayerCharacterNameAndIDEntity
{
   @ColumnInfo(name = "playerCharacterID")
   public UUID PlayerCharacterID;
   @ColumnInfo(name = "character_name")
   public String PlayerCharacterName;
}
