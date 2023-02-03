package sort;

public class IntegerSorter {

    public void mergeSort(int[] array, int arrayLength, String typeSort) {
        if (arrayLength < 2) {
            return;
        }

        int middleIndex = arrayLength / 2;
        int[] leftArray = new int[middleIndex];
        int[] rightArray = new int[arrayLength - middleIndex];

        System.arraycopy(array, 0, leftArray, 0, middleIndex);
        for (int i = middleIndex; i < arrayLength; i++) {
            rightArray[i - middleIndex] = array[i];
        }

        mergeSort(leftArray, leftArray.length, typeSort);
        mergeSort(rightArray, rightArray.length, typeSort);

        merge(array, leftArray, rightArray, leftArray.length, rightArray.length, typeSort);
    }

    private void merge(int[] array, int[] leftArray, int[] rightArray, int leftArraySize, int rightArraySize, String typeSort) {

        int leftArrayPointer = 0;
        int rightArrayPointer = 0;
        int arrayPointer = 0;

        while (leftArrayPointer < leftArraySize && rightArrayPointer < rightArraySize) {
            if (typeSort.equals("-a")) {
                if (leftArray[leftArrayPointer] <= rightArray[rightArrayPointer]) {
                    array[arrayPointer++] = leftArray[leftArrayPointer++];
                }
                else {
                    array[arrayPointer++] = rightArray[rightArrayPointer++];
                }
            }
            else {
                if (leftArray[leftArrayPointer] > rightArray[rightArrayPointer]) {
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
