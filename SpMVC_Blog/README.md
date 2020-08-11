# was : web application server(service)
* web browser를 사용하여 server와 통신을 하면서 어떤 일을 수행하는 어플리케이션
* 

## server 보내는 reqyest
* a href="주소" : hyper text를 보여주고, hyper text를 클릭했을때 serverfh req를 보내는 가장 기본적인 형태
 이 req를 contreller에서 받아서 처리할때는 method=request.get로 지정된 method가 연산을 수행하는 처리한다.

* form tag의 button을 클릭했을때 server로 req를 보내는 형태


* form tag에 method를 지정 하면 

##request, response
* req_1 (a href="input") == req_1 (write.jap)
==>controller
==>write(string title, string content)

* req_2(write 함수에서 model에 title, content attribute 를 설정하고, view.jap