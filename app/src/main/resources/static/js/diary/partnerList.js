const modalContainer = document.querySelector(".modal-container");
const btnModal = document.querySelector("#mainFilter>button");
const btnsRadio=document.querySelectorAll(".modal-input");
const CirclesRadio=document.querySelectorAll(".modal-radio-circle");

// 부모스크롤 비활성화
const openModal = () => {
    document.body.style.overflow = "hidden";
};

// 부모스크롤 활성화
const closeModal = () => {
    document.body.style.overflow = "unset";
};

btnModal.addEventListener("click", e => {
    modalContainer.style.display = "flex";
    openModal();
});

const closeBtn = modalContainer.querySelector(".close-btn")
closeBtn.addEventListener("click", e => {
    modalContainer.style.display = "none";
    closeModal();
});
/*
적용이 안됨
modalContainer.addEventListener("click", e => {
    const evTarget = e.target;
    if(evTarget.classList.contains("modal-overlay")) {
        modalContainer.style.display = "none"
    }
});

 */

let prev;
btnsRadio.forEach((btnRadio,index)=>{
    btnRadio.addEventListener("click",function(){
        if(prev!=null){
            prev.style.backgroundColor="white";
        }

        CirclesRadio[index].style.backgroundColor="skyblue";
        prev=CirclesRadio[index];
        console.log(index);


    });

});