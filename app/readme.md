##About the Assignment
Your task is to create an Android Application with two screens. The first page page is a list of events(Page1) according to the user's location. On event tap, you should show the events detailed page(Page2). Please note the UI elements in the page and create the best suited UI experience according to you.

###Page1 - Event Listing Page
Each row has 6 components - Activity Picture, title, Host Picture, Event summary, Location, Time 
Show the only first 5 events in the list only. Background colour of button : #22c7a2

###Page2 - Event Detail Page:
Each page has 6 components - Activity Picture, title, host name, event summary, event description, Host Picture, Time, google mapView of event location.

##Evaluation Criteria:
1. Stability: Please ensure that there are no crashes and all corner cases are handled.
2. The efficiency of the code: The code should have components that are getting reused in listView.
3. Functional Completeness: The code should be functionally complete with the mentioned features.
4. Readability and cleanliness of the code: Use good variable names so that the code is readable.



##Notes:
1. The motive of test your basic Android development skills and to find out the best role suitable for you in the company.
2. We strongly encourage you to use about third party libraries for networking and json parsing for network handling. 
3. Use Google Location Services to fetch the user's location(best accuracy).
4. Use Google Maps to show the location on the map.
5. APIs to be used:-


- listing URL:  
URL : https://api.kloh.in/kloh/external/v1/activity/list
Request Payload: {
  "location":{

	"lat": 12.926031,

	"lon":77.676246

}


- details URL: https://api.kloh.in//kloh/external/v1/activity{activityId}



###Submission:
The deadline is 22nd April as mentioned, or when you complete the task, just send and email. We recommend you to describe how you can improve your solution if you had more time.
