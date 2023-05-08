async function login() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    var errorMessage = document.getElementById("error-message");

    if (username == "") {
        errorMessage.innerHTML = "Please enter your username";
        errorMessage.style.color = "red";
    } else if (password == "") {
        errorMessage.innerHTML = "Please enter your password";
        errorMessage.style.color = "red";
    } else {
        errorMessage.innerHTML = "";
        await fetch('http://localhost:8080/login', {
            method: 'POST',
            body: JSON.stringify({
                "username":username,
                "password":password
            }),
            headers: {
                'Content-Type': 'application/json',
            }
        })
        .then(response=>{
            if(response.status==401){
                //sai mật khẩu
                return {
                    'status':'fail'
                }
            }
            else if(response.status == 404){
                //không có tài khoản
                return {
                    'status':'not found'
                }
            }
            return response.json()
        })
        .then(data=>{
            console.log(data)
        })
    }
}