/*$(function () {
    $.ajax({
        url:"../consumerBook/queryBookAll",
        type:"post",
        success:function (data) {
            
        }
    })
})*/




toMessage=function (bookId) {
    //alert(t);
    //var bookId=this.$("dl").attr(id);
    location.href="../consumerBook/toMessage?bookId="+bookId;
}