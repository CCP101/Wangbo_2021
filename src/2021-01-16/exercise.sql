## 1
CREATE DATABASE `BookManagement` CHARACTER SET 'utf8';
## 2
CREATE TABLE `book` (
    `BookId` int(2) NOT NULL COMMENT '图书编号',
    `Name` varchar(50) DEFAULT NULL COMMENT '图书名称',
    `ISBN` varchar(20) DEFAULT NULL COMMENT '图书ISBN',
    `Authors` varchar(100) DEFAULT NULL COMMENT '图书作者',
    `Category` varchar(20) DEFAULT NULL COMMENT '图书类别',
    `Price` double(10,2) DEFAULT NULL COMMENT '图书价格',
    `Publisher` varchar(50) DEFAULT NULL COMMENT '出版社',
    `PublishDate` date DEFAULT NULL COMMENT '出版日期',
    `Cover` varchar(100) DEFAULT NULL COMMENT '图书封面地址',
    `Stock` int(2) DEFAULT NULL COMMENT '图书库存',
                        PRIMARY KEY (`BookId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
## 3
INSERT INTO `wangbo`.`book`
    (`BookId`, `Name`, `ISBN`, `Authors`, `Category`, `Price`, `Publisher`, `PublishDate`, `Cover`, `Stock`)
VALUES
(1,'Java面向对象编程','12345','孙卫琴','计算机',78.00,'电子工业','2007-2-1','12345.jpg',5),
(2,'Java编程思想','34234','Scott En','计算机',90.20,'清华大学','2008-8-1','34234.jpg',6),
(3,'Java入门经典','68896','孙小美','计算机',125.50,'清华大学','2007-7-1','68896.jpg',13),
(4,'山楂树之恋','34687','艾米','文学',28.00,'清华大学','2009-9-1','34687.jpg',15),
(5,'健康饮食','90896','张悟本','生活',35.00,'机械工业','2009-1-1','90896.jpg',2),
(6,'健康312经络锻炼法','45790','祝总骧','生活',12.400,'电子工业','2006-3-1','45790.jpg',6),
(7,'JSP编程宝典','54379','Lynn Jean','计算机',102.00,'机械工业','2005-5-1','54379.jpg',7),
(8,'SSH实战','21346',' Calvin Klein','计算机',156.00,'机械工业','2007-8-1','21346.jpg',8),
(9,'.NET和JAVA遐想','95635','Bill Gates','计算机',99.90,'电子工业','2009-10-1','95635.jpg',11),
(10,'方与圆','76890','钱学强','文学',35.70,'机械工业','2009-3-1','76890.jpg',10),
(11,'罗马假日','23457','Steven Qing','文学',56.00,'清华大学','2009-9-1','23457.jpg',21),
(12,'MySQL宝典','96545','MySQL Corp.','计算机',100.90,'清华大学','2008-8-1','96545.jpg',1);
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
   OR book.Publisher = '清华大学';
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
        book.Category = '计算机';
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
VALUES (1, 'A', 22, '男', '122', '小学'),
       (2, 'B', 21, '男', '119', '中学'),
       (3, 'C', 23, '男', '110', '高中'),
       (4, 'D', 18, '女', '114', '大专');
## 17
UPDATE stu1
SET stu1.grade = '大专'
WHERE
    stu1.telephone LIKE '11%';
## 18
DELETE FROM
    stu1
WHERE
    stu1.`name` LIKE 'c%'
  AND stu1.sex = '男';
## 19
SELECT
    stu1.`name`,
    stu1.stuid
FROM
    stu1
WHERE
        stu1.age < 22
AND stu1.grade = '大专';
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
