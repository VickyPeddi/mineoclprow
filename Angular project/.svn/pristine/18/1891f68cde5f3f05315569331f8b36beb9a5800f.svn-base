import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormArray, FormControl, FormGroup, Validators } from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';
import * as $ from 'jquery';
import { MessageService } from 'primeng/api';
import { Observable } from 'rxjs';
import { AuthService } from 'src/app/auth/auth.service';
import { DataProviderService } from 'src/app/shared/data-provider.service';
import { environment } from 'src/environments/environment';

@Component({
	selector: 'app-activities-completion',
	templateUrl: './activities-completion.component.html',
	styleUrls: ['./activities-completion.component.css']
})
export class ActivitiesCompletionComponent implements OnInit, OnDestroy {


	backEndUrl: string = environment.backEndUrl;

	protected empCode: number;
	protected isSubmitted: boolean;
	protected list: any = {};
	protected activityMasterDatas: any = [];
	employeeDhruvaRODatas: string[];
	protected dhruvaActivityList: any = [];
	protected dhruvaActivityListFileUpload: any = [];
	currentRoCode: number;
	protected isKisanSevaKendra: boolean;
	protected isAttainer: boolean;
	protected isBrandedFuel: boolean;
	protected isSauKaSankalp: boolean;

	protected selectedFile: FileList;
	protected currentFileUpload: File;
	protected fileUploadList: Observable<string[]>;

	dhruvaActivitiesForm: FormGroup;
	protected dhruvaActivitiesArray: FormArray;

	buttonDisable: boolean = false;
	searchText: string;

	imageFormats: string[] = ['jpg', 'jpeg', 'gif', 'png', 'tiff'];
	isFormatInValid: boolean = true;

	private submittedActivityInputDatas: any = [];

	alreadyFilledROsMap = new Map<any, boolean>();

	constructor(private route: ActivatedRoute, private router: Router, protected http: HttpClient, protected title: Title, protected dataProviderService: DataProviderService,
		protected authService: AuthService, private messageService: MessageService) {
		this.isSubmitted = false;
		this.title.setTitle('Activities Completion - Dhruva 2.0');

	}

	ngOnInit() {
		this.route.queryParams.subscribe(params => {
			if (params.token && params.user) {
				this.authService.accessToken = params.token;
				this.authService.empCode = params.user;
				this.authService.isCOISLogin = true;
			}
		});


		this.fillMainPage();
		$(document).ready(function () {
			window.history.pushState(null, "", window.location.href);
			window.onpopstate = function () {
				window.history.pushState(null, "", window.location.href);
			};

		});
		this.onResetForm();
	}


	ngOnDestroy(): void {
	}

	fillMainPage() {
		this.alreadyFilledROsMap = new Map<any, boolean>();
		this.dataProviderService.loadROsWhereActivitiesHaveBeenSubmitted().subscribe(data => {
			data.forEach(ro => {
				this.alreadyFilledROsMap.set(ro, true);
			});
		})
		if (this.authService.employeeDhruvaRODatas)
			this.employeeDhruvaRODatas = this.authService.employeeDhruvaRODatas;
		else {
			this.messageService.add({ key: 'act', severity: 'warning', summary: '', detail: 'Pelase wait!!! Populating RO list' });
			this.dataProviderService.loadEmployeeDhruvaRODatas().subscribe(data => {
				this.authService.employeeDhruvaRODatas = data;
				this.employeeDhruvaRODatas = data;
			});
		}
	}

	//isBf: Branded Fuel
	//isAtt: Attainer
	//isSks: Sau ka Sankalp
	//isKsk: Kisan seva kendra
	loadDhruvaActivities(item: any, archetypeCode: string, isBf: boolean, isAtt: boolean, isSks: boolean, isKsk: boolean) {
		this.isSubmitted = false;

		this.dataProviderService.loadSubmittedActivityInputDatas(item.roCode).subscribe(data => {
			this.submittedActivityInputDatas = data;
		})

		this.http.get(`${environment.backEndUrl}/activity/activity-datas?arch=${archetypeCode}&bf=${isBf}&att=${isAtt}&sks=${isSks}&ksk=${isKsk}`)
			.subscribe(data => {
				this.dhruvaActivityList = data;

				this.dhruvaActivitiesArray = new FormArray([]);

				// if (this.submittedActivityInputDatas.length > 0) {
				const map = new Map<number, string>();
				this.submittedActivityInputDatas.forEach(activityData => {
					map.set(Number(activityData.embeddedkey.activityNo), activityData.value);
				});

				let submittedValue: string;
				for (const dhruvaActivity of this.dhruvaActivityList) {
					if (dhruvaActivity.entrytype === 'DROP') {
						submittedValue = map.get(Number(dhruvaActivity.activityNo));
						this.dhruvaActivitiesArray.push(new FormGroup({
							'activityNo': new FormControl(dhruvaActivity.activityNo),
							'activityName': new FormControl(dhruvaActivity.activityName),
							'selectedValue': new FormControl(submittedValue == undefined ? '' : submittedValue, Validators.required)
						}));
					}
				}

				// } else {
				//   for (const dhruvaActivity of this.dhruvaActivityList) {
				//     if (dhruvaActivity.entrytype === 'DROP') {
				//       this.dhruvaActivitiesArray.push(new FormGroup({
				//         'activityNo': new FormControl(dhruvaActivity.activityNo),
				//         'activityName': new FormControl(dhruvaActivity.activityName),
				//         'selectedValue': new FormControl('', Validators.required)
				//       }));
				//     }
				//   }
				// }


				this.dhruvaActivitiesForm = new FormGroup({
					'roCode': new FormControl(item.roCode),
					'roName': new FormControl(item.roName),
					'archetypeCode': new FormControl(item.archetypeCode),
					'archetypeName': new FormControl(item.archetypeName),
					'dhruvaActivities': this.dhruvaActivitiesArray
				});

				this.dhruvaActivityListFileUpload = [];

				this.dhruvaActivityList.forEach(dhruvaActivity => {
					if (dhruvaActivity.entrytype === 'DROPFILE') {
						this.dhruvaActivityListFileUpload.push(dhruvaActivity);
					}
				});
			});
	}

