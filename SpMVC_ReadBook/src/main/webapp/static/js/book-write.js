$(function () {
  $("#btn-save").click(function () {
    //
    //
    $("form").submit();
  });

  $("#naver-search").click(function () {
    let title = $("#title").val();
    if (title === "") {
      alert("도서명을 입력한 후 검색을 하세요");
      $("#title").focus();
      return false;
    }
    // ajax를 사용하여 서버에 네이버 검색 요청
    $.ajax({
      url: `${rootPath}/naver/search`,
      method: "POST",
      data: { search_text: title },
      success: function (result) {
        $("#search-result").html(result);
      },
      error: function (error) {
        alert("서버 통신 오류!!");
      },
    });
    $("#book-modal").css("display", "block");
  });
  // x 표시를 클릭 했을때 modal 창 닫기
  $("div#modal-header span").click(function () {
    $("#book-modal").css("display", "none");
  });

  /*
동적을로 구현된 html에 event 핸들링 설정하기
현재 rk 생성되는 동안이 없던 tag 를
js코드에서 동적으로 생성했을 경우 화면에 그려지는 것은 
아무런 문제가 없으나

js에서 event핸들러르 설정할때 아직 화면에 없는 tag에 연결을 하면
무싱헤 버리고 엇ㅂ던일로 만들어 버린다

사후에 js코드로 생성할 tag에 
event를 설정하려면 자체에 설정하지 않고
가장 상위 겍체인 document에 on 함수를 사용하여  event를 설ㅈ어한다
$(document).on("click","div.book-select",function(){}

주의사항
$(selector).click(function(){})
만약 기존에 selection에 click event가 설정되어 잇으면
기존의 잉벤트를 덮어쓰기 한다.

$(document).on("click","div.book-select")
만약 기존에 

동적으로 여는곳에서는
$(document).on()을 사용하여 event 행들러를 설정하고 

동적으로 
*/
  $(document).on("click", "div.book-select", function () {
    let isbn = $(this).data("isbn");
    //
    // 코드의 13자리를 잘라내라
    let length = isbn.length;
    isbn = isbn.substring(length - 13);
    //alert(isbn)

    $.ajax({
      url: `${rootPath}/api/isbn`,
      method: "POST",
      data: { search_text: isbn },
    })
      .done(function (bookVO) {
        // alert(JSON.stringify(bookVO))
        $("#seq").val(bookVO.seq);
        $("#title").val(bookVO.title);
        $("#link").val(bookVO.link);
        $("#image").val(bookVO.image);
        $("#author").val(bookVO.author);
        $("#price").val(bookVO.price);
        $("#discount").val(bookVO.discount);
        $("#publisher").val(bookVO.publisher);
        let isbn = bookVO.isbn;
        // isbn 변수에 들어잇는 문자열중에서 html tag 구조를 가진 단어가 있으면
        // 무조건 제거하라
        isbn = isbn.replace(/(<([^>]+)>)/gi, "");
        // isbn = isbn.substring(isbn.length - 17, isbn.length - 4);

        isbn = isbn.substring(isbn.length - 13);
        $("#isbn").val(isbn);

        $("#description").val(bookVO.description);
        $("#pubdate").val(bookVO.pubdate);
        $("section#book-modal").css("display", "none");
      })
      .fail(function (xhr, textStatus, error) {
        alert("서버와 통신오류!");
      });
  });
  $("section#book-modal").css("display", "none");
});
