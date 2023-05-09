async function onload() {

    const isLogin = sessionStorage.getItem('isLogin')

    if (isLogin == 'true') {
        var cards = document.getElementById('cards')
        fetch('http://localhost:8082/products')
            .then(res => res.json())
            .then(data => {
                for (var i = 0; i < data.length; i++) {
                    cards.appendChild(creatCard(data[i]))
                }
            })
    }
    else{
        window.location.href = "../account/login.html";
    }

}

function creatCard(product) {
    var newDiv = document.createElement("div");

    newDiv.classList.add("card");

    var img = document.createElement("img");
    img.id = "img-product"
    img.src = product.img;
    img.alt = "product image";
    img.addEventListener('click', async function () {

        localStorage.setItem('id-product', product.id)
        window.location.href = 'productDetail.html'
    })
    img.style.width = "100%";

    var h1 = document.createElement("h1");
    h1.id = "name";
    h1.textContent = product.name;
    h1.addEventListener('click', async function () {

        localStorage.setItem('id-product', product.id)
        window.location.href = 'productDetail.html'
    })

    var p = document.createElement("p");
    p.id = "price";
    p.classList.add("price");
    p.textContent = product.price.toLocaleString('it-IT', { style: 'currency', currency: 'VND' });

    var button = document.createElement("button");
    button.textContent = "Add to Cart";
    button.onclick = function () {
    };

    newDiv.appendChild(img);
    newDiv.appendChild(h1);
    newDiv.appendChild(p);
    newDiv.appendChild(button);

    return newDiv;
}

function togglePriceInputs() {
    var priceInputs = document.getElementById('priceInputs');
    if (priceInputs.style.display === 'none') {
        priceInputs.style.display = 'flex';
    } else {
        priceInputs.style.display = 'none';
    }
}

async function search() {
    var keyword = document.getElementById("searchInput").value
    var minprice = document.getElementById('minPriceInput').value
    if (minprice == '') {
        minprice = 0
    }
    var maxprice = document.getElementById('maxPriceInput').value
    if (maxprice == '') {
        maxprice = 0
    }

    fetch('http://localhost:8082/search-product?keyword=' + keyword + '&minPrice=' + minprice + '&maxPrice=' + maxprice)
        .then(res => res.json())
        .then(data => {
            var cards = document.getElementById('cards')
            cards.innerHTML = ""
            for (var i = 0; i < data.length; i++) {
                cards.appendChild(creatCard(data[i]))
            }
        })

}

async function show() {
    var idProduct = localStorage.getItem('id-product')
    console.log(idProduct)
    fetch('http://localhost:8082/product?id=' + idProduct)
        .then(res => res.json())
        .then(data => {
            document.getElementById('img').src = data.img
            document.getElementById('name').innerHTML = data.name
            document.getElementById('price').innerHTML = data.price.toLocaleString('it-IT', { style: 'currency', currency: 'VND' });
            document.getElementById('description').innerHTML = data.description
        })


}

async function addProduct() {
    const file = document.getElementById('file-input');
    const img = file.files[0];
    const name = document.getElementById('name').value
    const price = document.getElementById('price').value
    const units = document.getElementById('units').value
    const exp = document.getElementById('exp').value
    const description = document.getElementById('decription').value

    var formData = new FormData()
    formData.append('img', img)
    formData.append('name', name)
    formData.append('price', price)
    formData.append('units', units)
    formData.append('expirationDate', exp)
    formData.append('description', description)

    var product = await fetch('http://localhost:8082/add-product-img', {
        method: 'POST',
        body: formData,

    })

    if (product.ok) {
        alert('thành công')
    }
    else {
        alert('Tên bị trùng')
    }
}

async function updateImg(id, img) {
    console.log(id)
    var formData = new FormData()
    formData.append('img', img);
    formData.append('id', id);

    var response = await fetch('http://localhost:8082/upload-image/img', {
        method: 'POST',
        body: formData
    })

    if (response.ok) {
        console.log('ok')
    }
    else {
        console.log(response.status)
    }

}