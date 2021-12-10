import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Observable } from 'rxjs';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { DataProviderService } from 'src/app/shared/data-provider.service';
import { AuthService } from 'src/app/auth/auth.service';

@Component({
  selector: 'app-mis-sel-off-archetype-phase-index-param-site',
  templateUrl: './mis-sel-off-archetype-phase-index-param-site.component.html',
  styleUrls: ['./mis-sel-off-archetype-phase-index-param-site.component.css']
})
export class MisSelOffArchetypePhaseIndexParamSiteComponent implements OnInit {

  @Input() soList: Observable<string[]>;
  @Input() doList: any;
  @Input() saList: any;
  @Input() parametersList: any;
  @Input() buttonDisable: boolean;
  @Output() soChange = new EventEmitter();
  @Output() doChange = new EventEmitter();
  @Output() indexChange = new EventEmitter();
  @Output() showReport = new EventEmitter();

  misParametersInputForm: FormGroup;

  misArchetypes: string[];
  misPhases: string[];

  filterIndexes: any = [
    // { "type": "--Select--", "value": 0 },
    { "type": "Automation", "value": 1 },
    { "type": "Branded Fuels", "value": 2 },
    { "type": "FIT", "value": 3 },
    { "type": "Q & Q", "value": 4 },
    { "type": "Safety", "value": 5 },
    { "type": "SEVA", "value": 6 }
  ];

  filterSites: any = [
    { "type": "All", "value": 0 },
    { "type": "A Site", "value": 1 },
    { "type": "B Site", "value": 2 },
    { "type": "COCO", "value": 3 }
  ];

  constructor(private dataProviderService: DataProviderService, private authService: AuthService) { }

  ngOnInit() {
    this.onResetForm();
    this.dataProviderService.loadMISArchetypes().subscribe(data => this.misArchetypes = data);
    this.dataProviderService.loadMISPhases().subscribe(data => this.misPhases = data);
  }

  onResetForm() {
    this.misParametersInputForm = new FormGroup({
      'salesOrg': new FormControl('0'),
      'salesOff': new FormControl('0'),
      'salesArea': new FormControl('0'),
      'archetype': new FormControl('0'),
      'phase': new FormControl('0'),
      'index': new FormControl('', Validators.required),
      'parameter': new FormControl('0'),
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

  onSelectIndex(event: any) {

    this.indexChange.emit(event);
  }

  onRequestReport() {
    this.showReport.emit(this.misParametersInputForm.value);
  }

  ngOnDestroy(): void {
    this.soChange.unsubscribe();
    this.doChange.unsubscribe();
    this.indexChange.unsubscribe();
    this.showReport.unsubscribe();
  }

}
