-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 23, 2020 at 01:05 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.7

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `birth_date`, `gender`, `id_number`, `is_delete`, `name`, `position_id`) VALUES
(1, '1990-02-14', 1, 14021990, 0, 'Yogi Lestari', 5),
(2, '1991-05-10', 1, 100511991, 0, 'Anggi Setiawan', 2),
(3, '1993-04-20', 2, 20041993, 0, 'Rosiana', 4),
(4, '1994-01-11', 1, 11011994, 0, 'Yudi Ismiaji', 3),
(5, '1995-05-22', 1, 99991111, 1, 'Valen', 1);

--
-- Dumping data for table `position`
--

INSERT INTO `position` (`id`, `code`, `is_delete`, `name`) VALUES
(1, 'SA', 0, 'System Analyst'),
(2, 'BPS', 0, 'BPS'),
(3, 'PRG', 0, 'Programmer'),
(4, 'TEST', 0, 'Tester'),
(5, 'HELP', 0, 'Helpdesk');

