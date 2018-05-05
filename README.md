# 1A.CSCrush
Cs319 Section 1

Berk Ataç 21200623

Taner Düzceer 21300917 

Ahmet Akif Uğurtan 21400526 

Eren Aytüre 21200559


We will create a puzzle game called CS Crush. Game will be optimized for working on desktop systems. 
It will have similar gameplay as games such as Candy Crush, Bejeweled...
It will not be a exact copy of games similar to it. 
Game will be single player and aim of the game will be reaching a specific amount of points in order to reach next levels. 
Points will be collected by swapping objects and matching at least three of the same objects vertically or horizontally and making them crush. 
As player crushes objects new ones will fill their place from upwards.

https://king.com/tr/game/candycrush  

Installation the system and game

The CsCrush is developed in Java platform. It needs JRE7 (Java Runtime Environment). The minimum system requirements are 1.6 GHz processor and 2 GB ram. It is also needed the internet for signing up and logging in.
	The player can download it as jar file. After downloading, the player can run it.
XAMPP v3.2.2 must be installed to run database locally. Since we do not have any domain, we could not use a online database but a local database thanks to XAMPP. After installing XAMPP, you should open control panel of XAMPP and start Apache, MySQL and Tomcat. Then, you should press the admin button of MySQL to open phpmyadmin which is database management interface. Import the sql of our database (cscrush.sql) and display tables and entries via phpmyadmin. Now, the java application can connect the database on localhost thanks to JDBC library.

