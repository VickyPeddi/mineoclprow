import { Component, OnInit } from '@angular/core';
import { PapaParseResult, Papa } from 'ngx-papaparse';
import { MessageService } from 'primeng/api';
import { Title } from '@angular/platform-browser';
import { environment } from 'src/environments/environment';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { ApiResponse } from 'src/app/shared/model/api-response.model';

@Component({
	selector: 'app-dsa-summary',
	templateUrl: './dsa-summary.component.html',
	styleUrls: ['./dsa-summary.component.css']
})
export class DsaSummaryComponent implements OnInit {

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
		this.title.setTitle('DSA Summary - Dhruva 2.0');
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
				this.messageService.add({ key: 'dsa-upload-status', severity: 'warn', summary: 'Failure!!!', detail: 'Please upload file in ".csv" format only' });
				input.files = undefined;
				return;
			}

			const fileToRead = files[0];

			const fileReader = new FileReader();
			this.messageService.add({ key: 'dsa-upload-progress', severity: 'info', closable: false, summary: 'Please Wait!!!', detail: 'Processing Datas.' });
			fileReader.onload = this.onFileLoad;
			fileReader.readAsText(fileToRead, "UTF-8");
			await this.delay(500);

			// console.log("Result: ", this.papa.parse((fileReader.result as string), this.options));

			this.csvPayload = this.papa.parse((fileReader.result as string), this.options);

			if (this.csvPayload.errors.length == 0) {

				const httpOptions = {
					headers: new HttpHeaders({ 'Content-Type': 'application/json;charset=UTF-8' })
				};
				this.http.post<ApiResponse>(`${environment.backEndUrl}/dsa-summary/data`, JSON.stringify(this.csvPayload.data), httpOptions).subscribe(
					data => {
						if (data.success) {
							this.messageService.clear();
							this.messageService.add({ key: 'dsa-upload-status', severity: 'success', summary: 'Success!!!', detail: data.message });
						} else {
							this.messageService.clear();
							this.messageService.add({ key: 'dsa-upload-status', severity: 'error', summary: 'Failure!!!', detail: data.message });
						}
					},
					error => {
						this.messageService.clear();
						this.messageService.add({ key: 'dsa-upload-status', severity: 'error', summary: 'Failure!!!', detail: error });
					}
				);

			} else {
				this.csvPayload.errors.forEach(errorMessage => {
					this.messageService.add({ key: 'dsa-upload-status', severity: 'warn', summary: 'Failure!!!', detail: errorMessage.message + ' on row no ' + (errorMessage.row + 2) });
				});
			}
		}
	}

	onFileLoad(fileLoadedEvent) {

		const csvSeparator = ',';
		let parsedCsv: string[][];
		const textFromFileLoaded = fileLoadedEvent.target.result;

		const txt = textFromFileLoaded;

		return;
	}

	delay(ms: number) {
		return new Promise(resolve => setTimeout(resolve, ms));
	}
}
