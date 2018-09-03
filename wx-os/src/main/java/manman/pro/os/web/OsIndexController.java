package manman.pro.os.web;

import manman.pro.core.util.ResponseUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author hanpeng
 * @create 2018-06-30 10:18
 */
@RestController
@RequestMapping("/os/index")
public class OsIndexController {

    private final Log logger = LogFactory.getLog(OsIndexController.class);

    @RequestMapping("/index")
    public Object index(){
        return ResponseUtil.ok("hello world, this is os service");
    }
}
