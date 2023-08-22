# UGRC

## Possible ways an object can escape scope : 
* Assigning to global/class variable (object aliveness is equivalent to global/class variable) - No Algo to determine for stack allocation
    * Class - UserDatabase
    * Global - 
* Storing in Data Structure (List, Map, Set, etc)
* Return Calls (moving to another method scope)
* Argument to another method (similar to return) 
* Passing to external objects (object aliveness is equivalent to external object aliveness)

## Inferences for last usage and stack allocation for objects

* For objects which get referenced by global/class variables, we cannot determine the last usage of the object wrt method.
* This can be in regard to Storing in Data Structure, Another object referring to it.
* When an objects lifetime is matched to a global/class variable, we can't do the necessary algo.
* Except for Example_Return, rest all can't be optimized by algo.

