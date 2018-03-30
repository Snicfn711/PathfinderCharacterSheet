package com.pathfinderstattracker.pathfindercharactersheet.models.items;

import android.support.annotation.NonNull;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Stephen Hagen on 3/29/2018.
 */

public abstract class AbsItem implements IItem
{
    private double cost;
    private double weight;
    private String name;
    private String description;

    //region Getters and Setters
    @Override
    public double getCost()
    {
        return cost;
    }

    @Override
    public void setCost(double cost)
    {
        this.cost = cost;
    }

    @Override
    public double getWeightAtMediumSize()
    {
        return weight;
    }

    @Override
    public void setWeightAtMediumSize(double weightAtMediumSize)
    {
        this.weight = weightAtMediumSize;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String getDescription() {return description;}

    @Override
    public void setDescription(String description){this.description = description;}
    //endregion


    public AbsItem()
    {
        //Default constructor
    }

    public AbsItem(double cost, double weight, String name, String description)
    {
        setCost(cost);
        setWeightAtMediumSize(weight);
        setName(name);
        setDescription(description);
    }

    //region Comparators
    @Override
    public int compareTo(@NonNull IItem iItem)
    {
        //Since items can have so many different types, with no default way of ordering, we'll leave them all as equal
        //This is also a fun UX thing, since the "default" view of the inventory screen before sorting is of a random mess like you'd have in a backpack
        return 0;
    }

    public static Comparator<IItem> compareByCost = new Comparator<IItem>()
    {
        public int compare(IItem s1, IItem s2)
        {
            Double b1 = s1.getCost();
            Double b2 = s2.getCost();
            return b2.compareTo(b1);
        }
    };

    public static Comparator<IItem> compareByWeight = new Comparator<IItem>()
    {
        public int compare(IItem s1, IItem s2)
        {
            Double b1 = s1.getWeightAtMediumSize();
            Double b2 = s2.getWeightAtMediumSize();
            return b2.compareTo(b1);
        }
    };

    public static Comparator<IItem> compareByName = new Comparator<IItem>()
    {
        public int compare(IItem s1, IItem s2)
        {
            String b1 = s1.getName();
            String b2 = s2.getName();
            return b2.compareTo(b1);
        }
    };

    public static boolean checkIfSortedByCost(List<IItem> listToCheck)
    {
        for(int i = 0; i < listToCheck.size() - 1; i++)
        {
            if(listToCheck.get(i).getCost() < listToCheck.get(i + 1).getCost())
            {
                return false;
            }
        }
        return true;
    }

    public static boolean checkIfSortedByWeight(List<IItem> listToCheck)
    {
        for(int i = 0; i < listToCheck.size() - 1; i++)
        {
            if(listToCheck.get(i).getWeightAtMediumSize() < listToCheck.get(i + 1).getWeightAtMediumSize())
            {
                return false;
            }
        }
        return true;
    }

    public static boolean checkIfSortedByName(List<IItem> listToCheck)
    {
        for(int i = 0; i < listToCheck.size() - 1; i++)
        {
            int sortOrder = listToCheck.get(i).getName().compareTo(listToCheck.get(i + 1).getName());
            if(sortOrder > 0)
            {
                return false;
            }
        }
        return true;
    }
    //endregion
}
