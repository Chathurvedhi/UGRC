# UGRC

## Possible ways an object can escape scope : 
* Assigning to global/class variable (object aliveness is equivalent to global/class variable) - No Algo to determine for stack allocation
    * Class - UserDatabase
    * Global - 
* Storing in Data Structure (List, Map, Set, etc)
* Return Calls (moving to another method scope)
* Argument to another method (similar to return) 
* Passing to external objects (object aliveness is equivalent to external object aliveness)

## Inferences for last usage and stack allocation for objects - Changed Perspective

* For objects which get referenced by global/class variables, we cannot determine the last usage of the object wrt method.
* This can be in regard to Storing in Data Structure, Another object referring to it.
* When an objects lifetime is matched to a global variable, we can't do the necessary algo.

## 29 Aug 2023

* Searched for papers on object liveness, liveness analysis with garbage collection and related topics, most relevant papers :. 
* Went over a few papers from IITK and IITB by Prof. Amey Karkare [pdf](https://www.cl.cam.ac.uk/~am21/papers/cc14.pdf) 
    * Most of the papers involved complete flow-sensitive analysis of the program.
    * But heavy trade off in time for memory management.

* Important paper with similar points-to and them liveness analysis and good results - [pdf](https://dl.acm.org/doi/pdf/10.1145/1029873.1029884) 
    * Region based analysis with heap objects.
    * Deallocation of all objects in a region at once.
    * Given an input Java program, our system produces an output program augmented with region annotations.
    * Annotations include region creation, region deallocation of all objects, and region passing.
    * Flow-insensitive, context-sensitive pointer analysis to partition memory into regions and compute points-to information.
    * Flow-sensitive inter-procedural analysis to determine the region of each object at each program point.
    * Can correlate the region to stack allocation for some instances of region creation.

* Other papers which I will go over for understanding other implementations of flow analysis and garbage collection, not entirely sure if necessary. 
    * [Extensible intraprocedural flow analysis at the abstract syntax tree level](https://pdf.sciencedirectassets.com/271600/1-s2.0-S0167642313X00085/1-s2.0-S0167642312000172/main.pdf?X-Amz-Security-Token=IQoJb3JpZ2luX2VjEOn%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaCXVzLWVhc3QtMSJIMEYCIQD1589VxK0HfYZfbV2F7s3zxvOt2ZC%2B%2F48fXFZcygFulQIhAJ24NNPlf6oOmyekSB91NkD14TSEasVTxretSaeDRVjOKrsFCLH%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEQBRoMMDU5MDAzNTQ2ODY1Igwr0fUjcVcw2mzJd7gqjwWGhXZp6fdtVlwprBG5VBOd%2BysLQp%2B0CMyNoF7vBtidV1z6%2FaIeHSTK7hbNb6Av8mEzLFHrGVYQ8E9lLMsm68JVhS%2Bu98fl1BtRRiM%2FwlA11WPK78nXBV8rbth255wfWCzaUxrE0SuLqg06lNdTm7oRzgiVAeKBLmXf1DyYinBDyBJDad0xXAxBN1PoFsVQjKJN9o7oBbxFVU2VdDjomtj%2F7aoz0hkoSatP%2Bd8XNjG1pGwcB3RqO79aNIY3jm4lcgYn7Hm2X6ky6oAU512JU3xuGlKlbs2BruEz1lMp2ruOc3k3Ty%2B3xlY%2FUYOdcZ9wVLwaj3NkRbnwXQguWvn6kstvJzuF7KWyXBtpInfW5nYj4TVWqx1MnOyh%2B9X7ZN1QDRCc4xSXv8sggq4e0JlrrZBhdNiwBjMXsWxSP3I846vKIbSPUDIcEappv3ig%2BBKoIdOwSNpzrN0BneN1VbgG9SurTtDXSinY0nAdL6KeX3KejqyVfgVeKw%2FPpc9UiN%2FjKnOgndmmLjNjTXDsd2FuGQ29FJkdFnJouY59vGbZMtYMWXS4m7cU6c1r3x71MaLyP8Txv5n%2BtOArf%2FL9F3moUqrIOgKl%2Bj5NbYXCrPV3TxSeAJwFDQv1TLtxAwH3NCClGqgZUmroq3dCZTiJFf73v7R7VaUGSgKlvhUXKwpEBQpwmRrZOnu9USQ%2F0V68d5wCBuxUUsChYYAUvOjODMMyZ7E5nkcvHcRGCjonlvmTV%2Bh7PPqVTh4z1z9QgyhrYsypjf9mSnxf3AWc240npEU37yVuWKn%2FWjuqZ9uXazsKEXlZj3qjSsuX79xpmvq1IALg%2BuMJ7ifXGlQLas9JfCbTQzoQIhHqhNJWsylxTvjfyoRmMOiPuqcGOrABlumpqYNYt%2BZZKQGRUf4I9Qi4OXSfy8wmqD6rGlB%2F06OM5k%2FBpQIc5UIhkz4XeDMotploWKjyAsQ5Sr%2Fbx9p6GQ%2B5Y3A%2FmCloifaXpRQnm71OCghYmWue2QuypkitI4aVgWm8F6cEGqI8N6cARq0D3uqDbIcE2%2BtXf3KSbijZ%2BJ3JIPkon7RSGO3PBkEyQ%2FYoLjgzRSxnWo77ZAb1xU29xPVURUwfJwWMio5L2DvZErs%3D&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20230830T003733Z&X-Amz-SignedHeaders=host&X-Amz-Expires=300&X-Amz-Credential=ASIAQ3PHCVTYXKCT224P%2F20230830%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=b6314d45a1118266a241078389697785de7635bdce51c2680315719220664879&hash=1dde83a11067ce1e2146ca8655fb89eb6a0f6d572fd3bf5abd3e66dd5fb3b062&host=68042c943591013ac2b2430a89b270f6af2c76d8dfd086a07176afe7c76c2c61&pii=S0167642312000172&tid=spdf-db5d6b0e-d2e7-41eb-a4f6-4e27bfe5ea91&sid=2de72d1a8db9c94db27b2d177bf102e075c4gxrqb&type=client&tsoh=d3d3LnNjaWVuY2VkaXJlY3QuY29t&ua=0f005704025f00585b52&rr=7fe8f7444aaea90d&cc=in) 
    * [Garbage Collection and Local Variable Type-Precision and Liveness in JavaTM Virtual Machines](https://dl.acm.org/doi/pdf/10.1145/277652.277738) 

* Installed and working with soot but with a few issues, will resolve them or try Sootup(Soot successor).

## 5 Sep 2023

* Most papers have improved on Escape Analysis, Stack Allocation, and Garbage Collection, but not on Liveness Analysis.

* Went over multiple possble papers on the current issue, most relevant below.

* [Heap Profiling for Space-Efficient Java](https://dl.acm.org/doi/pdf/10.1145/378795.378820)
    * Analysis of drag time and possible solutions.
    * Drag time = product of size of object and time the object is reachable and not alive.
    * 2 part analysis of the program : 
        * Analysis of objects and stored into a file
        * Analyse the file producng list of allocatio sites sorted wit potential of drag reduction
    * 3 Optimizations
        * Assigning objects to null
        * Dead Code removal
        * Lazy Allocation
    * Near equal running times but large space optimisation.
    * Main problem, not algorithm to decide null points but is a prior run to decide the null points.

* [Estimating the impact of heap liveness information](https://www.researchgate.net/publication/221032951_Estimating_the_impact_of_heap_liveness_information_on_space_consumption_in_Java)
    * Improvement of the above tool.
    * Requires 1 run of the program to get the liveness information.
    * 1 run marks all points of importance(using stack, static, or heap reference) and are categorized.
    * Then Analysis of liveness takes all reference points as possible null assignment points.
    * At any point the object is used, all prev points are unmarked as possible null assignment points.
    * Last remaining points are the null assignment point.

* Other papers read : 
    * [Garbage Collection and Local Variable Type-Precision and Liveness in $Java^{TM}$ Virtual Machines](https://dl.acm.org/doi/pdf/10.1145/277650.277738)
    * [Lag, drag, void](https://dl.acm.org/doi/10.1145/232627.232633)
    * [Liveness-Garbage Collector, Func Lang](https://link.springer.com/chapter/10.1007/978-3-642-54807-9_5)

### Next Work

* One possible paper describing clear analysis method, to be checked for validity: [IITK Thesis](https://www.cse.iitk.ac.in/users/karkare/MTP/2013-14/vilay2014liveness.pdf)

* Other possible alternatives (both by Sigmund Cherem, Cornell) : 
    * [Region Analysis and Transformation for Java Programs](https://dl.acm.org/doi/10.1145/1029873.1029884)
    * [Compile-time deallocation of individual objects](https://dl.acm.org/doi/10.1145/1133956.1133975)
        * Just a further implementaion of the above

* Soot Compiler

## 19 Sep 2023

* Most work primarily surrounding Region based analysis by Tofte, Birkedal, Talpin

* Built on Functional Language ML
* Well typed expression transformed to region based
    * TE < e -> e', (T, p), phi; phi - supersets of all regions required for eval of e

* Functions modified to take run time parameters containing information based on regions.

* Problems
    * Polymorphic Recursion
    * Poor Results for nested and recursive
    * Storage mode allocation

* Bounding regions by analysis
    * Upper bound of # of values in a given region
    * Finite -> Activation Record
    * Infinite -> Linked List of fixed size region pages

* Stats
    * 10x to 0.25x in speed
    * 0.08x to 3000x in storage
    * If modified to be region friendly, much better performance

* Introduced Region Profiling for data leaks and modules for large pieces of code

* Garbage collection
    * Customized Cheney's Algo 
    * Applied to each region page which are connected to each other
    * All pages connected in region manner will get copied to to-space when 2/3 of the space of the free list is completed.
    * GC + region interface is worse than just RI
    * But it is better than GC individually(without RI).
