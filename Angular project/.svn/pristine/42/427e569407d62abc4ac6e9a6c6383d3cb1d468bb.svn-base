import { Component, OnInit, Input, Output, EventEmitter, OnDestroy } from '@angular/core';
import { Observable } from 'rxjs';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-mis-sel-off',
  templateUrl: './mis-sel-off.component.html',
  styleUrls: ['./mis-sel-off.component.css']
})
export class MisSelOffComponent implements OnInit, OnDestroy {

  @Input() soList: Observable<string[]>;
  @Input() doList: any;
  @Input() saList: any;
  @Input() buttonDisable: boolean;
  @Output() soChange = new EventEmitter();
  @Output() doChange = new EventEmitter();
  @Output() showReport = new EventEmitter();

  misParametersInputForm: FormGroup;

  constructor() { }

  ngOnInit() {
    this.onResetForm();
  }

  onResetForm() {
    this.misParametersInputForm = new FormGroup({
      'salesOrg': new FormControl('0'),
      'salesOff': new FormControl('0'),
      'salesArea': new FormControl('0')
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
    // this.saList = [];
    // this.list.subscribe((data: any) => {

    //   // slow as compared to forEach
    //   // for (const key in data) {
    //   //   if (data[key].salesOrg === String(event.target.value)) {
    //   //     this.doList = data[key].salesOffs;
    //   //     break;
    //   //   }
    //   // }

    //   // much faster irrespective of break
    //   data.forEach(
    //     (soList: any) => {
    //       if (soList.salesOrg === String(event.target.value)) {
    //         this.doList = soList.salesOffs;
    //       }
    //     });
    // });
  }

  onSelectSalesOff(event: any) {

    this.doChange.emit(event);

    if (event.target.value === "0") {
      this.misParametersInputForm.controls['salesArea'].setValue('0');
      this.saList = [];
      return;
    }
    this.misParametersInputForm.controls['salesArea'].setValue('0');
    // this.doList.forEach((doListArray: any) => {
    //   if (doListArray.salesoff === String(event.target.value)) {
    //     this.saList = doListArray.salesAreas;
    //   }
    // });
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
