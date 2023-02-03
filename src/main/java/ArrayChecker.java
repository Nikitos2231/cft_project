import file_exception.IncorrectFileTypeException;

import java.nio.file.Path;
import java.util.regex.Pattern;

public class ArrayChecker {

    public void isElementInteger(String element, Path path, String typeOfSort) throws IncorrectFileTypeException {
        if (!Pattern.matches("^(\\d+[\\n\\r]?)$" ,element)) {
            throw new IncorrectFileTypeException("Вы указали параметр " + typeOfSort + ", но файл с именем: "
                    + path.getFileName() + " не соответствует заданному типу");
        }
    }

    public void isElementValid(String element, Path path, String typeOfSort) throws IncorrectFileTypeException {
        if (!Pattern.matches("^(\\d+[\\n\\r]?)$", element) && !Pattern.matches("^([^\\s]+[\\n\\r]?)$", element)) {
            throw new IncorrectFileTypeException("Вы указали параметр " + typeOfSort + ", но файл с именем: "
                    + path.getFileName() + " не соответствует заданному типу");
        }
    }


    public void isElementString(String element, Path path, String typeOfSort) throws IncorrectFileTypeException {
        if (!Pattern.matches("^([^\\s]+[\\n\\r]?)$", element)) {
            throw new IncorrectFileTypeException("Вы указали параметр " + typeOfSort + ", но файл с именем: "
                    + path.getFileName() + " не соответствует заданному типу");
        }
    }

}
