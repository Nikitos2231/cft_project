import sort.IntegerSorter;
import sort.StringSorter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileCreator {

    private final ArrayConverter arrayConverter;

    public FileCreator() {
        arrayConverter = new ArrayConverter();
    }

    public boolean createAndFillNewFile(List<String> stringList, String typeArr, String outFile, String typeSort) throws IOException {
            if (typeArr.equals("-i")) {
                return fillArrayIntegers(stringList, outFile, typeSort);
            }
            else {
                return fillArrayStrings(stringList, outFile, typeSort);
            }
    }

    public boolean fillArrayIntegers(List<String> stringList, String outFile, String parameterSort) throws IOException {
        int[] array = arrayConverter.getIntArray(stringList);
        IntegerSorter integerSorter = new IntegerSorter();
        integerSorter.mergeSort(array, array.length, parameterSort);
        return fillOutFileMassIntegers(array, outFile);
    }

    public boolean fillArrayStrings(List<String> stringList, String outFile, String parameterSort) throws IOException {
        StringSorter arraySorter = new StringSorter();
        String[] array = arrayConverter.getStringArray(stringList);
        arraySorter.mergeSort(array, array.length, parameterSort);
        return fillOutFileMassStrings(array, outFile);
    }

    private boolean fillOutFileMassIntegers(int[] array, String outFile) throws IOException {
        try (FileWriter fileWriter = new FileWriter(outFile); BufferedWriter outputWriter = new BufferedWriter(fileWriter)) {
            for (int i = 0; i < array.length; i++) {
                outputWriter.write(String.valueOf(array[i]));
                outputWriter.newLine();
            }
            fileWriter.flush();
            outputWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Не удалось найти указанный путь до файла " + outFile);
            return false;
        }
        return true;
    }

    private boolean fillOutFileMassStrings(String[] array, String outFile) throws IOException {

        try (FileWriter fileWriter = new FileWriter(outFile); BufferedWriter outputWriter = new BufferedWriter(fileWriter)) {
            for (int i = 0; i < array.length; i++) {
                outputWriter.write(array[i]);
                outputWriter.newLine();
            }
            fileWriter.flush();
            outputWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Не удалось найти указанный путь до файла " + outFile);
            return false;
        }
        return true;
    }
}
