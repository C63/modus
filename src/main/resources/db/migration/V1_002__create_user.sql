-- alias: a
create table account (
  account_id    bigserial primary key,
  username      varchar(100)             not null,
  email         varchar(254),
  password_hash varchar(64)              not null,
  created_at    timestamp with time zone not null default (current_timestamp),
  modified_at   timestamp with time zone
);

create unique index account_email_idx
  on account (lower(email));

create unique index account_username_idx
  on account (lower(username));

create trigger account_modified_at_trigger
before update on account
for each row
execute procedure update_modified_at();