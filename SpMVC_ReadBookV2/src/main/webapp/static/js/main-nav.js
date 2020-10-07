$(function () {
  $(window).scroll(function () {
    let headerHeight = $("header").height(); // header tag 의 높이값
    // 화면을 세로방향으로 스크롤할때 원도우 화면의 최 상단 좌표 가져오기
    let windowTop = $(window).scrollTop();
    if (windowTop > headerHeight) {
      $("#main-nav").css("position", "fixed");
      $("#main-nav").css("top", "0");
    } else {
      $("#main-nav").css("position", "relative");
    }
  });

  $("li#menu-home").click(function () {});
  $("li#menu-books").click(function () {});
  $("li#menu-read-book").click(function () {});
  $("li#menu-login").click(function () {});

  // nav의 li tag를 클릭했을때
  $("#main-nav li").click(function () {
    let menu_text = $(this).text();
    let menu_id = $(this).attr("id");

    if (menu_text === "도서정보") {
      document.location.href = `${rootPath}/books`;
    } else if (menu_id === "menu-home") {
      document.location.href = `${rootPath}/`;
    } else if (menu_id === "menu-read-book") {
      document.location.href = `${rootPath}/read/`;
    } else if (menu_id === "menu-join") {
      document.location.href = `${rootPath}/member/join`;
    } else if (menu_id === "menu-mypage") {
      document.location.href = `${rootPath}/member/mypage`;
    } else if (menu_id === "menu-login") {
      //
      // spring security 에서 자체 지워되는 login from
      document.location.href = `${rootPath}/login`;
    } else if (menu_id === "menu-logout") {
      $.ajax({
        url: `${rootPath}/logout`,
        method: "POST",
        /*
        spring security logout 수행할때
        post 방식으로 요청을 해야한다
        post 


        beforeSend call back 함수를 붙여서
        setRequstHeader에 csrf 속성값을 
        */
        beforeSend: function (ax) {
          ax.setRequestHeader(`${csrf_header}`, `${csrf_token}`);
        },
        success: function (result) {
          document.location.replace(`${rootPath}/`);
        },
        error: function () {
          alert("서버와 통신오류 발생!!");
        },
      });
    }
  });
});
