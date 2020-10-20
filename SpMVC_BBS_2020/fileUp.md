# 사진이미지를 업로드하여 이미지 갤러리 bbs로 변환

* spring framework에서는 기본적으로 text 위주의 project만 지원한다.
* file(종류에 관계 없이)을 upload하기 위해서 apache에서 지원하는 dependency 도움을 받아야 한다.
* 

## file upload할수 잇도록 서버 context 를 설정해 주어야 한다.
* file-context.xml파일
*
*
* form tag에 
* upload 하는 파일의 type을 제한하고 싶을때 accept="image/*" 설정해 주면 된다.
* 파일의 확장자를 검사하여 제한하고 싶을때 accept=".gif, .jpg, .jpeg, .png"
* 미디어 타입과 확장자르르 검사아여 제한하고 싶을때 accept="video/mp4, audio/mp3, image/png"