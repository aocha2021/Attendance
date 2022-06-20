
$('#datetimepicker').datetimepicker({
	    changeMonth: true,
	    dateFormat: "yy-mm-dd",
   });
   

function clickPost() {
	let token = $("meta[name='_csrf']").attr("content");
	//同様に「_csrf＿header」という名前のcontent属性を取得し変数haderにセット
	let header = $("meta[name='_csrf_header']").attr("content");

	$(document).ajaxSend(function(e, xhr, options) {
　		//HTTPリクエストヘッダーにヘッダー名とトークンの値をセット
  		xhr.setRequestHeader(header, token);
	});

    $.ajax({
        //MainControllerのpostIndex()メソッドに遷移
        url: '/',
        type: 'POST',
        timeout: 60000,
        data: null
    })
    /*//Ajax通信成功の場合
    .done(function() {
        alert('success!');
    })
    //Ajax通信失敗の場合
    .fail(function() {
        alert('fail!');
    })*/
    //Ajax通信の成功・失敗に関わらず最後に処理
    .always(function() {
        console.log("完了");
    });
}



