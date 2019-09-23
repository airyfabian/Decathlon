# Decathlon
In the following program, I will show you my answer to the next test: “Your task is to write a Java program that would calculate the results of a Decathlon competition”.

I considered this: 
  
INPUT  
A CSV file contains the raw results of the competition (see ‘results.csv’ file in attachment).  
 
OUTPUT  
An XML with calculation results should be sent to an standard output stream. It should contain all the athletes in ascending order of their places. Athletes should have all the result data from the CSV file plus calculated total score and the place in the competition. In case of equal scores, athletes must share the places, e.g. 3-4 and 3-4 instead of 3 and 4.  
The rules for the point calculation can be found here: http://en.wikipedia.org/wiki/Decathlon (see formulas at the end of the page).  
 
TECHNICAL REQUIREMENTS  
1.	JDK 1.8 should be used  
2.	The program should not use any external libraries in addition to the Java standard API  
3.	The tests can use external libraries (Junit, Mockito, etc)  
4.	Your project should be build using Maven  
 
MY COMMENTS 
 
You must send in the program two parameters: input and output, in the input you need the path where you have csv file and output the path where you can find the file xml. 
 
Example 
 
mvn exec:java -Dexec.mainClass="com.kuehne_nagel.decathlon.Decathlon" -Dexec.args="C:\\eclipse\\personales\\decathlon\\ results.csv C:\\eclipse\\personales\\decathlon\\" 
 
The order to read the file is: 
 
name; 100 meters; Long jump; Shot put; High jump; 400 meters; 110 meters hurdles; Discus throw; Pole vault; Javelin throw; 1500 meters
