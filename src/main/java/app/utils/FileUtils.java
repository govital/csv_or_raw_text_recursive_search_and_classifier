package app.utils;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class FileUtils {

    public String getExtension(String fileName){
        return FilenameUtils.getExtension(fileName);
    }

    /**
     * This method does something extremely useful ...
     *
     * @param path to file or directory
     * @throws IOException if error reading from provided location
     */
    public List<Path> getPaths(String path) throws IOException {
        List<Path> paths = new ArrayList<>();
        if (new File(path).isDirectory()) {
                Files.walk(Paths.get(path)).forEach(
                        fileName ->
                                paths.add(fileName)
                );
        }else if (new File(path).isFile()){
            paths.add(Paths.get(path));
        }
        return paths;
    }
}
