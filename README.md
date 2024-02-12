# Post office


This Java project implements a system of distributed entities including parcels, mailboxes, active individuals, postmen, and recipients. Here's a brief overview of the classes included:

## Parcel:

Each parcel has a unique automatically generated integer identifier and a destination address (string).
Functionality includes retrieving the sending address, making a copy of the parcel, and composing a textual description in the format p_identifier[address].
## Mailbox:

A mailbox has an address and contains an array of parcels with a specified capacity.
Features include adding parcels individually, extracting the first parcel from the mailbox, and retrieving a parcel with a given recipient address.
Threads executing actions are temporarily blocked when attempting to retrieve a parcel from an empty mailbox or add a parcel to a full mailbox.
Provides functionality to retrieve the mailbox address and compose a textual description listing the parcels it contains (each parcel on a separate line).
## ActivePerson:

An active person has a name, time range limits (in milliseconds), and an associated mailbox.
At random time intervals within the specified range, the person executes a particular action.
An error occurs if the shortest and longest execution times are incorrectly specified.
Capable of composing a textual description of the person, including their name and associated mailbox.
## Postman:

A postman is an individual responsible for delivering parcels to designated mailboxes.
Created with an empty list of mailboxes, to which mailboxes can be added individually.
The postman delivers parcels to addresses based on the first parcel in the associated mailbox.
The delivery address is the address of the first parcel in the associated mailbox, and all parcels with that sending address are delivered in the same action.
## Recipient:

A recipient is an individual who retrieves parcels from their associated mailbox.
Parcels are retrieved in the order they are stored in the mailbox.
This Java program initializes a postman with an associated mailbox containing several parcels. It then creates a recipient, to whose associated mailbox the postman delivers parcels. After a specified time, the program stops the postman and the recipient and prints their details.
