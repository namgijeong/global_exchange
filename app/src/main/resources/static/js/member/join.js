/*function init() {
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
}*/


// $("#memberId").on("blur", function(){checkId($(this).val());});
// $("#memberPw").on("blur", function(){checkNick($(this).val());});

// function checkValue()
// {
//     if($('input[name="memberIdCheck"]').val()==''){
//         alert("아이디를 입력하세요.");
//         return false;
//     }
//
//     if($('input[name="memberPasswordCheck"]').val()==''){
//         alert("비밀번호를 입력하세요.");
//         return false;
//     }
//     $('input[name="memberId"]').val($('input[name="memberIdCheck"]').val());
//     $('input[name="memberPassword"]').val($('input[name="memberPasswordCheck"]').val());
//     // $("#realSubmit").submit();
//     $("form").submit();
//
//     // location.href="/member/emailLogin";
// }
//
//

function goGoogleOauth(){
    location.href="http://localhost:22222/member/googleLogin";
}


