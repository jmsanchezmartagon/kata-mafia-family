# kata-mafia-family
Just a Kata designed for some colleagues they want to have some training.

## Problem to solve:

Just imagine you're "The Punisher", the man who is fighting against the crime with no help from anybody! but you could get a file with info about the main mafia families from the Police Station (no ask how you did it)

But the thing is, the data isn't sorted, and the kind of info you have there is something like this:

```
Alphonse Grabriel;Capone;Scarface;Capone;Leader
Richard;Perotti;Richie Blue Eyes;Capone;Bad Ass
Michael J.;Spillane;Mickey;Westies;Leader
Igor;Gasparov;The Giant;Tambov gang;Sergeant
Vladimir;Kumarin;;Tambov gang;Leader
```  

There you can see how the info is sorted as follow:
 - Name
 - Last Name
 - Nick
 - Family
 - Level
 
 Levels can go from Leader/Counselor/Sergeant/Bad Ass. Assuming the next:
 - There is only one Leader per family, and two Counselors per leader
 - There are only two Counselors per family but they have in addition two Sergeants
 - But the Sergeants have their own gang of badasses
 - The badasses are shown in the file immediately after their Sergeant
 
 Punisher is interested then in having an application that allow to him to parse the info inside the stolen file, so that, he could have every single family sorted out by levels. That it could be pretty fancy because he could easily select new targets to punish
 
 Just from the initial file, generate a new file (one per family) a write there the info from the Leader to the Badasses. Please don't write just plain text, choose a structure that allow nesting (xml or json?) to make the task of reviewing the families as simple as we can
 
 ## Resources
Just go to the "to-punish/" folder, there you'll see the file with the info of people to punish

## Remember
Feel free of using your preferred programming language to code (java, kotlin, php, js...)
Feel free of using your preferred building tool to build (maven, gradle, ant...)
Feel free of using your preferred IDE (IntelliJ, Eclipse...)
BUT:
- Please try to go for the simplest solution
- Please provide any kind of tests to check your solution
- Bear in mind, a solution with a complexity greater than O(n^2) would be considered as poor (in fact from my point of view, even n^2 is too much) 
