# UGRC

## Possible ways an object can escape scope : 
* Assigning to global/class variable (object aliveness is equivalent to global/class variable)
    * Class - UserDatabase
    * Global - 
* Storing in Data Structure (List, Map, Set, etc)
* Return Calls (moving to another method scope)
* Argument to another method (similar to return) 
* Passing to external objects (object aliveness is equivalent to external object aliveness)
