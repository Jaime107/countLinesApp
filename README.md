# CountLinesApp

This proyect count lines of code in a file.


# LOC/H

1. 2:00 pm - 9:40 pm - lines of code 67 LOC

# START

Clone the project via git clone:
```
git clone git@github.com:Jaime107/countLinesApp.git
```

## PRE-REQUISITES

* Java jdk > 8
* Maven (Apache Maven)
* Git

## INSTALL

1. Run in terminal:

```
$$ mvn package
```

2. (Run):
The following command must be used in the project root folder:

### EXAMPLE 1 (LOC lines):
```
java -cp "./target/classes" edu.escuelaing.arsw.loccount.app.CountLinesApp loc /home/jaime/Documentos/arsw_talleres/filesCount/
```
### EXAMPLE 2 (PHY lines):
```
java -cp "./target/classes" edu.escuelaing.arsw.loccount.app.CountLinesApp phy /home/jaime/Documentos/arsw_talleres/filesCount/
```

## BUILT

* [Maven](https://maven.apache.org/) - Dependency Management
* [JAVA JDK 8](http://www.oracle.com/technetwork/java/javase/overview/index.html) - Building


## AUTHOR

* **JAIME MARTINEZ SOSA** - [Jaime107](https://github.com/Jaime107)


## LICENSE

This project is licensed

