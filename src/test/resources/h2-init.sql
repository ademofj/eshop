create table if not exists client_order (
  id              int not null primary key auto_increment
, status          varchar(10)
, order_date      date
, order_amount    double
);

create table if not exists order_item (
  id            int not null primary key auto_increment
, order_id      int not null
, product_code  varchar(20) not null
, price         double
);

create table if not exists product (
  id             int not null primary key auto_increment
, product_code   varchar(20) not null
, product_name   varchar(100)
);
