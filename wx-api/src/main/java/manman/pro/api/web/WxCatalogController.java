package manman.pro.api.web;

import manman.pro.core.util.ResponseUtil;
import manman.pro.db.domain.ShopCategory;
import manman.pro.db.service.ShopCategoryService;
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
 * @create 2018-06-30 14:12
 */
@RestController
@RequestMapping("/wx/catalog")
public class WxCatalogController {

    @Autowired
    private ShopCategoryService categoryService;

    /**
     * 分类栏目
     *
     * @param id 分类类目ID
     *    如果分类类目ID是空，则选择第一个分类类目。
     *    需要注意，这里分类类目是一级类目
     * @param page 分页页数
     * @param size 分页大小
     * @return 分类栏目
     *   成功则
     *  {
     *      errno: 0,
     *      errmsg: '成功',
     *      data:
     *          {
     *              categoryList: xxx,
     *              currentCategory: xxx,
     *              currentSubCategory: xxx
     *          }
     *  }
     *   失败则 { errno: XXX, errmsg: XXX }
     */
    @GetMapping("index")
    public Object index(Integer id,
                        @RequestParam(value = "page", defaultValue = "1") Integer page,
                        @RequestParam(value = "size", defaultValue = "10") Integer size) {

        // 所有一级分类目录
        List<ShopCategory> l1CatList = categoryService.queryL1();

        // 当前一级分类目录
        ShopCategory currentCategory = null;
        if(id != null){
            currentCategory = categoryService.findById(id);
        }
        else{
            currentCategory = l1CatList.get(0);
        }

        // 当前一级分类目录对应的二级分类目录
        List<ShopCategory> currentSubCategory = null;
        if (null != currentCategory) {
            currentSubCategory = categoryService.queryByPid(currentCategory.getId());
        }

        Map<String, Object> data = new HashMap();
        data.put("categoryList", l1CatList);
        data.put("currentCategory", currentCategory);
        data.put("currentSubCategory", currentSubCategory);
        return ResponseUtil.ok(data);
    }

    /**
     * 当前分类栏目
     *
     * @param id 分类类目ID
     * @return 当前分类栏目
     *   成功则
     *  {
     *      errno: 0,
     *      errmsg: '成功',
     *      data:
     *          {
     *              currentCategory: xxx,
     *              currentSubCategory: xxx
     *          }
     *  }
     *   失败则 { errno: XXX, errmsg: XXX }
     */
    @GetMapping("current")
    public Object current(Integer id) {
        if(id == null){
            return ResponseUtil.badArgument();
        }

        // 当前分类
        ShopCategory currentCategory = categoryService.findById(id);
        List<ShopCategory> currentSubCategory = categoryService.queryByPid(currentCategory.getId());

        Map<String, Object> data = new HashMap();
        data.put("currentCategory", currentCategory);
        data.put("currentSubCategory", currentSubCategory);
        return ResponseUtil.ok(data);
    }
}
