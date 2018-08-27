package com.pathfinderstattracker.pathfindercharactersheet.models.items;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/**
 * Created by Stephen Hagen on 3/29/2018.
 */

public abstract class AbsItem implements IItem, Serializable
{
    protected UUID itemID;
    protected double cost;
    protected double weight;
    protected String name;
    protected String description;

    //region Getters and Setters
    @Override
    public UUID getItemID(){return itemID;}
    @Override
    public void setItemID(UUID itemID){this.itemID = itemID;}
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

    @Override
    public String toString()
    {
        return name;
    }
    //region Comparators
    @Override
    public int compareTo(@NonNull IItem o)
    {
        //Since items can have so many different types, with no default way of ordering, we'll leave them all as equal
        //This is also a fun UX thing, since the "default" view of the inventory screen before sorting is of a random mess like you'd have in a backpack
        AbsItem temp = (AbsItem)o;
        return this.name.compareTo(temp.getName());
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
            return b1.compareTo(b2);
        }
    };
    
    public static Comparator<IItem> compareMundaneProtections = new Comparator<IItem>()
    {
        @Override
        public int compare(IItem s1, IItem s2)
        {
            if(s1 instanceof IProtection && s2 instanceof IProtection)
            {
                int order;
                IProtection p1 = (IProtection)s1;
                IProtection p2 = (IProtection)s2;
                
                order = compareProtectionCategories.compare(p1,p2);
                if(order == 0 && p1.getArmorType() == ArmorTypesEnum.Armor && p2.getArmorType() == ArmorTypesEnum.Armor)
                {
                   order = compareArmorWeightClasses.compare(p1,p2);
                }
                if(order == 0 && p1.getArmorType() == ArmorTypesEnum.Shield && p2.getArmorType() == ArmorTypesEnum.Shield)
                {
                    order = compareShieldWeightClass.compare(p1,p2);
                }
                if(order == 0)
                {
                    Integer ac1 = p1.getACBonus();
                    Integer ac2 = p2.getACBonus();

                    order = ac1.compareTo(ac2);
                }
                if(order == 0)
                {
                    order = p1.getName().compareTo(p2.getName());
                }
                return order;
                
            }
            return 0;
        }
    };
    
    public static Comparator<IItem> compareEquipment = new Comparator<IItem>()
    {
        public int compare(IItem s1, IItem s2)
        {
            if(s1 instanceof IEquipment && !(s2 instanceof IEquipment))
            {
                return -1;
            }
            else if(!(s1 instanceof IEquipment) && s2 instanceof IEquipment)
            {
                return 1;
            }
            return 0;
        }
    };
    
    private static Comparator<IProtection> compareProtectionCategories = new Comparator<IProtection>()
    {
        @Override
        public int compare(IProtection p1, IProtection p2)
        {
            if(p1 instanceof IArmor && p2 instanceof IShield)
            {
                return -1; 
            }
            else if(p1 instanceof IShield && p2 instanceof IArmor)
            {
                return 1;
            }
            return 0;
        }
    };
    
    private static Comparator<IProtection> compareArmorWeightClasses = new Comparator<IProtection>()
    {
        @Override
        public int compare(IProtection p1, IProtection p2)
        {
            IArmor a1 = (IArmor)p1;
            IArmor a2 = (IArmor)p2;
            if(a1.getWeightCategory() == ArmorWeightCategoryEnum.Light && a2.getWeightCategory() == ArmorWeightCategoryEnum.Medium)
            {
                return -1;
            }
            else if(a2.getWeightCategory() == ArmorWeightCategoryEnum.Light && a1.getWeightCategory() == ArmorWeightCategoryEnum.Medium)
            {
                return 1;
            }
            else if(a1.getWeightCategory() == ArmorWeightCategoryEnum.Medium && a2.getWeightCategory() == ArmorWeightCategoryEnum.Heavy)
            {
                return -1;
            }
            else if(a2.getWeightCategory() == ArmorWeightCategoryEnum.Medium && a1.getWeightCategory() == ArmorWeightCategoryEnum.Heavy)
            {
                return 1;
            }
            else if(a1.getWeightCategory() == ArmorWeightCategoryEnum.Light && a2.getWeightCategory() == ArmorWeightCategoryEnum.Heavy)
            {
                return -1;
            }
            else if(a2.getWeightCategory() == ArmorWeightCategoryEnum.Light && a1.getWeightCategory() == ArmorWeightCategoryEnum.Heavy)
            {
                return 1;
            }
            return 0;
        }
    };
    
    private static Comparator<IProtection> compareShieldWeightClass = new Comparator<IProtection>()
    {
        @Override
        public int compare(IProtection p1, IProtection p2)
        {
            IShield s1 = (IShield)p1;
            IShield s2 = (IShield)p2;
            if(s1.getWeightCategory() == ShieldWeightCategoryEnum.Buckler && s2.getWeightCategory() == ShieldWeightCategoryEnum.Light)
            {
                return -1;
            }
            else if(s2.getWeightCategory() == ShieldWeightCategoryEnum.Buckler && s1.getWeightCategory() ==ShieldWeightCategoryEnum.Light)
            {
                return 1;
            }
            else if(s1.getWeightCategory() ==ShieldWeightCategoryEnum.Light && s2.getWeightCategory() == ShieldWeightCategoryEnum.Heavy)
            {
                return -1;
            }
            else if(s2.getWeightCategory() == ShieldWeightCategoryEnum.Light && s1.getWeightCategory() == ShieldWeightCategoryEnum.Heavy)
            {
                return 1;
            }
            else if(s1.getWeightCategory() == ShieldWeightCategoryEnum.Heavy && s2.getWeightCategory() == ShieldWeightCategoryEnum.Tower)
            {
                return -1;
            }
            else if(s2.getWeightCategory() == ShieldWeightCategoryEnum.Heavy && s1.getWeightCategory() == ShieldWeightCategoryEnum.Tower)
            {
                return 1;
            }
            if(s1.getWeightCategory() == ShieldWeightCategoryEnum.Buckler && s2.getWeightCategory() == ShieldWeightCategoryEnum.Heavy)
            {
                return -1;
            }
            else if(s2.getWeightCategory() == ShieldWeightCategoryEnum.Buckler && s1.getWeightCategory() ==ShieldWeightCategoryEnum.Heavy)
            {
                return 1;
            }
            else if(s1.getWeightCategory() ==ShieldWeightCategoryEnum.Light && s2.getWeightCategory() == ShieldWeightCategoryEnum.Tower)
            {
                return -1;
            }
            else if(s2.getWeightCategory() == ShieldWeightCategoryEnum.Light && s1.getWeightCategory() == ShieldWeightCategoryEnum.Tower)
            {
                return 1;
            }
            else if(s1.getWeightCategory() == ShieldWeightCategoryEnum.Buckler && s2.getWeightCategory() == ShieldWeightCategoryEnum.Tower)
            {
                return -1;
            }
            else if(s2.getWeightCategory() == ShieldWeightCategoryEnum.Buckler && s1.getWeightCategory() == ShieldWeightCategoryEnum.Tower)
            {
                return 1;
            }
            return 0;
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

    public static boolean checkIfSortedByEquipment(List<IItem> listToCheck)
    {
        for(int i = 0; i < listToCheck.size() - 1; i++)
        {
            Boolean isCurrentEquipment = listToCheck.get(i) instanceof IEquipment;
            Boolean isNextEquipment = listToCheck.get(i + 1) instanceof IEquipment;

            if(!isCurrentEquipment && isNextEquipment)
            {
                return false;
            }
        }
        return true;
    }
    //endregion
}
