import java.util.List;

public class ArrayConverter {

    public int[] getIntArray(List<String> stringList) {
        int[] intArray = new int[stringList.size()];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = Integer.parseInt(stringList.get(i));
        }
        return intArray;
    }

    public String[] getStringArray(List<String> stringList) {
        String[] intArray = new String[stringList.size()];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = stringList.get(i);
        }
        return intArray;
    }
}
