import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author Lydia Ye
 */

public class InsertionSort implements Sorter {

  public static void main(String[] args) {
    Integer[] original = { 1, 4, 4, 5, 1, 5, 6, 3, 6, 3};
    SORTER.sort(original, (x, y) -> x == y ? 0 : x < y ? -1 : 1);

    for (int i =0; i<original.length; i++) {
      System.out.println(original[i]);
    }
  }

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
