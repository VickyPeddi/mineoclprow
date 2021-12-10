cd src/environments
((Get-Content -path environment.prod.ts -Raw) -replace 'spandan.indianoil','uat.indianoil') | Set-Content -Path environment.prod.ts