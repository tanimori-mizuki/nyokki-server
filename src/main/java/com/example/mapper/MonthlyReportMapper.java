package com.example.mapper;


import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.domain.MonthlyReport;
import com.example.domain.MonthlyReportExample;

/**
 * XMLファイル上のSQLを呼び出すクラス(myBatisGeneratorで自動生成)
 * 
 * @author fuka
 *DIコンテナに入れるため、手動でアノテーションを追加
 */
@Mapper
public interface MonthlyReportMapper {
	
	/**
	 * 月報をuserIdで検索するメソッド.
	 * 
	 * @param userId
	 * @return 月報情報
	 */
	MonthlyReport findByUserId(Integer userId);
	
	
	/**
	 * 月報を日付とユーザーIDで1件検索する
	 * @param date
	 * @param userId
	 * @return
	 */
	MonthlyReport findByDateAndUserId(Integer userId, Integer year, Integer month);

    int countByExample(MonthlyReportExample example);

    int deleteByExample(MonthlyReportExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MonthlyReport record);

    int insertSelective(MonthlyReport record);

    List<MonthlyReport> selectByExample(MonthlyReportExample example);

    MonthlyReport selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MonthlyReport record, @Param("example") MonthlyReportExample example);

    int updateByExample(@Param("record") MonthlyReport record, @Param("example") MonthlyReportExample example);

    int updateByPrimaryKeySelective(MonthlyReport record);

    int updateByPrimaryKey(MonthlyReport record);
}