The file named userVisits.sql contains the solution for SQL questions.
I have described about the assumptions for both questions as comments in SQL file.

Assumptions for Question 1 :

It's not described that what kind of paritioning is used for Logs table
In case it is range partition then depending on the database you can
uncomment the "Partition (p8)" line and give the actual partition names in it instead of p8.

Assumptions for Question 2 :

It is not clear that if we want the users who stayed in New York state
for complete Q2 of 2017
or who just stayed anytime during Q2 2017 and the stay may or may not be
for full Q2.
So I have given two queries based on each assumption.

