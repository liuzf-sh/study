-- mysql存储过程 批量插入
create procedure batchInsert(in args int)
begin
declare i int default 1;
start transaction;
while i <= args do
insert into student(id,name,tid) value(i,concat("刘知非-",i),null);
set i = i+1;
end while;
commit;
end
$