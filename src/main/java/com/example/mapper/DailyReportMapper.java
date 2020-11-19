package com.example.mapper;

import com.example.domain.DailyReport;
import com.example.domain.DailyReportExample;
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
public interface DailyReportMapper {
	
	/**
	 * ユーザIdで1件検索を行うメソッド.
	 * 
	 * @param userId
	 * @return 日報情報
	 */
	DailyReport findByUserId(Integer userId);

    int countByExample(DailyReportExample example);

    int deleteByExample(DailyReportExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DailyReport record);

    int insertSelective(DailyReport record);

    List<DailyReport> selectByExample(DailyReportExample example);

    DailyReport selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DailyReport record, @Param("example") DailyReportExample example);

    int updateByExample(@Param("record") DailyReport record, @Param("example") DailyReportExample example);

    int updateByPrimaryKeySelective(DailyReport record);

    int updateByPrimaryKey(DailyReport record);
}