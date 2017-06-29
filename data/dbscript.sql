-- 2017.06.29
-- add Table
create table TC_CODE_TYPE (
cod_typ_id varchar2(20),
cod_typ_name varchar2(200),
cod_typ_used varchar2(1)
)
;
-- add Data
INSERT INTO TC_CODE (CODE_ID, CODE_NAME) VALUES ('APT_TYPE_01', '매매');
INSERT INTO TC_CODE (CODE_ID, CODE_NAME) VALUES ('APT_TYPE_02', '전세');
INSERT INTO TC_CODE (CODE_ID, CODE_NAME) VALUES ('APT_TYPE_03', '월세');

-- alter table tb_rtms
alter table TB_RTMS add(rtmsLeaseMoney number);
alter table TB_RTMS add(rtmsRantMoney number);
alter table TB_RTMS add(rtmsType varchar2(20));