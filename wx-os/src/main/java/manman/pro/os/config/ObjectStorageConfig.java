package manman.pro.os.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author hanpeng
 * @create 2018-06-30 10:16
 */
@Component
@ConfigurationProperties(prefix = "manman.pro.os")
public class ObjectStorageConfig {

    private String address;

    private String port;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
