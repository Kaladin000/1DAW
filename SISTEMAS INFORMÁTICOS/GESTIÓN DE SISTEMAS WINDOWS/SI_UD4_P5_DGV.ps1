$Contraseña_Segura = ConvertTo-SecureString "SINF_123" -AsPlainText -Force

New-LocalUser AluDAW01 -Password $Contraseña_Segura
New-LocalUser AluSMR01 -Password $Contraseña_Segura
New-LocalUser AluASIR01 -Password $Contraseña_Segura
New-LocalUser Profe_DAW -Password $Contraseña_Segura
New-LocalUser Profe_SMR -Password $Contraseña_Segura
New-LocalUser Profe_ASIR -Password $Contraseña_Segura
New-LocalUser Jefe_de_estudios -Password $Contraseña_Segura

New-LocalGroup DAW
New-LocalGroup SMR
New-LocalGroup ASIR
New-LocalGroup Profesores
New-LocalGroup Alumnos

Add-LocalGroupMember -Group DAW -Member AluDAW01
Add-LocalGroupMember -Group DAW -Member Profe_DAW
Add-LocalGroupMember -Group SMR -Member AluSMR01
Add-LocalGroupMember -Group SMR -Member Profe_SMR
Add-LocalGroupMember -Group ASIR -Member AluASIR01
Add-LocalGroupMember -Group ASIR -Member Profe_ASIR
Add-LocalGroupMember -Group Alumnos -Member AluDAW01
Add-LocalGroupMember -Group Alumnos -Member AluSMR01
Add-LocalGroupMember -Group Alumnos -Member AluASIR01
Add-LocalGroupMember -Group Profesores -Member Profe_DAW
Add-LocalGroupMember -Group Profesores -Member Profe_SMR
Add-LocalGroupMember -Group Profesores -Member Profe_ASIR

Set-Location C:\
New-Item "Directorios" -itemType Directory
Set-Location C:\Directorios
New-Item "Alumnos" -itemType Directory
New-Item "Profesores" -itemType Directory