
call clean-package.bat

ren target\dhruva2api-1.0.0-SNAPSHOT.war dhruva2api.war
mkdir D:\Deployment\production\Dhruva2\%date%
copy target\dhruva2api.war D:\Deployment\production\Dhruva2\%date%


