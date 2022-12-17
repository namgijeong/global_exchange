let lodgingAnswerAjax=(function(){
    function add(lodgingAnswerVO, callback){
        $.ajax({
            url: "/needLodgingAnswer/answerWriteOk",
            type: "post",
            data: JSON.stringify(lodgingAnswerVO),
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
            url: "/needLodgingAnswer/list/" + param.lodgingNumber + "/" + page,
            success: function(answers){
                if (callback){
                    callback(answers);
                }
            },
            async:false

        })
    }

    function modify(lodgingAnswerVO, callback, error) {
        $.ajax({
            url: "/needLodgingAnswer/answerUpdateOk",
            type: "post",
            data: JSON.stringify(lodgingAnswerVO),
            contentType: "application/json; charset=utf-8",
            success: function () {
                if (callback) {
                    callback();
                }
            }
        });
    }

    function remove(lodgingAnswerNumber, callback){
        $.ajax({
            url: "/needLodgingAnswer/answerRemove/" + lodgingAnswerNumber,
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