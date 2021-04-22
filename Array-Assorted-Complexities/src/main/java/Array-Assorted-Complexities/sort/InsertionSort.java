package hw3.sort;


import hw3.list.IndexedList;

/**
 * The Insertion Sort algorithm, with minimizing swaps optimization.
 *
 * @param <T> Element type.
 */
public final class InsertionSort<T extends Comparable<T>>
    implements SortingAlgorithm<T> {

  private boolean less(T a, T b) {
    return a.compareTo(b) < 0;
  }

  @Override
  public void sort(IndexedList<T> indexedList) {

    int i = 1;
    int j;
    while (i < indexedList.length()) {
      T x = indexedList.get(i);
      j = i - 1;
      while (j >= 0 && less(x, indexedList.get(j))) {
        indexedList.put(j + 1, indexedList.get(j));
        j = j - 1;
      }
      indexedList.put(j + 1, x);
      i = i + 1;
    }

  }

  @Override
  public String name() {
    return "Insertion Sort";
  }
}
