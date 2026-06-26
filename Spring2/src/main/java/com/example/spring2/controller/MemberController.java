package com.example.spring2.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.spring2.config.ReadConfig;
import com.example.spring2.dto.Base64Upload;
import com.example.spring2.dto.MemberForm;
import com.example.spring2.entity.Member;
import com.example.spring2.service.MemberService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/members")
public class MemberController {

	@Autowired
	private MemberService service;
	
	/*
	 * request: account=?
	 * response: true/false
	 */
	@GetMapping("/exist")
	public ResponseEntity<Boolean> checkAccount(@RequestParam String account) {
		boolean isExist = service.checkAccount(account);
		// System.out.println(isExist);
		return ResponseEntity.ok(isExist);
	}
	
	/*
	 * request: Member
	 * response: {"success": true/false}
	 */
	@PostMapping("/register")
	public ResponseEntity<Map<String,Boolean>> register(@RequestBody Member member) {
		System.out.println(member.getAccount() + ":" + member.getPasswd());
		boolean isSuccess = service.register(member);
		
		Map<String,Boolean> map = Map.of("success", isSuccess);
		return ResponseEntity.ok(map);
	}
	
	/*
	 * request: {account:xxx, passwd: xxx}
	 * response: {"success": true/false}
	 */
	@PostMapping("/login")
	public ResponseEntity<Map<String,Boolean>> login(
			@RequestBody Map<String,String> body){
		String account = body.get("account");
		String passwd = body.get("passwd");
		
		//boolean isSuccess = service.login(account, passwd);
		boolean isSuccess = service.loginV2(account, passwd);
		
		Map<String,Boolean> map = Map.of("success", isSuccess);
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/loginV2")
	public ResponseEntity<Map<String,Boolean>> login(
			@RequestBody Map<String,String> body,
			HttpSession session
			){
		String account = body.get("account");
		String passwd = body.get("passwd");
		
		Member member = service.loginV3(account, passwd);
		
		Map<String,Boolean> map;
		if (member != null) {
			session.setAttribute("member", member);
			map = Map.of("success", true);
		}else {
			session.invalidate();
			map = Map.of("success", false);
		}
		
		return ResponseEntity.ok(map);
	}
	
	@RequestMapping("/logout")
	public ResponseEntity<Map<String,Boolean>> logout(HttpSession session) {
		System.out.println("Logout");
		session.invalidate();
		return ResponseEntity.ok(Map.of("success", true));
	}
	
	@Autowired
	@Qualifier("companyName")
	private String companyName;
	
	@Value("${company.tel}")
	private String companyTel;
	
	@PostMapping("/status")
	public ResponseEntity<Map<String,Object>> status(HttpSession session) {
		Object member = session.getAttribute("member");
		
		Map<String,Object> map = new HashMap<>();
		map.put("success", member != null);
		map.put("member", member);
		map.put("companyName", companyName);
		map.put("companyTel", companyTel);
		
		return ResponseEntity.ok(map);
		
	}
	
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	@PostMapping("/{id}")
	public void test1(@PathVariable Long id,
			@RequestParam MultipartFile upload) {
		
		try {
			byte[] bytes = upload.getBytes();
			String sql = """
					UPDATE member
					SET icon = :icon
					WHERE id = :id
					""";
			Map<String,Object> params = Map.of(
					"id", id,
					"icon", bytes
					);
			int n = jdbc.update(sql, params);
			System.out.println(n);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	@Autowired
	private ReadConfig readConfig;
	
	@PostMapping("/test2")
	public void test2(@ModelAttribute MemberForm memberForm) {
		System.out.println(memberForm.getAccount());
		System.out.println(memberForm.getFiles().size());
		System.out.println(readConfig.getUploadDir());
		
		File here = new File(".");
		System.out.println(here.getAbsolutePath());
		
		List<MultipartFile> files = memberForm.getFiles();
		for (MultipartFile file : files) {
			if (!file.isEmpty()) {
				try {
					file.transferTo(new File(
						here.getAbsolutePath()+"/"+
						readConfig.getUploadDir()+"/"+
						memberForm.getAccount()+"_"+file.getOriginalFilename()));
				}catch(Exception e) {
					System.out.println(e);
				}
			}
		}
		
	}
	
	@PostMapping("/upload/base64")
	public ResponseEntity<String> test3(@RequestBody Base64Upload request) {
		System.out.println(request.getFileName());
		System.out.println(request.getContentType());
		System.out.println(request.getBase64().length());
		
		// 1. save table => 1. String: request.getBase64()
		//					2. blob: fileBytes
		// 2. sabe file => fileBytes
		
		try {
			byte[] fileBytes = Base64.getDecoder().decode(request.getBase64());
			
			Path uploadDir = Path.of(readConfig.getUploadDir());
			Path filePath = uploadDir.resolve(request.getFileName());
			System.out.println(filePath.toString());
			Files.write(filePath, fileBytes);
			
			return ResponseEntity.ok("Upload Success");
		}catch(Exception e) {
			System.out.println(e);
			return ResponseEntity.badRequest().body("Upload Failure");
		}
		
		
	}
	
	
	
}