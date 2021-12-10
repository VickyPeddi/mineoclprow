import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Observable } from 'rxjs';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-mis-sel-off-consolidate',
  templateUrl: './mis-sel-off-consolidate.component.html',
  styleUrls: ['./mis-sel-off-consolidate.component.css']
})
export class MisSelOffConsolidateComponent implements OnInit {

  @Input() soList: Observable<string[]>;
  @Input() doList: any;
  @Input() saList: any;
  @Input() buttonDisable: boolean;
  @Output() soChange = new EventEmitter();
  @Output() doChange = new EventEmitter();
  @Output() showReport = new EventEmitter();

  filterTypes: any[] = [
    { "type": "Consolidate", "value": "0" },
    { "type": "State Office Wise", "value": "1" },
    { "type": "Divisional Office Wise", "value": "2" },
    { "type": "Sales Area Wise", "value": "3" }
  ];

  misParametersInputForm: FormGroup;

  constructor() { }

  ngOnInit() {
    this.onResetForm();
  }

  onResetForm() {
    this.misParametersInputForm = new FormGroup({
      'salesOrg': new FormControl('0'),
      'salesOff': new FormControl('0'),
      'salesArea': new FormControl('0'),
      'filterType': new FormControl('0')
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
    // this.showReport = null;
  }

  ngOnDestroy(): void {
    this.soChange.unsubscribe();
    this.doChange.unsubscribe();
    this.showReport.unsubscribe();
  }

}
