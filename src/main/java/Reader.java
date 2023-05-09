import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public static <T> List<T> reader(Class<T> entityClass, String filePath) {
        List<T> jsonList = new ArrayList<>();
        try (FileReader fileReader = new FileReader(filePath)) {
            Type type = TypeToken.getParameterized(List.class, entityClass).getType();
            jsonList = new Gson().fromJson(fileReader, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonList;
    }
}
