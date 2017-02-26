import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class FileReplacer {

    private String filename;

    public FileReplacer(String filename) {
        this.filename = filename;
    }

    public String replace(Map<String, String> replacements) throws IOException {
        StringReplacer replacer = new StringReplacer(fileContents());
        return replacer.replace(replacements);
    }

    private String fileContents() throws IOException {
        byte[] bytes =  Files.readAllBytes(Paths.get(filename));
        return new String(bytes);
    }
}
