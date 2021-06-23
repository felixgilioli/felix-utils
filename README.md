# Felix Utils Java Library

## Introduction

This is a library with some utilities methods for working with Java, by example:


#### before:
```java
void myMethod(String name) {

  if (name == null) {
    throw new NullPointerException();
  }

  if (name.isBlank()) {
    throw new IllegalArgumentException();
  }

  // code...
}

```

#### after:
```java
void myMethod(String name) {

  checkArgument(name, n -> n.isBlank());
  
  // code...
}

```

#### before:
```java

users = users.stream()
             .filter(user -> user.getAge() >= 18)
             .collect(Collectors.toList());

```

#### after:
```java

users = filter(users, user -> user.getAge() >= 18);

```

## Adding the dependency

if you want to include the library in your project, you can do this by adding the dependency below:

#### Maven

```xml
<dependency>
  <groupId>io.github.felixgilioli</groupId>
  <artifactId>felix-utils</artifactId>
  <version>1.2.1</version>
</dependency>
```

#### Gradle

```groovy
implementation 'io.github.felixgilioli:felix-utils:1.1.1'
```

## Documentation

The complete project documentation can be found [here](https://www.javadoc.io/doc/io.github.felixgilioli/felix-utils/latest/index.html).

## Contribution

Pull Requests are very welcome, feel free to contribute :smiley:.
