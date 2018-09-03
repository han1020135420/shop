package manman.pro.os.service;

import org.springframework.core.io.Resource;

import java.io.InputStream;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * TODO
 *
 * @author hanpeng
 * @create 2018-06-30 10:27
 */
public interface StorageService {
    void store(InputStream inputStream, String filename);

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    void delete(String filename);
}
