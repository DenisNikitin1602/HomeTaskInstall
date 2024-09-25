import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String basePath = "C:\\Games\\";

        StringBuilder log = new StringBuilder();
        createDir(basePath + "src", log);
        createDir(basePath + "src\\main", log);
        createDir(basePath + "src\\test", log);
        createDir(basePath + "res", log);
        createDir(basePath + "res\\drawables", log);
        createDir(basePath + "res\\vectors", log);
        createDir(basePath + "res\\icons", log);
        createDir(basePath + "savegames", log);
        createDir(basePath + "temp", log);

        createFile(basePath + "src\\main\\Main.java", log);
        createFile(basePath + "src\\main\\Utils.java", log);
        createFile(basePath + "temp\\temp.txt", log);

        try (FileWriter writer = new FileWriter(basePath + "temp\\temp.txt", true)) {
            writer.write(log.toString());
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    private static void createDir(String path, StringBuilder log) {
        File dir = new File(path);
        if (dir.mkdirs()) {
            log.append("Директория ").append(path).append(" успешно создана.\n");
        } else if (dir.exists()) {
            log.append("Директория ").append(path).append(" уже существует.\n");
        } else {
            log.append("Не удалось создать директорию ").append(path).append(".\n");
        }
    }

    private static void createFile(String path, StringBuilder log) {
        File file = new File(path);
        try {
            if (file.createNewFile()) {
                log.append("Файл ").append(path).append(" успешно создан.\n");
            } else {
                log.append("Файл ").append(path).append(" уже существует.\n");
            }
        } catch (IOException e) {
            log.append("Ошибка при создании файла ").append(path).append(": ").append(e.getMessage()).append("\n");
        }
    }
}