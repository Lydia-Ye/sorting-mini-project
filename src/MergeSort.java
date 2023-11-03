import java.util.Comparator;

/**
 * Sort using merge sort.
 *
 * @author Lydia Ye
 * @author Jayson Kunkel (for the parts finished in class for merge sort lab)
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {
  } // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array using the merge sort algorithm.
   */
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    int length = values.length;
    mergeSort(values,0, length, order);
  } // sort(T[], Comparator<? super T>

  // +-----------------+---------------------------------------------
  // | Local utilities |
  // +-----------------+

  /**
   * Merge the values from positions [lo..mid) and [mid..hi) back into
   * the same part of the array.
   *
   * Preconditions: Each subarray is sorted accorting to comparator.
   */
  static <T> void merge(T[] vals, int lo, int mid, int hi, Comparator<? super T> comparator) {

    // Create a temporary empty array to store merged vals
    T[] merged = java.util.Arrays.copyOfRange(vals, lo, hi);

    int l = lo; // starting index of left array
    int r = mid; // starting indes of right array
    int i = 0;
    int length = hi - lo;

    // copy elements to merged array in order

    while (l < mid && r < hi){
      if(comparator.compare(vals[l], vals[r]) < 0 || comparator.compare(vals[l], vals[r]) == 0) {
        // item at left array precedes or two items are equal
        merged[i] = vals[l];
        l++;
        i++;
      } else{
        // item at right array precedes
        merged[i] = vals[r];
        r++;
        i++;
      } // if
    } // while
    
    while (i < length) {
      if(l >= mid){ 
        // left array is full, copy all remaining items to right array
        merged[i] = vals[r];
        r++;
        i++;
      } else if(r >= hi){
        // right array is full, copy all remaining items to left array
        merged[i] = vals[l];
        l++;
        i++;
      } // if  
    } // while
          


    // Replace vals with merged array 
    int k = 0;
    for(int j = lo; j < hi; j++){
      vals[j] = merged[k];
      k++;
      
    } // for 
  } // merge

  /**
   * A helper method for sort using merge sort algorithm.
   */
  static <T> void mergeSort(T[] vals, int lo, int hi, Comparator<? super T> comparator) {
    /* Base case */
    if ((hi - lo) <= 1) {
      return;
    } // if

    /* Recursive case */
    int mid = lo + (hi - lo)/2;
    mergeSort(vals, lo, mid, comparator);
    mergeSort(vals, mid, hi, comparator);
    merge(vals, lo, mid, hi, comparator);
  } // mergeSort

} // class MergeSort
