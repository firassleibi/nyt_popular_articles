## NYT Most Popular Articles Project

This project loads the most popular articles from New York Times API.

#### How to test the code:

Code could be tested with methods below:

1. **Direct Install from APK File:**
	- Copy the file located at /app/build/outputs/apk/debug/app-debug.apk  to your mobile phone.
	- Allow install from unkown resources.
	- Install App.

2. **Run from Android Studio**
	- Import project with **Android Studio**
	- Sync the project with gradle.
	- Wait till all downloads are finished.
	- Press the play button and choose whether to run App on Simulator or Device.


#### How to run Test:
A Simple JUNIT Test case has been created, The test checks whether the API Key is correct or wrong by checking the HTTP response code, To run the Test Case:
   - Open the project in Android Studio
   - Right Click on the **Com (test)** folder in the Android Pane on the left.
   - Click on run Tests in COM
   - The tests will pass. If you want the tests to fail change the API Key in the Strings resources file.



#### How it works?

- Custom list view has been created with an adapter.
- A class for Article has been defined.
- We make an HTTP request to the API.
- We parse the JSON into a list array of Articles Class.
- We load the List Array in the List View Adapter.
- When press on a an article we pass the Article object to the details Activity using intent Extras.

#### Libraries used

- **Volley**: Used to make HTTP Requests.
- **Piccaso:** Used to load images in ImageView.



