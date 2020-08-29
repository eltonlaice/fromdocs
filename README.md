# Fromdocs for Java

Fromdocs is a library that allows extracting identification data from digital copies of some identification documents emited in Mozambique. The extracted data can be used to automate the completion of electronic forms and, with that the process becomes faster and less error prone.

Currently the set of documents supported by FromDocs include ID, NUIT, Passport and Driving license. The copies can be presented in PDF, JPG or PNG file formats.

## Features

## Usage

```java
DocumentReader reader  = new DocumentReader("/path/docfile.pdf", "NUIT");
Document document = reader.getDocument();
String number = document.getNumber();
String lastName = document.getLastName();
String givenNames = document.getGivenNames();
LocalDate birthdate = document.getBirthdate();
String placeBirth = document.getPlaceBirth();
LocalDate dateIssue = document.getDateIssue();
```

## Prerequisites

## Installation

### Using Maven

In order to install FromDocs using Maven you have to update your project's POM.xml to include the following snippet:

```xml
<dependency>
    <groupId>com.eltonlaice.fromdocs</groupId>
    <artifactId>fromdocs</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

### Using Gradle

### Manual Installation

If for some reason you can't use a dependency manager like Maven or Gradle, you can download a JAR from [releases page](releases) and include it in classpath of your project.

## Contributing

## Authors

## Credits

- [Elton Tomás Laice](https://github.com/eltonlaice)
- [All Contributors](../../contributors)

## License

Copyright 2020 Elton Laice

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.