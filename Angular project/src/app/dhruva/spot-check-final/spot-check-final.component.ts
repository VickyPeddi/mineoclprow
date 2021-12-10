import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormArray, FormControl, FormGroup, Validators } from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { Router, ActivatedRoute } from '@angular/router';
import Dexie from 'dexie';
import * as $ from 'jquery';
import { MessageService } from 'primeng/api';
import { AuthService } from 'src/app/auth/auth.service';
import { DataProviderService } from 'src/app/shared/data-provider.service';
import { NetworkStatusService } from 'src/app/shared/network-status.service';
import { environment } from 'src/environments/environment';

@Component({
	selector: 'app-spot-check-final',
	templateUrl: './spot-check-final.component.html',
	styleUrls: ['./spot-check-final.component.css']
})
export class SpotCheckFinalComponent implements OnInit {


	private db: any;

	employeeDhruvaRODatas: string[];
	currentRoCode: number;
	currentRoName: string;
	currentSiteType: string;
	currentArchetypeCode: any;
	spotCheckModuleNumbers: number[];
	spotCheckApplicableQuestions: any;
	isBrandedFuel: boolean;
	submitButtonEnableInstruction: string;

	spotCheckForm: FormGroup;
	spotCheckPoints: FormArray;

	buttonDisable: boolean = false;
	searchText: string;

	constructor(private route: ActivatedRoute, protected title: Title, protected router: Router, protected http: HttpClient, private authService: AuthService,
		private networkStatus: NetworkStatusService, private dataProviderService: DataProviderService, private messageService: MessageService) {

		this.title.setTitle('Spot Check - Dhruva 2.0');
	}

	ngOnInit() {

		this.route.queryParams.subscribe(params => {
			if (params.token && params.user) {
				this.authService.accessToken = params.token;
				this.authService.empCode = params.user;
				this.authService.isCOISLogin = true;
			}
		});


		if (!this.authService.archetypeWiseSpotCheckModuleNumbers) {
			this.dataProviderService.loadSpotCheckModules().subscribe(
				data => { this.authService.archetypeWiseSpotCheckModuleNumbers = data }
			);
		}
		if (!this.authService.spotcheckQuestions) {
			this.dataProviderService.loadSpotCheckQuestions().subscribe(
				data => { this.authService.spotcheckQuestions = data }
			);
		}
		if (this.authService.employeeDhruvaRODatas)
			this.employeeDhruvaRODatas = this.authService.employeeDhruvaRODatas;
		else {
			this.dataProviderService.loadEmployeeDhruvaRODatas().subscribe(data => {
				this.authService.employeeDhruvaRODatas = data;
				this.employeeDhruvaRODatas = data;
			});
		}
		// this.authService.spotcheckQuestions = this.authService.spotcheckQuestions;
		$(document).ready(function () {
			window.history.pushState(null, "", window.location.href);
			window.onpopstate = function () {
				window.history.pushState(null, "", window.location.href);
			};
		});

		this.createDatabase();
		this.onResetForm();
	}

	onResetForm() {
		this.spotCheckForm = new FormGroup({
			'roCode': new FormControl(''),
			'spotCheckPoints': new FormArray([])
		});
	}

	createDatabase() {
		this.db = new Dexie('dhruva2-spotcheck');
		this.db.version(1).stores({
			spotcheck: '++id, data'
		})
	}

	allocateResponsible(siteType: string, questionMaster: any): string {
		if (siteType == 'A') {
			return questionMaster.resASite;
		} else if (siteType == 'B') {
			return questionMaster.resBSite;
		} else if (siteType == 'COCO') {
			return questionMaster.resCOCOAdHoc;
		}
	}

