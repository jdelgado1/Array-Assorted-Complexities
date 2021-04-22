package hw3;

import hw3.list.MeasuredIndexedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MeasuredIndexedListTest {

  private static final int LENGTH = 15;
  private static final int DEFAULT_VALUE = 3;

  private MeasuredIndexedList<Integer> measuredIndexedList;

  @BeforeEach
  void setup() {
    measuredIndexedList = new MeasuredIndexedList<>(LENGTH, DEFAULT_VALUE);
  }

  @Test
  @DisplayName("MeasuredIndexedList starts with zero reads")
  void zeroReadsStart() {
    assertEquals(0, measuredIndexedList.accesses());
  }

  @Test
  @DisplayName("MeasuredIndexedList starts with zero writes")
  void zeroWritesStart() {
    assertEquals(0, measuredIndexedList.mutations());
  }


  @Test
  @DisplayName("MeasuredIndexedList starts with one reads")
  void oneWriteStart() {
    measuredIndexedList.put(1, 8);
    assertEquals(1, measuredIndexedList.mutations());
  }

  @Test
  @DisplayName("MeasuredIndexedList starts with one reads")
  void oneReadStart() {
    measuredIndexedList.get(7);
    assertEquals(1, measuredIndexedList.accesses());
  }

  @Test
  @DisplayName("MeasuredIndexedList mutates 5 same indices with same value")
  void fivePutSameMuts() {
    measuredIndexedList.put(2, 5);
    measuredIndexedList.put(2, 5);
    measuredIndexedList.put(2, 5);
    measuredIndexedList.put(2, 5);
    measuredIndexedList.put(2, 5);
    assertEquals(5, measuredIndexedList.mutations());
  }

  @Test
  @DisplayName("MeasuredIndexedList reads 5 at same index")
  void fiveReadSame() {
    measuredIndexedList.get(2);
    measuredIndexedList.get(2);
    measuredIndexedList.get(2);
    measuredIndexedList.get(2);
    measuredIndexedList.get(2);
    assertEquals(5, measuredIndexedList.accesses());
  }

  @Test
  @DisplayName("MeasuredIndexedList 5 mutations of diff values and indices")
  void fivePutDiffMuts() {
    measuredIndexedList.put(2, 100);
    measuredIndexedList.put(1, 2);
    measuredIndexedList.put(3, 5);
    measuredIndexedList.put(4, 2);
    measuredIndexedList.put(8, 1);
    assertEquals(5, measuredIndexedList.mutations());
  }

  @Test
  @DisplayName("MeasuredIndexedList 5 reads at diff indexes")
  void fiveReadDiff() {
    measuredIndexedList.get(2);
    measuredIndexedList.get(3);
    measuredIndexedList.get(4);
    measuredIndexedList.get(0);
    measuredIndexedList.get(9);
    measuredIndexedList.put(8, 1);
    assertEquals(5, measuredIndexedList.accesses());
  }

  @Test
  @DisplayName("MeasuredIndexedList 5 reads at diff indexes")
  void resets() {
    measuredIndexedList.put(2, 100);
    measuredIndexedList.put(1, 2);
    measuredIndexedList.get(3);
    measuredIndexedList.get(4);
    measuredIndexedList.reset();
    assertEquals(0, measuredIndexedList.accesses());
    assertEquals(0, measuredIndexedList.mutations());
  }

  @Test
  @DisplayName("put() changes the default value after IndexedList is instantiated.")
  void testCountOne() {
    measuredIndexedList.put(5, 8);
    assertEquals(8, measuredIndexedList.get(5));
    assertEquals(1, measuredIndexedList.count(8));
  }

  @Test
  @DisplayName("put() changes the default value after IndexedList is instantiated.")
  void testCountTwo() {
    measuredIndexedList.put(5, 9);
    assertEquals(9, measuredIndexedList.get(5));
    measuredIndexedList.put(14, 9);
    assertEquals(9, measuredIndexedList.get(14));
    assertEquals(2, measuredIndexedList.count(9));
  }

  @Test
  @DisplayName("put() changes the default value after IndexedList is instantiated.")
  void testCountAll3() {
    assertEquals(15, measuredIndexedList.count(3));
  }

  @Test
  @DisplayName("put() changes the default value after IndexedList is instantiated.")
  void testCountNoOtherEffect() {
    measuredIndexedList.put(5, 9);
    assertEquals(9, measuredIndexedList.get(5));
    measuredIndexedList.put(14, 9);
    assertEquals(9, measuredIndexedList.get(14));
    assertEquals(2, measuredIndexedList.count(9));
    assertEquals(17, measuredIndexedList.accesses());
    assertEquals(2, measuredIndexedList.mutations());
  }

  @Test
  @DisplayName("put() changes the default value after IndexedList is instantiated.")
  void testCountNoOtherEffectNone() {
    assertEquals(0, measuredIndexedList.count(30));
  }

  // TODO Add more tests
}
