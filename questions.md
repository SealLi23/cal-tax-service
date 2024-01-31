1. How to handle the bill when the vehicle travels across days? 
   For example, the car starts off at 23:40 Sep 21 and stop at 24:35 Sep 22? On which day should the bill be recorded, Sep 21 or Sep 22? (There is not charge based on the current rule, but need to allow for it if the charging rule is changed in the future. In the current implementation, the expense is counted in the first day.)
2. What is the possibility or frequency of the update on the taxing rule? 
3. Is the RESTful API a proper way to handle the query? Because the size of "dates" (timestamps taken by tollgates) may be various dramatically based on the frequency of the car usage. It could be a problem when the dates size is too big that over the size of the HTTP payload. So, probably it would be better to put the date records in a static
   file and let a batch data job to handle it periodically, and store the result in a database. Then use a date/time range as the search condition for the REST API to query the DB.
4. This is also about using REST APIs. The performance of using could be a problem as well when the "dates" is growing bigger. Because it maybe not a good practice to always keep the calculation rule and holiday config in memory, 
   if wants to support the scenario of multiple cities in the future.
5. Who will be the API callers? Personally, the Vehicle Type or its corresponding code would be enough for the query if its invoker has already known about the detail of the vehicle.
