import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Observable } from 'rxjs';
import { AuthService } from 'src/app/auth/auth.service';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FormGroup, FormControl, FormArray, Validators, FormBuilder } from '@angular/forms';
import { DataProviderService } from 'src/app/shared/data-provider.service';
import { environment } from '../../../environments/environment';
import * as moment from 'moment';
import { MessageService } from 'primeng/api';
import * as $ from 'jquery';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-atr-rca',
  templateUrl: './atr-rca.component.html',
  styleUrls: ['./atr-rca.component.css']
})
export class AtrRcaComponent implements OnInit {

  protected empCode: number;

  currentRoCode: number;
  currentPart: number;

  employeeDhruvaRODatasRCAFiltered: string[];
  protected rootCauses: Observable<string[]>;

  protected dhruvaRootCauseAnalysisForm: FormGroup;

  protected isRootCauseOther1: boolean = false;
  protected isRootCauseIssueOther1: boolean = false;
  protected isRootCauseIssueSupportOther1: boolean = false;
  protected isSupportStatusOther: boolean = false;

  protected rootCauseIssues1: Observable<string[]>;
  protected rootCauseIssueSupportOptions1: Observable<string[]>;

  submittedRootCauseDatas: string[] = [];
  alreadyFilledROsMap = new Map<any, Map<number, boolean>>();
  buttonDisable: boolean = false;
  searchText: string;

  //All drop down values must be prsent in type master table also. 
  //Or else report will come wrong. wanted to make completely db driven 
  //but frequent custom requirements made us do it static.
  protected yesNoOptions: any[] = [
    { "option": "Yes", "value": "551" },
    { "option": "No", "value": "552" }
  ];
  // protected rootCauseRanks: any[] = [
  //   { "rootCauseRank": "One", "value": "501" },
  //   { "rootCauseRank": "Two", "value": "502" },
  //   { "rootCauseRank": "Three", "value": "503" },
  //   { "rootCauseRank": "Four", "value": "504" },
  //   { "rootCauseRank": "Five", "value": "505" }
  // ];
  protected workScopeOptions: any[] = [
    { "workScope": "IOC", "value": "553" },
    { "workScope": "Dealer", "value": "554" }
  ];
  protected approvalStatusOptions: any[] = [
    { "approvalStatus": "Complete", "value": "555" },
    { "approvalStatus": "Incomplete", "value": "556" }
  ];
  protected pendingWithOptions: any[] = [
    { "pendingWith": "DO", "value": "557" },
    { "pendingWith": "SO", "value": "558" },
    { "pendingWith": "FO", "value": "564" },
    { "pendingWith": "Dealer", "value": "565" }
  ];
  protected workStatusOptions: any[] = [
    { "workStatus": "Complete", "value": "559" },
    // { "workStatus": "WIP", "value": "560" },
    { "workStatus": "Pending", "value": "560" },
    // { "workStatus": "Others", "value": "567" }
  ];
  protected supportStatusOptions: any[] = [
    { "supportStatus": "Action Completed", "value": "561" },
    { "supportStatus": "Action Started", "value": "562" },
    { "supportStatus": "Not yet Started", "value": "563" },
    { "supportStatus": "Others", "value": "999" }
  ];


  constructor(protected title: Title, protected authService: AuthService, protected route: Router, protected http: HttpClient,
    private dataProviderService: DataProviderService, private messageService: MessageService) {
    this.title.setTitle('ATR on RCA (100 ka Sankalp) - Dhruva 2.0');

  }

  fillMainPage() {
    if(this.authService.employeeDhruvaRODatas){
      this.employeeDhruvaRODatasRCAFiltered =  this.authService.employeeDhruvaRODatas.filter((value: any) => {
        if (value.attainer == 'Y' || value.sauKaSankalp == 'Y')
          return true;
      });
    }else{
      this.dataProviderService.loadRcaROs().subscribe(data=>{
        this.employeeDhruvaRODatasRCAFiltered = data;
       });
    }
    let temp: Map<number, boolean>;
    this.alreadyFilledROsMap = new Map<number, Map<number, boolean>>();
    this.dataProviderService.loadROsAndAttributesWhereRCAHaveBeenSubmitted().subscribe(data => {
      data.forEach(roAndPart => {
        if (this.alreadyFilledROsMap.get(roAndPart.roCode) != undefined && this.alreadyFilledROsMap.get(roAndPart.roCode) != undefined) {
          temp = this.alreadyFilledROsMap.get(roAndPart.roCode);
          temp.set(roAndPart.rootCauseSrNo, true);
          this.alreadyFilledROsMap.set(roAndPart.roCode, temp);
        } else {
          temp = new Map<number, boolean>();
          temp.set(roAndPart.rootCauseSrNo, true);
          this.alreadyFilledROsMap.set(roAndPart.roCode, temp);
        }
      });
    });
  }

