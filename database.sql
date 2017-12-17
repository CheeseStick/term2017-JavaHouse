-- 테이블 순서는 관계를 고려하여 한 번에 실행해도 에러가 발생하지 않게 정렬되었습니다.

-- AttachedFiles Table Create SQL
CREATE TABLE AttachedFiles
(
    `file_id`        INT            NOT NULL    AUTO_INCREMENT, 
    `filename`       VARCHAR(45)    NOT NULL, 
    `file_location`  VARCHAR(45)    NOT NULL, 
    `file_type`      VARCHAR(12)    NOT NULL, 
    PRIMARY KEY (file_id)
);


-- User Table Create SQL
CREATE TABLE User
(
    `user_id`                INT             NOT NULL    AUTO_INCREMENT, 
    `first_name`             VARCHAR(16)     NOT NULL, 
    `last_name`              VARCHAR(16)     NOT NULL, 
    `birthday`               DATE            NOT NULL, 
    `phone_no`               VARCHAR(11)     NOT NULL, 
    `address`                VARCHAR(255)    NOT NULL, 
    `address_detail`         VARCHAR(255)    NOT NULL, 
    `password`               VARCHAR(128)    NOT NULL, 
    `email`                  VARCHAR(128)    NOT NULL, 
    `ssn`                    VARCHAR(13)     NOT NULL, 
    `profile_photo_file_id`  INT             NULL, 
    `is_host`                BIT             DEFAULT 0, 
    `is_admin`               BIT             DEFAULT 0, 
    PRIMARY KEY (user_id, email)
);

ALTER TABLE User ADD CONSTRAINT FK_User_profile_photo_file_id_AttachedFiles_file_id FOREIGN KEY (profile_photo_file_id)
 REFERENCES AttachedFiles (file_id)  ON DELETE RESTRICT ON UPDATE RESTRICT;


-- HousingType Table Create SQL
CREATE TABLE HousingType
(
    `housing_type_id`  INT            NOT NULL    AUTO_INCREMENT, 
    `name`             VARCHAR(45)    NOT NULL, 
    PRIMARY KEY (housing_type_id)
);

ALTER TABLE HousingType COMMENT '주택타입 (아파트인지, 빌라인지)';


-- ResidenceType Table Create SQL
CREATE TABLE ResidenceType
(
    `residence_type_id`  INT            NOT NULL    AUTO_INCREMENT, 
    `name`               VARCHAR(45)    NOT NULL, 
    PRIMARY KEY (residence_type_id)
);

ALTER TABLE ResidenceType COMMENT '주거형태 (원룸인지, 투룸인지)';


-- ContractType Table Create SQL
CREATE TABLE ContractType
(
    `contract_type_id`  INT            NOT NULL    AUTO_INCREMENT, 
    `name`              VARCHAR(45)    NOT NULL, 
    PRIMARY KEY (contract_type_id)
);

ALTER TABLE ContractType COMMENT '계약종류 (하숙, 전대, 쉐어하우스 등등)';


-- PaymentType Table Create SQL
CREATE TABLE PaymentType
(
    `payment_type_id`  INT            NOT NULL    AUTO_INCREMENT, 
    `name`             VARCHAR(45)    NOT NULL, 
    PRIMARY KEY (payment_type_id)
);

ALTER TABLE PaymentType COMMENT '지불방법 (월세인지, 일시불인지)';


-- Item Table Create SQL
CREATE TABLE Item
(
    `item_id`              INT             NOT NULL    AUTO_INCREMENT, 
    `host_id`              INT             NOT NULL, 
    `is_available`         BIT             NOT NULL, 
    `item_title`           VARCHAR(250)    NOT NULL, 
    `item_desc`            VARCHAR(255)    NOT NULL, 
    `housing_type_id`      INT             NOT NULL, 
    `residence_type_id`    INT             NOT NULL, 
    `contract_type_id`     INT             NOT NULL, 
    `payment_type_id`      INT             NOT NULL, 
    `deposit`              INT             NOT NULL, 
    `price`                INT             NOT NULL, 
    `contract_start_date`  DATE            NOT NULL, 
    `contract_end_date`    DATE            NOT NULL, 
    `address`              VARCHAR(255)    NOT NULL, 
    `address_detail`       VARCHAR(255)    NOT NULL, 
    `pos_lat`              DOUBLE          NOT NULL, 
    `pos_lon`              DOUBLE          NOT NULL, 
    PRIMARY KEY (item_id)
);

ALTER TABLE Item ADD CONSTRAINT FK_Item_housing_type_id_HousingType_housing_type_id FOREIGN KEY (housing_type_id)
 REFERENCES HousingType (housing_type_id)  ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE Item ADD CONSTRAINT FK_Item_residence_type_id_ResidenceType_residence_type_id FOREIGN KEY (residence_type_id)
 REFERENCES ResidenceType (residence_type_id)  ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE Item ADD CONSTRAINT FK_Item_contract_type_id_ContractType_contract_type_id FOREIGN KEY (contract_type_id)
 REFERENCES ContractType (contract_type_id)  ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE Item ADD CONSTRAINT FK_Item_payment_type_id_PaymentType_payment_type_id FOREIGN KEY (payment_type_id)
 REFERENCES PaymentType (payment_type_id)  ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE Item ADD CONSTRAINT FK_Item_host_id_User_user_id FOREIGN KEY (host_id)
 REFERENCES User (user_id)  ON DELETE RESTRICT ON UPDATE RESTRICT;


