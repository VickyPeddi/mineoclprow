import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Title } from '@angular/platform-browser';
import { DataProviderService } from 'src/app/shared/data-provider.service';
import { AuthService } from 'src/app/auth/auth.service';
import { MessageService } from 'primeng/api';
import * as $ from 'jquery';
import { SQCAuditMaster } from 'src/app/shared/model/sqc-audit-master.model';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-sqc-audit-pdfs',
  templateUrl: './sqc-audit-pdfs.component.html',
  styleUrls: ['./sqc-audit-pdfs.component.css']
})
export class SqcAuditPdfsComponent implements OnInit {
  employeeDhruvaRODatas: SQCAuditMaster[];
  currentAuditNo: number;
  currentAudit: SQCAuditMaster;
  
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
    
    this.dataProviderService.getSQCSubmittedAudits().subscribe(data => {
      this.employeeDhruvaRODatas = data;
    });

    $(document).ready(function () {
      window.history.pushState(null, "", window.location.href);
      window.onpopstate = function () {
        window.history.pushState(null, "", window.location.href);
      };
    });
  }


  selectRoCode(item: SQCAuditMaster) {
    this.currentAuditNo = item.sqcAuditNo;
    this.currentAudit = item;
  }
  
  getImageReport() {
    this.messageService.add({ key: 'audit-pdf-toast', severity: 'warning', summary: 'Info', detail: 'Report generation may take time, Report will open in new tab automatically...' });
    this.dataProviderService.getSQCReport('image-report', this.currentAudit).subscribe((response) => {
      let file = new Blob([response], { type: 'application/pdf' });
      var fileURL = URL.createObjectURL(file);
      window.open(fileURL);
    })
  }
}
