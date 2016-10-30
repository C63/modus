-- alias: p
create table project (
  project_id          uuid primary key,
  project_name        varchar(100),
  project_description text,
  enabled             boolean                  not null default true,
  created_at          timestamp with time zone not null default (current_timestamp),
  modified_at         timestamp with time zone
);

create trigger project_modified_at_trigger
before update on project
for each row
execute procedure update_modified_at();

-- alias: ap
create table account_project (
  account_id  bigint references account (account_id),
  project_id  uuid references project (project_id),
  enabled     boolean                  not null default true,
  created_at  timestamp with time zone not null default (current_timestamp),
  modified_at timestamp with time zone
);

create trigger account_project_modified_at_trigger
before update on account_project
for each row
execute procedure update_modified_at();

alter table account
  add column enabled boolean not null default true;