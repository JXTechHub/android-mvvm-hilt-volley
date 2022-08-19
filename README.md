# android-mvvm-hilt-volley

In this repository, you'll find boilerplate code to get started with your Android project using Hilt and MVVM. In addition, an example is provided to show how to use volley with Hilt to execute network requests to fetch data and populate the room database. Using flow and live data, the data is fetched from the database and displayed as a list in recyclerview.

Sample dataset for demostration purpose: [How many people are in space now](http://api.open-notify.org/astros.json)

## More Context
It is not necessary to insert data into the room database as web data can be observed directly after receiving the json response, but this sample project is meant to illustrate room database, flow and live data concepts.

## Other QOL stuffs
1. View Binding
2. Writing reusable styles for your views, example in: res/values/styles.xml
3. Constraint Guidelines
4. Timber logging library included

## Useful References 
1. [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
2. [MVVM](https://developer.android.com/topic/architecture)
3. [Volley](https://google.github.io/volley/)
4. [Room](https://developer.android.com/training/data-storage/room)
5. [Flow](https://developer.android.com/kotlin/flow)
6. [Live Data](https://developer.android.com/topic/libraries/architecture/livedata) 
