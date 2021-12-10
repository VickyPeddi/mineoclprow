

cd dist
rmdir /S /Q dhruva2
ren dhruva2-ng7-app dhruva2
cd..
copy .htaccess dist\dhruva2
powershell -File Modify_Index.ps1
mkdir D:\d\Deployment\production\dhruva2-ng\%date%\dhruva2
xcopy /E dist\dhruva2 D:\d\Deployment\uat\dhruva2-ng\%date%\dhruva2
pause