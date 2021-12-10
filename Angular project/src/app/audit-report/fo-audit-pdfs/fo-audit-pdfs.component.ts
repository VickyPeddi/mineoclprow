import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Title } from '@angular/platform-browser';
import { DataProviderService } from 'src/app/shared/data-provider.service';
import { AuthService } from 'src/app/auth/auth.service';
import { MessageService } from 'primeng/api';
import * as $ from 'jquery';
import { FOAuditMaster } from 'src/app/shared/model/fo-audit-master.model';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-fo-audit-pdfs',
  templateUrl: './fo-audit-pdfs.component.html',
  styleUrls: ['./fo-audit-pdfs.component.css']
})
export class FoAuditPdfsComponent implements OnInit {

  employeeDhruvaRODatas: FOAuditMaster[];
  currentAuditNo: number;
  currentAudit: FOAuditMaster;
  
  constructor(private route: ActivatedRoute,protected http: HttpClient, protected title: Title, protected dataProviderService: DataProviderService,
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
    
    this.dataProviderService.getFOSubmittedAudits().subscribe(data => {
      this.employeeDhruvaRODatas = data;
    });

    $(document).ready(function () {
      window.history.pushState(null, "", window.location.href);
      window.onpopstate = function () {
        window.history.pushState(null, "", window.location.href);
      };
    });
  }


  selectRoCode(item: FOAuditMaster) {
    this.currentAuditNo = item.auditNo;
    this.currentAudit = item;
  }
  
  getNonComplianceReport() {
    this.messageService.add({ key: 'audit-pdf-toast', severity: 'warning', summary: 'Info', detail: 'Report generation may take time, Report will open in new tab automatically...' });
    this.dataProviderService.getFOSelfAuditReport('summary-report', this.currentAudit).subscribe((response) => {
      let file = new Blob([response], { type: 'application/pdf' });
      var fileURL = URL.createObjectURL(file);
      window.open(fileURL);
    })
  }
  getDetailedReport() {
    this.messageService.add({ key: 'audit-pdf-toast', severity: 'warning', summary: 'Info', detail: 'Report generation may take time, Report will open in new tab automatically...' });
    this.dataProviderService.getFOSelfAuditReport('detail-report', this.currentAudit).subscribe((response) => {
      let file = new Blob([response], { type: 'application/pdf' });
      var fileURL = URL.createObjectURL(file);
      window.open(fileURL);
    })
  }
  getImageReport() {
    this.messageService.add({ key: 'audit-pdf-toast', severity: 'warning', summary: 'Info', detail: 'Report generation may take time, Report will open in new tab automatically...' });
    this.dataProviderService.getFOSelfAuditReport('image-report', this.currentAudit).subscribe((response) => {
      let file = new Blob([response], { type: 'application/pdf' });
      var fileURL = URL.createObjectURL(file);
      window.open(fileURL);
    })
  }
}