  ngOnInit() {
    this.fillMainPage();

    $(document).ready(function () {
      window.history.pushState(null, "", window.location.href);
      window.onpopstate = function () {
        window.history.pushState(null, "", window.location.href);
      };
    });
    this.onResetForm();
  }

  onResetForm() {
    this.dhruvaRootCauseAnalysisForm = new FormGroup({
      // 'roCode': new FormControl({ value: '', disabled: false }),
      'part': new FormControl(''),
      'roCode': new FormControl(''),
      'roName': new FormControl(''),
      'archetypeName': new FormControl(''),
      'attainer': new FormControl(''),
      'sauKaSankalp': new FormControl(''),
      // 'rootCauseRank': new FormControl(''),
      'rootCauseSrNo': new FormControl(''),
      'rootCause1': new FormControl(''),
      'rootCauseOther1': new FormControl(''),
      'rootCauseIssue1': new FormControl(''),
      'rootCauseIssueOther1': new FormControl(''),
      'rootCauseIssueSupport1': new FormControl(''),
      'rootCauseIssueSupportOther1': new FormControl(''),
      'workScope': new FormControl(''),
      'targetSupportStart': new FormControl(''),
      'targetSupportEnd': new FormControl(''),
      'actualSupportStart': new FormControl(''),
      'actualSupportEnd': new FormControl(''),
      'approvalStatus': new FormControl(''),
      'pendingWith': new FormControl(''),
      'lastVisit': new FormControl(''),
      'supportStatus': new FormControl(''),
      'supportStatusOther': new FormControl(''),
      'comments': new FormControl(''),
      'lastVisitDays': new FormControl(''),
      'workStatus': new FormControl('560'),//by default, work status is 'Pending'
      'daysDelay': new FormControl(''),
      'reconstitution': new FormControl('')
    });


  }

  loadDhruvaRORootCauses(item: any, part: number) {



    this.isRootCauseOther1 = false;
    this.isRootCauseIssueOther1 = false;
    this.isRootCauseIssueSupportOther1 = false;

    this.submittedRootCauseDatas = [];

    this.dataProviderService.loadSubmittedRootCauseDatas(item.roCode, part).subscribe(data => {
      this.submittedRootCauseDatas = data;
    });

    this.rootCauses = this.dataProviderService.loadRootCausesData();

    this.dhruvaRootCauseAnalysisForm = new FormGroup({
      'part': new FormControl(part),
      'roCode': new FormControl(item.roCode),
      'roName': new FormControl(item.roName),
      'archetypeName': new FormControl(item.archetypeName),
      'attainer': new FormControl({ value: '551', disabled: true }),
      'sauKaSankalp': new FormControl({ value: '551', disabled: true }),
      // 'rootCauseRank': new FormControl(''),
      'rootCauseSrNo': new FormControl(part),
      'rootCause1': new FormControl(''),
      'rootCauseOther1': new FormControl(''),
      'rootCauseIssue1': new FormControl(''),
      'rootCauseIssueOther1': new FormControl(''),
      'rootCauseIssueSupport1': new FormControl(''),
      'rootCauseIssueSupportOther1': new FormControl(''),
      'workScope': new FormControl(''),
      'targetSupportStart': new FormControl(''),
      'targetSupportEnd': new FormControl(''),
      'actualSupportStart': new FormControl(''),
      'actualSupportEnd': new FormControl(''),
      'approvalStatus': new FormControl(''),
      'pendingWith': new FormControl(''),
      'lastVisit': new FormControl(''),
      'supportStatus': new FormControl(''),
      'supportStatusOther': new FormControl(''),
      'comments': new FormControl(''),
      'lastVisitDays': new FormControl(''),
      'workStatus': new FormControl('560'),//by default, work status is 'Pending'
      'daysDelay': new FormControl(''),
      'reconstitution': new FormControl('')
    });
  }

