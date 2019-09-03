INSERT IGNORE INTO `role` (`id`, `role`)
VALUES
	(1, 'ROLE_USER'),
	(2, 'ROLE_ADMIN');
	
INSERT IGNORE INTO `user` (`id`, `active`, `email`, `is_enabled`, `is_expired`, `is_loacked`, `last_name`, `name`, `password`, `token_id`)
VALUES
	(1, 1, 'user@user.com', 00000001, 00000000, 00000000, 'User', 'App', '$2a$12$zhsMPzr9IhS/5phURclxWue2ERAcCl5O83Oo5610bQxUbOHVDwqV.', NULL);
	
INSERT IGNORE INTO `user_role` (`user_id`, `role_id`)
VALUES
	(1, 1);
	