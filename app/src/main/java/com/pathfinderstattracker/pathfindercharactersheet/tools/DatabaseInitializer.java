package com.pathfinderstattracker.pathfindercharactersheet.tools;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.pathfinderstattracker.pathfindercharactersheet.database.PathfinderDatabase;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.WeaponEnchantmentEntity;
import com.pathfinderstattracker.pathfindercharactersheet.models.Damage;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IWeaponEnchantment;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.WeaponEnchantment;

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
    private static void addWeaponEnchantment(final PathfinderDatabase db, WeaponEnchantmentEntity weaponEnchantment)
    {
        db.WeaponEnchantmentDao().insertWeaponEnchantment(weaponEnchantment);
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
            populateWithTestData(mDb);
            return null;
        }
    }

    private static void populateWithTestData(PathfinderDatabase db)
    {
        IWeaponEnchantment weaponEnchantment = new WeaponEnchantment("Flaming",
                                                                     new Damage(1,6),
                                                                     "Fire",
                                                                     1,
                                                                     "Upon command, a flaming weapon is sheathed in fire that deals an extra 1d6 points of fire damage on a successful hit. The fire does not harm the wielder. The effect remains until another command is given.");
        WeaponEnchantmentEntity entityToInsert = new WeaponEnchantmentEntity(weaponEnchantment);
        addWeaponEnchantment(db, entityToInsert);
    }


}
