insert into todo (ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE)
values (10001, 'heavenlight', 'Get AWS Certified', CURRENT_DATE(), false);

insert into todo (ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE)
values (10002, 'heavenlight', 'Get Azure Certified', CURRENT_DATE(), false);

insert into todo (ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE)
values (10003, 'heavenlight', 'Get GCP Certified', CURRENT_DATE(), false);

insert into todo (ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE)
values (10004, 'john', 'Learn DevOps', CURRENT_DATE(), false);

insert into users(name, password)
values ("heavenlight", "$2a$04$A459.NRmf49RgKEa5s3meuud8MYyOyGskA61YqfgJUoPdnBIChoSS");

insert into users(name, password)
values ("john", "$2a$04$A459.NRmf49RgKEa5s3meuud8MYyOyGskA61YqfgJUoPdnBIChoSS");

insert into authorities (type)
values ('ADMIN');
insert into authorities (type)
values ('USER');

insert into users_authorities (user_id,authority_id)
values (1,1);
insert into users_authorities (user_id,authority_id)
values (1,2);
insert into users_authorities (user_id,authority_id)
values (2,2);

