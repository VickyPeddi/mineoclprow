import { Component, OnInit } from '@angular/core';
import { PapaParseResult, Papa } from 'ngx-papaparse';
import { MessageService } from 'primeng/api';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Title } from '@angular/platform-browser';
import { ApiResponse } from 'src/app/shared/model/api-response.model';
import { FormGroup, FormControl, FormArray, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { DataProviderService } from 'src/app/shared/data-provider.service';
import { PresentFutureDateValidator } from 'src/app/shared/validators/present-future-date.validator';
import { FromToDateMismatchValidator } from 'src/app/shared/validators/from-to-date-mismatch.validator';

@Component({
	selector: 'app-vendor-assign',
	templateUrl: './vendor-assign.component.html',
	styleUrls: ['./vendor-assign.component.css']
})
export class VendorAssignComponent implements OnInit {

	csvPayload: PapaParseResult;

	assetUrl: string;

	options = {
		delimiter: ',',
		header: true,
		// newline: '\\n',
		// dynamicTyping: true,
		skipEmptyLines: true
	}

	entryPointForm: FormGroup;
	retailOutletSelectForm: FormGroup;
	vendorAssignForm: FormGroup;
	soDOSAList: Observable<string[]>;
	doList: any;
	saList: any;
	isReportRequested: boolean = false;
	isWaiting: boolean = false;
	selectedRetailOutletList: number[] = [];
	isLoading: boolean;
	auditFinancialYears: string[] = [];

	selectMultipleFlag: boolean = false;

	submitted: boolean;
	buttonDisable: boolean;

	constructor(private title: Title, private messageService: MessageService, private papa: Papa, private http: HttpClient, private dataProviderService: DataProviderService) {
		this.title.setTitle('Vendor Assignment - Dhruva 2.0');
	}

	ngOnInit() {
		this.isWaiting = false;
		this.assetUrl = environment.assetUrl;
		this.onResetRetailOutletSelectForm();
		this.onResetEntryPointForm();
		this.onResetVendorAssignForm();
		this.populateAuditYears();
		this.soDOSAList = this.dataProviderService.loadSODOSAMaster();
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
				this.messageService.add({ key: 'vendor-assign-upload-status', severity: 'warn', summary: 'Failure!!!', detail: 'Please upload file in ".csv" format only' });
				input.files = undefined;
				return;
			}

			const fileToRead = files[0];

			const fileReader = new FileReader();
			this.messageService.add({ key: 'vendor-assign-upload-progress', severity: 'info', closable: false, summary: 'Please Wait!!!', detail: 'Processing Datas.' });
			fileReader.onload = this.onFileLoad;
			fileReader.readAsText(fileToRead, "UTF-8");
			await this.delay(500);

			// console.log("Result: ", this.papa.parse((fileReader.result as string), this.options));

			this.csvPayload = this.papa.parse((fileReader.result as string), this.options);

			// console.log(JSON.stringify(this.csvPayload.data));

			if (this.csvPayload.errors.length == 0) {

				const httpOptions = {
					headers: new HttpHeaders({ 'Content-Type': 'application/json;charset=UTF-8' })
				};
				this.http.post<ApiResponse>(`${environment.backEndUrl}/vendor/vendor-assign-details/upload`, JSON.stringify(this.csvPayload.data), httpOptions).subscribe(
					data => {
						if (data.success) {
							this.messageService.clear();
							this.messageService.add({ key: 'vendor-assign-upload-status', severity: 'success', summary: 'Success!!!', detail: data.message });
						} else {
							this.messageService.clear();
							this.messageService.add({ key: 'vendor-assign-upload-status', severity: 'error', summary: 'Failure!!!', detail: data.message });
						}
					},
					error => {
						this.messageService.clear();
						this.messageService.add({
							key: 'vendor-assign-upload-status', severity: 'warn', summary: 'Failure!!!', detail: 'Update Failed, Please check that uploaded file is in given format only, if system keeps on showing this error '
								+ 'then please contact administrator.'
						});
					}
				);
			} else {
				this.csvPayload.errors.forEach(errorMessage => {
					this.messageService.add({ key: 'vendor-assign-upload-status', severity: 'warn', summary: 'Failure!!!', detail: errorMessage.message + ' on row no ' + (errorMessage.row + 2) });
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

	onResetEntryPointForm() {
		this.entryPointForm = new FormGroup({
			'dataEntryPoint': new FormControl('option')
		})
	}

	onResetRetailOutletSelectForm() {
		this.retailOutletSelectForm = new FormGroup({
			'retailOutletDetails': new FormArray([])
		})
	}

	onResetVendorAssignForm() {
		this.vendorAssignForm = new FormGroup({
			'vendorCode': new FormControl('', [Validators.required, Validators.pattern('^[0-9]*$'), Validators.minLength(8)]),
			'vendorName': new FormControl({ value: '', disabled: true }, Validators.required),
			'auditType': new FormControl('', Validators.required),
			'auditYear': new FormControl('', Validators.required),
			'auditQuarter': new FormControl('', Validators.required),
			'startDate': new FormControl('', [Validators.required, PresentFutureDateValidator()]),
			'endDate': new FormControl('', [Validators.required, PresentFutureDateValidator()]),
			'roList': new FormControl('')
		})

		this.vendorAssignForm.setValidators(FromToDateMismatchValidator('startDate', 'endDate'));
	}

	onSelectSalesOrg(event: any) {

		if (event.target.value === "0") {
			this.doList = [];
			this.saList = [];
			return;
		}

		this.saList = [];
		this.soDOSAList.subscribe((data: any) => {

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
			return;
		}
		this.doList.forEach((doListArray: any) => {
			if (doListArray.salesoff === String(event.target.value)) {
				this.saList = doListArray.salesAreas;
			}
		});
	}

	onShowVendorAssignForm(event: any) {

		this.isWaiting = true;
		// console.log(JSON.stringify(event));

		this.dataProviderService.loadRetailOutletsForVendorAssignment(event.salesOrg, event.salesOff, event.salesArea,
			event.archetype, event.phase).subscribe(data => {

				let vendorAssignFormArray: FormArray = new FormArray([]);

				data.forEach(roData => {
					vendorAssignFormArray.push(new FormGroup({
						'isSelected': new FormControl(false),
						'roCode': new FormControl(roData.roCode),
						'roName': new FormControl({ value: roData.roName, disabled: true }),
						'archetype': new FormControl({ value: roData.archetypeName, disabled: true }),
						'phase': new FormControl({ value: roData.phase, disabled: true })
					}));
				});

				this.retailOutletSelectForm = new FormGroup({
					'retailOutletDetails': vendorAssignFormArray
				});

			}, error => {
				this.isWaiting = false;
				this.isReportRequested = true;
			}, () => {
				this.isWaiting = false;
				this.isReportRequested = true;
			});
	}

	get retailOutletSelectFormData(): FormArray {
		return <FormArray>this.retailOutletSelectForm.get('retailOutletDetails');
	}

	onSelectMultiple() {
		this.selectMultipleFlag = !this.selectMultipleFlag;

		this.retailOutletSelectFormData.controls.forEach(control => {
			control.get('isSelected').setValue(this.selectMultipleFlag);
		});
	}

	onSelectVendorAssignData() {
		// console.log(JSON.stringify(this.vendorAssignForm.value));
		this.selectedRetailOutletList = [];
		this.retailOutletSelectForm.value.retailOutletDetails.filter(retailOutlet => retailOutlet.isSelected).forEach(retailOutlet => {
			this.selectedRetailOutletList.push(retailOutlet.roCode);
		});

		console.log(this.selectedRetailOutletList);
	}

	get f() {
		return this.vendorAssignForm.controls;
	}

	populateVendorDetails(event: any) {
		if (event.target.value != undefined && event.target.value.length > 7) {
			this.isLoading = true;
			this.dataProviderService.loadVendorDetails(event.target.value).subscribe(
				data => {
					if (data != undefined) {
						this.vendorAssignForm.controls['vendorName'].setValue(data.vendorName + ', ' + data.city)
					} else {
						this.messageService.clear();
						this.messageService.add({ key: 'vendor-assign-option-status', severity: 'error', summary: 'Error occurred', detail: 'Vendor code is invalid.' });
					}
				},
				error => {
					this.vendorAssignForm.controls['vendorName'].setValue('');
				},
				() => { this.isLoading = false; }
			);
		} else {
			this.vendorAssignForm.controls['vendorName'].setValue('');
		}
	}

	populateAuditYears() {
		for (let year = new Date().getFullYear() - 1; year <= (new Date().getFullYear() + 1); year++) {
			this.auditFinancialYears.push(year + '-' + (year + 1));
		}
	}

	onSaveVendorAssignData() {

		this.vendorAssignForm.controls['roList'].setValue(this.selectedRetailOutletList);
		this.submitted = true;

		if (this.vendorAssignForm.value.roList.length == 0) {
			this.messageService.clear();
			this.messageService.add({ key: 'vendor-assign-option-status', severity: 'error', summary: 'Error occurred!', detail: 'Please select atleast one Retail outlet for audit!' });
			this.buttonDisable = false;
			return;
		}
		if (this.vendorAssignForm.invalid) {
			// this.messageService.clear();
			// this.messageService.add({ key: 'vendor-assign-option-status', severity: 'error', summary: 'Error occurred!', detail: 'Please fill in all the details before submitting!' });
			this.buttonDisable = false;
			return;
		}

		console.log(JSON.stringify(this.vendorAssignForm.value));

		this.buttonDisable = true;

		const httpOptions = {
			headers: new HttpHeaders({ 'Content-Type': 'application/json;charset=UTF-8' })
		};
		this.http.post<ApiResponse>(`${environment.backEndUrl}/vendor/vendor-assign-details/options`, JSON.stringify(this.vendorAssignForm.value), httpOptions).subscribe(
			data => {
				if (data.success) {
					this.messageService.clear();
					this.messageService.add({ key: 'vendor-assign-option-status', severity: 'success', summary: 'Success!!!', detail: data.message });
					this.buttonDisable = false;
					this.submitted = false;
				} else {
					this.messageService.clear();
					this.messageService.add({ key: 'vendor-assign-option-status', severity: 'error', summary: 'Failure!!!', detail: data.message });
					this.buttonDisable = false;
				}
			},
			error => {
				this.messageService.clear();
				this.messageService.add({
					key: 'vendor-assign-option-status', severity: 'error', summary: 'Failure!!!', detail: 'Update Failed, if system keeps on showing this error '
						+ 'then please contact administrator.'
				});
				this.buttonDisable = false;
			}
		);

	}

}
