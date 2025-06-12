Set-Location C:\Users\$env:username
new-item "Ejercicio" -Itemtype directory
set-location ejercicio
new-item "Imágenes" -Itemtype directory
new-item "Usuarios" -Itemtype directory
Set-Location Imágenes
new-item "Documentos" -ItemType directory
Set-Location Documentos
new-item "Backups" -ItemType directory
new-item "Borradores_TMP" -ItemType directory
new-item "Definitivos" -Itemtype directory
remove-item "Definitivos"
rename-item C:\Users\$env:username\ejercicio\Imágenes\Documentos\Borradores_TMP C:\Users\$env:username\ejercicio\Imágenes\Documentos\Borradores
set-location borradores
copy-item C:\Users\$env:username\ejercicio\Imágenes
copy-item C:\Users\$env:username\ejercicio\Imágenes\Documentos\Backups
Rename-Item C:\Users\$env:username\ejercicio\Imágenes\Documentos\borradores\Backups C:\Users\$env:username\ejercicio\Imágenes\Documentos\borradores\Descartados
rename-item C:\Users\$env:username\ejercicio\Imágenes\Documentos\borradores\Imágenes C:\Users\$env:username\ejercicio\Imágenes\Documentos\borradores\En_Proceso
Set-Location C:\Users\$env:username\ejercicio\Usuarios
new-item "Uno" -ItemType directory
new-item "Dos" -Itemtype directory
new-item "Tres" -ItemType directory
Set-Location C:\Users\$env:username
Remove-Item C:\Users\$env:username\Ejercicio\Usuarios\*s
Set-Location C:\Users\$env:username\ejercicio\Usuarios
Remove-Item Uno
new-item $env:username -ItemType directory
New-Item "Doc_Ejercicio.txt"
$fechaActual = Get-Date -Format "yyyy-MM-dd HH:mm:ss"
Add-Content "Doc_Ejercicio.txt" —Value $env:username,$fechaActual
Copy-item C:\Users\$env:username\ejercicio\usuarios\Doc_Ejercicio.txt C:\Users\$env:username\ejercicio\usuarios\Doc_Examen.txt
Copy-item C:\Users\$env:username\ejercicio\usuarios\Doc_Ejercicio.txt C:\Users\$env:username\ejercicio\usuarios\Definitivo.odt
Copy-item C:\Users\$env:username\ejercicio\usuarios\Doc_Ejercicio.txt C:\Users\$env:username\ejercicio\usuarios\Oficial.odt
Move-Item C:\Users\$env:username\ejercicio\usuarios\Doc_* C:\Users\$env:username\ejercicio\Imágenes\Documentos\Borradores\En_Proceso
Move-Item C:\Users\$env:username\ejercicio\usuarios\*.odt C:\Users\$env:username\Ejercicio\Imágenes\Documentos\Backups
Remove-Item C:\Users\$env:username\ejercicio\Imágenes\Documentos\Borradores\En_Proceso\?????x*
Set-Location C:\Users\$env:username
Set-ItemProperty -Path C:\users\$env:username\ejercicio\Imágenes\Documentos\Backups\* -Name IsReadOnly -Value $true