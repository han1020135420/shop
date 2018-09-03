package manman.pro.api.web;

import manman.pro.core.util.ResponseUtil;
import manman.pro.db.domain.*;
import manman.pro.db.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author hanpeng
 * @create 2018-06-30 10:50
 */
@RestController
@RequestMapping("/wx/home")
public class WxHomeController {

    @Autowired
    private ShopAdService adService;
    @Autowired
    private ShopGoodsService goodsService;
    @Autowired
    private ShopBrandService brandService;
    @Autowired
    private ShopTopicService topicService;
    @Autowired
    private ShopCategoryService categoryService;

    @GetMapping("/index")
    public Object index(){
        Map<String, Object> data = new HashMap<>();
        List<ShopAd> banner = adService.queryByApid(1);
        data.put("banner", banner);

        List<ShopCategory> channel = categoryService.queryChannel();
        data.put("channel", channel);

        List<ShopGoods> newGoods = goodsService.queryByNew(0, 4);
        data.put("newGoodsList", newGoods);

        List<ShopGoods> hotGoods = goodsService.queryByHot(0, 3);
        data.put("hotGoodsList", hotGoods);

        List<ShopBrand> brandList = brandService.query(0,4);
        data.put("brandList", brandList);

        List<ShopTopic> topicList = topicService.queryList(0, 3);
        data.put("topicList", topicList);

        List<Map> categoryList = new ArrayList<>();
        List<ShopCategory> catL1List = categoryService.queryL1WithoutRecommend(0, 6);
        for (ShopCategory catL1 : catL1List) {
            List<ShopCategory> catL2List = categoryService.queryByPid(catL1.getId());
            List<Integer> l2List = new ArrayList<>();
            for (ShopCategory catL2 : catL2List) {
                l2List.add(catL2.getId());
            }

            List<ShopGoods> categoryGoods = null;
            if(l2List.size() == 0){
                categoryGoods = new ArrayList<>();
            }
            else{
                categoryGoods = goodsService.queryByCategory(l2List, 0, 5);
            }

            Map catGoods = new HashMap();
            catGoods.put("id", catL1.getId());
            catGoods.put("name", catL1.getName());
            catGoods.put("goodsList", categoryGoods);
            categoryList.add(catGoods);
        }
        data.put("floorGoodsList", categoryList);

        return ResponseUtil.ok(data);
    }
}
