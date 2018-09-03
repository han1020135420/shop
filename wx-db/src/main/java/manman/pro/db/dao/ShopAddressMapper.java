package manman.pro.db.dao;

import java.util.List;
import manman.pro.db.domain.ShopAddress;
import manman.pro.db.domain.ShopAddressExample;
import org.apache.ibatis.annotations.Param;

public interface ShopAddressMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_address
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    long countByExample(ShopAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_address
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    int deleteByExample(ShopAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_address
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_address
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    int insert(ShopAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_address
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    int insertSelective(ShopAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_address
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    ShopAddress selectOneByExample(ShopAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_address
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    ShopAddress selectOneByExampleSelective(@Param("example") ShopAddressExample example, @Param("selective") ShopAddress.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_address
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<ShopAddress> selectByExampleSelective(@Param("example") ShopAddressExample example, @Param("selective") ShopAddress.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_address
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    List<ShopAddress> selectByExample(ShopAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_address
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    ShopAddress selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") ShopAddress.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_address
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    ShopAddress selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_address
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    ShopAddress selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_address
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    int updateByExampleSelective(@Param("record") ShopAddress record, @Param("example") ShopAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_address
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    int updateByExample(@Param("record") ShopAddress record, @Param("example") ShopAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_address
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    int updateByPrimaryKeySelective(ShopAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_address
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    int updateByPrimaryKey(ShopAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_address
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByExample(@Param("example") ShopAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_address
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByPrimaryKey(Integer id);
}