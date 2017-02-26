import java.util.Map;
import java.util.Map.Entry;

public class StringReplacer {
    private String source;

    public StringReplacer(String source) {
        this.source = source;
    }

    public String replace(Map<String, String> replacements) {
        String result = source;
        for(Entry<String, String> replacement : replacements.entrySet()) {
            result = source.replace("${" + replacement.getKey() + "}", replacement.getValue());
        }
        return result;
    }
}
