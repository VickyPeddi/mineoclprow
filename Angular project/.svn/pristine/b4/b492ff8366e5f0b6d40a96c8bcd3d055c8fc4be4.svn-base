import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Title } from '@angular/platform-browser';
import { DataProviderService } from 'src/app/shared/data-provider.service';
import { AuthService } from 'src/app/auth/auth.service';
import { MessageService } from 'primeng/api';
import * as $ from 'jquery';
import { AuditMaster } from 'src/app/shared/model/audit-master.model';
import { ActivatedRoute } from '@angular/router';
import { formatDate } from "@angular/common";


@Component({
  selector: 'app-audit-pdfs',
  templateUrl: './audit-pdfs.component.html',
  styleUrls: ['./audit-pdfs.component.css']
})
export class AuditPdfsComponent implements OnInit {
  employeeDhruvaRODatas: AuditMaster[];
  currentAuditNo: number;
  currentAudit: AuditMaster;

  //Changed
  fromDate: string;
  toDate: string;
  roCode: string;
  showErrorMessage: string = "";
  showDiv: boolean = false;
  showButton: boolean = true;

  constructor(private route: ActivatedRoute, protected http: HttpClient, protected title: Title, protected dataProviderService: DataProviderService,
    protected authService: AuthService, private messageService: MessageService) {
    this.title.setTitle('Activities Completion - Dhruva 2.0');
  }
  ngOnInit(): void {

    this.route.queryParams.subscribe(params => {
      if (params.token && params.user) {
        this.authService.accessToken = params.token;
        this.authService.empCode = params.user;
        this.authService.isCOISLogin = true;
      }
    });

    // this.dataProviderService.getSubmittedAudits().subscribe(data => {
    //   this.employeeDhruvaRODatas = data;
    // });

    $(document).ready(function () {
      window.history.pushState(null, "", window.location.href);
      window.onpopstate = function () {
        window.history.pushState(null, "", window.location.href);
      };
    });
  }


  selectRoCode(item: AuditMaster) {
    this.currentAuditNo = item.auditNo;
    this.currentAudit = item;
  }
  getNonComplianceReport() {
    this.messageService.add({ key: 'audit-pdf-toast', severity: 'warning', summary: 'Info', detail: 'Report generation may take time, Report will open in new tab automatically...' });
    this.dataProviderService.getPdf('summary-report', this.currentAudit).subscribe((response) => {
      let file = new Blob([response], { type: 'application/pdf' });
      var fileURL = URL.createObjectURL(file);
      window.open(fileURL);
    })
  }
  getDetailedReport() {
    this.messageService.add({ key: 'audit-pdf-toast', severity: 'warning', summary: 'Info', detail: 'Report generation may take time, Report will open in new tab automatically...' });
    this.dataProviderService.getPdf('detail-report', this.currentAudit).subscribe((response) => {
      let file = new Blob([response], { type: 'application/pdf' });
      var fileURL = URL.createObjectURL(file);
      window.open(fileURL);
    })
  }
  getImageReport() {
    this.messageService.add({ key: 'audit-pdf-toast', severity: 'warning', summary: 'Info', detail: 'Report generation may take time, Report will open in new tab automatically...' });
    this.dataProviderService.getPdf('image-report', this.currentAudit).subscribe((response) => {
      let file = new Blob([response], { type: 'application/pdf' });
      var fileURL = URL.createObjectURL(file);
      window.open(fileURL);
    })
  }

  refreshContainer() {
    this.employeeDhruvaRODatas = [];
    this.showDiv = false
    this.showErrorMessage = "";
    this.showButton = true;
  }

  onSubmitFitlerButton() {
    this.showErrorMessage = "Loading";
    if (this.fromDate == "" || this.fromDate === undefined || this.fromDate === null) {
      this.showErrorMessage = "From Date Required";
      return false;
    }
    if (this.toDate == "" || this.toDate === undefined || this.toDate === null) {
      this.showErrorMessage = "To Date Required";
      return false;
    }

    if (this.roCode == "" || this.roCode === undefined || this.roCode === null) {
      this.roCode = "NA";
    }

    const format = 'dd-MM-yyyy';
    const locale = 'en-US';
    const formattedFromDate = formatDate(this.fromDate, format, locale);
    const formattedToDate = formatDate(this.toDate, format, locale);
   

    this.showButton = false;
    this.showErrorMessage = "Loading...";

    this.dataProviderService.getSubmittedAuditsPost(formattedFromDate, formattedToDate, this.roCode).subscribe(data => {
      this.employeeDhruvaRODatas = data;
      this.showDiv = true;
    }, error => {
      this.showErrorMessage = "Please Try Later";
      this.showButton = true;
      this.showDiv = false;
    }, () => {
      console.log("Complete");
      this.showErrorMessage = "";
      this.showButton = true;
    });

  }

}
