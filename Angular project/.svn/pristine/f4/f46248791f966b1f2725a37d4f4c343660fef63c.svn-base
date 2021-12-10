import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormArray, FormControl, FormGroup, Validators } from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';
import Dexie from 'dexie';
import { MessageService } from 'primeng/api';
import { Observable } from 'rxjs';
import { AuthService } from 'src/app/auth/auth.service';
import { NetworkStatusService } from 'src/app/shared/network-status.service';
import { environment } from '../../../environments/environment';
import * as moment from 'moment';

@Component({
	selector: 'app-telecall-cadence',
	templateUrl: './telecall-cadence.component.html',
	styleUrls: ['./telecall-cadence.component.css']
})
export class TelecallCadenceComponent implements OnInit {

	private db: any;

	protected empCode: number;

	telecallCadenceForm: FormGroup;
	protected salesOffFormArray: FormArray;

	salesOrgOptions: Observable<string[]>;
	protected salesOffOptions: any = [];

	isSalesOffFormVisible: boolean = false;
	buttonDisable: boolean = false;

	yesNoOptions: any[] = [
		{ "option": "Yes", "value": "Y" },
		{ "option": "No", "value": "N" }
	];

	constructor(protected title: Title, protected authService: AuthService, protected route: Router, protected http: HttpClient,
		protected networkStatus: NetworkStatusService, private messageService: MessageService) {
		this.title.setTitle('Telecall Cadence Index - Dhruva 2.0');
	}

	ngOnInit() {
		this.salesOrgOptions = this.loadSalesOrgOptions();
		this.onResetForm();
		this.createDatabase();
	}

	private createDatabase() {
		this.db = new Dexie('dhruva2-telcad');
		this.db.version(1).stores({
			telcad: '++id, data'
		})
	}

	onResetForm() {
		this.telecallCadenceForm = new FormGroup({
			'salesOrg': new FormControl('', Validators.required),
			// 'salesoff': new FormControl(''),
			'sdcPresent': new FormControl('', Validators.required),
			'srhPresent': new FormControl('', Validators.required),
			'telecallDate': new FormControl('', Validators.required),
			'salesOffDetails': new FormArray([])
		})
	}

	//to be combined into one array containing SO and it's DO
	//done...
	loadSalesOrgOptions(): Observable<any> {
		return this.http.get(`${environment.backEndUrl}/telecall/so-list`);
	}

	loadSalesOffForm(salesOrg: string) {

		this.salesOrgOptions.subscribe(data => {
			data.forEach((singleData: any) => {
				if (singleData.salesOrg === salesOrg) {

					this.salesOffFormArray = new FormArray([]);

					singleData.salesOffs.forEach(salesOff => {

						this.salesOffFormArray.push(
							new FormGroup({
								'salesOff': new FormControl(salesOff.salesoff, Validators.required),
								'salesOffName': new FormControl(salesOff.salesOffName, Validators.required),
								'doManager': new FormControl('', Validators.required),
								'drsm': new FormControl('', Validators.required)
							})
						);
					});
					this.telecallCadenceForm.removeControl('salesOffDetails');
					this.telecallCadenceForm.addControl('salesOffDetails', this.salesOffFormArray);

					this.isSalesOffFormVisible = true;
					return;
				}
			});
		});

		// this.http.get(`${environment.backEndUrl}/telecall/do-list/${salesOrg}`).subscribe(data => {
		//   this.salesOffOptions = data;

		//   this.salesOffFormArray = new FormArray([]);

		//   for (const salesOffOption of this.salesOffOptions) {

		//     this.salesOffFormArray.push(
		//       new FormGroup({
		//         'salesOff': new FormControl(salesOffOption.salesoff, Validators.required),
		//         'salesOffName': new FormControl(salesOffOption.salesOffName, Validators.required),
		//         'doManager': new FormControl('', Validators.required),
		//         'drsm': new FormControl('', Validators.required)
		//       })
		//     );
		//   }

		//   this.telecallCadenceForm.removeControl('salesOffDetails');
		//   this.telecallCadenceForm.addControl('salesOffDetails', this.salesOffFormArray);

		//   this.isSalesOffFormVisible = true;

		// });
	}

	onSelectSalesOrg(event: any) {
		if (event.target.value.length > 0) {
			this.loadSalesOffForm(event.target.value);
		}
	}

	validateDate(event: any) {
		// if (event.target.value) {
		//   let remain: number = moment().diff(moment(event.target.value, 'YYYY-MM-DD'), 'months');
		//   if (remain > 1) {
		//     this.messageService.add({ key: 'tele', severity: 'error', summary: 'Error occurred', detail: 'Date cannot be older than two month' });
		//     this.telecallCadenceForm.controls['telecallDate'].setValue('');
		//     return;
		//   }
		//   remain = moment(event.target.value, 'YYYY-MM-DD').diff(moment(), 'hours');
		//   if (remain > 0) {
		//     this.messageService.add({ key: 'tele', severity: 'error', summary: 'Error occurred', detail: 'Date cannot be Future Date' });
		//     this.telecallCadenceForm.controls['telecallDate'].setValue('');
		//     return;
		//   }
		// }
	}

	onSavetelecallCadenceForm() {
		this.buttonDisable = true;

		// console.log(JSON.stringify(this.telecallCadenceForm.value));

		if (this.telecallCadenceForm.valid) {

			if (this.networkStatus.isOnline) {
				const httpOptions = {
					headers: new HttpHeaders({ 'Content-Type': 'application/json;charset=UTF-8' })
				};

				this.http.post(`${environment.backEndUrl}/telecall/save-telecall-index`, JSON.stringify(this.telecallCadenceForm.value), httpOptions)
					.subscribe(data => {
						this.messageService.add({ key: 'tele', severity: 'success', summary: 'Success', detail: 'Successfully Saved' });
						this.buttonDisable = false;
					}, error => {
						this.messageService.add({ key: 'tele', severity: 'error', summary: 'Error occurred', detail: error });
						this.buttonDisable = false;
					});
			} else {
				this.db.telcad.put({ data: JSON.stringify(this.telecallCadenceForm.value) }).then(async () => {
					console.log('saved in DB');
					this.buttonDisable = false;
				}).catch(error => {
					console.log('Error: ' + (error.stack || error));
					this.buttonDisable = false;
				});
			}
		} else {
			this.messageService.add({ key: 'tele', severity: 'error', summary: 'Error occurred', detail: 'Please fill in all the details before submitting' });
			this.buttonDisable = false;
		}
	}
}