-- TransactionHistory Table Create SQL
CREATE TABLE TransactionHistory
(
    `transaction_id`    INT         NOT NULL    AUTO_INCREMENT, 
    `host_id`           INT         NOT NULL, 
    `guest_id`          INT         NOT NULL, 
    `item_id`           INT         NOT NULL, 
    `contract_date`     DATETIME    NOT NULL, 
    `transaction_desc`  TEXT        NOT NULL, 
    PRIMARY KEY (transaction_id)
);

ALTER TABLE TransactionHistory ADD CONSTRAINT FK_TransactionHistory_host_id_User_user_id FOREIGN KEY (host_id)
 REFERENCES User (user_id)  ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE TransactionHistory ADD CONSTRAINT FK_TransactionHistory_guest_id_User_user_id FOREIGN KEY (guest_id)
 REFERENCES User (user_id)  ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE TransactionHistory ADD CONSTRAINT FK_TransactionHistory_item_id_Item_item_id FOREIGN KEY (item_id)
 REFERENCES Item (item_id)  ON DELETE RESTRICT ON UPDATE RESTRICT;


-- Paper Table Create SQL
CREATE TABLE Paper
(
    `paper_id`    INT             NOT NULL, 
    `user_id`     INT             NULL, 
    `item_id`     INT             NULL, 
    `paper_name`  VARCHAR(36)     NULL, 
    `paper_desc`  VARCHAR(250)    NULL, 
    PRIMARY KEY (paper_id)
);

ALTER TABLE Paper ADD CONSTRAINT FK_Paper_paper_id_AttachedFiles_file_id FOREIGN KEY (paper_id)
 REFERENCES AttachedFiles (file_id)  ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE Paper ADD CONSTRAINT FK_Paper_user_id_User_user_id FOREIGN KEY (user_id)
 REFERENCES User (user_id)  ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE Paper ADD CONSTRAINT FK_Paper_item_id_Item_item_id FOREIGN KEY (item_id)
 REFERENCES Item (item_id)  ON DELETE RESTRICT ON UPDATE RESTRICT;


-- HousingOption Table Create SQL
CREATE TABLE HousingOption
(
    `item_id`              INT    NOT NULL, 
    `has_TV`               BIT    DEFAULT 0, 
    `has_refrigerator`     BIT    DEFAULT 0, 
    `has_microwave`        BIT    DEFAULT 0, 
    `has_bed`              BIT    DEFAULT 0, 
    `bed_cnt`              INT    DEFAULT 0, 
    `has_bathroom`         BIT    DEFAULT 0, 
    `is_public_bathroom`   BIT    DEFAULT 0, 
    `has_ac`               BIT    DEFAULT 0, 
    `has_washing_machine`  BIT    DEFAULT 0, 
    `has_kitchen`          BIT    DEFAULT 0, 
    PRIMARY KEY (item_id)
);

ALTER TABLE HousingOption COMMENT '주택 내 옵션';

ALTER TABLE HousingOption ADD CONSTRAINT FK_HousingOption_item_id_Item_item_id FOREIGN KEY (item_id)
 REFERENCES Item (item_id)  ON DELETE RESTRICT ON UPDATE RESTRICT;


-- ItemPhoto Table Create SQL
CREATE TABLE ItemPhoto
(
    `item_id`  INT    NOT NULL, 
    `file_id`  INT    NOT NULL
);

ALTER TABLE ItemPhoto ADD CONSTRAINT FK_ItemPhoto_item_id_Item_item_id FOREIGN KEY (item_id)
 REFERENCES Item (item_id)  ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE ItemPhoto ADD CONSTRAINT FK_ItemPhoto_file_id_AttachedFiles_file_id FOREIGN KEY (file_id)
 REFERENCES AttachedFiles (file_id)  ON DELETE RESTRICT ON UPDATE RESTRICT;


-- Message Table Create SQL
CREATE TABLE Message
(
    `message_id`   INT         NOT NULL    AUTO_INCREMENT, 
    `msg_content`  TEXT        NOT NULL, 
    `sent_date`    DATETIME    NOT NULL, 
    `receiver_id`  INT         NOT NULL, 
    `sender_id`    INT         NOT NULL, 
    `is_unread`    BIT         DEFAULT 1, 
    PRIMARY KEY (message_id)
);

ALTER TABLE Message ADD CONSTRAINT FK_Message_receiver_id_User_user_id FOREIGN KEY (receiver_id)
 REFERENCES User (user_id)  ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE Message ADD CONSTRAINT FK_Message_sender_id_User_user_id FOREIGN KEY (sender_id)
 REFERENCES User (user_id)  ON DELETE RESTRICT ON UPDATE RESTRICT;


INSERT INTO HousingType (name) VALUES("아파트");
INSERT INTO HousingType (name) VALUES("빌라");
INSERT INTO HousingType (name) VALUES("주택");
INSERT INTO HousingType (name) VALUES("오피스텔");
INSERT INTO HousingType (name) VALUES("기타");

INSERT INTO ResidenceType (name) VALUES("원룸");
INSERT INTO ResidenceType (name) VALUES("투룸");
INSERT INTO ResidenceType (name) VALUES("쓰리룸 이상");

INSERT INTO ContractType (name) VALUES("하숙");
INSERT INTO ContractType (name) VALUES("전대");
INSERT INTO ContractType (name) VALUES("쉐어하우스");

INSERT INTO PaymentType (name) VALUES("월세");
INSERT INTO PaymentType (name) VALUES("사글세");
INSERT INTO PaymentType (name) VALUES("전세");
INSERT INTO PaymentType (name) VALUES("일시납");
