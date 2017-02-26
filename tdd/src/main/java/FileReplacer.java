import java.io.IOException;
import java.util.Map;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

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
        byte[] bytes =  readAllBytes(get(filename));
        return new String(bytes);
    }
}
