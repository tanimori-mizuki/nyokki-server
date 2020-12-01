package com.example.mapper;

import com.example.domain.Todo;
import com.example.domain.TodoExample;
import com.example.domain.User;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * XMLファイル上のSQLを呼び出すクラス(myBatisGeneratorで自動生成)
 * 
 * @author fuka DIコンテナに入れるため、手動でアノテーションを追加
 */
@Mapper
public interface TodoMapper {

	/**
	 * 全てのtodoデータを出力する(NOT generated by MyBatis Generator)
	 * 
	 * @return todoデータ一覧
	 */
	List<Todo> findAll(Integer userId,Date date);

	/**
	 * userIdと完了statusと日付を利用してtodoを検索
	 * @param date
	 * @param status
	 * @param userId
	 * @return
	 */
	List<Todo> todosFindByDayAndStatusAndUserId(Date date, Integer status, Integer userId);
	
	/**
	 * タスク内容でtodoの一意の検索
	 * @return
	 */
	Todo selectByTask(String task);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table todoes
	 *
	 * @mbggenerated Wed Nov 11 00:15:42 JST 2020
	 */
	int countByExample(TodoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table todoes
	 *
	 * @mbggenerated Wed Nov 11 00:15:42 JST 2020
	 */
	int deleteByExample(TodoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table todoes
	 *
	 * @mbggenerated Wed Nov 11 00:15:42 JST 2020
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table todoes
	 *
	 * @mbggenerated Wed Nov 11 00:15:42 JST 2020
	 */
	int insert(Todo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table todoes
	 *
	 * @mbggenerated Wed Nov 11 00:15:42 JST 2020
	 */
	int insertSelective(Todo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table todoes
	 *
	 * @mbggenerated Wed Nov 11 00:15:42 JST 2020
	 */
	List<Todo> selectByExample(TodoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table todoes
	 *
	 * @mbggenerated Wed Nov 11 00:15:42 JST 2020
	 */
	Todo selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table todoes
	 *
	 * @mbggenerated Wed Nov 11 00:15:42 JST 2020
	 */
	int updateByExampleSelective(@Param("record") Todo record, @Param("example") TodoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table todoes
	 *
	 * @mbggenerated Wed Nov 11 00:15:42 JST 2020
	 */
	int updateByExample(@Param("record") Todo record, @Param("example") TodoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table todoes
	 *
	 * @mbggenerated Wed Nov 11 00:15:42 JST 2020
	 */
	int updateByPrimaryKeySelective(Todo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table todoes
	 *
	 * @mbggenerated Wed Nov 11 00:15:42 JST 2020
	 */
	int updateByPrimaryKey(Todo record);
}