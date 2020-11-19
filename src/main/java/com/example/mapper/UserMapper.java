package com.example.mapper;

import com.example.domain.User;
import com.example.domain.UserExample;
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
public interface UserMapper {
	
	/**
	 * 全てのusersデータを出力する(NOT generated by MyBatis Generator)
	 * @return usersデータ一覧
	 */
	List<User> findAll();
	
	List<User> findAllUser();
	
	/**
	 * gmailでログインしているユーザを検索
	 * 
	 * @param gmail Gmailアドレス
	 * @return ユーザ情報
	 */
	User findByGmail(String gmail);
	
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}