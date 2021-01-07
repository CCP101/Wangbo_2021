## 1
CREATE TABLE `employee` (
    `id` int(11) NOT NULL COMMENT '员工编号',
    `first_name` varchar(20) DEFAULT NULL COMMENT '员工姓',
    `last_name` varchar(25) DEFAULT NULL COMMENT '员工名',
    `email` varchar(25) DEFAULT NULL COMMENT 'mail地址',
    `phone_number` varchar(20) DEFAULT NULL COMMENT '电话',
    `hire_date` date DEFAULT NULL COMMENT '雇佣时间',
    `job_id` varchar(10) DEFAULT NULL COMMENT '职务',
    `salary` int(11) DEFAULT NULL COMMENT '月薪',
    `commission_pct` int(11) DEFAULT NULL COMMENT '奖金的百分比',
    `manager_id` int(11) DEFAULT NULL COMMENT '管理者编号',
    `department_id` int(11) DEFAULT NULL COMMENT '部门编号',
    PRIMARY KEY (`id`)
) ;
## 2
SELECT * FROM `wangbo`.`employee`;
## 3
SELECT
    employee.id,
    employee.first_name,
    employee.last_name,
    employee.job_id,
    employee.salary
FROM
    employee;
## 4
SELECT
    employee.id,
    CONCAT( employee.first_name, employee.last_name ) AS NAME,
    employee.job_id,
    employee.salary
FROM
    employee;
## 5
SELECT
    employee.id,
    CONCAT( employee.first_name, employee.last_name ) AS 姓名,
    employee.email,
    employee.phone_number,
    employee.hire_date,
    employee.job_id,
    employee.salary AS 月薪,
    employee.commission_pct,
    employee.manager_id,
    employee.department_id
FROM
    employee;
## 6
SELECT
    employee.id,
    CONCAT( employee.first_name, employee.last_name ) AS 姓名,
    employee.email,
    employee.phone_number,
    employee.hire_date,
    employee.job_id,
    employee.salary AS 月薪,
    employee.commission_pct,
    employee.manager_id,
    employee.department_id
FROM
    employee
WHERE
    employee.department_id = 10;
## 7
SELECT
    employee.id,
    CONCAT( employee.first_name, employee.last_name ) AS 姓名,
    employee.email,
    employee.phone_number,
    employee.hire_date,
    employee.job_id,
    employee.salary AS 月薪,
    employee.commission_pct,
    employee.manager_id,
    employee.department_id
FROM
    employee
WHERE
    employee.job_id = '总经理';
## 8
SELECT
    employee.id,
    CONCAT( employee.first_name, employee.last_name ) AS 姓名,
    employee.email,
    employee.phone_number,
    employee.hire_date,
    employee.job_id,
    employee.salary AS 月薪,
    employee.commission_pct,
    employee.manager_id,
    employee.department_id
FROM
    employee
WHERE
    employee.salary > 3400;
## 9
SELECT
    employee.id,
    CONCAT( employee.first_name, employee.last_name ) AS 姓名,
    employee.email,
    employee.phone_number,
    employee.hire_date,
    employee.job_id,
    employee.salary AS 月薪,
    employee.commission_pct,
    employee.manager_id,
    employee.department_id
FROM
    employee
WHERE
    employee.salary >= 2900
  AND employee.salary <= 3600;
## 10
SELECT
    employee.id,
    CONCAT( employee.first_name, employee.last_name ) AS 姓名,
    employee.email,
    employee.phone_number,
    employee.hire_date,
    employee.job_id,
    employee.salary AS 月薪,
    employee.commission_pct,
    employee.manager_id,
    employee.department_id
FROM
    employee
WHERE
    employee.department_id = 10
   OR employee.department_id = 20;
## 11
SELECT
    employee.id,
    CONCAT( employee.first_name, employee.last_name ) AS 姓名,
    employee.email,
    employee.phone_number,
    employee.hire_date,
    employee.job_id,
    employee.salary AS 月薪,
    employee.commission_pct,
    employee.manager_id,
    employee.department_id
FROM
    employee
WHERE
    employee.job_id = '总经理'
   OR employee.job_id = '秘书';
## 12
SELECT
    employee.id,
    CONCAT( employee.first_name, employee.last_name ) AS 姓名,
    employee.email,
    employee.phone_number,
    employee.hire_date,
    employee.job_id,
    employee.salary AS 月薪,
    employee.commission_pct,
    employee.manager_id,
    employee.department_id
FROM
    employee
WHERE
    CONCAT( employee.first_name, employee.last_name ) like '%王%';
## 13
SELECT
    employee.id,
    CONCAT( employee.first_name, employee.last_name ) AS 姓名,
    employee.email,
    employee.phone_number,
    employee.hire_date,
    employee.job_id,
    employee.salary AS 月薪,
    employee.commission_pct,
    employee.manager_id,
    employee.department_id
FROM
    employee
WHERE
    CONCAT( employee.first_name, employee.last_name ) like '__哥%';
## 14
SELECT
    employee.id,
    CONCAT( employee.first_name, employee.last_name ) AS 姓名,
    employee.email,
    employee.phone_number,
    employee.hire_date,
    employee.job_id,
    employee.salary AS 月薪,
    employee.commission_pct,
    employee.manager_id,
    employee.department_id
FROM
    employee
WHERE
    employee.job_id = '总经理'
  AND employee.salary > 3800;
## 15
SELECT
    employee.id,
    CONCAT( employee.first_name, employee.last_name ) AS 姓名,
    employee.email,
    employee.phone_number,
    employee.hire_date,
    employee.job_id,
    employee.salary AS 月薪,
    employee.commission_pct,
    employee.manager_id,
    employee.department_id
FROM
    employee
WHERE
    employee.job_id = '总经理'
   OR employee.salary > 3800;
## 16
SELECT
    employee.id,
    CONCAT( employee.first_name, employee.last_name ) AS 姓名,
    employee.email,
    employee.phone_number,
    employee.hire_date,
    employee.job_id,
    employee.salary AS 月薪,
    employee.commission_pct,
    employee.manager_id,
    employee.department_id
FROM
    employee
ORDER BY
    employee.salary DESC;
## 17
SELECT
    employee.id,
    CONCAT( employee.first_name, employee.last_name ) AS 姓名,
    employee.salary*12 AS 年薪
FROM
    employee
ORDER BY
    employee.salary*12 DESC;