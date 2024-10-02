/*alert("join.js 호출");*/
/*아이디 중복검사, 비밀번호 유효성 검사*/
/*
    1. 아이디 중복확인을 한다.
    1-1. 만약 중복되면 '이미 존재하는 아이디입니다.'의 텍스트 색깔을 빨간색으로 바꾼다.
    1-2. 만약 사용가능한 아이디이면 '사용가능한 아이디입니다.'라고 텍스트 내용을 바꾸고, 초록색으로 나타낸다.
    2. 비밀번호가 특수문자, 소문자, 숫자를 포함하여 8자이상인지 확인한다.
    2-1. 만약 비밀번호가 조건에 맞지 않으면, '특수문자, 소문자, 숫자를 포함하며 8자 이상이어야합니다'의 텍스트 색깔을 빨간색으로 바꾼다.
    3. 비밀번호 확인을 했을 때, 같지 않으면 '비밀번호가 일치하지 않습니다'의 텍스트 색깔을 빨간색으로 바꾼다.
    4. 이름이 입력되었는지 확인한다.
    5. 이름이 입력되지 않았으면, '이름은 필수입력 항목입니다'의 텍스트 색깔을 빨간색으로 바꾼다.
    6. 전화번호가 입력되었는지 확인하고, 문자열로 변환하여 변수에 저장한다.
    6-1. 유효한 전화번호가 아니면, '전화번호는 필수입력 항목입니다'의 텍스트 색깔을 빨간색으로 바꾼다.
    7. 이메일이 입력되었다면 골뱅이를 포함하여 문자열로 변환하여 저장한다.
*/

/*임시 회원정보 객체배열 생성*/
let members = [
    {
        id: "a",
        password: "1"
    },
    {
        id: "b",
        password: "2"
    },
    {
        id: "c",
        password: "3"
    }
]

/*유효성 검사에 따른 form제출 방지 여부*/
function check(){
    let valid = false;

    if(checkValidId() === true && checkValidPW() === true){
        valid = true;
        //form 제출
    } else {
        event.preventDefault();//form 제출x
    }
}

/*1.아이디 유효성 검사*/
function checkValidId(){
    /*중복 검사*/
    let id = document.getElementById("id").value;
    let text = document.getElementById("text_id");
    let message = "이미 존재하는 아이디입니다.";
    let color ="white";
    let valid = false;

    let existedMember = members.find(member => member.id === id);
    if(existedMember){
        message ="이미 존재하는 아이디입니다."
        color="red"
    }else{
        message = "사용할 수 있는 아이디입니다."
        color="green"
        valid=true;
    }
    showMessage(text, message, color);

    return valid;
}

/*2. 비밀번호 유효성 검사*/
function checkValidPW(){
    let valid = false;
    valid = true;
    return valid;
}

/*show message*/
function showMessage(text, content, color){
    text.innerText = content;
    text.style.color = color;
}