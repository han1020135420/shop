package manman.pro.db.dao;

import java.util.List;
import manman.pro.db.domain.ShopUserCoupon;
import manman.pro.db.domain.ShopUserCouponExample;
import org.apache.ibatis.annotations.Param;

public interface ShopUserCouponMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_user_coupon
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    long countByExample(ShopUserCouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_user_coupon
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    int deleteByExample(ShopUserCouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_user_coupon
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_user_coupon
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    int insert(ShopUserCoupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_user_coupon
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    int insertSelective(ShopUserCoupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_user_coupon
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    ShopUserCoupon selectOneByExample(ShopUserCouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_user_coupon
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    ShopUserCoupon selectOneByExampleSelective(@Param("example") ShopUserCouponExample example, @Param("selective") ShopUserCoupon.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_user_coupon
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<ShopUserCoupon> selectByExampleSelective(@Param("example") ShopUserCouponExample example, @Param("selective") ShopUserCoupon.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_user_coupon
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    List<ShopUserCoupon> selectByExample(ShopUserCouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_user_coupon
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    ShopUserCoupon selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") ShopUserCoupon.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_user_coupon
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    ShopUserCoupon selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_user_coupon
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    ShopUserCoupon selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_user_coupon
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    int updateByExampleSelective(@Param("record") ShopUserCoupon record, @Param("example") ShopUserCouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_user_coupon
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    int updateByExample(@Param("record") ShopUserCoupon record, @Param("example") ShopUserCouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_user_coupon
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    int updateByPrimaryKeySelective(ShopUserCoupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_user_coupon
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    int updateByPrimaryKey(ShopUserCoupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_user_coupon
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByExample(@Param("example") ShopUserCouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_user_coupon
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByPrimaryKey(Integer id);
}