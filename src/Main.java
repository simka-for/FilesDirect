import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        File path = new File ("D:/test");   // Устанавливаем свой путь

        Long size = Files.walk(path.toPath()).         // Поток всех файлов по введенному пути
                map(Path::toFile)                   // Проходим по всем файлам
                .filter(File::isFile)               // Проверяет является ли объект файлом
                .mapToLong(File::length).sum();     // Считает размер файла и суммирует с остальными

        System.out.println(getFileSizeMb(size));
    }

    private static String getFileSizeMb(Long size){                                     // Вывод в мегабайтах
        return  "Размер директории = " + (double) size/(1024*1024) + "mb";
    }
    private static String getFileSizeGb(Long size) {                                   // Вывод в гигабайтах
        return "Размер директории = " + (double) size / (1024 * 1024 * 1024) + "gb";
    }
}
