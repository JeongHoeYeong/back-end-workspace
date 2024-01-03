-- 실습 문제
-- 도서관리 프로그램을 만들기 위한 테이블 만들기

-- 1. 출판사들에 대한 데이터를 담기 위한 출판사 테이블(TB_PUBLISHER) 
--    컬럼 : pub_no(출판사번호) -- 기본 키
--           pub_name(출판사명) -- NOT NULL
--           phone(전화번호)
CREATE TABLE tb_publisher(
pub_no INT PRIMARY KEY,
pub_name VARCHAR(20) NOT NULL,
phone VARCHAR(13)
);
INSERT INTO tb_publisher VALUES(1, '천그루숲', '010-8748-0784');
INSERT INTO tb_publisher VALUES(2, '골든래빗', '0505-398-0505');
INSERT INTO tb_publisher VALUES(3, '윌북', '031-955-3777');
SELECT * FROM tb_publisher;

-- 2. 도서들에 대한 데이터를 담기 위한 도서 테이블 (tb_book)
--    컬럼 : bk_no (도서번호) -- 기본 키
--           bk_title (도서명) -- NOT NULL
--           bk_author(저자명) -- NOT NULL
--           bk_price(가격)
--           bk_pub_no(출판사 번호) -- 외래 키(tb_publisher 테이블을 참조하도록)
--    조건 : 이때 참조하고 있는 부모 데이터 삭제 시 자식 데이터도 삭제 되도록 옵션 지정
create table tb_book(
bk_no int primary key,
bk_title varchar(20) not null,
bk_author varchar(20) not null,
bk_price int,
bk_pub_no int,
foreign key (bk_pub_no) references tb_publisher(pub_no) ON DELETE SET NULL
);
insert into tb_book value(1, '오늘부터 개발자', '김병욱', 16800, 1);
insert into tb_book value(2, '요즘 우아한 개발', '우아한 형제들', 24000, 2);
insert into tb_book value(3, '프로덕트 매니저 원칙', '장홍석', 22000, 2);
insert into tb_book value(4, '코딩 좀 아는 사람', '제러미 키신', 17800, 3);
insert into tb_book value(5, '그렇게 쓰면 아무도 안 읽습니다', '전주경', 19800, 3);
SELECT * FROM tb_book;

-- 3. 회원에 대한 데이터를 담기 위한 회원 테이블 (tb_member)
--    컬럼 : member_no(회원번호) -- 기본 키
--           member_id(아이디)   -- 중복 금지
--           member_pwd(비밀번호) -- NOT NULL
--           member_name(회원명) -- NOT NULL
--           gender(성별)        -- 'M' 또는 'F'로 입력되도록 제한
--           address(주소)       
--           phone(연락처)       
--           status(탈퇴여부)     -- 기본값 'N' / 'Y' 혹은 'N'만 입력되도록 제약조건
--           enroll_date(가입일)  -- 기본값 현재날짜
create table tb_member(
member_no int primary key,
member_id varchar(20) unique,
member_pwd varchar(20) not null,
member_name varchar(20) not null,
gender varchar(3) check(gender in('M', 'F')),
address varchar(20),
phone varchar(20),
status varchar(3) check(status in('N','Y')) default 'N',
enroll_date date default (current_date)
);
insert into tb_member values (1, 'user01', 'pass01', '홍길동', 'M', '서울시 강서구', '010-1111-2222', 'N', default);
insert into tb_member values (2, 'user02', 'pass02', '김말똥', 'M', '서울시 강남구', '010-3333-4444', 'N', default);
insert into tb_member values (3, 'user03', 'pass03', '강길순', 'F', '경기도 광주시', '010-4444-5555', 'N', default);
select * from tb_member;

-- 4. 도서를 대여한 회원에 대한 데이터를 담기 위한 대여 목록 테이블(tb_rent)
--    컬럼 : rent_no(대여번호) -- 기본 키
--           rent_mem_no(대여 회원번호) -- 외래 키(tb_member와 참조)
--           rent_book_no(대여 도서번호) -- 외래 키(tb_book와 참조)
--           rent_date(대여일) -- 기본값 현재날짜
--    조건 : 이때 부모 데이터 삭제 시 NULL 값이 되도록 옵션 설정

create table tb_rent (
rent_no int primary key,
rent_mem_no int,
rent_book_no int,
rent_date date default (current_date),
foreign key (rent_mem_no) references tb_member(member_no) on delete set null,
foreign key (rent_book_no) references tb_book(bk_no) on delete set null
);
INSERT INTO tb_rent VALUES(1, 1, 2, default);
INSERT INTO tb_rent VALUES(2, 1, 3, default);
INSERT INTO tb_rent VALUES(3, 2, 1, default);
INSERT INTO tb_rent VALUES(4, 2, 2, default);
INSERT INTO tb_rent VALUES(5, 1, 5, default);
SELECT * FROM tb_rent;

-- 5. 2번 도서를 대여한 회원의 이름, 아이디, 대여일, 반납 예정일(대여일 + 7일)을 조회하시오.
select member_name '회원 이름', member_id '아이디', enroll_date '대여일', adddate(enroll_date, interval 7 day) '반납 예정일'
from tb_member
join tb_rent on (rent_mem_no = member_no)
join tb_book on (rent_book_no = bk_no)
where rent_book_no = 2;

-- 6. 회원번호가 1번인 회원이 대여한 도서들의 도서명, 출판사명, 대여일, 반납예정일을 조회하시오.
select bk_title'도서명', bk_pub_no '출판사명', enroll_date '대여일', adddate(enroll_date, interval 7 day) '반납 예정일'
from tb_book
join tb_rent on (rent_book_no = bk_no)
join tb_member on (rent_mem_no = member_no)
where rent_mem_no = 1
order by 1 desc;