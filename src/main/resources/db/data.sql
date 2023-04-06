INSERT INTO user_tb(username, password, fullname, created_at) values('ssar', '1234',
'쌀', now());
INSERT INTO user_tb(username, password, fullname, created_at) values('cos', '1234',
'코스', now());

INSERT INTO account_tb(number, password, balance, user_id, created_at)
values('1111', '1234', 1000, 1, now());
INSERT INTO account_tb(number, password, balance, user_id, created_at)
values('2222', '1234', 1000, 2, now());

INSERT INTO history_tb(amount, w_balance, d_balance, w_account_id, d_account_id,
created_at) values(100, 900, 1100, 1, 2, now());
INSERT INTO history_tb(amount, w_balance, d_balance, w_account_id, d_account_id,
created_at) values(100, 800, null, 1, null, now());
//atm기로 출금했다 (atm기로 뽑았으니 입금자가 없으니까 null)
INSERT INTO history_tb(amount, w_balance, d_balance, w_account_id, d_account_id,
created_at) values(100, null, 900, null, 1, now());
commit;