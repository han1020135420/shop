package manman.pro.db.service;

import com.github.pagehelper.PageHelper;
import manman.pro.db.dao.ShopGoodsMapper;
import manman.pro.db.domain.ShopGoods;
import manman.pro.db.domain.ShopGoods.Column;
import manman.pro.db.domain.ShopGoodsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author hanpeng
 * @create 2018-06-30 10:52
 */
@Service
public class ShopGoodsService {
    @Autowired
    private ShopGoodsMapper goodsMapper;


    public List<ShopGoods> queryByNew(int offset, int limit) {
        ShopGoodsExample example = new ShopGoodsExample();
        example.or().andIsNewEqualTo(true).andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return goodsMapper.selectByExample(example);
    }

    public List<ShopGoods> queryByHot(int offset, int limit) {
        ShopGoodsExample example = new ShopGoodsExample();
        example.or().andIsHotEqualTo(true).andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return goodsMapper.selectByExample(example);
    }

    public List<ShopGoods> queryByCategory(List<Integer> catList, int offset, int limit) {
        ShopGoodsExample example = new ShopGoodsExample();
        example.or().andCategoryIdIn(catList).andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return goodsMapper.selectByExample(example);
    }

    public List<ShopGoods> queryByCategory(Integer catId, int offset, int limit) {
        ShopGoodsExample example = new ShopGoodsExample();
        example.or().andCategoryIdEqualTo(catId).andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return goodsMapper.selectByExample(example);
    }

    public ShopGoods findById(Integer id) {
        ShopGoodsExample example = new ShopGoodsExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(false);
        return goodsMapper.selectOneByExampleWithBLOBs(example);
    }

    public List<ShopGoods> querySelective(Integer catId, Integer brandId, String keyword, Integer isHot, Integer isNew, Integer offset, Integer limit, String sort) {
        ShopGoodsExample example = new ShopGoodsExample();
        ShopGoodsExample.Criteria criteria = example.createCriteria();

        if(catId != null && catId != 0){
            criteria.andCategoryIdEqualTo(catId);
        }
        if(brandId != null){
            criteria.andBrandIdEqualTo(brandId);
        }
        if(isNew != null){
            criteria.andIsNewEqualTo(isNew.intValue() == 1);
        }
        if(isHot != null){
            criteria.andIsHotEqualTo(isHot.intValue() == 1);
        }
        if(keyword != null){
            criteria.andKeywordsLike("%" + keyword + "%");
        }
        criteria.andDeletedEqualTo(false);

        if(sort != null){
            example.setOrderByClause(sort);
        }
        if(limit != null && offset != null) {
            PageHelper.startPage(offset, limit);
        }

        Column[] columns = new Column[]{Column.id, Column.name, Column.listPicUrl, Column.retailPrice};
        return goodsMapper.selectByExampleSelective(example ,columns);
    }

    public int countSelective(Integer catId, Integer brandId, String keyword, Integer isHot, Integer isNew, Integer page, Integer size, String sortWithOrder) {
        ShopGoodsExample example = new ShopGoodsExample();
        ShopGoodsExample.Criteria criteria = example.createCriteria();

        if(catId != null){
            criteria.andCategoryIdEqualTo(catId);
        }
        if(brandId != null){
            criteria.andBrandIdEqualTo(brandId);
        }
        if(isNew != null){
            criteria.andIsNewEqualTo(isNew.intValue() == 1);
        }
        if(isHot != null){
            criteria.andIsHotEqualTo(isHot.intValue() == 1);
        }
        if(keyword != null){
            criteria.andKeywordsLike("%" + keyword + "%");
        }
        criteria.andDeletedEqualTo(false);

        return (int)goodsMapper.countByExample(example);
    }

    public List<Integer> getCatIds(Integer brandId, String keyword, Integer isHot, Integer isNew) {
        ShopGoodsExample example = new ShopGoodsExample();
        ShopGoodsExample.Criteria criteria = example.createCriteria();

        if(brandId != null){
            criteria.andBrandIdEqualTo(brandId);
        }
        if(isNew != null){
            criteria.andIsNewEqualTo(isNew.intValue() == 1);
        }
        if(isHot != null){
            criteria.andIsHotEqualTo(isHot.intValue() == 1);
        }
        if(keyword != null){
            criteria.andKeywordsLike("%" + keyword + "%");
        }
        criteria.andDeletedEqualTo(false);

        List<ShopGoods> goodsList = goodsMapper.selectByExampleSelective(example, Column.categoryId);
        List<Integer> cats = new ArrayList<Integer>();
        for(ShopGoods goods : goodsList){
            cats.add(goods.getCategoryId());
        }
        return cats;
    }

    public Integer queryOnSale() {
        ShopGoodsExample example = new ShopGoodsExample();
        example.or().andIsOnSaleEqualTo(true).andDeletedEqualTo(false);
        return (int)goodsMapper.countByExample(example);
    }
}
