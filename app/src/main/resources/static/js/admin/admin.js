let flag=0;
let prev;
let flag2=0;
let prev2;
// html dom 이 다 로딩된 후 실행된다
$(document).ready(function(){
    // menu 클래스 바로 하위에 있는 a 태그를 클릭했을때
    $(".menu>a").click(function(){
        var submenu = $(this).next("ul");
        // submenu 가 화면상에 보일때는 위로 보드랍게 접고 아니면 아래로 보드랍게 펼치기            
        if( submenu.is(":visible") ){
            submenu.slideUp();
            $(this).css('backgroundColor','#293a50');
        }else{
            submenu.slideDown();

            $(this).css('backgroundColor','#3a495e');
        }

        var arrow=$(this).children().eq(1);
        if(arrow.hasClass('rightarrow')){
            arrow.removeClass('rightarrow');
            arrow.addClass('downarrow');
        }
        else if(arrow.hasClass('downarrow')){
            arrow.removeClass('downarrow');
            arrow.addClass('rightarrow');
        }

    });

    /* $(".hide>li").click(function(){

         flag++;



         if(flag%2==1){
             $(this).css('backgroundColor','#5468e2');
             $(prev).css('backgroundColor','#2d3e53');
             prev=$(this);


         }
         else{
             $(this).css('backgroundColor','#2d3e53');
             $(prev).css('backgroundColor','#2d3e53');
             prev=$(this);
         }
         */
    /*style의 backgroundColor이라 안가져와진다
    if($(this).attr('backgroundColor')=='#5468e2'){
        $(this).css('backgroundColor','#2d3e53');
    }
    */
    /*
    else if($(this).attr('backgroundColor')=='#2d3e53'){
        $(this).css('backgroundColor','#5468e2');
    }
    */
    /* });*/

    $(".hide>li").click(function(){
        if($(this).hasClass('normalcolor')){
            $(this).removeClass('normalcolor');
            $(this).addClass('clickcolor');
            console.log($(this).hasClass('clickcolor'));
            if(flag!=0){
                $(prev).removeClass('clickcolor');
                $(prev).addClass('normalcolor');
            }


            prev=$(this);
            flag++;
            console.log("변경됨");
        }
        else if($(this).hasClass('clickcolor')){
            $(this).removeClass('clickcolor');
            $(this).addClass('normalcolor');
            prev=$(this);
            console.log($(this).attr('backgroundColor'));
        }
    });
    $(".subnavigation_how_main>select").click(function(){
        if($(this).hasClass('selectnormalcolor')){
            $(this).removeClass('selectnormalcolor');
            $(this).addClass('selectclickcolor');
            console.log($(this).hasClass('selectclickcolor'));
            if(flag2!=0){
                $(prev2).removeClass('selectclickcolor');
                $(prev2).addClass('selectnormalcolor');
            }


            prev2=$(this);
            flag2++;
            console.log("변경됨");
        }
        else if($(this).hasClass('selectclickcolor')){
            $(this).removeClass('selectclickcolor');
            $(this).addClass('selectnormalcolor');
            prev2=$(this);
            console.log($(this).attr('backgroundColor'));
        }
    });
});