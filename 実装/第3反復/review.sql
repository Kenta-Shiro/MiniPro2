create table review(
reviewno int not null PRIMARY KEY,
titleno int not null,
member_id varchar(10) not null,
reviewdate datetime not null,
content varchar(100),
FOREIGN KEY (titleno) REFERENCES title(titleno),
FOREIGN KEY (member_id) REFERENCES member(id),
)