create table organizations(
  org_id serial primary key,
  org_name varchar(32) unique not null,
  org_description varchar(256)
);