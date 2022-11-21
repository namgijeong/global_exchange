const div = document.querySelector(".banner");
const arrows = document.querySelectorAll("div.arrow");
//const btns = document.querySelectorAll(".btn");
const firstDiv = document.createElement("div");
const lastDiv = document.createElement("div");
var count = 0;
var buttonCheck = true;
var numberButtonCheck = true;
//var temp = btns[count];
//기존 이미지 123456에서 자연스럽게 넘기고 눈속임을 하기 위해서 동적으로 6 123456 1을 추가
//firstDiv.innerHTML = `<img th:src="@{/images/main/006.png}">`;
firstDiv.innerHTML = `<img src="/images/main/006.png">`;
console.log(div);
console.log(firstDiv.innerHTML);
div.insertBefore(firstDiv, document.querySelector("div.banner div"));

//lastDiv.innerHTML = `<img th:src="@{/images/main/001.png}">`;
lastDiv.innerHTML = `<img src="/images/main/001.png">`;
div.appendChild(lastDiv);
//6 123456 1 이므로 1을 기본적으로 보이게하려면 한칸(90vw)왼쪽으로 이동
div.style.transform = "translate(-768px)";
//1을 기본적으로 보이게했으니 위치를 나타내주는 1버튼을 검은색으로 실행
//btns[0].style.background = "black";
//오른쪽으로 자동으로 0.5초마다 넘기는 이벤트 실행
let inter = setInterval(autoSlide, 2500);

// function autoSlide(){
//     count ++;
//     if(count == 6){
//         count = 0;
//     }
//     div.style.transform = "translate(-" + 90 * count +"vw)"
//     div.style.transition = "transform 0.5s";
// }
//오른쪽으로만 넘기는 이벤트
function autoSlide(){
    div.style.transition = "transform 0.5s";
    //한칸씩 움직인다는 뜻
    count ++;
    if(count == 6){ // 마지막 배너(6번)
        //움직이기전 위치를 나타내는 버튼 배경을 하얀색으로
        //btns[count - 1].style.background = "white";
        // 6 123456 1 이므로 123456을 보이기위해서는 인덱스 하나씩 다 증가시킨셈이라서 +1을 해준다
        //옆으로 부드럽게 넘기는 효과로 보이기 위해 가장 마지막 끝자리 1을 보여준다
        //사실상 123456의 1을 나타내므로 1을 나타내는 인덱스 0
        div.style.transform = "translate(-" + 768 * (count + 1) +"px)"
        count = 0;
        //btns[count].style.background = "black";
        //0초로 눈속임
        //123456의 1은 앞에 6이 있으므로 이미 한칸을 이동시킨셈이다
        setTimeout(function(){
            div.style.transition = "transform 0s";
            div.style.transform = "translate(-768px)";
        }, 500);
    }else{
        //btns[count - 1].style.background = "white";
        //btns[count].style.background = "black";
        div.style.transition = "transform 0.5s";
        div.style.transform = "translate(-" + 768 * (count + 1) +"px)"
    }
    //현재인덱스를 temp에 저장하여 그전 인덱스를 기억하게 하여 버튼을 하얀색으로 바꾸게하기 위해서
    //temp = btns[count];
}

// 이전버튼, 다음버튼
arrows.forEach(arrow => {
    arrow.addEventListener("click", function(){
        //이벤트가 다 끝나지 않은 0.5초동안 광클금지
        //true일때만 이벤트 실행
        if(buttonCheck){
            buttonCheck = false;
            let arrowType = arrow.classList[1];
            //자동넘기기 이벤트 일시중지
            clearInterval(inter);
            div.style.transition = "transform 0.5s";
            if(arrowType == "prev"){
                count --;
                if(count == -1){
                    //6 123456 1에서 가장 맨 왼쪽 6으로 넘어가게하기
                    div.style.transform = "translate(0px)";
                    //눈속임으로 사실상 123456의 6으로 이동
                    setTimeout(function(){
                        div.style.transition = "transform 0s";
                        div.style.transform = "translate(-4608px)";
                    }, 500);
                    //6인덱스 표시
                    count = 5;
                }else{
                    //6 123456 1 에서 맨앞에 6이 있으므로 인덱스+1을 해줘야한다
                    div.style.transform = "translate(-" + 768 * (count + 1) + "px)";
                }

            }else{
                count ++;
                if(count == 6){
                    div.style.transform = "translate(-" + 768 * (count + 1) + "px)";
                    setTimeout(function(){
                        div.style.transition = "transform 0s";
                        div.style.transform = "translate(-768px)";
                    }, 500);
                    count = 0;
                }else{
                    div.style.transform = "translate(-" + 768 * (count + 1) + "px)";
                }
            }
            //현재인덱스를 temp에 저장하여 그전 인덱스를 기억하게 하여 버튼을 하얀색으로 바꾸게하기 위해서
            //temp.style.background = "white";
            //temp = btns[count];
            //btns[count].style.background = "black";
            //일정시간이 지나면 자동이벤트 실행
            inter = setInterval(autoSlide, 2500);
            //2.5초후에 클릭허용
            setTimeout(()=>{buttonCheck = true}, 500);
        }
    });
});
// arrows.forEach(arrow => {
//     arrow.addEventListener("click", function(){
//         let arrowType = arrow.classList[1];
//         if(arrowType == "prev"){
//             count --;
//             if(count == -1){
//                 count = 5;
//             }

//         }else{
//             count ++;
//             if(count == 6){
//                 count = 0;
//             }
//         }

//         div.style.transform = "translate(-" + 90 * count +"vw)"

//     });
// });

// 원하는 번호의 배너로 이동
// btns.forEach((btn, i) => {
//     btn.addEventListener("click", function(){
//         count = i;
//         div.style.transform = "translate(-" + 90 * count +"vw)"
//     });
// });

/*
btns.forEach((btn, i) => {
    btn.addEventListener("click", function(){
        div.style.transition = "transform 0.5s";
        //0.5초 이벤트 실행하기 이전에 동그라미 버튼 광클금지
        if(numberButtonCheck){
            numberButtonCheck = false;
            //버튼이벤트 실행할동안 자동 이벤트 금지
            clearInterval(inter);
            count = i;
            div.style.transform = "translate(-" + 90 * (count + 1) +"vw)"
            temp.style.background = "white";
            temp = btns[count];
            btns[count].style.background = "black";
            //시간 지나면 자동 이벤트 실행
            inter = setInterval(autoSlide, 2500);
            //0.5초 지나면 동그라미 버튼 누른거 허용
            setTimeout(() => {numberButtonCheck = true}, 500);
        }
    });
});*/
