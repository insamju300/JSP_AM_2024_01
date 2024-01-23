DROP DATABASE IF EXISTS `JSP_AM`;
CREATE DATABASE `JSP_AM`;
USE `JSP_AM`;

CREATE TABLE article(
    id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    title CHAR(100) NOT NULL,
    `body` TEXT NOT NULL
);


CREATE TABLE `member`(
    id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    loginId CHAR(100) NOT NULL UNIQUE,
    `password` CHAR(200) NOT NULL,
    `name` CHAR(100) NOT NULL
);

INSERT INTO article
SET regDate = NOW(),
title = '제목1',
`body` = '내용1';

INSERT INTO article
SET regDate = NOW(),
title = '제목2',
`body` = '내용2';

INSERT INTO article
SET regDate = NOW(),
title = '제목3',
`body` = '내용3';

INSERT INTO article
SET regDate = NOW(),
title = '제목4',
`body` = '내용4';

SELECT *
FROM article
ORDER BY id DESC;

select SHA2('password',256);
