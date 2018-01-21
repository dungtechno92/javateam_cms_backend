
CREATE DATABASE IF NOT EXISTS `javateam_cms` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;

CREATE USER 'javateam_cms_user'@'%' IDENTIFIED BY '1';
GRANT ALL PRIVILEGES ON javateam_cms.* TO 'javateam_cms_user'@'%';
FLUSH PRIVILEGES;

