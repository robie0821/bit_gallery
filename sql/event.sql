CREATE EVENT IF NOT EXISTS auction_start
	ON SCHEDULE
		EVERY 1 HOUR STARTS '2023-09-21 00:01:00'
	ON COMPLETION PRESERVE
	ENABLE
	COMMENT '경매 시작'
	DO
	UPDATE auction_article
	SET status='progress'
	where status='expected' AND start_date<now();

CREATE EVENT IF NOT EXISTS auction_end
	ON SCHEDULE
		EVERY 1 HOUR STARTS '2023-09-21 00:01:00'
	ON COMPLETION PRESERVE
	ENABLE
	COMMENT '경매 종료'
	DO
	UPDATE auction_article
	SET status='end'
	where status='progress' AND end_date<now();