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

## 26th Sep 2023

* Went over the Cornell paper[link](https://dl.acm.org/doi/10.1145/1029873.1029884)

* The summary of the paper: 
    * Region based analysis based on points-to analysis.
    * Stack allocation on non-escaping objects.

* Stats
    * The static analysis takes up 16% of total compilation time(including soot and i/o of files).
    * Wrt memory management, the analysis is slightly worse than a dynamic GC on average. 
    * For applications which use significantly less memory, RA is significantly better than GC as GC is set to be called at higher memory intervals.
    * For short lived memory regions RA > GC
    * For long lived memory regions GC > RA
    * For most programs RA < GC by small factor.

* The analysis is divided into 3 parts: Points-to Analysis, Region Liveness Analysis and Region Translation.
* Points-to Analysis modified in format of Region based analysis creates segments the program into regions using flow-insensitve, context-sensitive analysis.
* Region Liveness Analysis is a flow-sensitive, inter-procedural analysis to determine the region of each object at each program point.
* Region Translation is a translation of the program to include region annotations for the final piece of code

* Stack allocation is also included similar to previous work on escape analysis, but with a few changes.
* There is a system of bounded allocations where between the creation and deletion of a region, if there is a bounded limit of memory which can be allocated, then the memory is allocated on the stack.

* Significant portion of inter region analysis is similar to implementations by Talpin, Birkedal, Tofte.

## 3rd Oct 2023

### Work to be done

* Presentation of paper of Cornell - Thursday, Friday, Saturday, Sunday
* Reading of these papers: 
    * [Cornell](https://dl.acm.org/doi/10.1145/1029873.1029884) - Extensive Reading
    * [Free-Me](https://dl.acm.org/doi/10.1145/1133255.1134024) 
    * [Conditional correlation analysis for safe region-based memory management](https://dl.acm.org/doi/10.1145/1375581.1375588) 
    * [Safe and efficient hybrid memory management for Java](https://dl.acm.org/doi/10.1145/2754169.2754185) 
 
## 10th Oct 2023

* Presentation of Cornell paper is mostly done, need to iron out some inconsistencies discussed during it and finish up with Cornell paper.
* Reading of Free-Me paper in completion - 8th Oct
* Creating Presentation - 9th Oct
* Presentation of Free-Me paper - 10th Oct

## 21th October 2023

* Spent most of the week doing a final run for paper search related to compile-time deallocation of memory.
* Looked at all ref/cited of any related paper along with work done by profs frequenting this field.
* Found other papers with similar methods as we discussed before using a flow-insensitive + flow,context-sensitive approach.
    * Most of them have the same conclusion with not as efficient as GC and only good for short-lived objects.
    * Points-to Analysis based papers have low performance wrt GC and aren't sufficient for compile time evaluation(Conclusion in one of the papers)

* Found a few papers which may have some relevance on heap memory management and analysis techniques which could be used to build something similar with more efficiency:
    * [IITB Heap Reference](https://dl.acm.org/doi/pdf/10.1145/1290520.1290521)
    * [Madrid Spain Heap Reference](https://dl.acm.org/doi/pdf/10.1145/1296907.1296922)
    * [Flow Control UTAustin](http://z.cs.utexas.edu/users/osa/laminar/pubs/pldi161-roy.pdf)
    * [Data-Structure Information](https://dl.acm.org/doi/pdf/10.1145/2754169.2754176)

* The only relevant papers with different approach and results are:
    * [Compile-Time Deallocation of Individual Objects](https://dl.acm.org/doi/pdf/10.1145/1133956.1133975)
    * [Uniqueness Inference for Compile-Time Object Deallocation](https://dl.acm.org/doi/pdf/10.1145/1296907.1296923)

* Both of the papers papers are by Sigmund Cherem and Radu Rugina: The same duo for Region Based Analysis paper I presented.

### Compile-Time Deallocation of Individual Objects

* Individual object recollection using free() statements for objects
* Tracks the state of one object at a time form allocation site till the last use of the object and it is no longer reachable.
* Built on the [Shape Analysis](https://dl.acm.org/doi/abs/10.1145/1047659.1040331)
* Went over the algorithm to a basic understanding.

### Base algorithm details

* It tracks each heap cell from a region of memory(from stack or heap) and keeps a reference count(k) of the given cell.
* Also another parameter t for each object which how far does each object gets tracked till it is not dealt with and is left to the GC.
    * This means this method does not deal with long-lived objects as they are too expensive to track.
* Another parameter for holding count
    * r = 0 -> Set of variables to refer to the object
    * r = 1 -> Set of variables and its fields refer to the object

### Results 

* The parameters k, t, r are set to 1, 30, 0 for most efficient results.
    * k = 1, means only objects which are referred once are tracked and are freed.
    * t = 30, means long-lived objects are not dealt with and left to the GC.

* Analysis for this basic parameter set take very long upto 70% of total compilation time.

* Integrated with GC shows improvement of 7-8% less memory allocated at given time. Upto 26% for small heaps
* Small run-time overhead but large compile-time overhead.

* Doesn't deal with long lived objects like prev iterations.

### Uniqueness Inference for Compile-Time Object Deallocation

* In the middle of reading this paper. Will update further.
* Haven't finished the algorithm yet. It is more complex than the previous paper.

* Does an analysis of uniqueness of an object at any given point in the program.
* If the unique refernce is overwritten or the variable dies, the object is freed.
* Better results on Heap size during runtime with much less analysis time during compilation.
* Will have to go over the algorithm in detail to see how it deals with long-lived objects and collection classes.



## 31 Oct 2023

* Compile-Time Deallocation of Individual Objects
    * Thought of manipulating the necessary bounds to get better results
    * But program is based on reference counts of each object.
    * Not related
    
* Uniqueness Inference for Compile-Time Object Deallocation
    * Based on the similar principle of reference count of the object.
    * Only deals with checking if an object has only one reference and has object deletion methods in place when the unique reference is overwritten
    * Primary outcome of the above: Recursive deallocation of objects efficiently when parent node is overwritten causing entire heap structure to be efficiently removed.

* Any papers cited by of relevance go toward memory leaks and resource leaks.

* Went over the previous papers read dealing with an algorithm with a flow-insensitive and flow,context-sensitive approach.
    * Most of them have the same conclusion with not as efficient as GC and only good for short-lived objects.
    * Points-to Analysis based papers have low performance wrt GC and aren't sufficient for compile time evaluation(Conclusion in one of the papers)

* Looking for papers on dealing with memory leaks
    * Most memory leak based on unused references are dealt with on runtime analysis tools.
    * [CLOSER](https://dl.acm.org/doi/abs/10.1145/1375634.1375636) - Resource management tool
    * [SAVER](https://dl.acm.org/doi/pdf/10.1145/3377811.3380323) - Primarily double free and use after free; for unused references, intraprocedural
    * [MemFix](https://dl.acm.org/doi/pdf/10.1145/3236024.3236079) - Deals primarily with double frees in C

* Most algorithms with points-to + liveness analysis deal with short-lived objects and are not efficient for long-lived objects.
* To make an algorithm for long-lived objects, we need to have a sense of the lifetime of the object.

* say for the case obj is a long lived object, and obj.f = obj2. If obj2 is a short lived reference and obj.f is never used we can do to things.
    * Delinking: obj.f = null at the last use of obj.f
    * obj = null at last use of the object itself

* For delinking obj.f we need to see all the use points of obj.f throughout the program.
* Track the class methods which utilize obj.f and track the use of either the methods or obj.f itself in code blocks.
* To add unlinking for the object, we need interprocedural liveness analysis, the prime factor missing in the above papers.

## Algorithm Ideas

### Algo 1 - Dealing with the object in its scope or higher only

* For Context insensitive summary of function to find out use/def, we must always take the conservative case where all parameters, return value and this is live at the end of the method which can't find the last use of the object.
* Rather we can map liveness of the objects just after the call to the caller function and do a context sensitive analysis.
* Either we deal with unallocating the object's field at the scope of allocation of the object or higher.

### Algo 2 - Extending Region based analysis interprocedural liveness analysis

* Assumes P = {param, ret, this} is live to start off with and taking all possible method calls it the program, conservatively remove the objects which are not live a end of every method.

### Algo 3

* Or we modify each method call saying it will be the last time the object will be called.
* Something similar to a check variable which if true will free the given field.
* Here a context insensitive analysis could identify spots where a given field could be freed and modify the code accordingly.
* We can employ a context insensitive analysis to find out if any field of parameter objects are used in the method and their last points of use in the method.
* If we take P = {param, ret, this}. We check for uses of v $\in$ P or v.f $\in$ P used in the method and determine their last use points by liveness analysis.
* We add check parameters for all these cases even into nested function calls - Not sure how yet

### To be done

* Need to learn with how to deal with liveness information including heap objects and var references.
* Once liveness information for var, references is understood, we can build use/def for each method.
* After that, similar liveness analysis for each method can determine last use points for var, references.