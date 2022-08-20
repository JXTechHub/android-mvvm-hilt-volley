# android-mvvm-hilt-volley

In this repository, you'll find boilerplate code to get started with your Android project using Hilt and MVVM. In addition, an example is provided to show you how to use volley with Hilt to execute network requests to fetch data and populate the room database. Data is then fetched from the database and displayed as a list in recyclerview using flow and live data.

For demonstration purposes, a sample dataset was used: [How many people are in space now](http://api.open-notify.org/astros.json)

## Note
It is not necessary to insert data into the room database as web data can be observed directly after receiving the json response, but this sample project is also meant to illustrate room database, flow and live data concepts.

## Other QOL Stuffs Included
1. View Binding
2. Reusable styles for your views, example in: res/values/styles.xml
3. Constraint Guidelines
4. Extensions
5. Timber logging library included

## Useful References 
1. [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
2. [MVVM](https://developer.android.com/topic/architecture)
3. [Volley](https://google.github.io/volley/)
4. [Room](https://developer.android.com/training/data-storage/room)
5. [Flow](https://developer.android.com/kotlin/flow)
6. [Live Data](https://developer.android.com/topic/libraries/architecture/livedata) 

## Contributing
You can fork the repository and create a pull request if you have any suggestions that could make this better. You can also open a new issue with the tag "enhancement". If you like the project, please give it a star! Once again, thank you!
1. Fork the Project
2. Create your Feature Branch (git checkout -b feature/navigation)
3. Commit your Changes (git commit -am 'Added new feature')
4. Push to the Branch (git push origin feature/navigation)
5. Open a Pull Request


## License
This library is free software; you can redistribute it and/or modify it under the terms of the MIT license. See [LICENSE](https://github.com/JXTechHub/android-mvvm-hilt-volley/blob/main/LICENSE) for details.