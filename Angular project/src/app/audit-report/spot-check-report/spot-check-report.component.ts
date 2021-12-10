import { Component, OnInit } from '@angular/core';
import { DataProviderService } from 'src/app/shared/data-provider.service';
import { MessageService } from 'primeng/api';
import { Title } from '@angular/platform-browser';

@Component({
	selector: 'app-spot-check-report',
	templateUrl: './spot-check-report.component.html',
	styleUrls: ['./spot-check-report.component.css']
})
export class SpotCheckReportComponent implements OnInit {

	public submittedSpotCheckRos: any = [];
	public buttonDisable: boolean;
	public isWaiting: boolean;
	public isReportRequested: boolean = false;
	fetchedDetails: boolean = false;
	fromDate: string;
	toDate: string;// Both are binded in html.

	constructor(private title: Title, private dataProviderService: DataProviderService, private messageService: MessageService) {
		this.title.setTitle('Spot Check Audit Reports - Dhruva 2.0');
	}

	ngOnInit() {
	}

	fetchSpotCheckDetails() {
		if (this.fromDate == '' || this.toDate == '' || this.fromDate == undefined || this.toDate == undefined) {
			this.messageService.add({ key: 'spot-report', severity: 'error', summary: 'Error occurred', detail: 'From-date and to-date are mandatory' });
			return;
		}

		this.isReportRequested = true;
		this.buttonDisable = true;
		this.isWaiting = true;
		this.dataProviderService.loadSubmittedSpotChecks(this.fromDate, this.toDate).subscribe(
			data => {
				this.submittedSpotCheckRos = data;
				// if (this.submittedSpotCheckRos.length == 0) {
				// 	this.messageService.add({ key: 'spot-report', severity: 'error', summary: 'Error occurred', detail: 'There does not exist any Retail Outlet in your selected criteria where Spot-Check was conducted.' });
				// }
			},
			error => { },
			() => {
				this.buttonDisable = false;
				this.isWaiting = false;
			});
	}

	generatePdf(inspNo: number) {
		this.messageService.add({ key: 'spot-report', severity: 'warn', summary: 'Attention', detail: 'Please wait, Report Generation may take time!!!' });
		// alert('Please wait, Report Generation may take time!!!');
		this.dataProviderService.getSpotCheckReportPdf(inspNo).subscribe(
			(response) => {
				let file = new Blob([response], { type: 'application/pdf' });
				var fileURL = URL.createObjectURL(file);
				window.open(fileURL);
			});
	}

}
