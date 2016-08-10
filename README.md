# fuber
Sample Rest application of booking cabs<br>
Features <br>
1. Add Asset(cab),View All Assets,single asset<br>
2. Add Customer,View All Customers,single Customer<br>
3. Book the cab for a customer (Not completed)<br>

1. Add customer <br>
Url-- http://localhost:8080/fcabs/customer/create<br>
Method-- POST<br>
Json Request<br>
{
    "name":"manikanata",<br>
    "mobileNo":"998088222",<br>
    "defaultLat":"88798"<br>
} <br>

2.List all customers<br>
Url --http://localhost:8080/fcabs/customer/search <br>
Method-- POST<br>

3.Search a customer by name <br>
Url --http://localhost:8080/fcabs/customer/search <br>
Method-- POST<br>
Json Request<br>
{
    
    "name":"manikanata"
  }

4.View a single customer<br>

List all customers<br>
Url --http://localhost:8080/fcabs/customer/view/1<br>
Method-- GET<br>

Similar functionality in Asset(Cab creation)<br>







