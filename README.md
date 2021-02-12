ScopeAI Android SDK
======================

A simple client for the ScopeAI API _ScopeAI_

* Try the ScopeAI demo at: https://api.scopemedia.com/#/demo/image-search
* Sign up for a free account at: https://api.scopemedia.com/#/signup
* Read the documentation at: https://developer.scopemedia.com/documentation/

Installation
------------
* Clone or download this repository
* Run `gradlew install` on windows or `gradle install` on macOS or unix

### Gradle:

Add the following to the dependencies section of your `build.gradle`:

```groovy
// Add the client to your dependencies:
dependencies {
    compile 'com.scopemedia.scopecheck:android-sdk:1.0.1'
}

// Make sure you have the Maven Local Repository in your Gradle File
repositories {
    mavenLocal()
}
```

### Maven:

Add the following to your dependencies:

```xml
<dependency>
  <groupId>com.scopemedia.scopecheck</groupId>
  <artifactId>android-sdk</artifactId>
  <version>1.0.1</version>
</dependency>
```

Getting Started
---------------
Get your Client ID and Client Secret [here](https://api.scopemedia.com/#/dashboard/products/ScopeCheck/)

To create a `ScopeCheckClient` instance with an ID and secret do the following:

```java
ScopeCheckClient client = new ScopeCheckBuilder(CLIENT_ID, CLIENT_SECRET).build();
```

You can also enable the debug and set an debug level based on OkHttp3

```java
ScopeCheckClient client = new ScopeCheckBuilder(CLIENT_ID, CLIENT_SECRET)
                .setDebugMode(true)
                .setDebugLevel(HttpLoggingInterceptor.Level.BODY)
                .build();
```

Perform request
-------------------
Network operations using the API client only occur by calling `.performSync()` or `.performAsync(...)` on a
`ScopeCallback<T>` object.

### Example for a prediction
#### Async
```java
PredictionRequest request = new PredictionRequest();
request.setMediaUrl(imageUrl);
request.setModelId("general-v3");

client.getPrediction(request).performAsync(new ScopeCallback<PredictionResponse>() {
    @Override
    public void onScopeResponse(PredictionResponse response) {
        Tag[] tags = response.getTags();
        for (Tag tag : tags)
            System.out.println(tag.getTag() + ":" + tag.getScore());
    }

    @Override
    public void onScopeFailure(Throwable throwable) {

    }
});
```

#### Sync
```java
PredictionRequest request = new PredictionRequest();
request.setMediaUrl(imageUrl);
request.setModelId("general-v3");

try {
    PredictionResponse response = client.getPrediction(request).performSync();
    Tag[] tags = response.getTags();
    for (Tag tag : tags)
        System.out.println(tag.getTag() + ":" + tag.getScore());
} catch (IOException e) {
    e.printStackTrace();
}
```