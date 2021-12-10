import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Observable } from 'rxjs';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-mis-sel-off-date-range',
  templateUrl: './mis-sel-off-date-range.component.html',
  styleUrls: ['./mis-sel-off-date-range.component.css']
})
export class MisSelOffDateRangeComponent implements OnInit {

  @Input() soList: Observable<string[]>;
  @Input() doList: any;
  // @Input() saList: any;
  @Input() buttonDisable: boolean;
  @Output() soChange = new EventEmitter();
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
      'fromDate': new FormControl('', Validators.required),
      'toDate': new FormControl('', Validators.required)
    });
  }

  onSelectSalesOrg(event: any) {

    this.soChange.emit(event);

    if (event.target.value === "0") {
      this.misParametersInputForm.controls['salesOff'].setValue('0');
      this.doList = [];
      return;
    }
    this.misParametersInputForm.controls['salesOff'].setValue('0');
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


  onRequestReport() {
    this.showReport.emit(this.misParametersInputForm.value);
    // this.showReport = null;
  }

  ngOnDestroy(): void {
    this.soChange.unsubscribe();
    this.showReport.unsubscribe();
  }

}
