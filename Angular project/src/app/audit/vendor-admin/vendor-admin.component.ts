import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { DataProviderService } from 'src/app/shared/data-provider.service';
import { AuthService } from 'src/app/auth/auth.service';
import { MessageService } from 'primeng/api';
import { VendorDetails } from 'src/app/shared/model/vendor-details.model';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { PresentFutureDateValidator } from 'src/app/shared/validators/present-future-date.validator';
import { FromToDateCompareValidator } from 'src/app/shared/validators/from-to-date-compare.validator';
import { ApiResponse } from 'src/app/shared/model/api-response.model';

@Component({
  selector: 'app-vendor-admin',
  templateUrl: './vendor-admin.component.html',
  styleUrls: ['./vendor-admin.component.css']
})
export class VendorAdminComponent implements OnInit {

  vendorInfoForm: FormGroup;

  buttonDisable: boolean = false;
  submitted: boolean = false;
  isLoading: boolean = false;
  currentVendorDetails: VendorDetails;

  constructor(protected http: HttpClient, protected title: Title, protected dataProviderService: DataProviderService,
    protected authService: AuthService, private messageService: MessageService) {

    this.title.setTitle('Vendor Administration - Dhruva 2.0');
  }

  ngOnInit() {
    this.onResetForm();
  }

  get f() {
    return this.vendorInfoForm.controls;
  }

  populateVendorDetails(event: any) {
    if (event.target.value != undefined && event.target.value.length > 7) {
      this.isLoading = true;
      this.dataProviderService.loadVendorDetails(event.target.value).subscribe(
        data => {
          if (data != undefined) {
            this.currentVendorDetails = data
            this.vendorInfoForm.controls['vendorName'].setValue(data.vendorName)
            this.vendorInfoForm.controls['vendorAddress'].setValue(data.addressLine1 + data.addressLine2 + data.addressLine3 + data.city);
          } else {
            this.messageService.clear();
            this.messageService.add({ key: 'vendor-admin', severity: 'error', summary: 'Error occurred', detail: 'Vendor code is invalid.' });
          }
        },
        error => {
          this.vendorInfoForm.controls['vendorName'].setValue('');
          this.vendorInfoForm.controls['vendorAddress'].setValue('');
          this.currentVendorDetails = null;
        },
        () => { this.isLoading = false; }
      );
    } else {
      this.vendorInfoForm.controls['vendorName'].setValue('');
      this.vendorInfoForm.controls['vendorAddress'].setValue('');
      this.currentVendorDetails = null;
    }
  }

  onSaveVendorData() {
    this.submitted = true;
    if (this.vendorInfoForm.invalid) {
      this.messageService.clear();
      this.messageService.add({ key: 'vendor-admin', severity: 'error', summary: 'Error occurred', detail: 'Please fill in all the details before submitting' });
      this.buttonDisable = false;
      return;
    }

    this.buttonDisable = true;

    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json;charset=UTF-8' })
    };

    this.http.post<ApiResponse>(`${environment.backEndUrl}/vendor/vendor-admin-details`, JSON.stringify(this.vendorInfoForm.value), httpOptions).subscribe(
      data => {
        if (data.success) {
          this.messageService.clear();
          this.messageService.add({ key: 'vendor-admin', severity: 'success', summary: 'Success', detail: data.message });
          this.buttonDisable = false;
          this.submitted = false;
          this.vendorInfoForm.reset();
        } else {
          this.messageService.clear();
          this.messageService.add({ key: 'vendor-admin', severity: 'error', summary: 'Failure!!!', detail: data.message });
          this.buttonDisable = false;
        }
      },
      error => {
        this.messageService.add({ key: 'vendor-admin', severity: 'error', summary: 'Error occurred', detail: 'Error Occurred, please make sure that all fields are filled properly.' });
        this.buttonDisable = false;
      }
    );

    // console.log(JSON.stringify(this.vendorInfoForm.value));
  }

  onResetForm() {
    this.vendorInfoForm = new FormGroup({
      'vendorCode': new FormControl('', [Validators.required, Validators.pattern('^[0-9]*$'), Validators.minLength(8)]),
      'vendorName': new FormControl('', Validators.required),
      'vendorAddress': new FormControl('', Validators.required),
      'vendorWorkOrder': new FormControl('', Validators.required),
      'vendorValidFrom': new FormControl('', [Validators.required, PresentFutureDateValidator()]),
      'vendorValidTo': new FormControl('', [Validators.required, PresentFutureDateValidator()]),
      'vendorAdminName': new FormControl('', Validators.required),
      'vendorAdminEmail': new FormControl('', [Validators.required, Validators.email]),
      'vendorAdminCell': new FormControl('', [Validators.required, Validators.pattern('^[0-9]*$'), Validators.minLength(10), Validators.maxLength(10)])
    });

    this.vendorInfoForm.setValidators(FromToDateCompareValidator('vendorValidFrom', 'vendorValidTo'));
  }

}
//^[0][1-9]\d{9}$|^[1-9]\d{9}$
//