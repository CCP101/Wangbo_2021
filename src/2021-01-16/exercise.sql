## 1
CREATE DATABASE `BookManagement` CHARACTER SET 'utf8';
## 2
CREATE TABLE `book` (
    `BookId` int(2) NOT NULL COMMENT 'ͼ����',
    `Name` varchar(50) DEFAULT NULL COMMENT 'ͼ������',
    `ISBN` varchar(20) DEFAULT NULL COMMENT 'ͼ��ISBN',
    `Authors` varchar(100) DEFAULT NULL COMMENT 'ͼ������',
    `Category` varchar(20) DEFAULT NULL COMMENT 'ͼ�����',
    `Price` double(10,2) DEFAULT NULL COMMENT 'ͼ��۸�',
    `Publisher` varchar(50) DEFAULT NULL COMMENT '������',
    `PublishDate` date DEFAULT NULL COMMENT '��������',
    `Cover` varchar(100) DEFAULT NULL COMMENT 'ͼ������ַ',
    `Stock` int(2) DEFAULT NULL COMMENT 'ͼ����',
                        PRIMARY KEY (`BookId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
## 3
INSERT INTO `wangbo`.`book`
    (`BookId`, `Name`, `ISBN`, `Authors`, `Category`, `Price`, `Publisher`, `PublishDate`, `Cover`, `Stock`)
VALUES
(1,'Java���������','12345','������','�����',78.00,'���ӹ�ҵ','2007-2-1','12345.jpg',5),
(2,'Java���˼��','34234','Scott En','�����',90.20,'�廪��ѧ','2008-8-1','34234.jpg',6),
(3,'Java���ž���','68896','��С��','�����',125.50,'�廪��ѧ','2007-7-1','68896.jpg',13),
(4,'ɽ���֮��','34687','����','��ѧ',28.00,'�廪��ѧ','2009-9-1','34687.jpg',15),
(5,'������ʳ','90896','����','����',35.00,'��е��ҵ','2009-1-1','90896.jpg',2),
(6,'����312���������','45790','ף����','����',12.400,'���ӹ�ҵ','2006-3-1','45790.jpg',6),
(7,'JSP��̱���','54379','Lynn Jean','�����',102.00,'��е��ҵ','2005-5-1','54379.jpg',7),
(8,'SSHʵս','21346',' Calvin Klein','�����',156.00,'��е��ҵ','2007-8-1','21346.jpg',8),
(9,'.NET��JAVA����','95635','Bill Gates','�����',99.90,'���ӹ�ҵ','2009-10-1','95635.jpg',11),
(10,'����Բ','76890','Ǯѧǿ','��ѧ',35.70,'��е��ҵ','2009-3-1','76890.jpg',10),
(11,'�������','23457','Steven Qing','��ѧ',56.00,'�廪��ѧ','2009-9-1','23457.jpg',21),
(12,'MySQL����','96545','MySQL Corp.','�����',100.90,'�廪��ѧ','2008-8-1','96545.jpg',1);
## 4
SELECT * FROM `book`
ORDER BY book.BookId DESC;
## 5
SELECT * FROM `book`
WHERE YEAR(book.PublishDate) = 2009;
## 6
SELECT * FROM `book`
WHERE
    book.Price > 100
   OR book.Publisher = '�廪��ѧ';
## 7
SELECT * FROM  `book`
WHERE book.`Name` LIKE '%JAVA%';
## 8
SELECT
    SUM( book.Stock ) AS COUNT
FROM
    book
GROUP BY
    book.Category
HAVING
        book.Category = '�����';
## 9
SELECT
    book.Category,
    SUM( book.Stock ) AS COUNT
FROM
    book
GROUP BY
    book.Category;
## 10
SELECT
    book.Publisher,
    SUM( book.Stock ) AS COUNT
FROM
    book
GROUP BY
    book.Publisher;
## 11
SELECT
    book.Publisher,
    SUM( book.Stock ) AS COUNT
FROM
    book
GROUP BY
    book.Publisher
HAVING
        SUM( book.Stock ) > 30;
## 12
SELECT
    book.Publisher,
    SUM( book.Stock ) AS COUNT
FROM
    book
GROUP BY
    book.Publisher
ORDER BY
    SUM( book.Stock )
LIMIT 1;
## 13
SELECT
    book.Publisher,
    SUM( book.Stock ) AS COUNT
FROM
    book
GROUP BY
    book.Publisher
ORDER BY
    SUM( book.Stock ) DESC
LIMIT 1;
## 13
CREATE TABLE `stu1` (
    `stuid` int(2) NOT NULL,
    `name` varchar(20) DEFAULT NULL,
    `age` int(2) DEFAULT NULL,
    `sex` varchar(2) DEFAULT NULL,
    `address` varchar(100) DEFAULT NULL,
    `telephone` varchar(11) DEFAULT NULL,
    PRIMARY KEY (`stuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
## 14
ALTER TABLE `wangbo`.`stu1`
ADD COLUMN `grade` varchar(20) NULL AFTER `telephone`;
## 15
ALTER TABLE `wangbo`.`stu1`
DROP COLUMN `address`;
## 16
INSERT INTO `wangbo`.`stu1`(`stuid`, `name`, `age`, `sex`, `telephone`, `grade`)
VALUES (1, 'A', 22, '��', '122', 'Сѧ'),
       (2, 'B', 21, '��', '119', '��ѧ'),
       (3, 'C', 23, '��', '110', '����'),
       (4, 'D', 18, 'Ů', '114', '��ר');
## 17
UPDATE stu1
SET stu1.grade = '��ר'
WHERE
    stu1.telephone LIKE '11%';
## 18
DELETE FROM
    stu1
WHERE
    stu1.`name` LIKE 'c%'
  AND stu1.sex = '��';
## 19
SELECT
    stu1.`name`,
    stu1.stuid
FROM
    stu1
WHERE
        stu1.age < 22
AND stu1.grade = '��ר';
## 20
SELECT * FROM stu1
LIMIT 0,3;
## 21
SELECT
    stu1.`name`,
    stu1.sex,
    stu1.age
FROM
    stu1
ORDER BY
    stu1.age DESC;
## 22
SELECT
    stu1.sex,
    AVG( stu1.age ) AS avg
FROM
    stu1
GROUP BY
    stu1.sex;
