let meetCommentAjax=(function(){
    /*function add(meetAnswer, callback, error){
        $.ajax({
            url: "/meetingAndHelpComment",
            type: "post",
            data: JSON.stringify(reply),
            contentType: "application/json; charset=utf-8", //data에 JSON 작성 시 반드시 contentType 작성
            success: function(result){
                if(callback){
                    callback(result);
                }
            },
            error: function(a, b, c){
                if(error){
                    error(a, b, c);
                }
            }
        });
    }*/

    function getList(meetAnswerNumber, callback,error){
        console.log("ajax에서 url넘기기전 들어옴"+meetAnswerNumber);
        $.ajax({
            url: "/meetingAndHelpComment/list/" + meetAnswerNumber ,
            success: function(comments){
                if (callback){
                    callback(comments);
                }
            },
            error: function(a, b, c){
                if(error){
                    error(a, b, c);
                }
            }


        })
    }
    return {getList:getList}
})();