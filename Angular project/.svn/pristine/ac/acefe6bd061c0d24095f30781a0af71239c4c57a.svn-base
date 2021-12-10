import { Component, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';
import { Papa, PapaParseResult } from 'ngx-papaparse';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { ApiResponse } from 'src/app/shared/model/api-response.model';
import { Title } from '@angular/platform-browser';

@Component({
	selector: 'app-ca-training',
	templateUrl: './ca-training.component.html',
	styleUrls: ['./ca-training.component.css']
})
export class CaTrainingComponent implements OnInit {

	csvPayload: PapaParseResult;

	assetUrl: string;

	options = {
		delimiter: ',',
		header: true,
		// newline: '\\n',
		// dynamicTyping: true,
		skipEmptyLines: true
	}

	constructor(private messageService: MessageService, private papa: Papa, private http: HttpClient, private title: Title) {
		this.title.setTitle('CA Training - Dhruva 2.0');
	}

	ngOnInit() {
		this.assetUrl = environment.assetUrl;
	}

	async onFileSelect(input: HTMLInputElement) {
		const files = input.files;
		if (files && files.length) {

			// console.log("Filename: " + files[0].name);
			// console.log("Type: " + files[0].type);
			// console.log("Size: " + files[0].size + " bytes");
			if (files[0].size > 20971520) {
				if (!confirm("File size is exceeding 20 MB, your browser may freeze, Want to continue?"))
					return;
			}
			if (files[0].name.split('.').pop() !== 'csv') {
				this.messageService.add({ key: 'ca-upload-status', severity: 'warn', summary: 'Failure!!!', detail: 'Please upload file in ".csv" format only' });
				input.files = undefined;
				return;
			}

			const fileToRead = files[0];

			const fileReader = new FileReader();
			this.messageService.add({ key: 'ca-upload-progress', severity: 'info', closable: false, summary: 'Please Wait!!!', detail: 'Processing Datas.' });
			fileReader.onload = this.onFileLoad;
			fileReader.readAsText(fileToRead, "UTF-8");
			await this.delay(500);

			// console.log("Result: ", this.papa.parse((fileReader.result as string), this.options));

			this.csvPayload = this.papa.parse((fileReader.result as string), this.options);

			if (this.csvPayload.errors.length == 0) {

				const httpOptions = {
					headers: new HttpHeaders({ 'Content-Type': 'application/json;charset=UTF-8' })
				};
				this.http.post<ApiResponse>(`${environment.backEndUrl}/ca-training/save`, JSON.stringify(this.csvPayload.data), httpOptions).subscribe(
					data => {
						if (data.success) {
							this.messageService.clear();
							this.messageService.add({ key: 'ca-upload-status', severity: 'success', summary: 'Success!!!', detail: data.message });
						} else {
							this.messageService.clear();
							this.messageService.add({ key: 'ca-upload-status', severity: 'error', summary: 'Failure!!!', detail: data.message });
						}
					},
					error => {
						this.messageService.clear();
						this.messageService.add({
							key: 'ca-upload-status', severity: 'warn', summary: 'Failure!!!', detail: 'Update Failed, Please check that uploaded file is in given format only, if system keeps on showing this error '
								+ 'then please contact administrator.'
						});
					}
				);

			} else {
				this.csvPayload.errors.forEach(errorMessage => {
					this.messageService.add({ key: 'ca-upload-status', severity: 'warn', summary: 'Failure!!!', detail: errorMessage.message + ' on row no ' + (errorMessage.row + 2) });
				});
			}

			//   const lines = (fileReader.result as string).split('\n');
			//   // lines.forEach((element: string) => {
			//   //   const cols: string[] = element.split(csvSeparator);
			//   //   csv.push(cols);
			//   // });
			//   // parsedCsv = csv;

			//   var result = [];
			//   var headers = lines[0].split(",");
			//   for (var i = 1; i < lines.length; i++) {
			//     if (lines[i] != '') {

			//       var obj = {};
			//       var currentline = lines[i].split(",");

			//       if (headers.length == currentline.length) {
			//         // console.log('On row ' + (i));
			//         for (var j = 0; j < headers.length; j++) {
			//           // obj[headers[j].toLowerCase().replace('"', '').replace('"', '')] = currentline[j].replace('"', '').replace('"', '');
			//           obj[headers[j]] = currentline[j];
			//         }
			//       } else {
			//         console.log('Please fill missing data on row ' + (i));
			//       }
			//       result.push(obj);
			//     } else {
			//       // alert('found blank line...')
			//     }
			//   }
			//   console.log(JSON.stringify(result));

			//   // console.log("Result:", this.papa.parse((fileReader.result as string), this.options));
		}
	}

	onFileLoad(fileLoadedEvent) {

		const csvSeparator = ',';
		let parsedCsv: string[][];
		const textFromFileLoaded = fileLoadedEvent.target.result;
		// console.log(this.csvContent);

		// alert(this.csvContent);
		const txt = textFromFileLoaded;
		// const csv = [];


		// console.log(result);

		// console.log(JSON.stringify(result)); //JSON
		// this.jsonContent = JSON.stringify(result);
		return;
		// console.log(parsedCsv);

		// this.papa.parse(this.csvContent, {
		//   complete: result => console.log(result)
		// });
	}

	delay(ms: number) {
		return new Promise(resolve => setTimeout(resolve, ms));
	}

}
