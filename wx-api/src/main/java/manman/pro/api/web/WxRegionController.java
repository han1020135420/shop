package manman.pro.api.web;

import manman.pro.core.util.ResponseUtil;
import manman.pro.db.domain.ShopRegion;
import manman.pro.db.service.ShopRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TODO
 *
 * @author hanpeng
 * @create 2018-06-30 17:32
 */
@RestController
@RequestMapping("/wx/region")
public class WxRegionController {

    @Autowired
    private ShopRegionService regionService;

    /**
     * 区域数据
     *
     * 根据父区域ID，返回子区域数据。
     * 如果父区域ID是0，则返回省级区域数据；
     *
     * @param pid 父区域ID
     * @return 区域数据
     *   成功则
     *  {
     *      errno: 0,
     *      errmsg: '成功',
     *      data: xxx
     *  }
     *   失败则 { errno: XXX, errmsg: XXX }
     */
    @GetMapping("list")
    public Object list(Integer pid) {
        if(pid == null){
            return ResponseUtil.badArgument();
        }

        List<ShopRegion> regionList = regionService.queryByPid(pid);
        return ResponseUtil.ok(regionList);
    }
}
