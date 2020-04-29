

This project verifies basic use cases revolving navigation and functionality in the app. Appium is used to perform actions on the mobile device.



## Getting Started

### Prerequisites

1. Java SDK
2. Android SDK and Android Debug Bridge (ADB)
3. Maven
4. Appium
5. TestNG
6. IDE (ex. Eclipse, IntelliJ)


### Installation

1. Clone the project

2. Import the project into an IDE
```
File > Import... > Existing Maven Projects
```
3. Build the project
```
Maven command: mvn clean install -DskipTests=true
```

## Running the tests


### Running the tests locally

1. Set the following config in ../qa-mobile-android-automation/src/main/resources/config.properties

```
local-device=true
```

2. Run testng.xml as TestNG Suite

### Running the tests on AWS Device Farm

1. Set the following config in ../qa-mobile-android-automation/src/main/resources/config.properties

```
local-device=false
```

2. Package the project

```
Maven command: mvn clean package -DskipTests=true
```

3. Under the /qa-mobile-android-automation/target folder copy zip-with-dependencies.zip

4. Create a new run on the AWS Device farm console

5. Drop the zip-with-dependencies.zip file into the console

6. Select a device pool and begin the run


## Generating an apk
1. Clone project generic-app-android
2. Open the project in Android Studio
3. Make changes, ex. introduce a new DB (if necessary)
4. Deploy the app to a mobile device to verify the app works
5. the apk will be available at the following location:
```

```
