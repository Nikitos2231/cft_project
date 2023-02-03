import file_exception.IncorrectFileTypeException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ListFiller {

    private final ArrayChecker arrayChecker;

    public ListFiller() {
        this.arrayChecker = new ArrayChecker();
    }

    public void fillTheFileList(List<String> objectList, Path path, String typeSort) throws NoSuchFileException {
        int countErrors = 0;
        List<String> stringList;
        try {
            stringList = Files.readAllLines(path);
        } catch (IOException e) {
            throw new NoSuchFileException("Не удалось найти файл: " + path.getFileName());
        }
        if (typeSort.equals("-i")) {
            for (String elementFile : stringList) {
                try {
                    arrayChecker.isElementValid(elementFile, path, typeSort);
                    arrayChecker.isElementInteger(elementFile, path, typeSort);
                    objectList.add(elementFile);
                } catch (IncorrectFileTypeException e) {
                    countErrors += 1;
                    e.printStackTrace();
                }
            }
        }
        else {
            for (String elementFile : stringList) {
                try {
                    arrayChecker.isElementValid(elementFile, path, typeSort);
                    arrayChecker.isElementString(elementFile, path, typeSort);
                    objectList.add(elementFile);
                } catch (IncorrectFileTypeException e) {
                    countErrors += 1;
                    e.printStackTrace();
                }
            }
        }
        if (countErrors != 0) {
            System.out.println("В файле с названием " + path.getFileName() + " не удалось обработать " + countErrors + " значений");
        }

    }

}
