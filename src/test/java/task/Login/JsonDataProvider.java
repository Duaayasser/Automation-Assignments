package task.Login;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import task.Utils.LoginData;

public class JsonDataProvider {

    private static List<LoginData> loadJsonData() throws Exception {
        Gson gson = new Gson();
        FileReader reader = new FileReader("src\\TestData\\testData.json");

        Type type = new TypeToken<List<LoginData>>() {}.getType();
        List<LoginData> list = gson.fromJson(reader, type);
        reader.close();
        return list;
    }

    @DataProvider(name = "validData")
    public Object[][] validData() throws Exception {
        return new Object[][] { { loadJsonData().get(0) } };
    }

    @DataProvider(name = "invalidCredentialsData")
    public Object[][] invalidCredentialsData() throws Exception {
        return new Object[][] { { loadJsonData().get(1) } };
    }

    @DataProvider(name = "missingPasswordData")
    public Object[][] missingPasswordData() throws Exception {
        return new Object[][] { { loadJsonData().get(2) } };
    }
}
