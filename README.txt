Welcome to the NWERC Hockey Leauge 2005!


STARTING THE GAME
-----------------

The program you can use to run hockey games is the Hockey Development
Environment (HDE).

Start by changing to the directory in which this README file resides.
You can start the HDE by running:

	java -jar hockey.jar

For compatibility, these classes are compiled with Java 1.4.0.  During
the actual contest, we plan to use the Java 1.5.* compiler and JVM.



MAKING YOUR OWN TEAMS
---------------------

If you want to write your own team, you can start from the template in
the teamTemplate directory.  The interfaces and classes that you will
extend and interact with reside in the jar file, so you can compile
with:

	javac -classpath .:hockey.jar teamTemplate/*.java

(or ".;hockey.jar" on windows platform)

For documentation on how to write your teams, see the API
documentation, which resides in the docs directory:

	docs/index.html

To add your team to the HDE, you must update the file "teamlist",
residing in this directory.  In this file there should be three lines
for every team:
- A line giving the name of the class for the team.
- A line giving the name of the team.
- A blank line.

Three blank lines in the teamlist file gives rise to a "separator" in
the list of teams in the HDE.



QUESTIONS, BUGS, ETC
--------------------

Feel free to send questions, bug reports, etc to
nwerc-hockey@nada.kth.se!


