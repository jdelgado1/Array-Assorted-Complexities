# Discussion

## PART A: MEASURED IndexedList

1. **Discuss from a design perspective whether or not iterating over a `MeasuredIndexedList` should affect the accesses 
and mutation counts. Note that for the purposes of this assignment we are NOT asking you to rewrite the 
`ArrayIndexedListIterator` to do so. However, if you wanted to include the `next()` and/or `hasNext()` 
methods in the statistics measured, can you inherit `ArrayIndexedListIterator` from `ArrayIndexedList` 
and override the relevant methods, or not? Explain.**

. The accesses counts will be affected because the next element has to be accessed somehow. The 
  mutations counts should not be affected because you are inherit the indexed list and use super in the other methods and are really
  only adding variable to track the mutations or put functions or acceses, which are get functions.
  To iterate through a measuredIndexList, you would have to acceses the data of the next index, and the data can be accessed directly so if access are affected
  becomes a question if accesseing this data directly, without the get ufcntion should count as an access, and I feel like it should since the get function also just access the value in the same way, and it literally 
  has to access what is stored after the vcurrent value.
   You can't inherit the ArrayIndexedListIterator to override the relevant methods inside it because the ArrayIndexedListIterator class is private, and this prevents
   users from overriding the methods inside this private class. Only protected or public methods can be used in the desired way. the MeasuredIndexed List class can't inherit
   the ArrayIndexedListIterator because it does not have access to this class since it's private. 


## PART B: ALL SORT OF SORTS

1. **Explain the mistake in the setup/implementation of the experiment is set up and implemented which resulted in a discrepancy between the results and what is expected from each sorting algorithm.**
There is a mistake in the data that the experiment uses. In the descending data file,
Some of the values don't fit how the data file is intended to be, since the number right after
a number ending in 0 is a number with one less digit which would then mean that the value after the
misplaced number is about 10 times greater, but in reality, it should just be one less than the previous number. 
This problem was seen in how selection sort had less accesses and mutations as well as a shorter run time with the worst case scenario
portrayed by the descending data, than it did when the data was already sorted. Also, the isSorted method is not properly implemented because
the previous value was compared to the current value in a way to return false if it is bigger and the default case being true. It would be more suitable to return true
only when the previous value is less than the current value, the default being false or unsorted. The way they compare strings can lead to errors, in the compareTo as 
well, some values may not be compared where theyre sbecause of type


2. **Does the actual running time correspond to the asymptotic complexity as you would expect?**
There seems to be no obvious correlation but in fact they do run less than the asymptomatic complexity O(n^2) the upper bound measure for the wrost case scenario, or about a function of 4000^2 since that is the input value. Other factors are like steps for given scenarios, whether already sorted or
the complete opposite also influence the differing run times 


3. **What explains the practical differences between these algorithms? (Theoretically, the algorithm runs in O(X) time, where X is a function of the input size, but in practice (i.e running it on datasets), you may observe that it is slower/faster compared to the other algorithms)**
The number of steps are what differentiate these algorithms  as well as the lower order terms for other steps. Algorithms generally with more complex steps for the needed sort, like bubble sort performance for random data performs generally performs slower than the others because it must compare a pair
and swap if out of order for every repetition needed, while insertion sort has much considers a much smaller part of the list after each iteration that it orders a pair, since it divided the list into a sorted and unsorted sides. Selection sort works differently as it s=works by selecting the smallest element and then
places is it in the first position of a subset (the way you think of it) that is in order. It keeps on selecting the next smalles element and then repeating the process with the same complexity however using O(n swaps) in the worst case while bubble sort has the same Asymptomatic complexity O(n^2) for swaps in the worst case.
Insertion sort, takes the element and inserts in into its place in the left sorted part of the array and repeats for every element also having O(n^2) swaps in the worst case scenario 
  


4. **Does it matter what kind of data (random, already sorted in ascending order, sorted in descending order) you are sorting? How should each algorithm behave (in terms of performance) based on the type of data it receives?**
In terms of performance, 
The data matters in the sense that some sorts will be better at sorting different types of data. For example
bubble sort would be the best ar sorting data that is in ascending order because it works by finding the value that is the smallest and bring it 
to the left side or the front. In ascending order, all the values are where theyre supposed to be and bubble sort uses the least step making one comparison between the 
first element and the one after. Insertion sort seems to be the best sort to use for random data, other than gnome sort,  because of the lower runs times, since it accesses and mutates
less data due to the having to the value that needs to be moved forward to the one before it and then repeat this until its bigger than element before it or it reaches the front in the worst
case scenario. Like selection sort, there would be a total of n(n-1)/2 comparisons and swaps, but with much fewer acceses. Selection sort sorts similary for a worst case scenario as run times are generally not too far off for descending order having the same swaps and accesses. In general, 
slection sort works worst in the best case with a complexity of O(n^2) while bubble and insertion have a shorter run time which is often the case because with 4000  = n, slection sort runs at 0.529 wheeras bubble is 0.52 and insertion is 0.03. But bubble and selection are not too far off. Gnome sort performs the worst. For worts case, bbuel performs worse because of the more steps needed for swaps 
checked for the inner loop. In this example running at 0.0682 while the others insertion at 0.067 and selection at 0.046 because of the number of swaps lower than oter sorts in the worst case scenario with only o(n) also because it removes the element of the unsorted part ot the end of sorted part


## PART C: ANALYSIS OF SELECTION SORT

1. Determine exactly how many comparisons C(n) and assignments A(n) are performed by this implementation of selection sort in the worst case. Both of those should be polynomials of degree 2 since you know that the asymptotic complexity of selection sort is O(n^2).
c(n) is n^2 - n - 1/ A(n) is n^2 + 5n - 5
First counting. 
3rd line : n for < length - 1
The first loop runs n-1 times but compares one more time than it runs
The second for loop repeats n(n-1)/2 times because of number of iterations
 of the first loop as well
5th: n(n-1)/2 + (n-1) for j < a.length since there's one more comparison at the end (1/2n^2 - 1/2n + n - 1 + n)
6th: n(n-1)/2 for a[j] > a[max] (+1/2n^2 + 3/2n +1/2n^2 - 1/2n - 1) = n^2 - n - 1

Now Assignment
3: 1 for i = 0, n - 1 for i ++ (1+n-1)
4: 1 * n-1 for max = i (n + n-1)
5: n - 1 for j = 0, n(n-1)/2 for j++ (2n-1 + n - 1) --> (3n-2 + 1/2n^2 - 1/2n)
7: n(n-1)/2 for max = j (5/2n + 1/2n^2 - 2) (n^2 + 2n -2)
10: n-1 for temp = a[i]; (n-1) (n^2 + 3n -3)
11: n-1 for a[i] = a[max]; (n-1) (n^2 + 4n -4)
12: n-1 for a[max] = temp; (n-1) (n^2 + 5n -5)
