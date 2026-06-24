package com.example.spring1.apis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring1.dto.MemberResponse;
import com.example.spring1.utils.Member;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/members")
public class Brad08 {
	public Brad08() {
		System.out.println("brad08");
	}
	
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	private MemberResponse memberResponse;
	
	@PostMapping( value = {"", "/{isGetId}"})
	public MemberResponse addMember(@RequestBody @Valid Member member,
			@PathVariable(required = false) Boolean isGetId) {
		String sql = """
				INSERT INTO member
					(account, passwd)
				VALUES
					(:account, :passwd)
				""";	
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("account", member.getAccount());
		map.put("passwd", BCrypt.hashpw(member.getPasswd(), BCrypt.gensalt()));
		
		//------------------------------
		//int n = jdbc.update(sql, map);
		//System.out.println(n);
		//------------------------------
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int n = jdbc.update(sql, new MapSqlParameterSource(map), keyHolder);
		System.out.println(n);
		System.out.println(keyHolder.getKey().intValue());
		
		if (isGetId == null) isGetId = false;
		
		if (n > 0 ) {
			if (isGetId) {
				member.setId(keyHolder.getKey().intValue());
			}
			memberResponse.setError(0);
			memberResponse.setMessage("Add Member Success");
			memberResponse.setMember(member);
		}else {
			memberResponse.setError(-1);
			memberResponse.setMessage("Add Member Failure");
		}
		return memberResponse;
	}
	@PostMapping("/list")
	public void addMembers(@RequestBody List<Member> members) {
		//System.out.println(members.size());
		String sql = """
				INSERT INTO member
					(account, passwd)
				VALUES
					(:account, :passwd)
				""";
		MapSqlParameterSource[] params = new MapSqlParameterSource[members.size()];
		for (int i=0; i<params.length; i++) {
			params[i] = new MapSqlParameterSource();
			params[i].addValue("account", members.get(i).getAccount());
			params[i].addValue("passwd", BCrypt.hashpw(members.get(i).getPasswd(), BCrypt.gensalt()));
		}
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int[] r = jdbc.batchUpdate(sql, params, keyHolder);
		for (int rr: r) {System.out.println(rr);}
		System.out.println("----");
		List<Map<String,Object>> maps = keyHolder.getKeyList();
		for (Map<String,Object> map : maps) {
			System.out.println(map.getOrDefault("GENERATED_KEY", -1));
		}
	}
	
	@PostMapping("/listv2")
	public void addMemberV2(@RequestBody List<Member> members) {
		for (Member member: members) {
			addMember(member, false);
		}
	}
	
	@DeleteMapping("/{id}")
	public MemberResponse delete(@PathVariable Integer id) {
		String sql = """
				DELETE FROM member
				WHERE id = :id
				""";
		HashMap<String, Integer> map = new HashMap<>();
		map.put("id", id);
		
		int n = jdbc.update(sql, map);
		if (n > 0) {
			memberResponse.setError(0);
			memberResponse.setMessage("Delete Success");
		}else {
			memberResponse.setError(-2);
			memberResponse.setMessage("Delete Failure");
		}
		memberResponse.setMember(null);
		
		return memberResponse;
	}
	
	@PutMapping("")
	public MemberResponse update(@RequestBody Member member) {
		String sql = """
				UPDATE member
				SET passwd = :passwd
				WHERE id = :id
				""";		
		HashMap<String, Object> map = new HashMap<>();
		map.put("id", member.getId());
		map.put("passwd", BCrypt.hashpw(member.getPasswd(), BCrypt.gensalt()) );
		
		int n = jdbc.update(sql, map);
		if (n > 0) {
			memberResponse.setError(0);
			memberResponse.setMessage("Update Success");
		}else {
			memberResponse.setError(-3);
			memberResponse.setMessage("Update Failure");
		}
		memberResponse.setMember(null);
		
		return memberResponse;		
		
	}
	
	
}