# Welcome to my Assignment!

Hi! This is my submission for Assignment 3 for the Advanced Software Engineering course in the MAC program at the University of Windsor. 
This is an **Android** app which allows one to maintain the sales leads for a client.

# Screenshots

![ScreenShot](/screenshots/register.jpeg)
![ScreenShot](/screenshots/login.jpeg)
![ScreenShot](/screenshots/details.jpeg)
![ScreenShot](/screenshots/db.png)
![ScreenShot](/screenshots/metrics.png)

# Storage

For storage purposes, both size and scalability had to be considered. Therefore, I have made use of **Google's Firebase Realtime Database** to push all the Client's sales leads directly to the database in realtime. This ensures both the safety of the data, as well as a scalable solution as the size of data increases with growing customers.

## Pricing

The most exciting part is that Google provides very generously a large storage for **FREE**. Therefore, for the purpose of this assignment, this seemed like the perfect choice.

## Firebase Authentication

Most apps need to know the identity of a user. Knowing a user's identity allows an app to securely save user data in the **CLOUD** and provide the same personalized experience across all of the user's devices.

Firebase Authentication provides backend services, easy-to-use SDKs, and ready-made UI libraries to authenticate users to the app. It supports authentication using passwords, phone numbers, popular federated identity providers like Google, Facebook and Twitter, and more.

Firebase Authentication integrates tightly with other Firebase services, and it leverages industry standards like **OAuth 2.0 and OpenID Connect**, so it can be easily integrated with the custom backend.

## Firebase Realtime Database

Ability to store and sync data with Google's NoSQL cloud database. Data is synced across all clients in realtime, and remains available when the app goes offline.

The Firebase Realtime Database is a cloud-hosted database. Data is stored as JSON and synchronized in realtime to every connected client.


