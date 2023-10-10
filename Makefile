all: main

main: compil
	java -classpath classes main.main.MainMaster

league: compil
	java -classpath classes main.main.MainLeague
	
tournament: compil
	java -classpath classes main.main.MainTournament

compil :
	javac -sourcepath src -d classes src/main/*/*.java
	

javadoc: 
	javadoc -sourcepath src -d docs -subpackages main
	
compiltest : compil
	javac -cp classes:junit-platform-console-standalone-1.9.1.jar -d classes test/*/*.java
	
runTest : compiltest classes
	java -jar junit-platform-console-standalone-1.9.1.jar -cp classes --scan-class-path
	
createJar: classes 
	jar cvfe game.jar main.main.MainMaster -C classes .
	
executeJar: createJar 
	java -jar game.jar
	
