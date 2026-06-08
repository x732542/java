package tw.brad.tutor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import tw.brad.apis.JdbcTool;
import tw.brad.apis.Member;
import tw.brad.apis.RowMapper;

public class Jdbc19 {

	public static void main(String[] args) {
		JdbcTool jdbc = new JdbcTool();
		String sql = """
				SELECT id, account, passwd
				FROM member
				""";
		List<Member> members = jdbc.query(sql, new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs) throws SQLException {
				Member member = new Member(rs.getLong("id"), rs.getString("account"), null);
				return member;
			}
		});
		
		for (Member member : members) {
			System.out.printf("%d:%s\n", member.getId(), member.getAccount());
		}
	}

}