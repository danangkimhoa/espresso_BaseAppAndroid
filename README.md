Base skeleton structure to start every new project, based on the design patters suggested by Robert C. Martin *(aka Uncle Bob)* on his clean architecture.

The project is divided in three modules:
* **domain**: java library project. Every test is a unit test and all its dependencies are pure java libraries: dagger 2, rxjava, lombok, junit and mockito.
* **data**: android library project. It’s the repository that supplies the data which will be consumed by the domain module. Dependencies: domain module, retrofit 2, dagger 2, rxjava, lombok, junit, mockito, roboelectric.
* **presentation**: android app project. It links the two previous modules and implement all the views interfaces defined in domain module. Dependencies: domain and data module, dagger 2, rxAndroid, lombok, androidannotations and espresso.

Also, it contains several packages named as "demo", which contain "demo" clases in order to ilustrate a basic usage of an Interactor-Presenter-View workflow. 

***Warning***: [Lombok Plugin for IntelliJ IDEA](https://github.com/mplushnikov/lombok-intellij-plugin) is required in order to support the annotations generated by [Lombo library](https://github.com/rzwitserloot/lombok)

***Warning***: To use [Gradle Retrolambda Plugin](https://github.com/evant/gradle-retrolambda) you will need install [JDK 8](http://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html) and create JAVA8_HOME environment variable. The same for your previous JDK (e.g: JAVA7_HOME)