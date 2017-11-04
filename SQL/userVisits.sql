-- Question 1

-- Assumptions :
-- It's not described that what kind of paritioning is used for Logs table
-- In case it is range partition then depending on database you can
-- uncomment the "Partition (p8)" line and give the actual partition names in it
-- instead of p8

create table userVisits as (
    select CookieID,
           min(ViewTimeStamp) as FirstVisit,
           max(ViewTimeStamp) as LastVisit
    from (
        select a.CookieID "CookieID",
            a.ViewTimeStamp "ViewTimeStamp"
            from Logs -- Partition (p8)       -- If its range partitioned uncomment the Partition and give the partition number for tha day
            a,
            Location b, Site c
            where
            a.ViewTimeStamp BETWEEN '2017-08-01 00:00:00' and '2017-08-31 23:59:59'
            and a.LocationID = b.LocationID
            and b.State = "New York"
            and a.SiteID = c.SiteID
            and c.SiteName != "CNN") d
        group by (CookieID)
    );

select * from userVisits;


-- Question 2

-- Assumptions :
-- It is not clear that if we want the users who stayed in New York state
-- for complete Q2 of 2017
-- or who just stayed anytime during Q2 2017 and the stay may or may not be
-- for full Q2
-- So I am giving two queries based on each assumption


-- Assuming that stay was for full Q2 2017
select UserId from UserAddress
where State = 'New York'
and
Start_DateTime <= '2017-04-01'
and
End_DateTime >= '2017-06-30';

-- Assuming that stay might not be for full Q2 but can also be partly in Q2
select UserId from UserAddress
where State = 'New York'
and
Start_DateTime <= '2017-06-30'
and
End_DateTime >= '2017-04-01';

