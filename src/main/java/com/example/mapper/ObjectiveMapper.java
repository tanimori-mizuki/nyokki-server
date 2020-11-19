package com.example.mapper;

import com.example.domain.Objective;
import com.example.domain.ObjectiveExample;
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
public interface ObjectiveMapper {
	
	/**
	 * ユーザIdで1件検索を行うメソッド.
	 * 
	 * @param userId
	 * @return 目標情報
	 */
	Objective findByUserId(Integer userId);

    int countByExample(ObjectiveExample example);

    int deleteByExample(ObjectiveExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Objective record);

    int insertSelective(Objective record);

    List<Objective> selectByExample(ObjectiveExample example);

    Objective selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Objective record, @Param("example") ObjectiveExample example);

    int updateByExample(@Param("record") Objective record, @Param("example") ObjectiveExample example);

    int updateByPrimaryKeySelective(Objective record);

    int updateByPrimaryKey(Objective record);
}