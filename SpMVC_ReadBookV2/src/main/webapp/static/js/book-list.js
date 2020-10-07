$(function () {
  $("td.book-title").click(function () {
    let seq = $(this).data("seq");
    // query string 방식
    // document.location.href = `${rootPath}/books/detail?seq=${seq}`

    // path varriable 방식
    document.location.href = `${rootPath}/books/detail/${seq}`;
  });
});
