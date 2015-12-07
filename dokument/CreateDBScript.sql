# Script för att skapa newtonbank databas

DROP SCHEMA IF EXISTS newtonbank;
CREATE SCHEMA newtonbank CHARACTER SET utf8 COLLATE utf8_general_ci;
GRANT ALL ON newtonbank.* TO root@localhost IDENTIFIED BY 'root';

USE newtonbank;

CREATE TABLE Customer ( 
	personNr BIGINT UNSIGNED NOT NULL,
	name VARCHAR(30) NOT NULL,
	PRIMARY KEY(personNr)
) ENGINE=INNODB;

CREATE TABLE Account (
		accountId INT UNSIGNED NOT NULL AUTO_INCREMENT,
		personNr BIGINT UNSIGNED NOT NULL,
		accountType ENUM('SPARKONTO', 'KREDITKONTO') NOT NULL,
		rate DECIMAL(4, 2) UNSIGNED NOT NULL DEFAULT 0,
		balance DECIMAL(9, 2) NOT NULL DEFAULT 0,
		credit INT UNSIGNED,
		creditRate DECIMAL(4, 2) UNSIGNED,
		PRIMARY KEY(accountId),
	 	FOREIGN KEY (personNr) REFERENCES Customer(personNr) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=INNODB AUTO_INCREMENT=1001;

CREATE TABLE Transaction (
		transId INT UNSIGNED NOT NULL AUTO_INCREMENT,
		accountId INT UNSIGNED NOT NULL,
		transDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
		transType ENUM('IN', 'UT') NOT NULL,
		amount DECIMAL(6, 2) NOT NULL,
		balance DECIMAL(6, 2) NOT NULL,
		PRIMARY KEY(transId),
	 	FOREIGN KEY (accountId) REFERENCES Account(accountId) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=INNODB;

#************************************************************************************
INSERT INTO Account (personNr, rate, accountType) VALUES(199501012222, 0.5, 'SPARKONTO')
insert into account (personNr, accountType, rate, balance) values (199501012222, 'sparkonto', 5, 7500.50);
# testa skapa ny kund 12345
insert into customer values (199501012222, 'Anna Nguey');

# testa skapa nytt konto till kund 12345
insert into account (personNr, accountType, rate, balance, credit) values (199501012222, 'sparkonto', 5, 7500.50, 5000);
insert into account (personNr, accountType, rate, balance, credit) values (199501012222, 'kreditkonto', 1, 3000, 5000);

# testa skapa ny transaction till konto 1001 och 1002 (kontonr genereta automatisk)
insert into transaction (accountId, transType, amount, balance) values (1001, 'IN', 100, 7600.50);
insert into transaction (accountId, transType, amount, balance) values (1001, 'UT', -2000, 5600.50);
insert into transaction (accountId, transType, amount, balance) values (1002, 'IN', 200, 3200);
insert into transaction (accountId, transType, amount, balance) values (1002, 'UT', -1000, 2200);

# testa ta bort transaction som tillhör konto 1001
delete from transaction where accountId=1001;

# testa ta bort konto som tillhör kund 12345
delete from account where personNr=12345;

# testa ta bort kund 12345
delete from customer where personNr=12345;

INSERT INTO Account (personNr, rate, accountType) VALUES(199501012222, 0,50, 'SPARKONTO')
