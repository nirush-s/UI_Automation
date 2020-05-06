set projectpath=D:\LW 4.0 Selenium Automation\Odessa Projects\BBNT Project\BBNT
cd\
D:
cd D:\LW 4.0 Selenium Automation\Odessa Projects\BBNT Project\BBNT
echo %projectpath%
set classpath=%projectpath%\bin;%projectpath%\lib\*
echo %classpath%
java org.testng.TestNG Create_Asset.xml
pause
