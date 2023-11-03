import java.util.Comparator;

/**
 * Sort using YeLydia Sort, a modified version of Tim sort algorithm.
 *
 * @author Lydia Ye
 */

public class YeLydiaSort implements Sorter {
  
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new YeLydiaSort();
  static final int MIN_MERGE = 32;
  int runLength = MIN_MERGE;


  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  YeLydiaSort() {
  } // YeLydiaSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array using the main idea of Timsort.
   */
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    yeLydiaSort(values,0, values.length, order);
  } // sort(T[], Comparator<? super T>

  // +-----------------+---------------------------------------------
  // | Local utilities |
  // +-----------------+

  /**
   * A helper method for sort based on merge sort algorithm.
   */
  public <T> void yeLydiaSort(T[] vals, int lo, int hi, Comparator<? super T> order) {
    // Divide the array into runs and use insertion sort to sort each run.
    for (int start = lo; start < hi; start += this.runLength) {
      int end = Math.min(start + this.runLength, hi);
      InsertionSort.insertionSort(vals, start, end, order);
    } // for

    // Merge the sorted runs using merge sort.
    for (int split = this.runLength; split < hi - lo; split = 2 * split) {
      for (int start = lo; start < hi; start += 2 * split) {
        int mid = start + split - 1;
        int end = Math.min(start + 2 * split - 1, hi - 1);
        MergeSort.merge(vals, start, mid, end, order);
      } // for
    } // for
  } // yeLydiaSort
} // class YeLydiaSort
