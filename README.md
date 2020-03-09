# trainapp-aishwarna

# User Story 1: User Registration:

### Use case 1.1 : Valid User:
 If the user is new to the website , they must fill the registration form with all necessary details for login.

### Use case 1.2: User Already Registered:
If the user is already regitered , then it displays the message "You have Already Registered" and directs you to the login page.

# User Story 2:  UserLogin:

## usecase 2.1: Valid Username and Password:
If the user is successfully registered, the admin will provide username and password.
The user must enter valid  username and password to login.

### usecase 2.2:Invalid Username or password:
If the user entered username or password is incorrect, then it displays the message "Invalid UserName or Password" and allows the user to reenter the username and password .

# User Story 3:AdminLogin:
Admin will have seperate  username and pasword. If it is valid ,it allows him to view all train details, booking details of user and he can also able to delete trains ,if needed.

# User Story 4: Viewing train details:

##  usecase 4.1: User Side:
 Once the user Login was successful, they can able to view all the train details and to view the particular train detail , they can search it by giving the train name.
 
 ## usecase 4.2: Admin Side:
 Once the admin login was successful, he can also be able to view all the details of the train.
 

# User Story 5: Booking 

## usecase 5.1: UserTicketBooking:
After seeing the train details and if the user  wants to book the ticket, they need to click the booking option.
By doing so,it will direct them to the booking page and need to give the required details.

### usecase 5.2: Successfull Booking:
 The booking is considered successfull, it will update it in the database and only admin can view that.
 
 ### usecase 5.3: UnSuccessfull Booking due to user side:
 If the booking failed due to user network issues , the admin will intimate the user to ensure proper network connection.    
  
### usecase 5.4: UnSuccessfull Booking due to server side:
If the booking failed due to server issues, the user must send an email to admin to recover the error.


# User Story 6: Admin features

## Feature 1: Adding Trains:

The admin can add the new trains and it can be visible to both the user and the admin.

## Feature 2: Deleting Trains: 
The admin can delete the trains if needed, it will update in the database as well.


 












