package fileProcess_DosyadanDataAlma;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class _01Property {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();

        String file = "src/test/java/fileProcess/_01PropertyFile.properties";

        FileReader fileReader = new FileReader(file);

        properties.load(fileReader);
        System.out.println(properties.getProperty("url"));
        System.out.println(properties.getOrDefault("url1", "yok"));
        fileReader.close();
    }
}
