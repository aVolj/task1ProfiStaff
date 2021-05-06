package ru.volodichev;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileHandler {
    //Тип искомого файла. Если не задавать, то ищет все файлы
    static String typeFile = "";
    private List<String> listName = new ArrayList<String>();

    public String getTypeFile() {
        return typeFile;
    }

    public void setTypeFile(String typeFile) {
        FileHandler.typeFile = typeFile;
    }

    public void sortListFileNames() {

        listName = listName.stream().sorted(String::compareToIgnoreCase).collect(Collectors.toList());
    }

    public void printToFile() throws FileNotFoundException, UnsupportedEncodingException {

        PrintWriter writer = new PrintWriter("file-name.txt", "UTF-8");
        listName.stream().forEach(writer::println);
        writer.close();
    }

    /**
     * Метод поиска файлов в папке и во всех подпапках
     *
     * @param dir - директория в которой производится поиск
     */
    public void getAllNamesToFile(File dir) throws FileNotFoundException, UnsupportedEncodingException {
        if (dir.isDirectory()) {
            // получаем все вложенные объекты в каталоге
            for (File item : dir.listFiles()) {
                if (item.isDirectory()) {
                    getAllNamesToFile(item);
                } else {
                    String nameFile = item.getName();
                    if (nameFile.endsWith(typeFile)) {
                        listName.add(nameFile);
                    }
                }
            }
        }
        sortListFileNames();
        printToFile();
    }
}
