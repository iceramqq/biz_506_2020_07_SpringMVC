## jsp의 확장기능
* 전통적인 jsp는 html 코드내에 java코드를 삽입하여 연산을 수행하거나,
controller로 부터 보내진 변수를 표현하는 과정에서 디자인이 무너지는 현상이
자주 발생을 하고, 그렇지 않아도 복잡한 html 코드를 더 복잡하게 만든다.
* 디자이너와 java 개발자가 협업을 할때 트러블을 일으키는 대표적인 상황이
연출된다.

## EL(express Lang.)와 JSTL(JSP Standerd tag Lib)
* JSP 2.x 규격이 나오면서 html 코드에 java 코드를 삽입하지 않아도 더 유연하게
view를 만들수 있는 확장기능이 탄생을 한다.
* JSP 에 include file 등 일부 코드만 최소한으로 사용을 하면서 더 나은 view를 만드는
방법니다.

### EL(expression : 계산식, Lang. )
* EL tag : ${변수}, ${1200*25}
* controller로 부터 model에 담겨서 전달된 변수값을 문자열로 변환하여 표시하거나
* 계산식을 이용하여 결과를 문자열로 변환하여 표시하는 용도
* JSP 1.x : <%= pageContext.getAttribyute("ORDER") %>
* EL : ${OTDER}

### JSPL(JSP Standerd tag Lib.)
* JSP 2.x 규격이 사용된 뒤로, 더이상 JSP 표준코드를 사용하지 말자는 움직


* JSP 1.x 코드

	<%
    for(int i = 0; i < 10 ; i++) {
    %>
    <h3>blabla</h3>
    <%
    }
    %>
    
* JSPL

	<c:forEach begin="1" end="10" varStatus="index">
	<h3>blabla</h3>
	</c:forEach>

	
## spring project 에서 exception이 발생했을때
* 원칙 1 : 블럭을 제일 아래쪽부터 확인하라
* EL tag 를 사용한 JSP : 보통 객체.필드변수 형식의 EL tag에서 필드변수가 없은때
발생하는 대표적인 exception

* project가 시작되면서 발생하는 

### 사용자가 서버에 데이터를 보내기
1. 고정값을 보내는 방법 : a href="주소?변수=값" 형식으로 링크를 만드는 방법
이 방법은 값을 변경하려면 소스코드를 변경해야 하는 문제가 있다.
2. 사용자가 키보드로 입력

	<from>
		<input>
		<input>
		<button>보내기</button>
	</from>
	
* 이러한 방법을
* 
* 라는 속성을 지정할수 있는데 기본값이 get이다.

### 
* 를 주로 사용하고, 최신기술에 put, deldete, head 등이 있다
* 방식 : 에  입력된 데이터를 문다열로 변환하여 서버로 전송 보내는 데이터가 주소창에 노츨이되고, 누군가 조작하기가 쉽다.

* 방식 : 프로토콜의 영역에 데이터를 심어서 서버로 전송을 한다
문다열방식으로 전송되지 않기때문에 방식에 비해 보안이 좋으며 데이터 길이에 제한이 엇다
일반적으로 을 사용한 입력값 전송에는 