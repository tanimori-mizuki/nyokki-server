package com.example.mapper;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.example.domain.Todo;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.destination.Destination;
import com.ninja_squad.dbsetup.destination.DriverManagerDestination;

import common_sql.TodoMapperTestSql;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
public class TodoMapperTest {

	@Autowired
	private static TodoMapperTestSql todomapperTestSql;

	@Autowired
	private static TodoMapper todoMapper;

	/**
	 * DB接続の情報（url,user,password）
	 */
	static Destination dest = new DriverManagerDestination("jdbc:postgresql://localhost:5432/nyokki-server", "postgres",
			"postgres");

	/**
	 * テスト実行時に一度だけ呼ばれる
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DbSetup todo_dbSetup = new DbSetup(dest, Operations.sequenceOf(todomapperTestSql.TODO_DELETE,
				todomapperTestSql.TODO_AUTO_INCREMENT, todomapperTestSql.TODO_INSERT));
		todo_dbSetup.launch();// 実行
	}

	/**
	 * インサートされた情報が正しいか確認
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		Date date = new Date(2021, 1, 14);

		// 確認用objectの作成
		Todo todo1 = new Todo();
		todo1.setId(1);
		todo1.setUserId(4);
		todo1.setDailyReportId(1);
		todo1.setTask("サンプルタスク1");
		todo1.setStatus(1);
		todo1.setRegistrationDate(date);

		Todo todo2 = new Todo();
		todo2.setId(2);
		todo2.setUserId(4);
		todo2.setDailyReportId(1);
		todo2.setTask("サンプルタスク2");
		todo2.setStatus(1);
		todo2.setRegistrationDate(date);

		Todo todo3 = new Todo();
		todo3.setId(3);
		todo3.setUserId(4);
		todo3.setDailyReportId(1);
		todo3.setTask("サンプルタスク3");
		todo3.setStatus(1);
		todo3.setRegistrationDate(date);

		Todo todo4 = new Todo();
		todo4.setId(4);
		todo4.setUserId(4);
		todo4.setDailyReportId(1);
		todo4.setTask("サンプルタスク4");
		todo4.setStatus(1);
		todo4.setRegistrationDate(date);
		Todo todo5 = new Todo();

		todo5.setId(5);
		todo5.setUserId(4);
		todo5.setDailyReportId(1);
		todo5.setTask("サンプルタスク5");
		todo5.setStatus(1);
		todo5.setRegistrationDate(date);

		// DBからデータの取得
		Todo actual1 = todoMapper.selectByPrimaryKey(1);
		Todo actual2 = todoMapper.selectByPrimaryKey(2);
		Todo actual3 = todoMapper.selectByPrimaryKey(3);
		Todo actual4 = todoMapper.selectByPrimaryKey(4);
		Todo actual5 = todoMapper.selectByPrimaryKey(5);

		// objectの一致確認
		assertEquals(actual1, todo1);
		assertEquals(actual2, todo2);
		assertEquals(actual3, todo3);
		assertEquals(actual4, todo4);
		assertEquals(actual5, todo5);

	}

	/**
	 * テストデータの削除
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		DbSetup todo_dbSetup = new DbSetup(dest,
				Operations.sequenceOf(todomapperTestSql.TODO_DELETE, todomapperTestSql.TODO_AUTO_INCREMENT));
		todo_dbSetup.launch();// 実行

	}

	/**
	 * とりあえず一つDBインサートが正しいのか確認
	 */
	@Test
	public void 主キーからtodoを確認する() {
		Integer id = 1;
		String task = "サンプルタスク1";
		Todo todo = todoMapper.selectByPrimaryKey(1);
		assertEquals(task, todo.getTask());
	}

	@Test
	public void todoの更新を行う() {
		System.out.println("updateのtestメソッド");

	}

}

