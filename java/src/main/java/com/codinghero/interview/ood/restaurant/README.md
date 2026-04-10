Good
1. Refactor Customer to ReserveApplication. Because some information belongs to the reservation information, doesn't belong to customer.
2. Use enum TableCapacity

Not Sure
1. Cancel. What criteria class do we use to cancel?
(1) Reservation
(2) id of Reservation
(3) ReserveApplication (I think Reservation is better than ReserveApplication. Because just successful reservation can be canceled. So ReserveApplication maybe a failed Reservation.)
(4) customer 's name, mobilePhoneNumber
