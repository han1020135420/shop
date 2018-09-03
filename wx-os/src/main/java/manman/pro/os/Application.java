package manman.pro.os;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * TODO
 *
 * @author hanpeng
 * @create 2018-06-30 10:10
 */
@SpringBootApplication(scanBasePackages = {"manman.pro.core","manman.pro.db","manman.pro.os"})
@MapperScan("manman.pro.db.dao")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
