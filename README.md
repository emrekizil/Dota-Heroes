<h1 align="center">Dota-Heroes</h1>
</br>
<p align="center">
  A Dota Heroes app that shows filtering, searching operations, and implementation of multi-modularization by feature pattern.
</p>
</br>

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=21"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
  <a href="https://github.com/"><img src="https://img.shields.io/badge/Flow-based"/></a>
  <a href="https://github.com/emrekizil"><img alt="Profile" src="https://img.shields.io/badge/github-emrekizil-red"/></a> 
</p>

## Screenshots
<p align="center">
<img src="/previews/home_page.png" width="20%"/>
<img src="/previews/filter_page.png" width="20%"/>
<img src="/previews/bookmarks_page.png" width="20%"/>
<img src="/previews/detail_page.png" width="20%"/>
</p>

## Tech Stack & Open Source Libraries
- Minimum SDK level 21
- 100% [Kotlin](https://kotlinlang.org/)  based + [Flow](https://developer.android.com/kotlin/flow) and [Coroutines](https://developer.android.com/kotlin/coroutines)
- [Architecture Components](https://developer.android.com/topic/libraries/architecture)
  - [Use Cases](https://developer.android.com/topic/architecture/domain-layer) purpose is to request data from repositories and turn them ready to use for the UI layer
  - [Repository](https://developer.android.com/topic/architecture/data-layer) pattern is a design pattern that isolates the data layer from the rest of the app
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) class is a business logic or screen level state holder. It exposes the state to the UI and encapsulates related business logic
  - [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) is a class that holds the information about the lifecycle state of a component (like an activity or a fragment) and allows other objects to observe this state
- [Navigation Component](https://developer.android.com/guide/navigation) refers to the interactions that allow users to navigate across, into, and back out from the different pieces of content within the app
- [Retrofit](https://square.github.io/retrofit/) A type-safe HTTP client for Android and Java
- [Gson]()
- [Dagger Hilt](https://dagger.dev/hilt/) Hilt provides a standard way to incorporate Dagger dependency injection into an Android application
- [Coil](https://coil-kt.github.io/coil/) An image loading library for Android backed by Kotlin Coroutines
- [Room](https://developer.android.com/training/data-storage/room) persistence library provides an abstraction layer over SQLite to allow for more robust database access while harnessing the full power of SQLite.
- [Jetpack Datastore](https://developer.android.com/topic/libraries/architecture/datastore) is a data storage solution that allows you to store key-value pairs or typed objects with protocol buffers.


## Dependency graph
<p align="center">
<img src="/previews/dependency_graph.jpg" width="80%" height="500px""/>
</p>

## Architecture
MVVM [***Model View ViewModel***](https://developer.android.com/topic/architecture#recommended-app-arch)

![Architecture](https://user-images.githubusercontent.com/21035435/69536839-9f4c8e80-0fa0-11ea-85ee-d7823e5a46b0.png)

# License
```xml
Designed and developed by 2023 emrekizil

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
