let arayListCustomer = [];
let arayListEmployee = [];
let inputContent = document.getElementById("contentShow");
//table customer
let tableCustomer = document.getElementById("tblCustomer");
let customerName = document.getElementById("inputName");
let customerAddress = document.getElementById("inputAddress");

//table employee
let tablelEmployee = document.getElementById("tblEployee");
let employeeSalary= document.getElementById("inputSalary");
let employeeWorkDay = document.getElementById("inputWorkDay");


let customer = new Customer();
let employee = new Employee();

function showChoose(choose) {
    if (choose === "Customer") {
        inputContent.innerText = "Table Customer";
        displayCustomer.style.display = "block";
        displayEmployee.style.display = "none";
        customer.setName(customerName.value);
        customer.setAddress(customerAddress.value);
        arayListCustomer.push(customer);
        customerName.value = "";
        customerAddress.value = "";
        addInfo();
    } else {
        inputContent.innerText = "Table Employee";
        displayEmployee.style.display = "block";
        displayCustomer.style.display = "none";
        employee.setSalary(employeeSalary.value);
        employee.setWorkDay(employeeWorkDay.value);
        arayListEmployee.push(employee);
        employeeSalary.value = "";
        employeeWorkDay.value = "";
        addInfo();
    }
}

function addInfo() {
    showInfo();
}

function showInfo() {
    var drawTable = "<tr><th>Name</th>\n" +
                    "<th>Address</th>\n" +
                    "</tr>";
    for(var i = 0 ; i < arayListCustomer.length; i++){
        drawTable += "<tr>" +
            "<td>"+ arayListCustomer[i].getName()  + "</td>" +
            "<td>"+ arayListCustomer[i].getAddress() +"</td>" +
            "<td><button onclick='deleteProduct("+ i +")'>Remove</button></td>" +
            "</tr>"
    }
    tableCustomer.innerHTML = drawTable;
}



