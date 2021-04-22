package hw3.list;

import exceptions.IndexException;

/**
 * An ArrayIndexedList that is able to report the number of
 * accesses and mutations, as well as reset those statistics.
 *
 * @param <T> The type of the array.
 */
public class MeasuredIndexedList<T> extends ArrayIndexedList<T>
    implements Measured<T> {

  private int acs;
  private int muts;

  /**
   * Constructor for a MeasuredIndexedList.
   *
   * @param size         The size of the array.
   * @param defaultValue The initial value to set every object to in the array..
   */
  public MeasuredIndexedList(int size, T defaultValue) {
    super(size, defaultValue);
    acs = 0;
    muts = 0;
    // 
  }

  @Override
  public int length() {
    return super.length();
  }

  @Override
  public T get(int index) {

    //acs = acs + 1;
    T theVal = super.get(index);
    acs = acs + 1;
    return theVal;
  }

  @Override
  public void put(int index, T value) throws IndexException {

    super.put(index, value);
    muts = muts + 1;
  }

  @Override
  public void reset() {
    //
    acs = 0;
    muts = 0;
  }

  @Override
  public int accesses() {
    return acs; //
  }

  @Override
  public int mutations() {
    return muts; //
  }

  @Override
  public int count(T value) {
    int count = 0;
    int i;

    for (i = 0; i < length(); i++) {
      if (MeasuredIndexedList.this.get(i) == value) {
        count = count + 1;
        //acs--;
      }
    }
    //acs = acs - i;
    //MeasuredIndexedList.this.reset();

    return count; //
  }

}
