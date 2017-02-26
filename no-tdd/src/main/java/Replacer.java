import java.util.Map;
import java.util.Map.Entry;

public class Replacer {

    private Source source;

    public Replacer(Source source) {
        this.source = source;
    }

    public String replace(Map<String, String> replacements) throws Exception {
        String result = source.getContents();
        for (Entry<String, String> replacement : replacements.entrySet()) {
            result = result.replace("${" + replacement.getKey() + "}", replacement.getValue());
        }
        return result;
    }
}
