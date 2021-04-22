package hw3;

import hw3.list.ArrayIndexedList;
import hw3.list.IndexedList;
import hw3.sort.SortingAlgorithm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class SortingAlgorithmTest {

  private SortingAlgorithm<Integer> unit;

  private static IndexedList<Integer> sample() {
    IndexedList<Integer> indexedList = new ArrayIndexedList<>(8, 0);
    indexedList.put(0, 8);
    indexedList.put(1, 7);
    indexedList.put(2, 6);
    indexedList.put(3, 5);
    indexedList.put(4, 4);
    indexedList.put(5, 3);
    indexedList.put(6, 2);
    indexedList.put(7, 1);
    return indexedList;
  }

  protected abstract SortingAlgorithm<Integer> createSortingAlgorithm();

  @BeforeEach
  public void initSortingAlgorithm() {
    this.unit = createSortingAlgorithm();
  }

  @Test
  @DisplayName("The sorting algorithm sorted the input array sample")
  public void sortSample() {
    IndexedList<Integer> indexedList = sample();
    unit.sort(indexedList);
    assertTrue(SortingAlgorithmDriver.isSorted(indexedList));
  }

  /*  You are NOT required to add more tests here BUT encouraged to do so! */
}
