import command_errors.*;

import java.util.regex.Pattern;

public class CommandParser {

    public void checkAmountCommand(String[] arrayCommand) throws InvalidAmountCommandException {
        if (arrayCommand.length < 3) {
            throw new InvalidAmountCommandException("Вы ввели неверное количество команд, пожалуйста, проверьте, правильность введенных данных");
        }
    }

    public boolean checkCommandOnFirstArgument(String[] arrayCommand) throws CommandException {
        if (arrayCommand[0].equals("-a") || arrayCommand[0].equals("-d")) {
            if (arrayCommand[1].equals("-s") || arrayCommand[1].equals("-i")) {
                if (Pattern.matches("^(.+\\.txt)$", arrayCommand[2])) {
                    int amountFiles = arrayCommand.length - 3;
                    if (amountFiles > 0) {
                        for (int i = 3; i < arrayCommand.length; i++) {
                            if (!Pattern.matches("^(.+\\.txt)$", arrayCommand[i])) {
                                throw new IncorrectInFileNameException("Неверное название входных файлов, проверьте, что вы указали у каждого файла расширение .txt");
                            }
                        }
                        return true;
                    }
                    else {
                        throw new IncorrectAmountInFilesException("Неправильное количество входных файлов, проверьте, что вы указали хотя бы 1 входной файл");
                    }
                }
                else {
                    throw new IncorrectOutFileNameException("Неправильно введено имя выходного файла, проверьте, что оно оканчивается на .txt");
                }
            }
            else {
                throw new InvalidSecondArgumentException("Неправильно введены аргументы");
            }
        }
        return false;
    }

    public boolean checkCommandsWithoutFirstArgument(String[] arrayCommand) throws CommandException {
        if (arrayCommand[0].equals("-s") || arrayCommand[0].equals("-i")) {
            if (Pattern.matches("^(.+\\.txt)$", arrayCommand[1])) {
                int amountFiles = arrayCommand.length - 2;
                if (amountFiles > 0) {
                    for (int i = 2; i < arrayCommand.length; i++) {
                        if (!Pattern.matches("^(.+\\.txt)$", arrayCommand[i])) {
                            throw new IncorrectInFileNameException("Неверное название входных файлов, проверьте, что вы указали у каждого файла расширение .txt");
                        }
                    }
                    return true;
                }
                else {
                    throw new IncorrectAmountInFilesException("Неправильное количество входных файлов, проверьте, что вы указали хотя бы 1 входной файл");
                }
            }
            else {
                throw new IncorrectOutFileNameException("Неправильно введено имя выходного файла, проверьте, что оно оканчивается на .txt");
            }
        }
        else {
            throw new InvalidFirstArgumentException("Неправильно введен первый аргумент, проверьте, что вначале вы ввели одну из следующих команд: -i, -s, -a, -d");
        }
    }
}
