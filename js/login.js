/*alert("login.js 호출")*/
/*아이디 비번 정확하게 입력되었는지 검사*/
function checkLogin(){
    /*
        1. 임시로 로그인 기능을 확인하고자, 회원들의 정보를 담은 객체배열을 생성하여.
        2. 입력한 아이디를 가진 회원이 있는지 확인한다.
        3. 만약 없다면 아이디가 틀렸다는 알림을 띄우고, 다시 입력하도록 한다.
        4. 만약 아이디가 맞다면 비밀번호가 맞는지 확인한다.
        5. 만약 비밀번호가 틀렸다면 틀렸다고 알림을 띄우고, 다시 입력하도록 한다.
        6. 만약 아이디와 비밀번호가 모두 맞다면, form을 제출한다.
    */

    /*1번: 임시 회원정보 객체배열 생성*/
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

    let id = document.getElementById("id").value;
    let password = document.getElementById("password").value;
    let formActionPage = document.getElementById("container").getAttribute("action");
    /*alert(id + ", " +password);*/
    /*alert(formActionPage);*/

    /*2번*/
    let member = members.find(member => member.id === id);

    /*3~6번*/
    if(!member){
        alert("아이디가 틀렸습니다.");
        event.preventDefault(); //form 제출x
        window.location.href="../html/login.html";
    } else {
        if(password != member.password){
            alert("비밀번호가 틀렸습니다");
            event.preventDefault(); //form 제출x
            window.location.href="../html/login.html";
        }
        else {
            alert("아이디와 비밀번호 모두 맞았습니다");
            //form 제출
        }
    }
}