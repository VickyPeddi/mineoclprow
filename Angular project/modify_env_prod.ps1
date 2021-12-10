cd src/environments
((Get-Content -path environment.prod.ts -Raw) -replace 'uat.indianoil','spandan.indianoil') | Set-Content -Path environment.prod.ts