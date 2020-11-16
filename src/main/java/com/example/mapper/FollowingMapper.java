package com.example.mapper;

import com.example.domain.Following;
import com.example.domain.FollowingExample;
import com.example.domain.User;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * XMLファイル上のSQLを呼び出すクラス(myBatisGeneratorで自動生成)
 * 
 * @author fuka
 *DIコンテナに入れるため、手動でアノテーションを追加
 */
@Mapper
public interface FollowingMapper {
	
	/**
	 * 全てのusersデータを出力する(NOT generated by MyBatis Generator)
	 * @return usersデータ一覧
	 */
	List<Following> findAll();
	
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table followings
     *
     * @mbggenerated Wed Nov 11 00:25:22 JST 2020
     */
    int countByExample(FollowingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table followings
     *
     * @mbggenerated Wed Nov 11 00:25:22 JST 2020
     */
    int deleteByExample(FollowingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table followings
     *
     * @mbggenerated Wed Nov 11 00:25:22 JST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table followings
     *
     * @mbggenerated Wed Nov 11 00:25:22 JST 2020
     */
    int insert(Following record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table followings
     *
     * @mbggenerated Wed Nov 11 00:25:22 JST 2020
     */
    int insertSelective(Following record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table followings
     *
     * @mbggenerated Wed Nov 11 00:25:22 JST 2020
     */
    List<Following> selectByExample(FollowingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table followings
     *
     * @mbggenerated Wed Nov 11 00:25:22 JST 2020
     */
    Following selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table followings
     *
     * @mbggenerated Wed Nov 11 00:25:22 JST 2020
     */
    int updateByExampleSelective(@Param("record") Following record, @Param("example") FollowingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table followings
     *
     * @mbggenerated Wed Nov 11 00:25:22 JST 2020
     */
    int updateByExample(@Param("record") Following record, @Param("example") FollowingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table followings
     *
     * @mbggenerated Wed Nov 11 00:25:22 JST 2020
     */
    int updateByPrimaryKeySelective(Following record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table followings
     *
     * @mbggenerated Wed Nov 11 00:25:22 JST 2020
     */
    int updateByPrimaryKey(Following record);
}