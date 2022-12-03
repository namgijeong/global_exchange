let meetAnswerAjax=(function(){
    function add(meetAnswerVO, callback){
        $.ajax({
            url: "/meetingAndHelpAnswer/answerWriteOk",
            type: "post",
            data: JSON.stringify(meetAnswerVO),
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
            url: "/meetingAndHelpAnswer/list/" + param.meetNumber + "/" + page,
            success: function(answers){
                if (callback){
                    callback(answers);
                }
            },
            async:false

        })
    }

    function modify(meetAnswerVO, callback, error) {
        $.ajax({
            url: "/meetingAndHelpAnswer/answerUpdateOk",
            type: "post",
            data: JSON.stringify(meetAnswerVO),
            contentType: "application/json; charset=utf-8",
            success: function () {
                if (callback) {
                    callback();
                }
            }
        });
    }


    return {getList:getList, modify:modify, add:add}
})();