import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import static java.nio.charset.Charset.defaultCharset;
import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

public class StringReplacer {

    private String filename;

    public StringReplacer(String filename) {
        this.filename = filename;
    }

    public String replace(Map<String, String> replacements) throws IOException {
        String result = fileContents();
        for (Entry<String, String> replacement : replacements.entrySet()) {
            result = result.replace("${" + replacement.getKey() + "}", replacement.getValue());
        }
        return result;
    }

    private String fileContents() throws IOException {
        byte[] bytes = readAllBytes(get(filename));
        return new String(bytes, defaultCharset());
    }
}
