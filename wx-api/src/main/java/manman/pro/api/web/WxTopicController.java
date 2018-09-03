package manman.pro.api.web;

import manman.pro.core.util.ResponseUtil;
import manman.pro.db.domain.ShopTopic;
import manman.pro.db.service.ShopTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author hanpeng
 * @create 2018-06-30 17:38
 */
@RestController
@RequestMapping("/wx/topic")
public class WxTopicController {

    @Autowired
    private ShopTopicService topicService;

    /**
     * 专题列表
     *
     * @param page 分页页数
     * @param size 分页大小
     * @return 专题列表
     *   成功则
     *  {
     *      errno: 0,
     *      errmsg: '成功',
     *      data:
     *          {
     *              data: xxx,
     *              count: xxx
     *          }
     *  }
     *   失败则 { errno: XXX, errmsg: XXX }
     */
    @GetMapping("list")
    public Object list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                       @RequestParam(value = "size", defaultValue = "10") Integer size) {
        List<ShopTopic> topicList = topicService.queryList(page, size);
        int total = topicService.queryTotal();
        Map<String, Object> data = new HashMap();
        data.put("data", topicList);
        data.put("count", total);
        return ResponseUtil.ok(data);
    }

    /**
     * 专题详情
     *
     * @param id 专题ID
     * @return 专题详情
     *   成功则
     *  {
     *      errno: 0,
     *      errmsg: '成功',
     *      data: xxx
     *  }
     *   失败则 { errno: XXX, errmsg: XXX }
     */
    @GetMapping("detail")
    public Object detail(Integer id) {
        if(id == null){
            return ResponseUtil.badArgument();
        }

        ShopTopic topic = topicService.findById(id);
        return ResponseUtil.ok(topic);
    }

    /**
     * 相关专题
     *
     * @param id 专题ID
     * @return 相关专题
     *   成功则
     *  {
     *      errno: 0,
     *      errmsg: '成功',
     *      data: xxx
     *  }
     *   失败则 { errno: XXX, errmsg: XXX }
     */
    @GetMapping("related")
    public Object related(Integer id) {
        if(id == null){
            return ResponseUtil.badArgument();
        }

        List<ShopTopic> topicRelatedList = topicService.queryRelatedList(id, 0, 4);
        return ResponseUtil.ok(topicRelatedList);
    }
}
