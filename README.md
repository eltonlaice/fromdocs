# Fromdocs for Java

Java package to get structured data from ID, Passport, driving license and NUIT. Fromdocs supports images and PDF

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

## Credits

- [Elton Tomás Laice](https://github.com/eltonlaice)
- [All Contributors](../../contributors)

## License

Apache License, Version 2.0. Please see [License File](LICENSE.md) for more information.
