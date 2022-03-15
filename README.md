# OpenBrewery-Android
Repository created to develop an Android app that shows Open Brewery API content openbrewerydb.org

## Features

### Brewery Listing

![Brewery Listing Image](TO BE POSTED)

The results shown at brewery listing is gotten from https://api.openbrewerydb.org/breweries 
through HTTP request. This API returns a brewery objects JSON array and the application is 
responsible for converting the data into a readable one.
Example:
```
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
```
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

## Navigation

## Dependencies

## Tests
