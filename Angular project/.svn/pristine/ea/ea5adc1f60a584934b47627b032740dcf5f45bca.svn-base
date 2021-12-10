import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';
import * as $ from 'jquery';
import { MessageService } from 'primeng/api';
import { AuthService } from 'src/app/auth/auth.service';
import { DataExportService } from 'src/app/shared/data-export.service';
import { DataProviderService } from 'src/app/shared/data-provider.service';
import { AuditUserMaster } from 'src/app/shared/model/auditor-master.model';
import { AuditUserExportMaster } from 'src/app/shared/model/auditor-master-export.model';

@Component({
  selector: 'app-audit-user-documents',
  templateUrl: './audit-user-documents.component.html',
  styleUrls: ['./audit-user-documents.component.css']
})
export class AuditUserDocumentsComponent implements OnInit {
  auditUsersDataList: AuditUserMaster[];
  currentUserId: string;
  currentUser: AuditUserMaster;

  constructor(private route: ActivatedRoute, protected http: HttpClient, protected title: Title, protected dataProviderService: DataProviderService,
    protected authService: AuthService, private dataExportService: DataExportService, private messageService: MessageService) {
    this.title.setTitle('Audit User Documents - Dhruva 2.0');
  }
  ngOnInit(): void {

    this.route.queryParams.subscribe(params => {
      if (params.token && params.user) {
        this.authService.accessToken = params.token;
        this.authService.empCode = params.user;
        this.authService.isCOISLogin = true;
      }
    });

    this.dataProviderService.getRegisteredAuditUsers().subscribe(data => {
      this.auditUsersDataList = data;
    });

    $(document).ready(function () {
      window.history.pushState(null, "", window.location.href);
      window.onpopstate = function () {
        window.history.pushState(null, "", window.location.href);
      };
    });
  }


  selectAuditUser(item: AuditUserMaster) {
    this.currentUserId = item.userId;
    this.currentUser = item;
  }
  getIDProofDocument() {
    this.dataProviderService.getAuditUserDocuments('id-proof', this.currentUser).subscribe((response) => {
      let file = null;
      if (this.currentUser.idProofExt.toLowerCase() == "pdf") {
        file = new Blob([response], { type: 'application/pdf' });
      } else if (this.currentUser.idProofExt.toLowerCase() == "png") {
        file = new Blob([response], { type: 'application/png' });
      } else if (this.currentUser.idProofExt.toLowerCase() == "jpg") {
        file = new Blob([response], { type: 'application/jpg' });
      } else if (this.currentUser.idProofExt.toLowerCase() == "jpeg") {
        file = new Blob([response], { type: 'application/jpeg' });
      }

      var fileURL = URL.createObjectURL(file);
      var anchor = document.createElement("a");
      anchor.download = "id-proof." + this.currentUser.idProofExt;
      anchor.href = fileURL;
      anchor.click();
    })
  }
  getPhotographDocument() {
    this.dataProviderService.getAuditUserDocuments('photograph', this.currentUser).subscribe((response) => {
      let file = null;
      if (this.currentUser.photographExt.toLowerCase() == "pdf") {
        file = new Blob([response], { type: 'application/pdf' });
      } else if (this.currentUser.photographExt.toLowerCase() == "png") {
        file = new Blob([response], { type: 'application/png' });
      } else if (this.currentUser.photographExt.toLowerCase() == "jpg") {
        file = new Blob([response], { type: 'application/jpg' });
      } else if (this.currentUser.photographExt.toLowerCase() == "jpeg") {
        file = new Blob([response], { type: 'application/jpeg' });
      }

      var fileURL = URL.createObjectURL(file);
      var anchor = document.createElement("a");
      anchor.download = "photograph." + this.currentUser.photographExt;
      anchor.href = fileURL;
      anchor.click();
    })
  }
  getEducationProofDocument() {
    this.dataProviderService.getAuditUserDocuments('education-proof', this.currentUser).subscribe((response) => {
      let file = null;
      if (this.currentUser.educationProofExt.toLowerCase() == "pdf") {
        file = new Blob([response], { type: 'application/pdf' });
      } else if (this.currentUser.educationProofExt.toLowerCase() == "png") {
        file = new Blob([response], { type: 'application/png' });
      } else if (this.currentUser.educationProofExt.toLowerCase() == "jpg") {
        file = new Blob([response], { type: 'application/jpg' });
      } else if (this.currentUser.educationProofExt.toLowerCase() == "jpeg") {
        file = new Blob([response], { type: 'application/jpeg' });
      }

      var fileURL = URL.createObjectURL(file);
      var anchor = document.createElement("a");
      anchor.download = "education-proof." + this.currentUser.educationProofExt;
      anchor.href = fileURL;
      anchor.click();
    })
  }

  exportAsXLSX(): void {
    let array: any = this.auditUsersDataList.map(auditUsersData => new AuditUserExportMaster(auditUsersData.role, auditUsersData.firstName,
      auditUsersData.lastName, auditUsersData.email, auditUsersData.mobile, auditUsersData.qualificationLevel, auditUsersData.idType,
      auditUsersData.vendorAdminName));
    this.dataExportService.exportAsExcelFile(array, 'Audit User Documents');
  }

}

