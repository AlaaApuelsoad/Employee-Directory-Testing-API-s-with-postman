USE `demo`;

DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `members`;

--
-- Table structure for table `members`
--

CREATE TABLE `members` (
  `user_id` varchar(50) NOT NULL,
  `pw` char(85) NOT NULL,
  `active` tinyint NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `members`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: https://www.luv2code.com/generate-bcrypt-password
--
-- Default passwords here are: qnet123
--

INSERT INTO `members`
VALUES
('john','{bcrypt}$2a$10$i.YV04Wg7wh/40/.UKWJEe.m8I3asfRL6gy52Yg4Xt5hqfgGmf06y',1),
('randy','{bcrypt}$2a$10$i.YV04Wg7wh/40/.UKWJEe.m8I3asfRL6gy52Yg4Xt5hqfgGmf06y',1),
('max','{bcrypt}$2a$10$i.YV04Wg7wh/40/.UKWJEe.m8I3asfRL6gy52Yg4Xt5hqfgGmf06y',1),
('josh','{bcrypt}$2a$10$i.YV04Wg7wh/40/.UKWJEe.m8I3asfRL6gy52Yg4Xt5hqfgGmf06y',1);


--
-- Table structure for table `authorities`
--

CREATE TABLE `roles` (
  `user_id` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  UNIQUE KEY `authorities5_idx_1` (`user_id`,`role`),
  CONSTRAINT `authorities5_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `members` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `roles`
--

INSERT INTO `roles`
VALUES
('john','ROLE_EMPLOYEE'),
('randy','ROLE_EMPLOYEE'),
('max','ROLE_MANAGER'),
('josh','ROLE_ADMIN');
