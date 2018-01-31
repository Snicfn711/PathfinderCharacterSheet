package com.pathfinderstattracker.pathfindercharactersheet.models.races;

/**
 * Created by Stephen Hagen on 1/5/2018.
 */

public interface IMovement
{
    String Name = null;
    int Speed = 0;
    MovementManeuverabilityEnum Maneuverability = MovementManeuverabilityEnum.Average;
}
