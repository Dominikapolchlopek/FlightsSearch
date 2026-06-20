aby odpalić trzeba: 

1.pobrać node.js

2.wpisać w folderze do którego skopiowało się repo `npm install`

2.1 jeżeli błąd to npm error syscall spawn "C:\Windows\System32\cmd.exe" wpisać `$env:ComSpec="C:\Windows\System32\cmd.exe"`

2.2 jeżeli błąd to PSSecurity Exeption wpisać `Set-ExecutionPolicy RemoteSigned -Scope CurrentUser`

3. wpisać `npm run dev` i wejść na wyświetlonego linka http