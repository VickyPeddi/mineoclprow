import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { DataProviderService } from 'src/app/shared/data-provider.service';
import { VendorPersonnel } from 'src/app/shared/model/vendor-manage.model';
import { MessageService } from 'primeng/api';

@Component({
	selector: 'app-vendor-manage',
	templateUrl: './vendor-manage.component.html',
	styleUrls: ['./vendor-manage.component.css']
})
export class VendorManageComponent implements OnInit {

	vendorManageForm: FormGroup;
	isPersonnelRequested: boolean = false;
	isWaiting: boolean = false;
	buttonDisable: boolean = false;

	vendorPersonnelDatas: VendorPersonnel[] = null;

	personnelTypeOptions: any[] = [
		{ "option": "All", "value": 0 },
		{ "option": "Vendor Administrator", "value": 1 },
		{ "option": "Auditor", "value": 2 },
		{ "option": "Reviewer", "value": 3 }
	];

	constructor(private title: Title, private dataProviderService: DataProviderService, private messageService: MessageService) {
		this.title.setTitle('Vendor Management - Dhruva 2.0');
	}

	ngOnInit() {
		this.onResetForm();
	}

	onRequestPersonnel() {
		this.buttonDisable = true;
		this.isWaiting = true;
		this.isPersonnelRequested = true;
		this.dataProviderService.loadVendorPersonnelDatas(this.vendorManageForm.value.personnelType).subscribe(
			data => {
				this.vendorPersonnelDatas = data;
			},
			error => { },
			() => {
				this.isWaiting = false;
				this.buttonDisable = false;
			});
	}

	onVendorRowAction(vendorCode: string, initialState: string) {

		this.dataProviderService.togglePersonnelState(vendorCode, initialState).subscribe(
			data => {
				if (data.success) {
					this.messageService.clear();
					this.messageService.add({ key: 'vendor-manage', severity: 'success', summary: 'Success!!!', detail: data.message });
				} else {
					this.messageService.clear();
					this.messageService.add({ key: 'vendor-manage', severity: 'error', summary: 'Failure!!!', detail: data.message });
				}
			},
			error => {
				this.messageService.clear();
				this.messageService.add({
					key: 'vendor-manage', severity: 'warn', summary: 'Failure!!!', detail: '\n Update Failed, if system keeps on showing this error '
						+ 'then please contact administrator.'
				});
			},
			() => { this.onRequestPersonnel() })
	}

	onResetForm() {
		this.vendorManageForm = new FormGroup({
			'personnelType': new FormControl('0')
		});
	}

}
