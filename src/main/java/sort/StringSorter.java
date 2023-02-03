package sort;

public class StringSorter {

    public void mergeSort(String[] array, int arrayLength, String typeSort) {
        if (arrayLength < 2) {
            return;
        }

        int middleIndex = arrayLength / 2;
        String[] leftArray = new String[middleIndex];
        String[] rightArray = new String[arrayLength - middleIndex];

        System.arraycopy(array, 0, leftArray, 0, middleIndex);
        if (arrayLength - middleIndex >= 0)
            System.arraycopy(array, middleIndex, rightArray, 0, arrayLength - middleIndex);

        mergeSort(leftArray, leftArray.length, typeSort);
        mergeSort(rightArray, rightArray.length, typeSort);

        merge(array, leftArray, rightArray, leftArray.length, rightArray.length, typeSort);
    }

    private void merge(String[] array, String[] leftArray, String[] rightArray, int leftArraySize, int rightArraySize, String typeSort) {

        int leftArrayPointer = 0;
        int rightArrayPointer = 0;
        int arrayPointer = 0;

        while (leftArrayPointer < leftArraySize && rightArrayPointer < rightArraySize) {
            if (typeSort.equals("-a")) {
                if (leftArray[leftArrayPointer].compareTo(rightArray[rightArrayPointer]) < 0) {
                    array[arrayPointer++] = leftArray[leftArrayPointer++];
                }
                else {
                    array[arrayPointer++] = rightArray[rightArrayPointer++];
                }
            }
            else {
                if (leftArray[leftArrayPointer].compareTo(rightArray[rightArrayPointer]) > 0) {
                    array[arrayPointer++] = leftArray[leftArrayPointer++];
                }
                else {
                    array[arrayPointer++] = rightArray[rightArrayPointer++];
                }
            }
        }

        while (leftArrayPointer < leftArraySize) {
            array[arrayPointer++] = leftArray[leftArrayPointer++];
        }

        while (rightArrayPointer < rightArraySize) {
            array[arrayPointer++] = rightArray[rightArrayPointer++];
        }
    }

}
