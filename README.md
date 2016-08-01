# Setup / Information:

-	IDE used is Eclipse.
-	Download GitHub software for desktop.
-	Get code from GitHub URL as mention below [https://github.com/umarib/aspose-services] 
-	Right click on “Package explorer of eclipse” Import 
-	Select “Existing Projects into WorkSpace”
-	Click “Next” then Browse path from workspace (where you download code from gitHub) and import step completed.
-	Then right click on project then click “Build path” and add JDK 1.7 as default.
-	Right click on Project and then go to “Maven” do “Update Project” Check “Force Update“ then click ok.
-	Click on Main Menu -> Project Press “Clean”.
-	Right click on Project and Run as “Maven Build”.
-	War will copied in “<outputDirectory>E:/AsposeTest/</outputDirectory>” check in your pom.xml file.
-	Simply open Tomcat 7 or above and replace that war file in “webApp” folder and go to bin directory run startup.bat.
-	When server starts access this URL in your browser Plz Use FireFox for better result.
[http://localhost:8080/aspose-services/index.jsp] 

-	1st section will take txt file from User by pressing “Choose File”. And Convert Button will convert that file too docx. Which you can check on path E:\AsposeTest
-	Second and 3rd section will give you functionality to Add Protection on document. Protection is given in dropdown. Select one and by pressing Submit button you will get download option. Download it in specific directory.
-	Open it and view your file with new Protection Type.