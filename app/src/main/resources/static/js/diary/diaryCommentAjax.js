let diaryCommentAjax=(function(){
    function add(diaryCommentVO, callback){
        $.ajax({
            url: "/diaryComment/commentWrite",
            type: "post",
            data: JSON.stringify(diaryCommentVO),
            contentType: "application/json; charset=utf-8",
            success: function(result){
                if(callback){
                    callback(result);
                }
            }/*,
            error: function(a, b, c){
                if(error){
                    error(a, b, c);
                }
            }*/
        });
    }

    function getList(param, callback){
        let page = param.page || 1;
        $.ajax({
            url: "/diaryComment/list/" + param.diaryNumber + "/" + page,
            success: function(answers){
                if (callback){
                    callback(answers);
                }
            },
            async:false

        })
    }

    function modify(diaryCommentVO, callback, error) {
        $.ajax({
            url: "/diaryComment/commentUpdate",
            type: "post",
            data: JSON.stringify(diaryCommentVO),
            contentType: "application/json; charset=utf-8",
            success: function () {
                if (callback) {
                    callback();
                }
            },
            error: function(a, b, c){
                if(error){
                    error(a, b, c);
                }
            }
        });
    }

    function remove(diaryCommentNumber, callback){
        $.ajax({
            url: "/diaryComment/commentRemove/" + diaryCommentNumber,
            type: "get",
            success: function(){
                if(callback){
                    callback();
                }
            }
        })
    }

    return {getList:getList, modify:modify, add:add, remove:remove}
})();