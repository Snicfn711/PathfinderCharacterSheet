package com.pathfinderstattracker.pathfindercharactersheet.models.races;

/**
 * Created by Stephen Hagen on 1/5/2018.
 */

public class Movement implements IMovement
{
    public String Name;
    public int Speed;
    public MovementManeuverabilityEnum Maneuverability;

    public Movement()
    {
        //Default Constructor
    }

    public Movement(String name, int speed, MovementManeuverabilityEnum maneuverability)
    {
        setName(name);
        setSpeed(speed);
        setManeuverability(maneuverability);
    }

    public void setName(String name)
    {
        Name = name;
    }
    public void setSpeed(int speed)
    {
        Speed = speed;
    }
    public void setManeuverability(MovementManeuverabilityEnum maneuverability)
    {
        Maneuverability = maneuverability;
    }
    public String getName()
    {
        return Name;
    }
    public int getSpeed()
    {
        return Speed;
    }
    public MovementManeuverabilityEnum getManeuverability()
    {
        return Maneuverability;
    }

}
