CREATE TABLE boy(
	hid varchar(32) NOT NULL,
	bname varchar(32) NOT NULL,
	PRIMARY KEY (`hid`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE girl(
	hid varchar(32) NOT NULL,
	bname varchar(32) NOT NULL,
	PRIMARY KEY (`hid`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO boy VALUES('A','屌丝');
INSERT INTO boy VALUES('B','杨过');
INSERT INTO boy VALUES('C','成关系');

INSERT INTO girl VALUES('B','小龙女');
INSERT INTO girl VALUES('C','张柏芝');
INSERT INTO girl VALUES('D','直女');
	
	
SELECT * FROM boy;
SELECT * FROM girl;

# --------------------------------内连接
# 第一种 
SELECT b.*,g.bname gname	FROM boy b INNER JOIN girl g ON b.hid = g.hid;
# 第二种 
SELECT b.*,g.bname gname	FROM boy b, girl g WHERE b.hid = g.hid;


# 左外连接
SELECT b.*,g.bname gname FROM boy b LEFT JOIN girl g ON b.hid = g.hid;

# 右外连接
SELECT b.*,g.bname gname FROM boy b right	JOIN girl g ON b.hid = g.hid;

# mysql不支持完全连接