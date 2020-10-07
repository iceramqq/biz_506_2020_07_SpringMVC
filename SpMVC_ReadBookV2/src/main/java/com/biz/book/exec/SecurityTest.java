package com.biz.book.exec;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

import javax.print.attribute.standard.PDLOverrideSupported;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/*
 * jayspt 패키지의 standardPBEStringEncrytor 클래스를 사용하여
 * 
 */
public class SecurityTest {

	public static void main(String[] args) {
		
		String propsFile = "./src/main/webapp/WEB-INF/spring/db.connect.properties";
		
		StandardPBEStringEncryptor pbe = new StandardPBEStringEncryptor();
		Scanner scan = new Scanner(System.in);
		
		Map<String, String> envList = System.getenv();
		String saltPassword = envList.get("BIZ.NET");
		
		if(saltPassword == null) {
			System.out.println("BIZ.NET 환경변수 설정값이 없습니다. 확인하세요");
			return;
		}
		
		System.out.printf("BIZ.NET 환경변수 : %s\n",saltPassword);
		
		System.out.printf("BIZ.NET UserName >>");
		String userName = scan.nextLine();
		
		System.out.printf("BIZ.NET Password >>");
		String password = scan.nextLine();
		
		pbe.setAlgorithm("PBEWithmd5anddes");
		
		/*
		 * 사용하는데 문제가 발생할 수 잇다.
		 * 
		 *  문자열을 바로 사용하지 않고 
		 *  시스템에 환경변수를 저장해 두고
		 *  환경변수를 가져다 비밀번호로 사용을 한다.
		 *  
		 *  이라는 문자열이 노출이 되어도
		 *  네트워크를 통해서 암호를 추출하기가 매우 어려워진다
		 *  
		 *  따라서 암호화 하는 효과를 좀더 배가 시킬수 있다
		 */
		pbe.setPassword(saltPassword);
		
		String encUserName = pbe.encrypt(userName);
		String encPassword = pbe.encrypt(password);
		
		String saveUserName = String.format("oracle.username=ENC(%s)",encUserName);
		String savePassword = String.format("oracle.password=ENC(%s)",encPassword);
		
		try {
			PrintWriter out = new PrintWriter(propsFile);
			out.println(saveUserName);
			out.println(savePassword);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scan.close();
		System.out.println("DB 연결 속성파일 생성 완료");		
	}
}
