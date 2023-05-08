async function uploadFile() {
    const input = document.getElementById("uploadImg");
    const file = input.files[0];
    const formData = new FormData()

    formData.append('img', file);
    formData.append('id', 26);
    
    var response = await fetch('http://localhost:8082/update-product/img', {
        method: 'POST',
        body: formData
    })
    
    if(response.ok){
        document.getElementById('response').innerHTML='ok'
    }
    else{
        document.getElementById('response').innerHTML='not ok'
    }
}

async function aa(){
    console.log('aa')
    await fetch('http://localhost:8080/test')
    .then(response=>response.json())
    .then(data=>{
        console.log(data)
    })
    
}