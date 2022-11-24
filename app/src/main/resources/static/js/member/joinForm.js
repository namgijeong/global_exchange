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
        return;
    }
    /*
    $.ajax({
        url: "/member/checkId.me",
        data: {"memberId": memberId},
        success: function(result){
            let message, color;

            if(result == "true"){
                message = "사용 가능한 아이디입니다.";
                color = "blue";
                check = true;
            }else{
                message = "중복된 아이디입니다.";
                color = "red";
            }

            $("#memberIdResult").css("color", color);
            $("#memberIdResult").text(message);
        },
        error: function(a, b, c){
            console.log(a, b, c);
        }
    });
    */
}
function checkNick(memberNick) {

    if (!memberNick) {
        $("#memberNickResult").text("닉네임을 입력해주세요.");
        $("#memberNickResult").css("color", "red");
        $("#memberNickResult").css("display", "block");
        $("#memberNick").css("border", "1px solid red");
        return;
    } else {
        $("#memberNickResult").text("");
        $("#memberNickResult").css("display", "none");
        $("#memberNick").css("border", "1px solid rgb(238, 238, 238)");
        return;
    }
    /*
    $.ajax({
        url: "/member/checkId.me",
        data: {"memberId": memberId},
        success: function(result){
            let message, color;

            if(result == "true"){
                message = "사용 가능한 아이디입니다.";
                color = "blue";
                check = true;
            }else{
                message = "중복된 아이디입니다.";
                color = "red";
            }

            $("#memberIdResult").css("color", color);
            $("#memberIdResult").text(message);
        },
        error: function(a, b, c){
            console.log(a, b, c);
        }
    });
    */
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

