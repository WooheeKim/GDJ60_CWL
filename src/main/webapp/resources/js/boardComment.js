//list
getList(1);

function getList(page){
    fetch("/board/comment/list?boardNum="+boardCommentAdd.getAttribute('data-board-comment')+"&page="+page, {
        method:'GET'
    })
    .then((response)=>response.text())
    .then((res)=>{
        
        $("#boardCommentListResult").html(res.trim());
    })
}

//page
$("#boardCommentListResult").on("click",".page-link", function(e){
    let page = $(this).attr("data-board-page");
    getList(page);
    
    e.preventDefault();
});

//add
$("#boardCommentAdd").click(function(){

    $.ajax({
        url:'../board/comment/add',
        type:'POST',
        data:{
            'boardCommentContents': $("#boardCommentContents").val(),
            'boardNum': $("#boardCommentAdd").attr('data-board-comment')
        },
        success:(res)=>{
            if(res.trim()==1){
                alert('댓글이 등록되었습니다')
                $("#boardCommentContents").val("");
                getList(1);            
            }else {
                alert('등록 실패!')
            }
        }
    })
})

//delete
$("#boardCommentListResult").on("click",".delete",function(e){
    fetch("../board/comment/delete", {
        method:'POST',
        headers:{
           "Content-type":"application/x-www-form-urlencoded"
       },
       body:"boardCommentNum="+$(this).attr("data-boardcomment-num")
       }).then((response)=>{return response.text()})
         .then((res)=>{
           if(res.trim()>0){
               alert('댓글이 삭제되었습니다');
               getList(1);
           }else {
               alert('삭제 실패!');
           }
         })
         e.preventDefault();
})

//update
$("#boardCommentListResult").on("click", ".update", function(e){
    let boardCommentNum = $(this).attr("data-boardcomment-num");
    $("#boardCommentContents").val($("#boardCommentContents"+boardCommentNum).text());
    $("#contentsConfirm").attr("data-boardcomment-num", boardCommentNum);
    e.preventDefault();
})

//confirm
$("#contentsConfirm").click(function(){
    $.ajax({
        url:'../board/comment/update',
        type:'POST',
        data:{
            'boardCommentNum': $(this).attr("data-boardcomment-num"),
            'boardCommentContents': $("#boardCommentContents").val()
        },
        success:(res)=>{
            if(res.trim()>0){
                alert('댓글이 수정되었습니다');
                $("#closeModal").click();
                getList(1);            
            }else {
                alert('수정 실패!');
            }
        }
    })
})