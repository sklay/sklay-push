 @echo off
 
 set clspath=.\templates;.\config.properties;.\types.properties;
 setlocal enabledelayedexpansion
 for %%j in (.\lib\*.jar) do (
 set clspath=!clspath!;%%j
 )

echo classpath is %clspath% 

java -cp %clspath% com.tool.frame.SelectFrame

endlocal