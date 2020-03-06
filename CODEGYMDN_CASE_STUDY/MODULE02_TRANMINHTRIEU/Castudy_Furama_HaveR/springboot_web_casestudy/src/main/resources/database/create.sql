drop database if exists `db_furama_resort` ;
create database `db_furama_resort`;
use `db_furama_resort`;
Create Table `db_furama_resort`.type_customers (
    type_customer_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    type_customer_name nvarchar(50)
);

Create Table `db_furama_resort`.customers (
    customer_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    full_name nvarchar(50) not null,
	birthday date,
    id_card varchar(45),
	phone_number varchar(50),
    email varchar(50) not null,
    address nvarchar(500) not null,
    type_customer_id INT UNSIGNED,
	constraint fk_type_customer foreign key(type_customer_id) references type_customers(type_customer_id)
);

Create Table `db_furama_resort`.type_rents (
    type_rent_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    type_rent_name nvarchar(50),
    price int
);  

-- Create Table `db_furama`.positions (
--     position_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
--     position_name nvarchar(50)
-- );  

-- Create Table `db_furama_resort`.educations (
--     education_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
--     education_name nvarchar(50)
-- );  

-- Create Table `db_furama_resort`.departments (
--     department_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
--     department_name nvarchar(50)
-- );  

Create Table `db_furama_resort`.employees (
    employee_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    full_name nvarchar(50) not null,
    birthday date,
    id_card varchar(45),
    salary decimal(18,2),
	phone_number varchar(50),
    email varchar(50) not null,
    address nvarchar(500) not null
	-- position_id INT UNSIGNED,
-- 	constraint fk_position foreign key(position_id) references positions(position_id),
-- 	education_id INT UNSIGNED,
-- 	constraint fk_education foreign key(education_id) references educations(education_id),
--     department_id INT UNSIGNED,
-- 	constraint fk_department foreign key(department_id) references departments(department_id)
);

Create Table `db_furama_resort`.type_services (
    type_service_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	type_services_name varchar(50)
);  

Create Table `db_furama_resort`.accompanied_services (
    accompanied_service_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	accompanied_service_name varchar(50),
    price int,
    unit varchar(50),
    accompanied_service_status varchar(30)
);  

Create Table `db_furama_resort`.services (
    service_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	service_status varchar(30),
	service_name varchar(50),
    area_used int,
    number_floors int,
    number_max_people int,
    rental_costs decimal(18,2),
    accompanied_service_status varchar(30),
	type_rent_id INT UNSIGNED,
	constraint fk_type_rent foreign key(type_rent_id) references type_rents(type_rent_id),
	type_service_id INT UNSIGNED,
	constraint fk_type_service foreign key(type_service_id) references type_services(type_service_id)
);  

Create Table `db_furama_resort`.contracts (
    contract_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    contract_date date,
    contract_date_end date,
    deposit decimal(18,2),
    total decimal(18,2),
    employee_id INT UNSIGNED,
	constraint fk_employee foreign key(employee_id) references employees(employee_id),
    customer_id INT UNSIGNED,
	constraint fk_customer foreign key(customer_id) references customers(customer_id),
    service_id INT UNSIGNED,
    constraint fk_service FOREIGN KEY(service_id) REFERENCES services(service_id)
);  

Create Table `db_furama_resort`.contract_details (
    contract_detail_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    quantity int,
    contract_id INT UNSIGNED,
	constraint fk_contract foreign key(contract_id) references contracts(contract_id),
	accompanied_service_id INT UNSIGNED,
	constraint fk_accompanied_service foreign key(accompanied_service_id) references accompanied_services(accompanied_service_id)
);  


Create Table `db_furama_resort`.role (
    role_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name nvarchar(50)
);

Create Table `db_furama_resort`.user (
    user_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    email nvarchar(50),
	password nvarchar(50)
);

Create Table `db_furama_resort`.user_role (
    user_role_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	role_id INT UNSIGNED NOT NULL,
	user_id INT UNSIGNED NOT NULL,
	foreign key(role_id) references roles(role_id),
	foreign key(user_id) references users(user_id),
);

