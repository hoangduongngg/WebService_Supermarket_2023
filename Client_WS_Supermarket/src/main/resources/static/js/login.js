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
        var response = await fetch('http://127.0.0.1:8090/account/dologin', {
            method: 'POST',
            body: JSON.stringify({
                "username": username,
                "password": password
            }),
            headers: {
                'Content-Type': 'application/json',
            }
        })
        if (response.status == 404 || response.status == 401) {
            errorMessage.innerHTML = 'Sai thông tin tài khoản hoặc mật khẩu!'
            errorMessage.style.color = 'red'
        } else if (response.ok) {
            const responseData = await response.json()
            sessionStorage.setItem('isLogin', true)
            sessionStorage.setItem('id-accout-login', responseData.id)
            sessionStorage.setItem('id-customer-login', responseData.idCustomer)
            window.location.href = 'http://127.0.0.1:8090/'
        }
    }
}

