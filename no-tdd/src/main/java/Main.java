import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        String filename = args[0];
        Map<String, String> replacements = parseReplacements(args[1]);
        Replacer replacer = new Replacer(new FileSource(filename));
        String result = replacer.replace(replacements);
        System.out.println(result);
    }

    private static Map<String, String> parseReplacements(String json) {
        return new Gson().fromJson(json, new TypeToken<HashMap<String, String>>(){}.getType());
    }

}
