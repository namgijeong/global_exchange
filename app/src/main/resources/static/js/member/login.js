function init() {
    gapi.load('auth2', function() {
        gapi.auth2.init();
        options = new gapi.auth2.SigninOptionsBuilder();
        options.setPrompt('select_account');
        // 추가는 Oauth 승인 권한 추가 후 띄어쓰기 기준으로 추가
        options.setScope('email profile openid https://www.googleapis.com/auth/user.birthday.read');
        // 인스턴스의 함수 호출 - element에 로그인 기능 추가
        // GgCustomLogin은 li태그안에 있는 ID, 위에 설정한 options와 아래 성공,실패시 실행하는 함수들
        gapi.auth2.getAuthInstance().attachClickHandler('goRealGoogleLogin', options, onSignIn, onSignInFailure);
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

function checkValue()
{
    if(!document.userInfo.id.value){
        alert("아이디를 입력하세요.");
        return false;
    }

    if(!document.userInfo.password.value){
        alert("비밀번호를 입력하세요.");
        return false;
    }

    // 비밀번호와 비밀번호 확인에 입력된 값이 동일한지 확인
    if(document.userInfo.password.value != document.userInfo.passwordcheck.value ){
        alert("비밀번호를 동일하게 입력하세요.");
        return false;
    }
}

// 취소 버튼 클릭시 로그인 화면으로 이동
function goLoginForm() {
    location.href="LoginForm.jsp";
}