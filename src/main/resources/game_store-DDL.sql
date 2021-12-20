create schema game_store;

drop table game

create table game (
	id serial primary key,
	name varchar(128) not null,
	platform varchar(128) not null,
	publisher varchar(128) not null,
	price numeric(8, 2), --Precision set up to 999999.99
	quantity_on_hand integer not null,
	quantity_ordered integer not null
);