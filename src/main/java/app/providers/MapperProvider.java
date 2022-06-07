package app.providers;

import app.interfaces.IMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class MapperProvider implements IMapper {
    private ObjectMapper mapper = new ObjectMapper();

    public <T>T jsonToObj(String jsonPath, Class<T> type) throws IOException {
        File jsonPathFile = new File(jsonPath);
        return mapper.readValue(jsonPathFile, type);
    }


}
