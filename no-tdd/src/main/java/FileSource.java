import java.io.IOException;

import static java.nio.charset.Charset.defaultCharset;
import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

public class FileSource implements Source {

    private String filename;

    public FileSource(String filename) {
        this.filename = filename;
    }

    public String getContents() throws IOException {
        byte[] bytes = readAllBytes(get(filename));
        return new String(bytes, defaultCharset());
    }
}
