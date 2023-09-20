-- 유저
DROP TABLE IF EXISTS auction_user RESTRICT;

-- 공지사항
DROP TABLE IF EXISTS auction_announcement RESTRICT;

-- 첨부파일
DROP TABLE IF EXISTS auction_attached_file RESTRICT;

-- 경매
DROP TABLE IF EXISTS auction_article RESTRICT;

-- 경매기록
DROP TABLE IF EXISTS auction_history RESTRICT;

-- 환전게시판
DROP TABLE IF EXISTS auction_exchange RESTRICT;

-- 유저
CREATE TABLE auction_user (
	user_no       INTEGER      NOT NULL, -- 유저번호
	authority     VARCHAR(32)  NOT NULL DEFAULT 'USER', -- 권한
	email         VARCHAR(40)  NOT NULL, -- 이메일
	password      VARCHAR(64)  NOT NULL, -- 비밀번호
	name          VARCHAR(50)  NOT NULL, -- 이름
	phone         VARCHAR(30)  NOT NULL, -- 전화번호
	zonecode      INTEGER      NOT NULL, -- 우편번호
	address       VARCHAR(255) NOT NULL, -- 주소
	detail_addr   VARCHAR(255) NOT NULL, -- 상세주소
	join_date     DATE         NOT NULL DEFAULT (current_date()), -- 가입일자
	profile_photo VARCHAR(255) NULL,     -- 사진
	point         INTEGER      NOT NULL DEFAULT 0 -- 포인트
);

-- 유저
ALTER TABLE auction_user
	ADD CONSTRAINT PK_auction_user -- 유저 기본키
		PRIMARY KEY (
			user_no -- 유저번호
		);

-- 유저 유니크 인덱스
CREATE UNIQUE INDEX UIX_auction_user
	ON auction_user ( -- 유저
		email ASC -- 이메일
	);

ALTER TABLE auction_user
	MODIFY COLUMN user_no INTEGER NOT NULL AUTO_INCREMENT;

ALTER TABLE auction_user
	AUTO_INCREMENT = 1;

-- 공지사항
CREATE TABLE auction_announcement (
	announcement_no INTEGER      NOT NULL, -- 공지사항번호
	user_no         INTEGER      NOT NULL, -- 유저번호
	title           VARCHAR(255) NOT NULL, -- 제목
	content         MEDIUMTEXT   NULL,     -- 내용
	fixed           INTEGER      NOT NULL DEFAULT 0, -- 고정
	created_date    DATETIME     NOT NULL DEFAULT now() -- 생성일자
);

-- 공지사항
ALTER TABLE auction_announcement
	ADD CONSTRAINT PK_auction_announcement -- 공지사항 기본키
		PRIMARY KEY (
			announcement_no -- 공지사항번호
		);

ALTER TABLE auction_announcement
	MODIFY COLUMN announcement_no INTEGER NOT NULL AUTO_INCREMENT;

ALTER TABLE auction_announcement
	AUTO_INCREMENT = 1;

-- 첨부파일
CREATE TABLE auction_attached_file (
	file_no         INTEGER      NOT NULL, -- 파일번호
	announcement_no INTEGER      NOT NULL, -- 공지사항번호
	filepath        VARCHAR(255) NOT NULL  -- 파일경로
);

-- 첨부파일
ALTER TABLE auction_attached_file
	ADD CONSTRAINT PK_auction_attached_file -- 첨부파일 기본키
		PRIMARY KEY (
			file_no -- 파일번호
		);

ALTER TABLE auction_attached_file
	MODIFY COLUMN file_no INTEGER NOT NULL AUTO_INCREMENT;

ALTER TABLE auction_attached_file
	AUTO_INCREMENT = 1;

-- 경매
CREATE TABLE auction_article (
	article_no   INTEGER      NOT NULL, -- 경매 번호
	user_no      INTEGER      NOT NULL, -- 유저번호
	title        VARCHAR(255) NOT NULL, -- 제목
	content      MEDIUMTEXT   NULL,     -- 내용
	artist       VARCHAR(50)  NOT NULL, -- 작가명
	view_count   INTEGER      NOT NULL DEFAULT 0, -- 조회수
	created_date DATETIME     NOT NULL DEFAULT now(), -- 생성일자
	photo        VARCHAR(255) NOT NULL, -- 사진
	start_date   DATETIME     NOT NULL DEFAULT (CURDATE() + INTERVAL 1 DAY), -- 시작날짜
	end_date     DATETIME     NOT NULL DEFAULT (CONCAT(CURDATE() + INTERVAL 3 DAY, ' 23:59:00')), -- 종료날짜
	status       VARCHAR(32)  NOT NULL DEFAULT 'EXPECTED', -- 상태
	cur_price    INTEGER      NOT NULL, -- 현재가격
	end_price    INTEGER      NOT NULL, -- 즉시구매가격
	cur_bidder   INTEGER      NULL,     -- 현재입찰자
	bid_count    INTEGER      NOT NULL DEFAULT 0 -- 입찰횟수
);

