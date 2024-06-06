CREATE TABLE Locations (LocationID int, LocName varchar(100))
 
CREATE TABLE LocationHist (LocationID int, ModifiedDate DATETIME)

CREATE TRIGGER TR_UPD_Locations ON Locations
FOR UPDATE 
NOT FOR REPLICATION 
AS
 
BEGIN
  INSERT INTO LocationHist
  SELECT LocationID
    ,getdate()
  FROM inserted
END

insert into Locations values (1, 'this is name')

update Locations set LocName = 'this name is altered' where LocationID = 1

 select * from Locations;
 select * from LocationHist;