package com.biz.ems.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.biz.ems.model.EmsVO;

@Service
public class NaverMailSendService {

	@Autowired
	private JavaMailSender xMail;
	
	@Autowired
	private String winPath;
	
	public void sendMail(EmsVO emsVO) {
		
		String uploadFolder = winPath;
		
		String from_email = emsVO.getFrom_email();
		String to_email = emsVO.getTo_email();
		
		String s_file1 = emsVO.getS_file1();
		String s_file2 = emsVO.getS_file2();
		
		/*
		 * mime type
		 * 인터넷 tcp/ip 를 통해서 주고받는 문서(파일)들은
		 * 고유의 형식을 갖는다
		 * 그러한 형식을 마임타입이라고 한다.
		 * hyper text markup tag 로 만들어진 문서를 html doc tape 리라고 하며
		 * 이처럼 mime type을 지정해둔 문서는 인터넷으로부터 받앗을때
		 * 즉시 내용을 확인할 수 있다.
		 * 
		 * mnail을 통해서 지금만드는 mime type은 email viewer 에서
		 * 확인할 수 ㅆ는 문서 형식이다.
		 * 이 문서는 메모장이나, weg growser로 보면 그내용을 정획히
		 * 확인 어렵다.
		 * 대표적으로 
		 */
		MimeMessage message = xMail.createMimeMessage();
		
		//
		// 여러가지 기능을 수행해 주는 도구
		MimeMessageHelper mHelper = null;
		
		try {
			// 두번째값을 true : html 적용을 한 메시지를 보낼수 있다.
			// 두번째값을 true : 메시지에 이미지 파일을 적용하여 보낼수 있다.
			mHelper = new MimeMessageHelper(message,true,"UTF-8");
			mHelper.setFrom(from_email);
			mHelper.setTo(to_email);
			mHelper.setSubject(emsVO.getS_subject());
			
			// 두번째값을 true : html 적용을 한 메시지를 보낼수 있다.
			mHelper.setText(emsVO.getS_content(), true);
			
			FileSystemResource rs = null;
			if(!s_file1.isEmpty()) {
				rs = new FileSystemResource(new File(uploadFolder,s_file1));
				mHelper.addAttachment(s_file1, rs);
			}
			if(!s_file2.isEmpty()) {
				rs = new FileSystemResource(new File(uploadFolder,s_file2));
				mHelper.addAttachment(s_file2, rs);
			}
			xMail.send(message);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
