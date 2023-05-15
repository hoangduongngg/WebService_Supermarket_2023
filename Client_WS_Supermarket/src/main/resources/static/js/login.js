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
        var response = await fetch('http://127.0.0.1:8080/login', {
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
            const responseData = await response.json()
            errorMessage.innerHTML = 'Sai thông tin tài khoản, mật khẩu'
            errorMessage.style.color = 'red'
            console.log(responseData);
        } else if (response.ok) {
            const responseData = await response.json()
            if (responseData.role === 'customer') {
                // window.location.href = 'http://127.0.0.1:8090/'
                // window.location.href = 'http://localhost:8090/'
                window.location.href = 'http://localhost:8090'
            }
            else{
                window.location.href = 'http://127.0.0.1:8090/product/listProduct'
            }
        }
    }
}

