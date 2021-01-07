## 1
CREATE TABLE `employee` (
    `id` int(11) NOT NULL COMMENT 'Ա�����',
    `first_name` varchar(20) DEFAULT NULL COMMENT 'Ա����',
    `last_name` varchar(25) DEFAULT NULL COMMENT 'Ա����',
    `email` varchar(25) DEFAULT NULL COMMENT 'mail��ַ',
    `phone_number` varchar(20) DEFAULT NULL COMMENT '�绰',
    `hire_date` date DEFAULT NULL COMMENT '��Ӷʱ��',
    `job_id` varchar(10) DEFAULT NULL COMMENT 'ְ��',
    `salary` int(11) DEFAULT NULL COMMENT '��н',
    `commission_pct` int(11) DEFAULT NULL COMMENT '����İٷֱ�',
    `manager_id` int(11) DEFAULT NULL COMMENT '�����߱��',
    `department_id` int(11) DEFAULT NULL COMMENT '���ű��',
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
    CONCAT( employee.first_name, employee.last_name ) AS ����,
    employee.email,
    employee.phone_number,
    employee.hire_date,
    employee.job_id,
    employee.salary AS ��н,
    employee.commission_pct,
    employee.manager_id,
    employee.department_id
FROM
    employee;
## 6
SELECT
    employee.id,
    CONCAT( employee.first_name, employee.last_name ) AS ����,
    employee.email,
    employee.phone_number,
    employee.hire_date,
    employee.job_id,
    employee.salary AS ��н,
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
    CONCAT( employee.first_name, employee.last_name ) AS ����,
    employee.email,
    employee.phone_number,
    employee.hire_date,
    employee.job_id,
    employee.salary AS ��н,
    employee.commission_pct,
    employee.manager_id,
    employee.department_id
FROM
    employee
WHERE
    employee.job_id = '�ܾ���';
## 8
SELECT
    employee.id,
    CONCAT( employee.first_name, employee.last_name ) AS ����,
    employee.email,
    employee.phone_number,
    employee.hire_date,
    employee.job_id,
    employee.salary AS ��н,
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
    CONCAT( employee.first_name, employee.last_name ) AS ����,
    employee.email,
    employee.phone_number,
    employee.hire_date,
    employee.job_id,
    employee.salary AS ��н,
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
    CONCAT( employee.first_name, employee.last_name ) AS ����,
    employee.email,
    employee.phone_number,
    employee.hire_date,
    employee.job_id,
    employee.salary AS ��н,
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
    CONCAT( employee.first_name, employee.last_name ) AS ����,
    employee.email,
    employee.phone_number,
    employee.hire_date,
    employee.job_id,
    employee.salary AS ��н,
    employee.commission_pct,
    employee.manager_id,
    employee.department_id
FROM
    employee
WHERE
    employee.job_id = '�ܾ���'
   OR employee.job_id = '����';
## 12
SELECT
    employee.id,
    CONCAT( employee.first_name, employee.last_name ) AS ����,
    employee.email,
    employee.phone_number,
    employee.hire_date,
    employee.job_id,
    employee.salary AS ��н,
    employee.commission_pct,
    employee.manager_id,
    employee.department_id
FROM
    employee
WHERE
    CONCAT( employee.first_name, employee.last_name ) like '%��%';
## 13
SELECT
    employee.id,
    CONCAT( employee.first_name, employee.last_name ) AS ����,
    employee.email,
    employee.phone_number,
    employee.hire_date,
    employee.job_id,
    employee.salary AS ��н,
    employee.commission_pct,
    employee.manager_id,
    employee.department_id
FROM
    employee
WHERE
    CONCAT( employee.first_name, employee.last_name ) like '__��%';
## 14
SELECT
    employee.id,
    CONCAT( employee.first_name, employee.last_name ) AS ����,
    employee.email,
    employee.phone_number,
    employee.hire_date,
    employee.job_id,
    employee.salary AS ��н,
    employee.commission_pct,
    employee.manager_id,
    employee.department_id
FROM
    employee
WHERE
    employee.job_id = '�ܾ���'
  AND employee.salary > 3800;
## 15
SELECT
    employee.id,
    CONCAT( employee.first_name, employee.last_name ) AS ����,
    employee.email,
    employee.phone_number,
    employee.hire_date,
    employee.job_id,
    employee.salary AS ��н,
    employee.commission_pct,
    employee.manager_id,
    employee.department_id
FROM
    employee
WHERE
    employee.job_id = '�ܾ���'
   OR employee.salary > 3800;
## 16
SELECT
    employee.id,
    CONCAT( employee.first_name, employee.last_name ) AS ����,
    employee.email,
    employee.phone_number,
    employee.hire_date,
    employee.job_id,
    employee.salary AS ��н,
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
    CONCAT( employee.first_name, employee.last_name ) AS ����,
    employee.salary*12 AS ��н
FROM
    employee
ORDER BY
    employee.salary*12 DESC;