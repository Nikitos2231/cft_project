import command_errors.CommandException;
import command_errors.InvalidAmountCommandException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {


        List<String> containsFiles = new ArrayList<>();

        FileCreator fileCreator = new FileCreator();
        CommandParser commandParser = new CommandParser();
        ListFiller listFiller = new ListFiller();

        System.out.println("Здравствуйте, вас приветствует программа для сортировки слиянием значений из разных файлов, с соединением в один файл");
        System.out.println("Введите команды в следующем формате через пробел: ");
        System.out.println("1) -a or -d (сортировка по возрастанию или по убыванию соответственно) (необязательный аргумент)");
        System.out.println("2) -i or -s (тип данных, который вы планируете сортировать) (обязательный аргумент)");
        System.out.println("3) <Имя выходного файла> (при отсутствии файла он создастся автоматически) (обязательный аргумент)");
        System.out.println("4) <Имя выходного файла> ... (файлы, из которых взять данные. Может быть произвольное количество) (обязательный аргумент)");



        String commandLine = Arrays.toString(args).trim()
                .replaceAll("\\s+", " ")
                .replaceAll(",", "")
                .replaceAll("\\[", "")
                .replaceAll("]", "");
        String[] commandStr = commandLine.split(" ");


        try {
            commandParser.checkAmountCommand(commandStr);
        }
        catch (InvalidAmountCommandException e) {
            e.printStackTrace();
            return;
        }
        try {
            if (commandParser.checkCommandOnFirstArgument(commandStr)) {
                for (int i = 3; i < commandStr.length; i++) {
                    listFiller.fillTheFileList(containsFiles, Path.of(commandStr[i]), commandStr[1]);
                }
                if (!fileCreator.createAndFillNewFile(containsFiles, commandStr[1], commandStr[2], commandStr[0])) {
                    return;
                }
                System.out.println("Файлы успешно обработаны и данные помещены в файл: " + commandStr[2]);
            } else if (commandParser.checkCommandsWithoutFirstArgument(commandStr)) {
                for (int i = 2; i < commandStr.length; i++) {
                    listFiller.fillTheFileList(containsFiles, Path.of(commandStr[i]), commandStr[0]);
                }
                if (!fileCreator.createAndFillNewFile(containsFiles, commandStr[0], commandStr[1], "-a")) {
                    return;
                }
                System.out.println("Файлы успешно обработаны и данные помещены в файл: " + commandStr[1]);
            }
        } catch (NoSuchFileException | CommandException e) {
            e.printStackTrace();
        } finally {
            containsFiles.clear();
        }
    }
}
