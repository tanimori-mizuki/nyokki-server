package common_sql;

import static com.ninja_squad.dbsetup.Operations.*;

import org.springframework.stereotype.Component;

import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;

@Component
public class TodoMapperTestSql {

	/**
	 * todoのデータを挿入
	 */
	public static final Operation TODO_INSERT = insertInto("todoes").columns("id,user_id,task,status,registration_date")
			.values("1,4,'サンプルタスク',1,'2021-01-14'").values("2,4,'サンプルタスク2',1,'2021-01-14'")
			.values("3,4,'サンプルタスク3',1,'2021-01-14'").values("4,4,'サンプルタスク4',1,'2021-01-14'")
			.values("5,4,'サンプルタスク5',1,'2021-01-14'").build();

	/**
	 * todoのデータの削除
	 */
	public static final Operation TODO_DELETE = deleteAllFrom("todoes");
	/**
	 * todoの自動採番の設定（また１からインサートされるように）
	 */
	public static final Operation TODO_AUTO_INCREMENT = Operations.sql("SELECT SETVAL ('todoes_id_seq', 1, false);");

}