	selectRoCode(item: any) {
		this.currentRoCode = item.roCode;
		this.isKisanSevaKendra = item.priceGrp === '13' || item.priceGrp === '14' || item.priceGrp === '15' || item.priceGrp === '16';
		this.isBrandedFuel = item.brandedFuel === 'Y';
		this.isAttainer = item.attainer === 'Y';
		this.isSauKaSankalp = item.sauKaSankalp === 'Y';
		this.messageService.clear('act');
		this.loadDhruvaActivities(item, item.archetypeCode, this.isBrandedFuel, this.isAttainer, this.isSauKaSankalp, this.isKisanSevaKendra);
		this.fileUploadList = this.getActivityFileList(item.roCode);

	}

	get dhruvaActivitiesFormData() {
		return <FormArray>this.dhruvaActivitiesForm.get('dhruvaActivities');
	}

	onSaveActData() {

		this.buttonDisable = true;

		// console.log(JSON.stringify(this.dhruvaActivitiesForm.value));

		const httpOptions = {
			headers: new HttpHeaders({ 'Content-Type': 'application/json;charset=UTF-8' })
		};
		this.http.post(`${environment.backEndUrl}/activity/save-activities-input`, JSON.stringify(this.dhruvaActivitiesForm.value), httpOptions).subscribe(
			() => {
				this.messageService.add({ key: 'act', severity: 'success', summary: 'Success', detail: 'Successfully Saved' });
				this.buttonDisable = false;
				this.isSubmitted = true;
				this.fillMainPage();
				this.currentRoCode = this.dhruvaActivitiesForm.value.roCode;
			},
			error => {
				this.messageService.add({ key: 'act', severity: 'error', summary: 'Error occurred', detail: 'Error Occurred, please make sure that all fields are filled properly.' });
				this.buttonDisable = false;
			}
		);
	}

	onSelectFile(event: any) {
		this.selectedFile = event.target.files;
	}

	onUploadActivityFile(item: any) {

		if (this.selectedFile == undefined) {
			this.messageService.add({ key: 'act', severity: 'error', summary: 'Error occurred', detail: 'Please select a file!' });
			return false;
		}

		this.currentFileUpload = this.selectedFile.item(0);

		if (this.currentFileUpload == undefined) {
			this.messageService.add({ key: 'act', severity: 'error', summary: 'Error occurred', detail: 'Please select a file!' });
			return false;
		}

		this.isFormatInValid = true;

		for (var i = 0; i < this.imageFormats.length; i++) {
			if (this.currentFileUpload.name.split('.').pop().toUpperCase() === this.imageFormats[i].toUpperCase()) {
				this.isFormatInValid = false;
				break;
			}
		}

		if (this.isFormatInValid) {
			this.messageService.add({ key: 'act', severity: 'warn', summary: 'Fail!!!', detail: 'Please upload "image" files only' });
			this.selectedFile = undefined;
			return;
		}

		if (this.currentFileUpload.size > 2097152) {
			this.messageService.add({ key: 'act', severity: 'error', summary: 'Error occurred', detail: 'Please select file less than 2MB!' });
			this.selectedFile = undefined;
			return false;
		}

		const formdata: FormData = new FormData();
		formdata.append('file', this.currentFileUpload);
		formdata.append('activityCode', item.activityNo);
		formdata.append('roCode', String(this.currentRoCode));

		this.http.post(`${environment.backEndUrl}/activity/save-activities-file`, formdata).subscribe(
			() => {
				this.fileUploadList = this.getActivityFileList(this.currentRoCode);
				this.messageService.add({ key: 'act', severity: 'success', summary: 'Success', detail: 'File Uploaded Successfully' });
			},
			error => {
				this.messageService.add({ key: 'act', severity: 'error', summary: 'Error occurred', detail: error });
			});

		this.selectedFile = undefined;
	}

	getActivityFileList(roCode: number): Observable<any> {
		return this.http.get(`${environment.backEndUrl}/activity/activity-file-list/${roCode}`);
	}

	onResetForm() {
		this.dhruvaActivitiesForm = new FormGroup({
			'roCode': new FormControl(''),
			'roName': new FormControl(''),
			'archetypeCode': new FormControl(''),
			'archetypeName': new FormControl(''),
			'dhruvaActivities': new FormArray([])
		});
	}

}
