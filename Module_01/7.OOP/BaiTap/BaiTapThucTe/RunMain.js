let arayListCustomer = [];
let arayListEmployee = [];
let inputContent = document.getElementById("contentShow");
//table customer
let tableCustomer = document.getElementById("tblCustomer");
let customerName = document.getElementById("inputName");
let customerAddress = document.getElementById("inputAddress");

//table employee
let tableEmployee = document.getElementById("tblEployee");
let employeeSalary= document.getElementById("inputSalary");
let employeeWorkDay = document.getElementById("inputWorkDay");





function showChoose(choose) {
    if (choose === "Customer") {
        inputContent.innerText = "Table Customer";
        displayCustomer.style.display = "block";
        displayEmployee.style.display = "none";
    } else {
        inputContent.innerText = "Table Employee";
        displayEmployee.style.display = "block";
        displayCustomer.style.display = "none";
    }
}

function addInfoCustomer() {
    let customer = new Customer();
    customer.setAddress(customerAddress.value);
    customer.setName(customerName.value);
    arayListCustomer.push(customer);
    customerName.value = "";
    customerAddress.value = "";
    showInfoCustomer();
}

function addInfoEmployee() {
    let employee = new Employee();
    employee.setSalary(employeeSalary.value);
    employee.setWorkDay(employeeWorkDay.value);
    arayListEmployee.push(employee);
    employeeSalary.value = "";
    employeeWorkDay.value = "";
    showInfoEmployee();
}

function showInfoCustomer() {
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

function showInfoEmployee() {
    var drawTable = "<tr><th>Salary</th>\n" +
                    "<th>WorkDay</th>\n" +
                    "</tr>";
    for(var i = 0 ; i < arayListEmployee.length; i++){
        drawTable += "<tr>" +
            "<td>"+ arayListEmployee[i].getSalary()  + "</td>" +
            "<td>"+ arayListEmployee[i].getWorkDay() +"</td>" +
            "<td><button onclick='deleteProduct("+ i +")'>Remove</button></td>" +
            "</tr>"
    }
    tableEmployee.innerHTML = drawTable;
}




