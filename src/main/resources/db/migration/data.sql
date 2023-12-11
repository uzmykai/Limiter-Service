INSERT INTO Rule (id,name, description, category, status,
maxSecondsPerRequest,maxRequest, dateCreated, createdBy)
VALUES (1,"defaultRule","general_rule","default","active",5,100,"2023-12-07","System")


INSERT INTO Client (id,ipAddress,status,dateCreated, createdBy)
VALUES (1,"172.16.0.1","active","2023-12-07","System"),
(2,"172.0.0.1","active","2023-12-07","System")


INSERT INTO ClientRule (id,clientId,ruleId,status,dateCreated, createdBy)
VALUES (1,"1","1","active","2023-12-07,"System"),
(2,"2","2","active","2023-12-07,"System")