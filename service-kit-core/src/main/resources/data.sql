
-- -- SELECT * FROM CMTCONSUMER_M LIMIT 1
-- -- Insert data for Complaint request types
-- insert into CSTREQUESTTYPE_M
-- (id, type)

-- values

-- (1 , 'SUPPLY RELATED'),
-- (2 , 'BILLING RELATED'),
-- (3 , 'METER RELATED'),
-- (4 , 'OTHER CUSTOMER SERVICES'),
-- (5 , 'GENERAL'),
-- (6 , 'EMERGENCY'),
-- (7 , 'STAFF RELATED'),
-- (8 , 'THEFT RELATED');


-- --Insert data for Complaint Request
-- insert into CSTREQUEST_M (id, request_NATURE,display_NATURE, type_id, duration,effective_date,request_resolving_basis,responsibleofficetype_id,service_level)

-- values

-- (1, 'Bill Stop' , 'Bill Stop' , (select id from CSTREQUESTTYPE_M where type = 'BILLING RELATED'), '0',now(),'dummy data','1','1'),
-- (2, 'Meter Burnt' ,'Meter Burnt' , (select id from CSTREQUESTTYPE_M where type = 'METER RELATED'), '240',now(),'dummy data','1','1'),
-- (3 , 'Supply Failed - Individual', 'Supply Failed - Individual' , (select id from CSTREQUESTTYPE_M where type = 'SUPPLY RELATED') , '4',now(),'dummy data','1','1'),
-- (4 , 'Load Enhancement', 'Load Enhancement' , (select id from CSTREQUESTTYPE_M where type = 'OTHER CUSTOMER SERVICES') , '0',now(),'dummy data','1','1'),
-- (5 , 'Final Bill', 'Final Bill' , (select id from CSTREQUESTTYPE_M where type = 'BILLING RELATED') , '24',now(),'dummy data','1','1'),
-- (6 , 'High Bill', 'High Bill' , (select id from CSTREQUESTTYPE_M where type = 'BILLING RELATED') , '60',now(),'dummy data','1','1'),
-- (7 , 'Bill not Recived', 'Bill not Recived' , (select id from CSTREQUESTTYPE_M where type = 'BILLING RELATED') , '23',now(),'dummy data','1','1'),
-- (8 , 'Dim supply', 'Dim supply' , (select id from CSTREQUESTTYPE_M where type = 'SUPPLY RELATED') , '6',now(),'dummy data','1','1'),
-- (9 , 'Re- Billing Request', 'Re- Billing Request' , (select id from CSTREQUESTTYPE_M where type = 'BILLING RELATED') , '45',now(),'dummy data','1','1'),
-- (10 , 'settlement', 'Settlement' , (select id from CSTREQUESTTYPE_M where type = 'OTHER CUSTOMER SERVICES') , '720',now(),'dummy data','1','1'),
-- (11 , 'Transformer - Cable/lugs bur', 'Transformer - Cable/lugs bur' ,  (select id from CSTREQUESTTYPE_M where type = 'SUPPLY RELATED') , '24',now(),'dummy data','1','1'),
-- (12 , 'Transformer - Oil leaking', 'Transformer - Oil leaking' , (select id from CSTREQUESTTYPE_M where type = 'GENERAL') , '24',now(),'dummy data','1','1'),
-- (13 , 'Pole - Leaning', 'Pole - Leaning' , (select id from CSTREQUESTTYPE_M where type = 'EMERGENCY') , '240',now(),'dummy data','1','1'),
-- (14 , 'SC-Wire broken', 'SC-Wire broken' , (select id from CSTREQUESTTYPE_M where type = 'SUPPLY RELATED') , '6',now(),'dummy data','1','1'),
-- (15 , 'Pole - Rusted/damaged', 'Pole - Rusted/damaged' , (select id from CSTREQUESTTYPE_M where type = 'SUPPLY RELATED') , '3',now(),'dummy data','1','1'),
-- (16 , 'Pole - Fell down', 'Pole - Fell down' , (select id from CSTREQUESTTYPE_M where type = 'EMERGENCY') , '6',now(),'dummy data','1','1'),
-- (17 , 'Additional Charges Dispute', 'Additional Charges Dispute' , (select id from CSTREQUESTTYPE_M where type = 'BILLING RELATED') , '168',now(),'dummy data','1','1'),
-- (18 , 'Meter Change', 'Meter Change' , (select id from CSTREQUESTTYPE_M where type = 'METER RELATED') , '720',now(),'dummy data','1','1'),
-- (19 , 'Line - Bunched/Twisted', 'Line - Bunched/Twisted' , (select id from CSTREQUESTTYPE_M where type = 'SUPPLY RELATED') , '6',now(),'dummy data','1','1'),
-- (20 , 'supply not connected ', 'Supply not connected' , (select id from CSTREQUESTTYPE_M where type = 'OTHER CUSTOMER SERVICES') , '72',now(),'dummy data','1','1'),
-- (21 , 'TARRIF CHANGE', 'TARRIF CHANGE' , (select id from CSTREQUESTTYPE_M where type = 'OTHER CUSTOMER SERVICES') , '82',now(),'dummy data','1','1'),
-- (22 , 'BILL NOT RECEIVED', 'BILL NOT RECEIVED' , (select id from CSTREQUESTTYPE_M where type = 'BILLING RELATED') , '48',now(),'dummy data','1','1'),
-- (23 , 'TRANSFORMER THEFT', 'TRANSFORMER THEFT' , (select id from CSTREQUESTTYPE_M where type = 'METER RELATED') , '3',now(),'dummy data','1','1'),
-- (24 , 'Arrears dispute', 'Arrears dispute' , (select id from CSTREQUESTTYPE_M where type = 'BILLING RELATED') , '168',now(),'dummy data','1','1'),
-- (25 , 'Voltage low', 'Voltage low' , (select id from CSTREQUESTTYPE_M where type = 'SUPPLY RELATED') , '3',now(),'dummy data','1','1'),
-- (27 , 'Meter Theft', 'Meter Theft' , (select id from CSTREQUESTTYPE_M where type = 'METER RELATED') , '3',now(),'dummy data','1','1'),
-- (28 , 'category', 'Category Changes' , (select id from CSTREQUESTTYPE_M where type = 'OTHER CUSTOMER SERVICES') , '10',now(),'dummy data','1','1'),
-- (29 , 'Transformer - Sparking At Pole', 'Transformer - Sparking' , (select id from CSTREQUESTTYPE_M where type = 'SUPPLY RELATED') , '24',now(),'dummy data','1','1'),
-- (30 , 'CHECK METER', 'CHECK METER' , (select id from CSTREQUESTTYPE_M where type = 'BILLING RELATED') , '10',now(),'dummy data','1','1'),
-- (31 , 'تعدیل نام', 'نعدیل نام' , (select id from CSTREQUESTTYPE_M where type = 'OTHER CUSTOMER SERVICES') , '5',now(),'dummy data','1','1'),

