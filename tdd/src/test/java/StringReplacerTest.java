import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.emptyMap;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StringReplacerTest {

    public static final Map<String, String> NO_REPLACEMENTS = emptyMap();

    @Test
    public void does_nothing_with_empty_source() throws Exception {
        StringReplacer replacer = new StringReplacer("");

        String result = replacer.replace(NO_REPLACEMENTS);

        assertThat(result, is(""));
    }

    @Test
    public void does_nothing_when_no_replacements() throws Exception {
        StringReplacer replacer = new StringReplacer("Some content");

        String result = replacer.replace(NO_REPLACEMENTS);

        assertThat(result, is("Some content"));
    }

    @Test
    public void does_replacement() throws Exception {
        StringReplacer replacer = new StringReplacer("Hello ${name}!");
        Map<String, String> replacements = new HashMap<String,String>() {
            {
                put("name", "Erinda");
            }
        };

        String result = replacer.replace(replacements);

        assertThat(result, is("Hello Erinda!"));
    }
}