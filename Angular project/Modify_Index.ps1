$str = Get-Content service-worker-version
$i = [System.Decimal]::Parse($str)
$i++

Set-Content service-worker-version $i
((Get-Content -path dist/dhruva2/ngsw.json -Raw) -replace '"configVersion": 1',-join('"configVersion": ',$i)) | Set-Content -Path dist/dhruva2/ngsw.json



cd dist
cd dhruva2
((Get-Content -path index.html -Raw) -replace 'href="/assets/','href="/dhruva2/assets/') | Set-Content -Path index.html

