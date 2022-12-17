let lodgingCommentAjax=(function(){
    function add(lodgingAnswerCommentVO, callback, error){
        $.ajax({
            url: "/needLodgingComment/commentWriteOk",
            type: "post",
            data: JSON.stringify(lodgingAnswerCommentVO),
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
    }

    function getList(lodgingAnswerNumber, callback,error){
        console.log("ajax에서 url넘기기전 들어옴"+lodgingAnswerNumber);
        $.ajax({
            url: "/needLodgingComment/list/" + lodgingAnswerNumber ,
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


        });
    }

    function modify(lodgingAnswerCommentVO, callback, error){
        $.ajax({
            url: "/needLodgingComment/commentUpdateOk",
            type: "post",
            data: JSON.stringify(lodgingAnswerCommentVO),
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
    }


    function remove(lodgingAnswerCommentNumber, callback){
        $.ajax({
            url: "/needLodgingComment/commentRemove/" + lodgingAnswerCommentNumber,
            type: "get",
            success: function(){
                if(callback){
                    callback();
                }
            }
        });
    }


    return {getList:getList, add:add , modify:modify, remove:remove}
})();