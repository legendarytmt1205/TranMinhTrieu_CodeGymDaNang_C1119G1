var inpName = document.getElementById("name");
var price = document.getElementById("price");
var discount = document.getElementById("discount");
var arrProduct = [];
var notification = document.getElementById("notification");
var tableProduct = document.getElementById("tableProduct");

function addProduct() {
    var phone = new Phone();
    phone.setName(inpName.value);
    phone.setDiscount(discount.value*1);
    phone.setPrice(price.value*1);
    arrProduct.push(phone);
    price.value = "";
    discount.value = "";
    inpName.value ="";
    notification.innerText = "Add Successfully !!!";
    notification.style.color = 'blue';
    show();
}
function show() {
    var drawTable = "<tr><th>Name</th>\n" +
        "<th>Price</th>\n" +
        "<th>Discount</th>\n" +
        "<th>Total Price</th>\n" +
        "<th>Action</th>\n" +
        "</tr>";
    for(var i = 0 ; i < arrProduct.length; i++){
        drawTable += "<tr>" +
            "<td>"+ arrProduct[i].getName()  + "</td>" +
            "<td>"+ arrProduct[i].getPrice() +"</td>" +
            "<td>" + arrProduct[i].getDiscount() + "</td>" +
            "<td>"+ arrProduct[i].getTotalPrice() +"</td>" +
            "<td><button onclick='deleteProduct("+ i +")'>Remove</button></td>" +
            "</tr>"
    }
    alert(drawTable);
    tableProduct.innerHTML = drawTable;
}
function deleteProduct(e) {
    arrProduct.splice(e,1);
    show();
}

var textContent = document.getElementById("textContent");
var btnShowAndHide = document.getElementById("btnShowAndHide");
textContent.style.visibility = 'hidden';
function test() {
    if(btnShowAndHide.innerText === "Show"){
        textContent.style.visibility = 'visible';
        btnShowAndHide.innerText = "Hide";
    }else{
        textContent.style.visibility = 'hidden';
        btnShowAndHide.innerText = "Show";
    }
}

