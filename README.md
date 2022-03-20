# OpenBrewery-Android
Repository created to develop an Android app that shows Open Brewery API content openbrewerydb.org

## Features

### Brewery Listing

![Brewery Listing Image](TO BE POSTED)

The results shown at brewery listing is gotten from https://api.openbrewerydb.org/breweries 
through HTTP request. This API returns a brewery objects JSON array and the application is 
responsible for converting the data into a readable one.
Example:
```yaml
[
  ...
  {
    id: 299,
    name: "Almanac Beer Company",
    brewery_type: "micro",
    street: "651B W Tower Ave",
    address_2: null,
    address_3: null,
    city: "Alameda",
    state: "California",
    county_province: null,
    postal_code: "94501-5047",
    country: "United States",
    longitude: "-122.306283180899",
    latitude: "37.7834497667258",
    phone: "4159326531",
    website_url: "http://almanacbeer.com",
    updated_at: "2018-08-23T23:24:11.758Z",
    created_at: "2018-08-23T23:24:11.758Z"
  },
  ...
]
```

---
**NOTE**

The filter and ordering is gonna be developed in the next release.

---

### Brewery Details

![Brewery Details Image](TO BE POSTED)

When the user clicks on some brewery in the list, it's redirected
to the details page where is shown all the info about the chosen
brewery. The same approach is used to get the brewery details but
the request is made, for example
https://api.openbrewerydb.org/breweries/madtree-brewing-cincinnati
and the result obtained is:
```yaml
{
  id: "madtree-brewing-cincinnati",
  name: "MadTree Brewing",
  brewery_type: "regional",
  street: "3301 Madison Rd",
  address_2: null,
  address_3: null,
  city: "Cincinnati",
  state: "Ohio",
  county_province: null,
  postal_code: "45209-1132",
  country: "United States",
  longitude: "-84.4239715",
  latitude: "39.1563725",
  phone: "5138368733",
  website_url: "http://www.madtreebrewing.com",
  updated_at: "2021-10-23T02:24:55.243Z",
  created_at: "2021-10-23T02:24:55.243Z"
}
```

Note that the brewery ID is passed at the and of the link.

## Architecture

### Presentation layer architecture

## Package structure

```bash
Open Brewery Android
└── app
    ├── BreweryApplication.kt
    └── ui
        ├── activity
        │   └── MainActivity.kt
        └── fragment
            └── MainFragment.kt
    features
        ├── brewerydetail
            ├── data
            │   ├── datasource
            │   │   ├── local
            │   │   │   ├── BreweryDetailLocalDataSourceImpl.kt
            │   │   │   └── BreweryDetailLocalDataSource.kt
            │   │   └── remote
            │   │       ├── BreweryDetailDataSourceImpl.kt
            │   │       └── BreweryDetailDataSource.kt
            │   ├── repository
            │   │   ├── BreweryDetailRepositoryImpl.kt
            │   │   └── BreweryDetailRepository.kt
            │   └── service
            │       └── BreweryDetailService.kt
            ├── di
            │   └── BreweryDetailDI.kt
            └── ui
                ├── fragment
                │   └── BreweryDetailFragment.kt
                └── viewmodel
                    └── BreweryDetailViewModel.kt
        ├── brewerylist
            ├── data
            │   ├── datasource
            │   │   ├── local
            │   │   │   ├── BreweryListLocalDataSourceImpl.kt
            │   │   │   └── BreweryListLocalDataSource.kt
            │   │   └── remote
            │   │       ├── BreweryListDataSourceImpl.kt
            │   │       └── BreweryListDataSource.kt
            │   ├── repository
            │   │   ├── BreweryListRepositoryImpl.kt
            │   │   └── BreweryListRepository.kt
            │   └── service
            │       └── BreweryListService.kt
            ├── di
            │   └── BreweryListDI.kt
            └── ui
                ├── adapter
                │   └── BreweryListAdapter.kt
                ├── fragment
                │   └── BreweryListFragment.kt
                ├── viewholder
                │   └── BreweryListViewHolder.kt
                └── viewmodel
                    └── BreweryListViewModel.kt
        ├── shared
            ├── data
            │   ├── database
            │   │   ├── configuration
            │   │   │   └── AppDatabase.kt
            │   │   ├── dao
            │   │   │   └── BreweryDao.kt
            │   │   └── entity
            │   │       └── BreweryEntity.kt
            │   ├── extensions
            │   │   ├── BreweryEntityExt.kt
            │   │   └── BreweryResponseExt.kt
            │   ├── remote
            │   │   └── response
            │   │       └── BreweryResponse.kt
            │   └── ResultStatus.kt
            ├── di
            │   ├── DatabaseDI.kt
            │   └── RetrofitDI.kt
            ├── domain
            │   └── model
            │       └── Brewery.kt
            └── ui
                └── base
                    └── BaseViewModel.kt
```

## Navigation

## Dependencies

For this app we are using Gradle as the build system.

You can check below the complete list of Gradle dependencies separated by their functionalities

#### Core
- Core KTX: Common libraries that are part of the Android framework
- Core Testing: Android Core-Testing

#### Layout
- Appcompat: Allows access to new APIs on older API versions
- Material: Material components
- ConstraintLayout: Allows create large and complex layouts with a flat view hierarchy
- Jetpack RecyclerView: Creates dynamic lists

#### Tests
- JUnit: Unit tests
- Mockk: Mocking library for Kotlin
- Kotlintest Assertions: Assertions
- Espresso: Integrated tests

#### Dependency Injection (Koin)
Kotlin injection library
- Koin Scope: Manages Android Scopes
- Koin Test: Injecting in Tests

#### Kotlin coroutines
- Coroutines core: Commons coroutines across all platforms
- Coroutines Android: Coroutines dispatchers and logging unhandled exceptions
- Coroutines Test: Utilities for testing coroutines

#### Jetpack Navigation
- Navigation Dynamic Features Fragment: Feature module Support
- Navigation Testing: Testing Navigation

#### HTTP API
- Retrofit: A type-safe HTTP client
- Gson: Convert a JSON string to an equivalent Kotlin object
- Logging interceptor: OkHttp interceptor which logs request and response information

#### Local database (Room)
The Room persistence library provides an abstraction layer over SQLite
- Room KTX: Kotlin Extensions and Coroutines support
- Room Testing: Room Test helpers
