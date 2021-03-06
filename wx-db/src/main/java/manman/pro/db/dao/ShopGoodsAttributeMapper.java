package manman.pro.db.dao;

import java.util.List;
import manman.pro.db.domain.ShopGoodsAttribute;
import manman.pro.db.domain.ShopGoodsAttributeExample;
import org.apache.ibatis.annotations.Param;

public interface ShopGoodsAttributeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_goods_attribute
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    long countByExample(ShopGoodsAttributeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_goods_attribute
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    int deleteByExample(ShopGoodsAttributeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_goods_attribute
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_goods_attribute
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    int insert(ShopGoodsAttribute record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_goods_attribute
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    int insertSelective(ShopGoodsAttribute record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_goods_attribute
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    ShopGoodsAttribute selectOneByExample(ShopGoodsAttributeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_goods_attribute
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    ShopGoodsAttribute selectOneByExampleSelective(@Param("example") ShopGoodsAttributeExample example, @Param("selective") ShopGoodsAttribute.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_goods_attribute
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<ShopGoodsAttribute> selectByExampleSelective(@Param("example") ShopGoodsAttributeExample example, @Param("selective") ShopGoodsAttribute.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_goods_attribute
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    List<ShopGoodsAttribute> selectByExample(ShopGoodsAttributeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_goods_attribute
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    ShopGoodsAttribute selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") ShopGoodsAttribute.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_goods_attribute
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    ShopGoodsAttribute selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_goods_attribute
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    ShopGoodsAttribute selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_goods_attribute
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    int updateByExampleSelective(@Param("record") ShopGoodsAttribute record, @Param("example") ShopGoodsAttributeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_goods_attribute
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    int updateByExample(@Param("record") ShopGoodsAttribute record, @Param("example") ShopGoodsAttributeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_goods_attribute
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    int updateByPrimaryKeySelective(ShopGoodsAttribute record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_goods_attribute
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    int updateByPrimaryKey(ShopGoodsAttribute record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_goods_attribute
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByExample(@Param("example") ShopGoodsAttributeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_goods_attribute
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByPrimaryKey(Integer id);
}