$("#memberId").on("blur", function(){checkId($(this).val());});
$("#memberNick").on("blur", function(){checkNick($(this).val());});
$("#memberPw").on("blur", function(){pwCheck($(this).val());});
$("#memberDoublePw").on("blur", function(){pwDoubleCheck($(this).val());});


function checkId(memberId) {

    if (!memberId) {
        $("#memberIdResult").text("아이디를 입력해주세요.");
        $("#memberIdResult").css("color", "red");
        $("#memberIdResult").css("display", "block");
        $("#memberId").css("border", "1px solid red");
        return;
    } else {
        $("#memberIdResult").text("");
        $("#memberIdResult").css("display", "none");
        $("#memberId").css("border", "1px solid rgb(238, 238, 238)");

        // var data = {memberId : memberId};
        $.ajax({
            url: "/memberJoinCheck/joinCheckId",
            type:"post",
            data: memberId,
            contentType:"application/json; charset=utf-8",
            success: function(result){
                console.log(result);
                let message, color;

                if(result == true){
                    message = "사용 가능한 아이디입니다.";
                    color = "blue";

                }else{
                    message = "중복된 아이디입니다.";
                    color = "red";
                }
                $("#memberIdResult").css("display", "block");
                $("#memberIdResult").css("color", color);
                $("#memberIdResult").text(message);
            },
            error: function(a, b, c){
                console.log(a, b, c);
            }
        });


        return;
    }

    // $.ajax({
    //     url: "/memberJoinCheck/joinCheckId",
    //     data: {"memberId": memberId},
    //     contentType:"application/json; charset=utf-8",
    //     success: function(result){
    //         let message, color;
    //
    //         if(result == true){
    //             message = "사용 가능한 아이디입니다.";
    //             color = "blue";
    //
    //         }else{
    //             message = "중복된 아이디입니다.";
    //             color = "red";
    //         }
    //         $("#memberIdResult").css("display", "block");
    //         $("#memberIdResult").css("color", color);
    //         $("#memberIdResult").text(message);
    //     },
    //     error: function(a, b, c){
    //         console.log(a, b, c);
    //     }
    // });

}
function checkNick(memberNick) {

    console.log(memberNick);
    if (!memberNick) {
        $("#memberNickResult").text("닉네임을 입력해주세요.");
        $("#memberNickResult").css("color", "red");
        $("#memberNickResult").css("display", "block");
        $("#memberNick").css("border", "1px solid red");
        return;
    } else {
        // $("#memberNickResult").text("");
        // $("#memberNickResult").css("display", "none");
        // $("#memberNick").css("border", "1px solid rgb(238, 238, 238)");


        $.ajax({
            url: "/memberJoinCheck/joinCheckNickname",
            type:"post",
            data: memberNick,
            contentType:"application/json; charset=utf-8",
            success: function(result){
                console.log(result);
                let message, color;

                if(result == true){
                    message = "사용 가능한 닉네임 입니다.";
                    color = "blue";
                }else{
                    message = "중복된 닉네임 입니다.";
                    color = "red";
                }
                $("#memberNickResult").css("display", "block");
                $("#memberNickResult").css("color", color);
                $("#memberNickResult").text(message);
            },
            error: function(a, b, c){
                console.log(a, b, c);
            }
        });

        return;
    }



}

function pwCheck(memberPw){
        let pwRegex=/^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{10,}$/;
        //let pwRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{10,}$/;
          //let pwRegex=/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{10,25}$/;
        //let pwRegex=/^[a-zA-Z0-9!@#$%^&*()?_~]{10,}$/;
        if(!pwRegex.test(memberPw)){
            console.log(memberPw);
            $("#memberPwResult").css("color", "red");
            $("#memberPw").css("border", "1px solid red");
            return;
        }
        else{

            $("#memberPwResult").css("color", "rgb(153, 153, 153)");
            $("#memberPw").css("border", "1px solid rgb(238, 238, 238)");
            return;
        }
}

