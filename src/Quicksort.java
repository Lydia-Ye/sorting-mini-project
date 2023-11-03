import java.util.Comparator;

/**
 * Sort using Quicksort.
 *
 * @author Lydia Ye
 * @author Julian Kim (for the parts finished in class for quick sort lab)
 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  Quicksort() {
  } // Quicksort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array using quick sort algorithm.
   */
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    quickSort(values, order, 0, values.length);
  } // sort(T[], Comparator<? super T>

  /**
   * A helper method for sort using quick sort algorithm.
   */
  private static <T> void quickSort(T[] values, Comparator<? super T> compare, int lb, int ub) {
    /* Base case */
    if (ub - lb <= 1) {
      return;
    } // if
    
    /* Recursive case */
    int pivotIndex = partition(values, compare, lb, ub);
    quickSort(values, compare, lb, pivotIndex);
    quickSort(values, compare, pivotIndex, ub);
  } // quickSort(T[], Comparator, int, int)

  /**
   * Select a pivot and partition the subarray from [lb .. ub) into 
   * the following form.
   *
   * <pre>
   * ---+-----------------+-+----------------+---
   *    | values <= pivot |p| values > pivot |
   * ---+-----------------+-+----------------+---
   *    |                 |                  |
   *    lb                pivotLoc           ub
   * </pre>
   *
   * @return pivotLoc.
   */
  public static <T> int partition(T[] arr, Comparator<? super T> compare, int lb, int ub) {
    int pivotIndex = (lb + ub) / 2;
    swap(arr, lb, pivotIndex);
    T pivot = arr[lb];

    int small = lb + 1;
    int large = ub;

    while(small < large) {
      T lowerValue = arr[small];
      T upperValue = arr[large - 1];

      if (compare.compare(lowerValue, pivot) <= 0) {
        small++;
      } else if (compare.compare(upperValue, pivot) > 0) {
        large--;
      } else {
        swap(arr, small, large - 1);
      } // if ... else
    } // while

    swap(arr, lb, small - 1);
    return small - 1;
  } // partition(T[],Comparator<? super T>, int, int)

  private static <T> void swap(T[] values, int i, int j) {
    T temp = values[i];
    values[i] = values[j];
    values[j] = temp;
  } // swap(T[], int, int)
} // class Quicksort
