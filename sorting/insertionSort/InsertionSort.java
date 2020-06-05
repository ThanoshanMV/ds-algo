package sorting.insertionSort;

/**
 * A class that implements Insertion Sort
 */
public class InsertionSort {

    /**
     * Insertion Sort Algorithm
     *
     * In Insertion Sort, we keep track of currentIndex.
     * We make sure that value of currentIndex is relatively sorted
     * with value of currentIndex-1.
     *
     * @param vals: int array
     */
    public static void insertionSort(int[] vals){
        int curInd;
        for (int pos = 1; pos < vals.length; pos++) {
            curInd = pos;
            while (curInd > 0 && vals[curInd] < vals[curInd-1]){
                swap(vals, curInd, curInd-1);
                curInd = curInd-1;
            }
        }
    }

    public static void swap(int[] vals, int curInd, int prevCurInd){
        int temp = vals[curInd];
        vals[curInd] = vals[prevCurInd];
        vals[prevCurInd] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {7,23,16,50,49,2,71,18};
        System.out.println("Before Insertion Sort: ");
        for(int i : arr){
            System.out.print(i+" , ");
        }
        System.out.println("");
        System.out.println("After Insertion Sort: ");
        insertionSort(arr);
        for(int i: arr){
            System.out.print(i+" , ");
        }
    }
}
