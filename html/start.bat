@ECHO OFF

:install
  call npm install
GOTO run

:run
  call node %~dp0/server.js
GOTO end

:end
