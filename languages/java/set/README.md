# Set
 - Is a set of elements
 - HashSet the faster, dont maintain the order of elements
 - LinkedHashSet more slow then HashSet maintain the insertion order of elements
 - TreeSet more slow then LinkedHashSet short the elements and maintain the order

## How equals works in set
 - It compares hashcode, if returns true, a comparison is made using equals method
 - If HashCode and equals is not in class, set made comparison using pointer

## How TreeSet compare your own elements
 - It uses compareTo method, in your elements, their class must have Comparable interface implemented