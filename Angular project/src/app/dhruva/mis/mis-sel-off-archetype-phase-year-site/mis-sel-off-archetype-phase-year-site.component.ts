import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Observable } from 'rxjs';
import { FormGroup, FormControl } from '@angular/forms';
import { DataProviderService } from 'src/app/shared/data-provider.service';
import { AuthService } from 'src/app/auth/auth.service';

@Component({
  selector: 'app-mis-sel-off-archetype-phase-year-site',
  templateUrl: './mis-sel-off-archetype-phase-year-site.component.html',
  styleUrls: ['./mis-sel-off-archetype-phase-year-site.component.css']
})
export class MisSelOffArchetypePhaseYearSiteComponent implements OnInit {

	@Input() soList: Observable<string[]>;
	@Input() doList: any;
	@Input() saList: any;
	@Input() buttonDisable: boolean;
	@Output() soChange = new EventEmitter();
	@Output() doChange = new EventEmitter();
	@Output() showReport = new EventEmitter();

	misParametersInputForm: FormGroup;

	misArchetypes: string[];
	misPhases: string[];

	filterSites: any = [
		{ "type": "All", "value": 0 },
		{ "type": "A Site", "value": 1 },
		{ "type": "B Site", "value": 2 },
		{ "type": "COCO", "value": 3 }
	];

	misFinancialYears: string[] = [];

	constructor(private dataProviderService: DataProviderService) { }

	ngOnInit() {
		this.onResetForm();
		this.populateFinancialYears();
		this.dataProviderService.loadMISArchetypes().subscribe(data => this.misArchetypes = data);
		this.dataProviderService.loadMISPhases().subscribe(data => this.misPhases = data);
	}

	populateFinancialYears() {
		for (let year = 2018; year <= (new Date().getMonth() > 2 ? new Date().getFullYear() : new Date().getFullYear() - 1); year++) {
			this.misFinancialYears.push(year + '-' + (year + 1));
		}
	}

	onResetForm() {
		this.misParametersInputForm = new FormGroup({
			'salesOrg': new FormControl('0'),
			'salesOff': new FormControl('0'),
			'salesArea': new FormControl('0'),
			'archetype': new FormControl('0'),
			'phase': new FormControl('0'),
			'financialYear': new FormControl('2018-2019'),
			'filterSite': new FormControl('1')
		});
	}

	onSelectSalesOrg(event: any) {

		this.soChange.emit(event);

		if (event.target.value === "0") {
			this.misParametersInputForm.controls['salesOff'].setValue('0');
			this.misParametersInputForm.controls['salesArea'].setValue('0');
			this.doList = [];
			this.saList = [];
			return;
		}
		this.misParametersInputForm.controls['salesOff'].setValue('0');
		this.misParametersInputForm.controls['salesArea'].setValue('0');
	}

	onSelectSalesOff(event: any) {

		this.doChange.emit(event);

		if (event.target.value === "0") {
			this.misParametersInputForm.controls['salesArea'].setValue('0');
			this.saList = [];
			return;
		}
		this.misParametersInputForm.controls['salesArea'].setValue('0');
	}

	onRequestReport() {
		this.showReport.emit(this.misParametersInputForm.value);
	}

	ngOnDestroy(): void {
		this.soChange.unsubscribe();
		this.doChange.unsubscribe();
		this.showReport.unsubscribe();
	}
}
