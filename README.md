control-flow-graph
==================

Model of a control flow graph in Java

Compile
---

```
mvn compile
```

Execute
---

```
mvn exec:java
or
mvn exec:java -Dexec.mainClass="fr.univnantes.controlflowgraph.App"
```

Add as library
---
Retrieve project
```
git clone https://github.com/masterALMA2016/control-flow-graph.git
```

Execute these commands in control-flow-graph root directory (where the pom.xml file is)
```
mvn package

mvn install
or
mvn install:install-file -Dfile=target/controlflowgraph-1.0.jar -DgroupId=fr.univnantes.controlflowgraph -DartifactId=controlflowgraph -Dpackaging=jar -Dversion=1.0
```

Then edit your project pom.xml to add these lines
```
  <dependencies>
    <dependency>
	    <groupId>fr.univnantes.controlflowgraph</groupId>
	    <artifactId>controlflowgraph</artifactId>
	    <version>1.0</version>
	</dependency>
  </dependencies>
```

Update the library
---
Run "git pull origin master" in control-flow-graph directory and then follow "Add library" section

