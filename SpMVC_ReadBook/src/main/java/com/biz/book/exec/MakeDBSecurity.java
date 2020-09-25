package com.biz.book.exec;

import java.util.Map;
import java.util.Scanner;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/*
 * jayspt 패키지의 standardPBEStringEncrytor 클래스를 사용하여
 * 
 */
public class MakeDBSecurity {

	public static void main(String[] args) {
		StandardPBEStringEncryptor pbe = new StandardPBEStringEncryptor();
		Scanner scan = new Scanner(System.in);
		
		Map<String, String> envList = System.getenv();
		
		System.out.print("문자열 >> ");
		String planText = scan.nextLine();
		
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
		pbe.setPassword(envList.get("BIZ.NET"));
		
		for (int i = 0; i < 10; i++) {
			String encText = pbe.encrypt(planText);
			System.out.printf("P : %s, E : %s\n",planText,encText);
			
			String dencText = pbe.decrypt(encText);
			System.out.printf("E : %s, P : %s\n",dencText,planText);
		}
		
	}
}