	selectRoCode(event: any, item: any) {

		this.spotCheckApplicableQuestions = [];
		this.isBrandedFuel = item.brandedFuel == 'Y';
		this.currentRoCode = item.roCode;
		this.currentRoName = item.roName;
		this.currentSiteType = item.site;
		this.currentArchetypeCode = item.archetypeCode;

		this.dataProviderService.checkSpotCheckEligibility().subscribe(
			data => {
				this.submitButtonEnableInstruction = data.message;
			},
			error => {
				console.error(error);
			},
			() => { }
		);

		this.authService.archetypeWiseSpotCheckModuleNumbers.forEach(archetypeWiseSpotCheckModuleNumber => {
			if (archetypeWiseSpotCheckModuleNumber.archetype == this.currentArchetypeCode) {

				this.spotCheckModuleNumbers = archetypeWiseSpotCheckModuleNumber.modules;
			}
		});

		this.spotCheckModuleNumbers.forEach(spotCheckModuleNumber => {
			this.authService.spotcheckQuestions.forEach(spotcheckQuestion => {
				if (spotCheckModuleNumber == 4) {
					if (this.isBrandedFuel) {
						if (spotcheckQuestion.id.parentModuleId == spotCheckModuleNumber) {
							this.spotCheckApplicableQuestions.push(spotcheckQuestion);
						}
					}
				} else {
					if (spotcheckQuestion.id.parentModuleId == spotCheckModuleNumber) {
						this.spotCheckApplicableQuestions.push(spotcheckQuestion);
					}
				}
			});
		});

		this.spotCheckPoints = new FormArray([]);
		for (const point of this.spotCheckApplicableQuestions) {
			this.spotCheckPoints.push(new FormGroup({
				'spotCheckPointNo': new FormControl(point.id.questionNo),
				'spotCheckPointModuleNo': new FormControl(point.id.parentModuleId),
				'spotCheckPoint': new FormControl({ value: point.text, disabled: true }),
				'spotCheckPointValue': new FormControl('', point.inputType == 'DROP' ? Validators.required : null),
				'spotCheckPointInputType': new FormControl({ value: point.inputType, disabled: true }),
				'spotCheckPointOptions': new FormControl({ value: point.dropDownValues, disabled: true }),
				'spotCheckPointResponsible': new FormControl(this.allocateResponsible(this.currentSiteType, point))
			}));
		}

		this.spotCheckForm = new FormGroup({
			'roCode': new FormControl(this.currentRoCode),
			'user': new FormControl(''),
			'spotCheckPoints': this.spotCheckPoints
		});

	}

	onSubmitForm() {
		// console.log(JSON.stringify(this.spotCheckForm.value));
		this.buttonDisable = true;

		if (this.spotCheckForm.valid) {

			if (this.networkStatus.isOnline) {

				const httpOptions = {
					headers: new HttpHeaders({ 'Content-Type': 'application/json;charset=UTF-8' })
				};

				this.http.post(`${environment.backEndUrl}/spot-check/spot-check-datas`, JSON.stringify(this.spotCheckForm.value), httpOptions).subscribe(
					data => {
						this.messageService.add({ key: 'spot-entry', severity: 'success', summary: 'Success', detail: 'Successfully Saved' });
					}, error => {
						this.messageService.add({ key: 'spot-entry', severity: 'error', summary: 'Error occurred', detail: 'Update failed, please make sure that same RO was not inspected by you within last 7 days!!' });
						this.buttonDisable = false;
					},
					() => {
						this.buttonDisable = false;
					}
				);
			} else {
				this.spotCheckForm.controls['user'].setValue(this.authService.empCode);
				this.db.spotcheck.put({ data: JSON.stringify(this.spotCheckForm.value) }).then(async () => {
					this.messageService.add({ key: 'spot-entry', severity: 'success', summary: 'Success', detail: 'Data has been saved offline, When you get internet connection, Please press "SYNC" button, available at the top right corner' });
				}).catch(error => {
					console.log((error.stack || error));
					this.messageService.add({ key: 'spot-entry', severity: 'error', summary: 'Error occurred', detail: (error.stack || error) });
				});
			}
			this.router.navigate(['/home/spot-check-final']);
		} else {
			this.messageService.add({ key: 'spot-entry', severity: 'error', summary: 'Error occurred', detail: 'Please fill in all the details before submitting' });
			this.buttonDisable = false;
		}
		// this.spotCheckForm.reset();
	}

	get spotCheckFormData() {
		return <FormArray>this.spotCheckForm.get('spotCheckPoints');
	}

	onSpotCheckDataSync() {
		let wasAnyDataInDb: boolean = false;
		if (this.networkStatus.isOnline) {
			this.db.spotcheck.each(data => {
				this.syncSpotCheckData(data);
				wasAnyDataInDb = true;
			}).then(() => {
				if (wasAnyDataInDb) {
					this.showSyncToast(true);
				} else {
					this.showSyncToast(false);
				}
			}).catch(error => {
				this.messageService.add({ key: 'spot', severity: 'error', summary: 'Error occurred', detail: error });
			});
		} else {
			this.messageService.add({ key: 'spot', severity: 'error', summary: 'Failure', detail: 'You are still offline' });
		}
	}
	showSyncToast(isSuccess: boolean): any {
		if (isSuccess)
			this.messageService.add({ key: 'spot', severity: 'success', summary: 'Success', detail: 'Sychronisation Successful' });
		else
			this.messageService.add({ key: 'spot', severity: 'error', summary: 'Failure', detail: 'No saved data found on this device' });
	}

	syncSpotCheckData(data: any) {
		const httpOptions = {
			headers: new HttpHeaders({ 'Content-Type': 'application/json;charset=UTF-8' })
		};

		this.http.post(`${environment.backEndUrl}/spot-check/spot-check-datas`, data.data, httpOptions)
			.subscribe(msg => {
				this.db.spotcheck.delete(data.id).then((deleteCount) => {
					// console.log("Deleted " + deleteCount + " objects")
				});
			});
	}


}
