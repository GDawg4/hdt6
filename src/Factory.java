import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Factory {

    public Map<String, String> getMap(String type) {
        if (type == null) {
            return null;
        }
        if (type == "1") {
            return new HashMap<>();

        } else if (type == "2") {
            return new TreeMap<>();

        } else if (type == "3") {
            return new LinkedHashMap<>();
        }
        else{
            return null;
        }
    }
}
