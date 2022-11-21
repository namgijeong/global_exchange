

// html dom 이 다 로딩된 후 실행된다
$(document).ready(function(){
    // menu 클래스 바로 하위에 있는 a 태그를 클릭했을때
    $(".notice-wrapper").click(function(){
        var submenu = $(this).next(".notice-content");
        // submenu 가 화면상에 보일때는 위로 보드랍게 접고 아니면 아래로 보드랍게 펼치기            
        if( submenu.is(":visible") ){
            submenu.slideUp();
            submenu.css("display", "none" );
        }else{
            submenu.slideDown();
            submenu.css("display","block");
        }

    });

});
