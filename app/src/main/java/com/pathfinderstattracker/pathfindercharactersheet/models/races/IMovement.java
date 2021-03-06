package com.pathfinderstattracker.pathfindercharactersheet.models.races;

/**
 * Created by Stephen Hagen on 1/5/2018.
 */
import java.io.Serializable;

public interface IMovement extends Serializable
{
    String getName();
    void setName(String name);
    int getSpeed();
    void setSpeed(int speed);
    MovementManeuverabilityEnum getManeuverability();
    void setManeuverability(MovementManeuverabilityEnum maneuverability);
}
