select *  from national;
select * from city;
select * from plan;
select * from destination;
select * from PLAN_CITY;
select * from MEMBER;

drop table plan;
drop table city;
drop table destination;
drop table plan_city;
ALTER TABLE Destination DROP COLUMN city_code;


insert into national values ('KR', '/images/flag/KOR.gif', '대한민국', '0:00');
insert into national values ('JP', '/images/flag/JPN.gif', '일본', '0:00');
insert into national values ('CN', '/images/flag/CHN.gif', '중국', '-1:00');
insert into national values ('VN', '/images/flag/VNM.gif', '베트남', '-2:00');
insert into national values ('AU', '/images/flag/AUS.gif', '호주', '+1:00');

insert into national values ('US', '/images/flag/USA.gif', '미국', '-13:00');
insert into national values ('CA', '/images/flag/CAN.gif', '캐나다', '-13:00');
insert into national values ('MX', '/images/flag/MEX.gif', '멕시코', '-15:00');
insert into national values ('BR', '/images/flag/BRA.gif', '브라질', '-12:00');
insert into national values ('AR', '/images/flag/ARG.gif', '아르헨티나', '-12:00');

insert into national values ('GB', '/images/flag/GBR.gif', '영국', '-8:00');
insert into national values ('DE', '/images/flag/DEU.gif', '독일', '-7:00');
insert into national values ('ES', '/images/flag/ESP.gif', '스페인', '-7:00');
insert into national values ('IT', '/images/flag/ITA.gif', '이탈리아', '-7:00');
insert into national values ('FR', '/images/flag/FRA.gif', '프랑스', '-7:00');

update city set city_image= '/images/city/seoul.jpeg' where city_code= 'SEL';
-- 아시아
insert into City values ('SEL', 'Y', '서울', '37.566826', '126.978652', 'KR');
insert into City values ('PUS', '', '부산', '35.179820', '129.075087', 'KR');
insert into City values ('CJU', '', '제주도', '33.488917', '126.498229', 'KR');

insert into City values ('TYO', 'Y', '도쿄', '35.676422', '139.650027', 'JP');
insert into City values ('OSA', '', '오사카', '34.672770', '135.497019', 'JP');
insert into City values ('SPK', '', '삿포로', '43.055145', '141.364648', 'JP');

insert into City values ('PEK', 'Y', '베이징', '39.904211', '116.407395', 'CN');
insert into City values ('SHA', '', '상해', '31.206223', '121.451777', 'CN');
insert into City values ('CAN', '',  '광저우', '23.129043', '113.273093', 'CN');

insert into City values ('HAN', 'Y', '하노이', '21.027764', '105.834159', 'VN');
insert into City values ('DAD', '', '다낭', '16.054753', '108.202756', 'VN');
insert into City values ('NHA', '', '나트랑', '12.252747', '109.190535', 'VN');

insert into City values ('SYD', '', '시드니', '-33.875173', '151.181852', 'AU');
insert into City values ('MEL', '', '멜버른', '-37.786453', '144.970506', 'AU');
insert into City values ('CBR', 'Y', '캔버라', '-35.280184', '149.131032', 'AU');

-- 아메리카
insert into City values ('WAS', 'Y', '워싱턴', '38.907192', '-77.036870', 'US');
insert into City values ('NYC', '', '뉴욕', '40.699101', '-73.993469', 'US');
insert into City values ('CHI', '', '시카고', '41.877245', '-87.648247', 'US');

insert into City values ('YVR', '', '벤쿠버', '49.283467', '-123.121503', 'CA');
insert into City values ('YMQ', '', '몬트리올', '45.502304', '-73.566317', 'CA');
insert into City values ('YOW', 'Y', '오타와', '45.420057', '-75.700339', 'CA');

insert into City values ('MEX', 'Y', '멕시코시티', '19.432607', '-99.133208', 'MX');
insert into City values ('CUN', '', '칸쿤', '21.160444', '-86.851258', 'MX');
insert into City values ('MTY', '', '몬테레이', '25.684571', '-100.326870', 'MX');

insert into City values ('RIO', '', '리우데자네이루', '-22.927704', '-43.187872', 'BR');
insert into City values ('SAO', '', '상파울로', '-23.554979', '-46.621460', 'BR');
insert into City values ('BSB', 'Y', '브라질리아', '-15.807393', '-47.894117', 'BR');

insert into City values ('BUE', 'Y', '부에노스아이레스', '-34.603684', '-58.381559', 'AR');
insert into City values ('MDZ', '', '멘도사', '-32.889094', '-68.845302', 'AR');
insert into City values ('USH', '', '우수아이아', '-54.802481', '-68.303149', 'AR');

--유럽
insert into City values ('LON', 'Y', '런던', '51.507217', '-0.127586', 'GB');
insert into City values ('MAN', '', '맨체스터', '53.472122', '-2.238185', 'GB');
insert into City values ('LPL', '', '리버풀', '53.405840', '-2.988638', 'GB');

insert into City values ('MUC', '', '뮌헨', '48.130806', '11.581036', 'DE');
insert into City values ('BER', 'Y', '베를린', '52.520006', '13.404954', 'DE');
insert into City values ('HAM', '', '함부르크', '53.547138', '9.986567', 'DE');

insert into City values ('MAD', 'Y', '마드리드', '40.416775', '-3.703790', 'ES');
insert into City values ('BCN', '', '바르셀로나', '41.387615', '2.179789', 'ES');
insert into City values ('SVQ', '', '세비야', '37.384345', '-5.981497', 'ES');

insert into City values ('ROM', 'Y', '로마', '41.896706', '12.482202', 'IT');
insert into City values ('MIL', '', '밀라노', '45.467760', '9.180475', 'IT');
insert into City values ('FLR', '', '피렌체', '43.769764', '11.258130', 'IT');

insert into City values ('PAR', 'Y', '파리', '48.857547', '2.351376', 'FR');
insert into City values ('LYS', '', '리옹', '45.759597', '4.838560', 'FR');
insert into City values ('MRS', '', '마르세유', '43.301556', '5.381080', 'FR');
