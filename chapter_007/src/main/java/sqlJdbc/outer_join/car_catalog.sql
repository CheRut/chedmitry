create table transmission (
	id serial primary key,
	name character varying(30)
);

create table car_body(
	id serial primary key,
	name character varying(10)
);


create table engine(
	id serial primary key,
	name character varying(30)
);

create table car(
	id serial primary key,
	name character varying(20),
	engine_id int references engine(id),
	transmission_id int references transmission(id),
	car_body_id int references car_body(id)
);

insert into transmission(name) values('механическая трансмиссия');
insert into transmission(name) values('автоматическая трансмиссия');
insert into transmission(name) values('вариатор');


insert into car_body(name) values('седан');
insert into car_body(name) values('хетчбэк');
insert into car_body(name) values('купэ');
insert into car_body(name) values('минивен');


insert into engine(name) values('дизельный двигатель');
insert into engine(name) values('бензиновый двигатель');
insert into engine(name) values('роторный двигатель');
insert into engine(name) values('электродвигатель');

insert into car(name,engine_id,transmission_id,car_body_id) values('mazda',3,2,3);
insert into car(name,engine_id,transmission_id,car_body_id) values('ford',1,1,2);
insert into car(name,engine_id,transmission_id,car_body_id) values('mitsubishi',2,1,1);



select c.name,eng.name,tm.name,cb.name from car as c 
left outer join engine as eng on c.engine_id = eng.id
left outer join transmission as tm on c.transmission_id = tm.id
left outer join car_body as cb on c.car_body_id = cb.id;


select t.name  from transmission as t left outer join car as c on c.transmission_id = t.id where c.transmission_id is null;

select e.name  from engine as e left outer join car as c on c.engine_id = e.id where c.engine_id is null;

select cb.name  from car_body as cb left outer join car as c on c.car_body_id = cb.id where c.car_body_id is null;