function pwDoubleCheck(memberDoublePw){
    if(memberDoublePw!=$("#memberPw").val()){
        $("#memberPwDoubleResult").css("color", "red");
        $("#memberPwDoubleResult").css("display", "block");
        $("#memberDoublePw").css("border", "1px solid red");
        return;
    }
    else{
        $("#memberPwDoubleResult").css("color", "rgb(153, 153, 153)");
        $("#memberPwDoubleResult").css("display", "none");
        $("#memberDoublePw").css("border", "1px solid rgb(238, 238, 238)");

        return;
    }
}


if($('select[name="memberTeachingLang"]').val() == "ENGLISH") {

    $('input[name="memberNationUrl"]').val("/images/nation/america.png");
}

if($('select[name="memberTeachingLang"]').val() == "SPANISH") {

    $('input[name="memberNationUrl"]').val("/images/nation/spain.png");
}
if($('select[name="memberTeachingLang"]').val() == "FRENCH") {

    $('input[name="memberNationUrl"]').val("/images/nation/france.png");
}
if($('select[name="memberTeachingLang"]').val() == "GERMAN") {

    $('input[name="memberNationUrl"]').val("/images/nation/germany.png");
}
if($('select[name="memberTeachingLang"]').val() == "ITALIAN") {

    $('input[name="memberNationUrl"]').val("/images/nation/italy.png");
}
if($('select[name="memberTeachingLang"]').val() == "PORTUGUESE") {

    $('input[name="memberNationUrl"]').val("/images/nation/portugal.png");
}
if($('select[name="memberTeachingLang"]').val() == "RUSSIAN") {

    $('input[name="memberNationUrl]').val("/images/nation/russia.png");
}
if($('select[name="memberTeachingLang"]').val() == "JAPANESE") {

    $('input[name="memberNationUrl"]').val("/images/nation/japan.png");
}
if($('select[name="memberTeachingLang"]').val() == "CHINESE") {

    $('input[name="memberNationUrl"]').val("/images/nation/china.png");
}
if($('select[name="memberTeachingLang"]').val() == "KOREAN") {

    $('input[name="memberNationUrl"]').val("/images/nation/southKorea.png");
}



$('#radio1').on('click',function(){
    //let radioValue=$('.radio-value:checked').val();
    $("#radioSelect>div:nth-child(1)>label").css("backgroundColor","#0075ef");
    $("#radioSelect>div:nth-child(2)>label").css("backgroundColor","white");
});

$('#radio2').on('click',function(){
    //let radioValue=$('.radio-value:checked').val();
    $("#radioSelect>div:nth-child(1)>label").css("backgroundColor","white");
    $("#radioSelect>div:nth-child(2)>label").css("backgroundColor","#0075ef");
});



/*$(function(){
    $('#msComboTest').msDropDown();
});*/

function init() {
    gapi.load('auth2', function() {
        gapi.auth2.init();
        options = new gapi.auth2.SigninOptionsBuilder();
        options.setPrompt('select_account');
        // 추가는 Oauth 승인 권한 추가 후 띄어쓰기 기준으로 추가
        options.setScope('email profile openid https://www.googleapis.com/auth/user.birthday.read');
        // 인스턴스의 함수 호출 - element에 로그인 기능 추가
        // GgCustomLogin은 li태그안에 있는 ID, 위에 설정한 options와 아래 성공,실패시 실행하는 함수들
        gapi.auth2.getAuthInstance().attachClickHandler('startGoogle', options, onSignIn, onSignInFailure);
    })
}

function onSignIn(googleUser) {
    var access_token = googleUser.getAuthResponse().access_token
    $.ajax({
        // people api를 이용하여 프로필 및 생년월일에 대한 선택동의후 가져온다.
        url: 'https://people.googleapis.com/v1/people/me'
        // key에 자신의 API 키를 넣습니다.
        , data: {personFields:'birthdays', key:'AIzaSyBOdmeC4SOSzXmPGLEM2vZueqiBSWKg3wk', 'access_token': access_token}
        , method:'GET'
    })
        .done(function(e){
            //프로필을 가져온다.
            var profile = googleUser.getBasicProfile();
            console.log(profile)
        })
        .fail(function(e){
            console.log(e);
        })
}
function onSignInFailure(t){
    console.log(t);
}