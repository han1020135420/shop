package manman.pro.db.dao;

import java.util.List;
import manman.pro.db.domain.ShopTopic;
import manman.pro.db.domain.ShopTopicExample;
import org.apache.ibatis.annotations.Param;

public interface ShopTopicMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_topic
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    long countByExample(ShopTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_topic
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    int deleteByExample(ShopTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_topic
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_topic
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    int insert(ShopTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_topic
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    int insertSelective(ShopTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_topic
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    ShopTopic selectOneByExample(ShopTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_topic
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    ShopTopic selectOneByExampleSelective(@Param("example") ShopTopicExample example, @Param("selective") ShopTopic.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_topic
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    ShopTopic selectOneByExampleWithBLOBs(ShopTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_topic
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<ShopTopic> selectByExampleSelective(@Param("example") ShopTopicExample example, @Param("selective") ShopTopic.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_topic
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    List<ShopTopic> selectByExampleWithBLOBs(ShopTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_topic
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    List<ShopTopic> selectByExample(ShopTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_topic
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    ShopTopic selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") ShopTopic.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_topic
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    ShopTopic selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_topic
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    ShopTopic selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_topic
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    int updateByExampleSelective(@Param("record") ShopTopic record, @Param("example") ShopTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_topic
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    int updateByExampleWithBLOBs(@Param("record") ShopTopic record, @Param("example") ShopTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_topic
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    int updateByExample(@Param("record") ShopTopic record, @Param("example") ShopTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_topic
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    int updateByPrimaryKeySelective(ShopTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_topic
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(ShopTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_topic
     *
     * @mbg.generated Thu Jun 28 18:05:45 CST 2018
     */
    int updateByPrimaryKey(ShopTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_topic
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByExample(@Param("example") ShopTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_topic
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByPrimaryKey(Integer id);
}