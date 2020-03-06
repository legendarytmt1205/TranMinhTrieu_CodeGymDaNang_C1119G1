-- insert into `db_furama`.departments(department_name) 
-- values ('Laundry'),('receptionist'),('restaurant'),('security'),('office');

-- insert into `db_furama`.positions(position_name) 
-- values ('Manager'),('head_office'),('Supervisor'),('staff');

-- insert into `db_furama`.educations(education_name) 
-- values ('Postgradute'),('university_graduate'),('college_graduate'),('secondary_graduate');

insert into `db_furama_resort`.employees(full_name,birthday,id_card,salary,phone_number,email, address)
values('Hoàng Văn Khanh','1990-01-24', '012312345', 7000000.00, '076121212', 'abc1@gamil.com', 'Quảng Trị'),
('Đặng Văn B', '1970-07-12', '012312346', 20000000.00, '0932121234', 'abc2@gamil.com', 'Đà Nẵng'),
('Trần C', '1991-02-14', '012312347', 9000000.00, '033121256', 'abc3@gamil.com', 'Quảng Bình'),
('Khánh Trang', '1994-10-12', '012312348', 7000000.00, '044121278', 'Trang@gamil.com', 'Quảng Trị'),
('Nguyễn Thị Trang', '1992-11-11', '012312398', 15000000.00, '0231213412', 'ab23@gamil.com', 'Đà Nẵng'),
('Hoàng Thị Ngọc Quỳnh', '1994-08-06', '012312432', 15000000.00, '012123434', 'abewq4@gamil.com', 'Huế'),
('Trần Thị Thu Út', '1980-06-19',' 012312567', 9000000.00, '02324356', 'abqwe@gamil.com', 'Đà Nẵng'),
('Lê Văn C', '1982-05-21', '012845743', 7000000.00, '0821212345', 'abqq223@gamil.com', 'Quảng Nam'),
('Hoàng Ngọc G', '1981-04-14', '012324183', 15000000.00, '094121278', 'abcwqe224@gamil.com', 'Hà Nội'),
('Trần Long Hoàng Ngọc', '1979-02-15', '012324179', 15000000.00, '0541212986', 'abdsad4@gamil.com', 'Quảng Trị');

insert into `db_furama_resort`.type_customers(type_customer_name)
values ('Diamond'),('Platinium'),('Gold'),('Silver'),('Member');

insert into `db_furama_resort`.customers(full_name,birthday,id_card,phone_number,email,address,type_customer_id)
values ('Hoàng Long', '1970-03-15', '098765432', '023567344', 'zxcs@gmail.com', 'Quảng Trị', 1),
('Trần Văn A', '1968-09-15', '098712322', '023567865', 'zxwqe232cs@gmail.com', 'Đà Nẵng', 1),
('Nguyễn Ngọc B', '1990-07-15', '06755432', '023567432', 'zx23cs@gmail.com', 'Quảng Trị', 3),
('Lê Văn C', '1969-06-15', '098734534', '023567423', '5asd6@gmail.com', 'Quảng Trị', 5),
('Nguyễn Hà', '1983-05-15', '09886652', '023549676', 'zxmkucs@gmail.com', 'Đà Nẵng', 2),
('Hoàng Văn C', '1985-11-25', '094355432', '023565624', 'zxqwecs@gmail.com', 'Vinh', 1),
('Trần B', '1995-04-25', '098765232', '023567631', 'zxcs@gmail.com', 'Quảng Ngãi', 1),
('Đoàn A', '1993-06-24', '098765412', '023567231', 'fdsd@gmail.com', 'Quảng Trị', 2),
('Trần Văn A', '1982-01-23', '098767332', '023847324', 'zghghgxcs@gmail.com', 'Đà Nẵng', 1),
('Lê Văn K', '1965-02-04', '097123132', '098367344', 'zxwewcs@gmail.com', 'Quảng Ngãi', 2);

insert into `db_furama_resort`.type_rents(type_rent_name,price) 
values ('Năm',100000000.00),
('Tháng',15000000.00),('Ngày',1000000.00),('Gio',200000.00);

insert into `db_furama_resort`.type_services(type_services_name) 
values ('Villa'),('House'),('Room');

insert into `db_furama_resort`.services(service_status,service_name,area_used,number_floors,number_max_people,rental_costs,accompanied_service_status,type_rent_id,type_service_id)
values('a','Villa1',100.00,3,3,1000000.00,'f',2,1),
('b','House1', 50.00, 2 , 3, 750000.00,'u',3, 2),
('c','House2', 60.00, 2 , 5, 850000.00,'c',4, 2),
('d','Room1', 30.00, 1 , 3, 300000.00,'k',3, 3),
('e','Villa2', 150.00, 4 , 5, 1500000.00,'y',3, 1),
('f','House3', 50.00, 1 , 3, 5000000.00,'o',2, 2),
('g','Romm2', 25.00, 1 , 2, 1500000.00,'u',4, 3),
('k','Villa3', 100.00, 2 , 2, 6000000.00,'e',2, 1);


insert into `db_furama_resort`.accompanied_services(accompanied_service_name,price,unit,accompanied_service_status)
values('Massage',500000.00,1,'good'),
('Car',400000.00,1,'good'),
('foods',150000,2,'good'),
('drinks',100000,2,'good'),
('Karaoke',5000000,5,'good');

insert into `db_furama_resort`.contracts(contract_date,contract_date_end,deposit,total,employee_id,customer_id,service_id)
values('2019-09-24','2019-10-01','5000000.00',25000000.00,1,3,1),
('2019-10-24','2019-10-30',2000000.00,12000000.00, 1, 2,1),
('2019-01-31','2019-02-24',1000000.00,9000000.0, 3,3,1),
('2015-05-12','2019-02-20',2000000.00,15000000.00, 2,6,1),
('2019-04-12','2019-04-15', 1000000.00,12000000.00, 5,4,5),
('2016-01-12','2019-01-15',1000000.00,13000000.00, 1,1,2),
('2019-06-20','2019-03-01',2000000.00,14000000.00,7,7,8);


insert into `db_furama_resort`.contract_details(quantity,contract_id,accompanied_service_id)
values (3,1,3),(4,6,3),(2,3,2),(5,4,4),(2,1,1),(2,2,1),(2,7,2),(1,7,3);

INSERT INTO `db_furama_resort`.`role` (`role_id`, `name`) VALUES ('3', 'ROLE_ADMIN');
INSERT INTO `db_furama_resort`.`role` (`role_id`, `name`) VALUES ('3', 'ROLE_USER');

INSERT INTO `db_furama_resort`.`user` (`user_id`, `email`, `password`)
VALUES ('3', 'tmt@gmail.com', '$2a$10$mEIbCMGnV5g2ws3YlxsiM.JoIkV5fPZ6y1mDqi3qUsI42wCzPQP.C');

INSERT INTO `db_furama_resort`.`user` (`user_id`, `email`, `password`)
VALUES ('3', 'user@gmail.com', '$2a$10$mEIbCMGnV5g2ws3YlxsiM.JoIkV5fPZ6y1mDqi3qUsI42wCzPQP.C');

INSERT INTO `db_furama_resort`.`user_role` (`user_role_id`, `role_id`, `user_id`)
VALUES ('1', '1', '1');
INSERT INTO `db_furama_resort`.`user_role` (`user_role_id`, `role_id`, `user_id`)
VALUES ('2', '2', '2');