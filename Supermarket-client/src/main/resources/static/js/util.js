function changeDisplay(dropdownId) {
    document.getElementById(dropdownId).classList.toggle("show");
}

function filterByName(searchId, dropdownId) {
    var input, filter, ul, li, a, i;
    input = document.getElementById(searchId);
    filter = input.value.toUpperCase();
    div = document.getElementById(dropdownId);
    a = div.getElementsByTagName("a");
    for (i = 0; i < a.length; i++) {
        txtValue = a[i].textContent || a[i].innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            a[i].style.display = "";
        } else {
            a[i].style.display = "none";
        }
    }
}
function selectProduct(productNameDisplayField, dropdownField, productIdField, productNameField, id, name){
    changeDisplay(dropdownField);
    document.getElementById(productNameDisplayField).innerText = name;
    document.getElementById(productIdField).value = id;
    document.getElementById(productNameField).value = name;
}