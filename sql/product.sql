drop table product if exists;

create table product (
	id int auto_increment primary key, 
	name varchar(100) not null, 
	price int not null
);

insert into product values(null, 'まぐろ', 100);
insert into product values(null, 'サーモン', 100);
insert into product values(null, 'えび', 100);
insert into product values(null, 'いか', 100);
insert into product values(null, 'えんがわ', 100);
insert into product values(null, 'あなご', 100);
insert into product values(null, 'たまご', 100);
insert into product values(null, 'ほたて', 100);
insert into product values(null, '赤貝', 100);
insert into product values(null, 'つぶ貝', 100);
insert into product values(null, 'サラダ軍艦', 150);
insert into product values(null, 'ねぎとろ軍艦', 150);
insert into product values(null, 'ねぎとろ巻', 150);
insert into product values(null, 'アボガド巻', 150);
insert into product values(null, 'トロ', 200);
insert into product values(null, 'いくら', 200);
insert into product values(null, 'うに', 200);
