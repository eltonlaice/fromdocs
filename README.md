# Fromdocs for Java

Fromdocs is a library that allows extracting identification data from digital copies of some identification documents emited in Mozambique. The extracted data can be used to automate the completion of electronic forms and, with that the process becomes faster and less error prone.

Currently the set of documents supported by FromDocs include ID, NUIT, Passport and Driving license. The copies can be presented in PDF, JPG or PNG file formats.

## Usage

In order to use this library you should first import **DocumentReader** class from its package, you can proceed as instructed in the following snippet:

```java
import com.eltonlaice.DocumentReader;
```

Then you should create a DocumentReader instance passing a copy of the document and its type as arguments:

```java
DocumentReader reader  = new DocumentReader("/path/docfile.pdf", "NUIT");
```

Finally you can extract data from the document like this:

```java
Document document = reader.getDocument();
String number = document.getNumber();
String lastName = document.getLastName();
String givenNames = document.getGivenNames();
LocalDate birthdate = document.getBirthdate();
String placeBirth = document.getPlaceBirth();
LocalDate dateIssue = document.getDateIssue();
```

## Prerequisites
Before you install FromDocs you must make sure you have **Tesseract-OCR** installed in your Operating System. Feel free to browse their  [documentation page](https://tesseract-ocr.github.io/tessdoc/) in order to have installation instructions. 

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

If for some reason you can't use a dependency manager like Maven or Gradle, you can download a JAR from [releases page](../../releases) and include it in classpath of your project.

## Authors

- [Elton Tomás Laice](https://github.com/eltonlaice)

## Credits

- [Edson Michaque](https://github.com/edsonmichaque)

## License

Copyright 2020 Elton Laice

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.