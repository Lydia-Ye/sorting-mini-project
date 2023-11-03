import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author Lydia Ye
 */

public class InsertionSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new InsertionSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  InsertionSort() {
  } // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array using the insertion sort algorithm.
   */
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    insertionSort(values, 0, values.length, order);
  } // sort(T[], Comparator<? super T>

  /**
   * A helper method for sort using insertion sort algorithm.
   */
  static <T> void insertionSort(T[] values, int lo, int hi, 
                                Comparator<? super T> order) {
    int length = hi - lo;
    for (int i = lo + 1; i < length; i++) {
      T current = values[i];

      // compare current with previous sorted elements to find the correct 
      // position of current value
      while ((i - 1) >= 0 && (order.compare(values[i - 1], current) > 0)) {
        values[i] = values[i - 1];
        i--;
      } // while

      // copy current value to the correct postion
      values[i] = current;                  
    } // for
  } // insertionSort()
} // class InsertionSort
