--  psql -h localhost -p 5432 -U tshimoda -d pokemon_app_db

create table if not exists elemental
(
	id serial primary key,
	name_en VARCHAR(10) unique not null,
	name_ja VARCHAR(10) unique not null
);


create table if not exists pokemon
(
	id serial primary key,
	name VARCHAR(20) unique not null,
	pokedex_id Integer unique not null,
	image BYTEA null
);

create table if not exists pokemon_elemental
(
	elemental_id bigint not null,
	pokemon_id bigint not null,
	primary key (pokemon_id,elemental_id),
	foreign key (pokemon_id) references pokemon(id),
	foreign key (elemental_id) references elemental(id)
);