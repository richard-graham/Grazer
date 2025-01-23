Grazer Android app:

I structured it using Clean Architecture with three layers: data, domain, and presentation. The core tech stack includes Jetpack Compose for the UI, Hilt for dependency injection, Retrofit for API calls, and Coroutines with Flow for async operations. For token storage, I went with EncryptedSharedPreferences which seemed like a good option after some research.

A key decision was using interfaces for repositories. It makes the app way more testable since we can mock repositories easily, and it lets us swap implementations without touching business logic. This gives us the flexibility to do things like add caching or switch from REST to GraphQl if that was the desire. 

While the app works well, there's room for improvement. Offline support using Room would be nice, and the error handling could be more sophisticated. Adding pagination for the user list would help performance with larger datasets. The testing coverage is also non-existent, if I were to extend this I would add robust UI and unit tests.