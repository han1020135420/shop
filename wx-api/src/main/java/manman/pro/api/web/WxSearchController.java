package manman.pro.api.web;

import manman.pro.api.annotation.LoginUser;
import manman.pro.core.util.ResponseUtil;
import manman.pro.db.domain.ShopKeyword;
import manman.pro.db.domain.ShopSearchHistory;
import manman.pro.db.service.ShopKeywordService;
import manman.pro.db.service.ShopSearchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author hanpeng
 * @create 2018-06-30 17:33
 */
@RestController
@RequestMapping("/wx/search")
public class WxSearchController {

    @Autowired
    private ShopKeywordService keywordsService;
    @Autowired
    private ShopSearchHistoryService searchHistoryService;

    /**
     * 搜索页面信息
     *
     * 如果用户已登录，则给出用户历史搜索记录。
     *
     * @param userId 用户ID
     * @return 搜索页面信息
     *   成功则
     *  {
     *      errno: 0,
     *      errmsg: '成功',
     *      data:
     *      {
     *          defaultKeyword: xxx,
     *          historyKeywordList: xxx,
     *          hotKeywordList: xxx
     *      }
     *  }
     *  失败则 { errno: XXX, errmsg: XXX }
     */
    @GetMapping("index")
    public Object index(@LoginUser Integer userId) {
        //取出输入框默认的关键词
        ShopKeyword defaultKeyword = keywordsService.queryDefault();
        //取出热闹关键词
        List<ShopKeyword> hotKeywordList = keywordsService.queryHots();

        List<ShopSearchHistory> historyList = null;
        if(userId != null) {
            //取出用户历史关键字
            historyList = searchHistoryService.queryByUid(userId);
        }

        Map<String, Object> data = new HashMap();
        data.put("defaultKeyword", defaultKeyword);
        data.put("historyKeywordList", historyList);
        data.put("hotKeywordList", hotKeywordList);
        return ResponseUtil.ok(data);
    }

    /**
     * 关键字提醒
     *
     * 当用户输入关键字一部分时，可以推荐系统中合适的关键字。
     *
     * @param keyword 关键字
     * @return 合适的关键字
     *   成功则
     *  {
     *      errno: 0,
     *      errmsg: '成功',
     *      data: xxx
     *  }
     *   失败则 { errno: XXX, errmsg: XXX }
     */
    @GetMapping("helper")
    public Object helper(String keyword) {
        if(keyword == null){
            return ResponseUtil.badArgument();
        }

        Integer page = 1;
        Integer size = 10;
        List<ShopKeyword> keywordsList = keywordsService.queryByKeyword(keyword, page, size);
        String[] keys = new String[keywordsList.size()];
        int index = 0;
        for (ShopKeyword key : keywordsList) {
            keys[index++] = key.getKeyword();
        }
        return ResponseUtil.ok(keys);
    }

    /**
     * 关键字清理
     *
     * 当用户输入关键字一部分时，可以推荐系统中合适的关键字。
     *
     * @param userId 用户ID
     * @return 清理是否成功
     *   成功则 { errno: 0, errmsg: '成功' }
     *   失败则 { errno: XXX, errmsg: XXX }
     */
    @PostMapping("clearhistory")
    public Object clearhistory(@LoginUser Integer userId) {
        if(userId == null){
            return ResponseUtil.unlogin();
        }

        searchHistoryService.deleteByUid(userId);
        return ResponseUtil.ok();
    }
}
