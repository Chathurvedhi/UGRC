# Undergraduate Research Course

## Compile Time Memory Management

* Under the guidance of Prof. Krishna Nandivada.
* The current memory management system in Java is handled by a garbage collector which reclaims objects based on reachability from the root set.
* This paper introduces an algorithm for compile-time memory management that allows objects to be freed at their last point of use during program execution rather than the point when it becomes unreachable.
* The algorithm involves an interprocedural flow-sensitive and value context-sensitive analysis along with interprocedural liveness analysis to determine the last usage point of an object using allocation abstraction.