--create table product
create table product (
id serial primary key,
name character varying(100),
type_id integer,
expired_date timestamp,
price float
);


--create table type
create table type(
id serial primary key,
name character varying(50)
);


--create relationship
alter table product add foreign key (type_id) references type(id);

-- fill table type data

insert into type(name) values ('сыр');
insert into type(name) values ('молоко');
insert into type(name) values ('мороженое');


-- fill product table
insert into product(name,type_id,expired_date,price) values ('Сыр Российский',1,'2018-01-12',140.35);
insert into product(name,type_id,expired_date,price) values ('Кубанская буренка',2,'2018-04-12',70);
insert into product(name,type_id,expired_date,price) values ('Сыр Голландский',1,'2018-02-14',170.25);
insert into product(name,type_id,expired_date,price) values ('Простоквашино',2,'2018-05-12',65);
insert into product(name,type_id,expired_date,price) values ('Веселый молочник',2,'2018-03-12',72);

insert into product(name,type_id,expired_date,price) values ('Ванильное мороженое',3,'2018-03-22',55);
insert into product(name,type_id,expired_date,price) values ('Шоколадное мороженое',3,'2018-04-12',60);
insert into product(name,type_id,expired_date,price) values ('Крем-брюле ',3,'2018-02-11',70);
insert into product(name,type_id,expired_date,price) values ('Эскимо',3,'2018-01-30',110);
insert into product(name,type_id,expired_date,price) values ('фруктовый лед',3,'2018-02-02',40.35);
insert into product(name,type_id,expired_date,price) values ('Чабан',2,'2018-06-16',80);

insert into product(name,type_id,expired_date,price) values ('Новая деревня',2,'2018-01-17',63.45);
insert into product(name,type_id,expired_date,price) values ('Домик в деревне',2,'2018-05-12',68);
insert into product(name,type_id,expired_date,price) values ('Parmalat',2,'2018-07-13',80);
insert into product(name,type_id,expired_date,price) values ('ARO',2,'2018-08-13',77);
insert into product(name,type_id,expired_date,price) values ('Юбилейный',1,'2018-04-14',128.35);
insert into product(name,type_id,expired_date,price) values ('Сыр Косичка',1,'2018-02-18',70);
insert into product(name,type_id,expired_date,price) values ('Сыр Плавленый',1,'2018-07-10',40);
insert into product(name,type_id,expired_date,price) values ('Вкуснотеево',2,'2018-03-03',67);
insert into product(name,type_id,expired_date,price) values ('Сыр Пармезан',1,'2018-01-01',144);
insert into product(name,type_id,expired_date,price) values ('Сыр Тысяча озер',1,'2018-03-18',158.99);
insert into product(name,type_id,expired_date,price) values ('Сыр Карлов двор',1,'2018-05-05',827);
insert into product(name,type_id,expired_date,price) values ('Сыр Золото европы',1,'2018-02-01',173);
insert into product(name,type_id,expired_date,price) values ('Фрилайн',1,'2018-04-12',133);



--1. Написать запрос получение всех продуктов с типом "СЫР"
	select p.name from product as p inner join  type as t on t.id = p.type_id and t.name = 'сыр';
	
--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное" 
	select p.name from product as p  where p.name like '%мороженое%';

--3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце
	select * from product as p  where p.expired_date < '2018-02-01';

--4. Написать запрос, который вывод самый дорогой продукт.	
	select * from product as p  where p.price = (select max(price)from product);
	
--5. Написать запрос, который выводит количество всех продуктов определенного типа.
	 select count(p.id) from product as p  where p.type_id = 2;

--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
	select * from product as p  where p.type_id between 1 and 2;

--7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.	
	select t.id, t.name from type as t where t.id in (select type_id from product  group by type_id having count(type_id) < 10 );
	
--8. Вывести все продукты и их тип.
	select p.name,t.name from product p inner join type t on p.type_id=t.id;
	
