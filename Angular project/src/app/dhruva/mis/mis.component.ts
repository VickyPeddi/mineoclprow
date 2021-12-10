import { HttpClient } from '@angular/common/http';
import { Component, OnChanges, OnDestroy, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Observable, Subject } from 'rxjs';
import { AuthService } from 'src/app/auth/auth.service';
import { DataExportService } from 'src/app/shared/data-export.service';
import { DataProviderService } from 'src/app/shared/data-provider.service';

@Component({
	selector: 'app-mis',
	templateUrl: './mis.component.html',
	styleUrls: ['./mis.component.css']
})
export class MisComponent implements OnInit, OnChanges, OnDestroy {

	reportDetails: Observable<string>;
	reportId: number;
	reportName: string;
	reportType: number;
	reportMessage: string;
	searchText: string;
	message: string;
	soDOSAList: Observable<string[]>;
	doList: any;
	saList: any;
	parameterValues: any = [];
	parameterList: any;
	isReportRequested: boolean = false;
	isReportExported: boolean = false;
	isWaiting: boolean = false;

	// misParametersInputForm: FormGroup;

	misReportValues: Observable<any>;
	misReportValuesShow: any = [
		{ "reportHeaders": null, "reportDatas": null, "valid": true }
	];

	dtOptions: DataTables.Settings = {};
	trigger = new Subject();

	constructor(protected http: HttpClient, protected title: Title, protected dataProviderService: DataProviderService,
		protected router: Router, private route: ActivatedRoute, protected authService: AuthService, private dataExportService: DataExportService) { }

	ngOnInit() {

		this.dtOptions = {
			autoWidth: false,
			lengthMenu: [5, 10, 25, 50],
			pagingType: 'full_numbers',
			pageLength: 5,
			dom: 'fltpi'
		};

		this.route.params.subscribe(
			(params: Params) => {
				this.reportDetails = this.dataProviderService.loadMISReport(params['id']);

				this.reportDetails.subscribe((data: any) => {
					this.title.setTitle(`MIS for ${data.repName} - Dhruva 2.0`);
					this.reportId = data.repId;
					this.reportName = data.repName;
					this.reportType = data.reportType;
					this.reportMessage = data.reportMessage;
					this.misReportValues = null;
					this.misReportValuesShow = [{ "reportHeaders": null, "reportDatas": null, "valid": true }];
					this.isReportRequested = false;
				})
			});
		// this.onResetForm();
		this.soDOSAList = this.dataProviderService.loadSODOSAMaster();
		this.dataProviderService.loadMISParameters().subscribe(data => this.parameterValues = data);
	}

	ngOnChanges(changes: import("@angular/core").SimpleChanges): void {
		console.log('called..............');
	}

	// onResetForm() {
	//   this.misParametersInputForm = new FormGroup({
	//     'salesOrg': new FormControl('0'),
	//     'salesOff': new FormControl('0'),
	//     'salesArea': new FormControl('0')
	//   });
	// }

	onShowReport(event: any) {

		this.isWaiting = true;
		// console.log(JSON.stringify(this.misParametersInputForm.value));

		this.misReportValues = this.dataProviderService.loadMISReportValues(this.reportId, event.salesOrg, event.salesOff, event.salesArea,
			this.reportType, event.fromDate, event.toDate, event.filterType, event.archetype, event.phase, event.filterSite, event.financialYear,
			event.financialQuarter, event.index, event.parameter);

		this.misReportValues.subscribe(
			data => {
				if (data.reportDatas != null && (data.reportDatas.length > 10000 || this.reportId === 41)) {
					this.isReportExported = true;
					this.misReportValuesShow = data;
					this.exportAsXLSX();
				} else {
					this.isReportExported = false;
					this.misReportValuesShow = data;
				}
			},
			error => {
				this.isWaiting = false;
			},
			() => {
				if (this.misReportValuesShow.reportDatas && this.misReportValuesShow.reportDatas.length <= 10000) {
					this.trigger.next();
				}
				this.isWaiting = false;
				this.isReportRequested = true;
			});
	}

	onSelectSalesOrg(event: any) {

		if (event.target.value === "0") {
			this.doList = [];
			this.saList = [];
			// this.misParametersInputForm.controls['salesOff'].setValue('0');
			// this.misParametersInputForm.controls['salesArea'].setValue('0');
			return;
		}
		// this.misParametersInputForm.controls['salesOff'].setValue('0');
		// this.misParametersInputForm.controls['salesArea'].setValue('0');
		this.saList = [];
		this.soDOSAList.subscribe((data: any) => {

			// slow as compared to forEach
			// for (const key in data) {
			//   if (data[key].salesOrg === String(event.target.value)) {
			//     this.doList = data[key].salesOffs;
			//     break;
			//   }
			// }

			// much faster irrespective of break
			data.forEach(
				(soList: any) => {
					if (soList.salesOrg === String(event.target.value)) {
						this.doList = soList.salesOffs;
					}
				});
		});
	}

	onSelectSalesOff(event: any) {

		if (event.target.value === "0") {
			this.saList = [];
			// this.misParametersInputForm.controls['salesArea'].setValue('0');
			return;
		}
		// this.misParametersInputForm.controls['salesArea'].setValue('0');
		this.doList.forEach((doListArray: any) => {
			if (doListArray.salesoff === String(event.target.value)) {
				this.saList = doListArray.salesAreas;
			}
		});
	}

	onSelectIndex(event: any) {
		console.log(event.target.value);

		this.parameterList = this.parameterValues.filter(parameter => parameter.embeddedId.indexId == event.target.value);
		console.log(this.parameterList);

	}	

	exportAsXLSX(): void {

		// this.misReportValues.subscribe((data: any) => {
		//   let array: any = [...[data.reportHeaders], ...data.reportDatas];
		//   this.dataExportService.exportAsExcelFile(array, this.reportName);
		// });
		// this.misReportValues.subscribe((data: any) => {
		let array: any = [...[this.misReportValuesShow.reportHeaders], ...this.misReportValuesShow.reportDatas];
		this.dataExportService.exportAsExcelFile(array, this.reportName);
		this.isReportExported = true;
		// });
	}

	ngOnDestroy(): void {
		this.trigger.unsubscribe();
	}
}
