CREATE EVENT IF NOT EXISTS auction_start
	ON SCHEDULE
		EVERY 1 HOUR STARTS '2023-09-23 00:01:00'
	ON COMPLETION PRESERVE
    ENABLE
    COMMENT '경매 시작'
    DO
	UPDATE
	  auction_article
	SET
	  status='progress'
	WHERE
	  status='expected' AND start_date<now();

CREATE EVENT IF NOT EXISTS auction_end
	ON SCHEDULE
		EVERY 1 HOUR STARTS '2023-09-23 00:01:00'
	ON COMPLETION PRESERVE
    ENABLE
    COMMENT '경매 종료'
    DO
	UPDATE
	  auction_article A
	  inner join auction_user U on A.user_no=U.user_no
	  inner join auction_history H on A.cur_bidder=H.user_no AND A.article_no=H.article_no AND A.cur_price=H.price
	SET
	 A.status='end'
	 ,U.point=U.point+A.cur_price
	 ,H.win_bid=1
	WHERE
	 status='progress' AND A.end_date<now();