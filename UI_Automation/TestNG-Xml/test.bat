set projectpath=D:\LW 4.0 Selenium Automation\BBNT Project\BBNT
echo %projectpath%
set classpath=%projectpath%\bin;%projectpath%\lib\*
echo %classpath%
java org.testng.TestNG testng.xml
pause