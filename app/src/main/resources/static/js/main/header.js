
/*const $joinMember = $('#joinMember');
const $login = $('#login');
const $memberNickname = $('#memberNickname');
const $logout = $('#logout');
const $notice = $('#notice');
const $question = $('#question');*/


//alert("들어옴");

/*
$joinMember.on('click', function () {
    // alert("눌림");
    location.href = "/member/join";
});

$login.on('click', function () {
    location.href = "/member/login";
});

$memberNickname.on('click', function () {
    location.href = "/member/mypage?memberNumber=" + memberNumber;
});

$logout.on('click', function () {
    location.href = "/member/logout?memberNumber=" + memberNumber;
});

$notice.on('click', function () {
    location.href = "/notice/list";
});

$question.on('click', function () {
    location.href = "/question/question";
});
*/

// 관리자 페이지로 이동
/*$admin.on('click', function () {
    console.log('들어옴');
    $adminForm.submit();
})*/

//돋보기 이미지 누르면 검색결과 페이지로 이동

$('#searchGo').on('click',function(){
    //form submit
    console.log("submit버튼 누름");

    //$("#searchSection").submit();
    //console.log("submit버튼 누름");
    document.searchSectionForm.submit();
});

/* window.onload = function() {
     $("#searchGo").on('click',function(){
         console.log("submit버튼 누름");
         //document.searchSectionForm.submit();

     });
 };*/
/*function clickSearch(){
    console.log("submit버튼 누름");
}*/

/*window.onload = function(){
    function clickSearch(){
        console.log("submit버튼 누름");
    }
};*/
