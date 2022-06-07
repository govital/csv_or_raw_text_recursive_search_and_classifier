package app.interfaces;

import java.io.IOException;

public interface IMapper {
    <T>T jsonToObj(String jsonPath, Class<T> type) throws IOException;
}