-- 경매
ALTER TABLE auction_article
	ADD CONSTRAINT PK_auction_article -- 경매 기본키
		PRIMARY KEY (
			article_no -- 경매 번호
		);

ALTER TABLE auction_article
	MODIFY COLUMN article_no INTEGER NOT NULL AUTO_INCREMENT;

ALTER TABLE auction_article
	AUTO_INCREMENT = 1;

-- 경매기록
CREATE TABLE auction_history (
	history_no INTEGER  NOT NULL, -- 기록번호
	user_no    INTEGER  NOT NULL, -- 유저번호
	article_no INTEGER  NOT NULL, -- 경매 번호
	price      INTEGER  NOT NULL, -- 입찰액
	bid_date   DATETIME NOT NULL DEFAULT now(), -- 입찰시간
	win_bid    INTEGER  NOT NULL DEFAULT 0 -- 낙찰
);

-- 경매기록
ALTER TABLE auction_history
	ADD CONSTRAINT PK_auction_history -- 경매기록 기본키
		PRIMARY KEY (
			history_no -- 기록번호
		);

-- 경매기록 유니크 인덱스
CREATE UNIQUE INDEX UIX_auction_history
	ON auction_history ( -- 경매기록
		article_no ASC, -- 경매 번호
		price ASC       -- 입찰액
	);

ALTER TABLE auction_history
	MODIFY COLUMN history_no INTEGER NOT NULL AUTO_INCREMENT;

ALTER TABLE auction_history
	AUTO_INCREMENT = 1;

-- 환전게시판
CREATE TABLE auction_exchange (
	exchange_no    INTEGER      NOT NULL, -- 환전게시판번호
	user_no        INTEGER      NOT NULL, -- 유저번호
	title          VARCHAR(255) NOT NULL, -- 제목
	content        MEDIUMTEXT   NOT NULL, -- 내용
	created_date   DATETIME     NOT NULL DEFAULT now(), -- 생성일자
	exchange_point INTEGER      NOT NULL DEFAULT 0 -- 환전포인트
);

-- 환전게시판
ALTER TABLE auction_exchange
	ADD CONSTRAINT PK_auction_exchange -- 환전게시판 기본키
		PRIMARY KEY (
			exchange_no -- 환전게시판번호
		);

-- 공지사항
ALTER TABLE auction_announcement
	ADD CONSTRAINT FK_auction_user_TO_auction_announcement -- 유저 -> 공지사항
		FOREIGN KEY (
			user_no -- 유저번호
		)
		REFERENCES auction_user ( -- 유저
			user_no -- 유저번호
		);

-- 첨부파일
ALTER TABLE auction_attached_file
	ADD CONSTRAINT FK_auction_announcement_TO_auction_attached_file -- 공지사항 -> 첨부파일
		FOREIGN KEY (
			announcement_no -- 공지사항번호
		)
		REFERENCES auction_announcement ( -- 공지사항
			announcement_no -- 공지사항번호
		);

-- 경매
ALTER TABLE auction_article
	ADD CONSTRAINT FK_auction_user_TO_auction_article -- 유저 -> 경매
		FOREIGN KEY (
			user_no -- 유저번호
		)
		REFERENCES auction_user ( -- 유저
			user_no -- 유저번호
		);

-- 경매기록
ALTER TABLE auction_history
	ADD CONSTRAINT FK_auction_user_TO_auction_history -- 유저 -> 경매기록
		FOREIGN KEY (
			user_no -- 유저번호
		)
		REFERENCES auction_user ( -- 유저
			user_no -- 유저번호
		);

-- 경매기록
ALTER TABLE auction_history
	ADD CONSTRAINT FK_auction_article_TO_auction_history -- 경매 -> 경매기록
		FOREIGN KEY (
			article_no -- 경매 번호
		)
		REFERENCES auction_article ( -- 경매
			article_no -- 경매 번호
		);

-- 환전게시판
ALTER TABLE auction_exchange
	ADD CONSTRAINT FK_auction_user_TO_auction_exchange -- 유저 -> 환전게시판
		FOREIGN KEY (
			user_no -- 유저번호
		)
		REFERENCES auction_user ( -- 유저
			user_no -- 유저번호
		);