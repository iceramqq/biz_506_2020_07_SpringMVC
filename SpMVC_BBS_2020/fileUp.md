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

## 첨부파일이 게시판에서 CRUD 구현
1. insert
* 파일을 업로드할때 파일름 UUI  부착하기
* 파일을 UUID를 부착하여 upload를 실행하고, UUID가 부착된 파일이름을 게시글의 file명 필드에 추가한후
insert 수행하기

2. delete
* 업로드된 첨부파일을 삭제작업 수행 우선
* seq값으로 게시글을 가져오고 file명 필드에서 첨부파일 이름을 getter하여 upload폴더의 파일 삭제
* 해당하는 게시글을 삭제
* 게시글은 없는데 필요없는 주인없는 파일들이 upload폴더에 쌓이게 된다.

3. updete
* seq 값으로 게시글을 가져와서 write.jsp에 보이고 변경할 데이터들 입력받기


## 다중파일 업로드 CRUD 구현
1. 디증파일을 업로드하고
2. 파일의 원래이름과 업로드된 파일이름정보를 list로 생성
3. bbs table에 데이터를 insert 하고
4. bbs table로 부터 새로생성된 seq값을 가져오고
5. file table에 파일 list를 insert하는데 이때 I_b_seq 칼럼에 bbs의 seq값을 같이
첨부하여 insert 한다.