  onSelectRORootCause(item: any, part: number) {
    this.currentRoCode = item.roCode;
    this.currentPart = part;
    this.loadDhruvaRORootCauses(item, part);
  }

  onSelectRootCause1(event: any) {
    if (event.target.value.length > 0) {
      if (event.target.value === "99") {
        this.isRootCauseOther1 = true;
      } else {
        this.isRootCauseOther1 = false;
      }
      this.dhruvaRootCauseAnalysisForm.controls['rootCauseIssue1'].setValue('');
      this.dhruvaRootCauseAnalysisForm.controls['rootCauseIssueSupport1'].setValue('');
      this.rootCauseIssues1 = this.dataProviderService.loadRootCauseIssuesData(Number(event.target.value));
    }
  }

  onSelectRootCauseIssue1(event: any) {
    if (event.target.value.length > 0) {
      if (event.target.options[event.target.options.selectedIndex].text === "Others") {
        this.isRootCauseIssueOther1 = true;
      } else {
        this.isRootCauseIssueOther1 = false;
      }
      this.dhruvaRootCauseAnalysisForm.controls['rootCauseIssueSupport1'].setValue('');
      this.rootCauseIssueSupportOptions1 = this.dataProviderService.loadRootCauseIssueSupportOptions(Number(event.target.value));
    }
  }

  onSelectRootCauseIssueSupport1(event: any) {
    if (event.target.value.length > 0) {
      if (event.target.options[event.target.options.selectedIndex].text === "Others") {
        this.isRootCauseIssueSupportOther1 = true;
      } else {
        this.isRootCauseIssueSupportOther1 = false;
      }
    }
  }

  onSelectSupportStatus(event: any) {
    if (event.target.value.length > 0) {
      if (event.target.value === "999") {
        this.isSupportStatusOther = true;
      } else {
        this.isSupportStatusOther = false;
      }
    }
  }

  calculateLastVisitDays(event: any) {
    let remainDays = moment().diff(moment(event.target.value, 'YYYY-MM-DD'), 'days');
    if (remainDays < 0) {
      alert('Cannot be future date (Last Visit)!!!');
      this.dhruvaRootCauseAnalysisForm.controls['lastVisitDays'].setValue('');
      this.dhruvaRootCauseAnalysisForm.controls['lastVisit'].setValue('');
    } else {
      this.dhruvaRootCauseAnalysisForm.controls['lastVisitDays'].setValue(remainDays);
    }
  }

  calculateDelayDays(event: any) {
    let remainDays = moment().diff(moment(event.target.value, 'YYYY-MM-DD'), 'days');
    this.dhruvaRootCauseAnalysisForm.controls['daysDelay'].setValue(remainDays);
    // if (remainDays < 0) {
    //   // alert('Cannot be future date (Target Support End Date)!!!');
    //   // this.dhruvaRootCauseAnalysisForm.controls['daysDelay'].setValue('');
    // } else {
    // }
  }

  computeWorkStatus(event: any) {
    if (event.target.value.length > 0) {
      this.dhruvaRootCauseAnalysisForm.controls['workStatus'].setValue(559);
    } else {
      this.dhruvaRootCauseAnalysisForm.controls['workStatus'].setValue(560);
    }
  }

  onSaveRootCauseAnalysisForm() {

    this.buttonDisable = true;
    // console.log(JSON.stringify(this.dhruvaRootCauseAnalysisForm.value));

    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json;charset=UTF-8' })
    };
    this.http.post(`${environment.backEndUrl}/root-cause/save-rca-form`, JSON.stringify(this.dhruvaRootCauseAnalysisForm.value), httpOptions).subscribe(
      data => {
        this.buttonDisable = false;
        this.fillMainPage();
        this.messageService.add({ key: 'atr', severity: 'success', summary: 'Success', detail: 'Successfully Saved' });
      },
      error => {
        this.buttonDisable = false;
        this.messageService.add({ key: 'atr', severity: 'error', summary: 'Error occurred', detail: 'Please make sure that all details are filled properly.' });
      }
    );
    
    this.submittedRootCauseDatas =null; 
    this.dataProviderService.loadSubmittedRootCauseDatas(this.dhruvaRootCauseAnalysisForm.controls['roCode'].value, this.dhruvaRootCauseAnalysisForm.controls['part'].value).subscribe(data => {
      this.submittedRootCauseDatas = data;
    });
    console.log(this.submittedRootCauseDatas);
    
  }

}
