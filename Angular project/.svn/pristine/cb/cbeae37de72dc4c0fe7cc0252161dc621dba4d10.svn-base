import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { DataProviderService } from 'src/app/shared/data-provider.service';
import { DivisionEnggIndex } from 'src/app/shared/model/division-engg-index.model';
import { DataExportService } from 'src/app/shared/data-export.service';

@Component({
  selector: 'app-do-engg-leaderboard',
  templateUrl: './do-engg-leaderboard.component.html',
  styleUrls: ['./do-engg-leaderboard.component.css']
})
export class DoEnggLeaderboardComponent implements OnInit {

  updatedOn: string;
  doEnggLeaderboardDatas: DivisionEnggIndex[] = [];
  searchText: string;

  constructor(protected title: Title, protected dataProviderService: DataProviderService, private dataExportService: DataExportService
  ) {

    this.title.setTitle('DO Engg Leaderboard - Dhruva 2.0');
  }

  ngOnInit() {
    this.dataProviderService.loadDivisionEnggIndex().subscribe(data => {
      this.doEnggLeaderboardDatas = data;
      this.updatedOn = data[0].updatedOn;
    });
  }
  exportAsXLSX(): void {

    // this.misReportValues.subscribe((data: any) => {
    //   let array: any = [...[data.reportHeaders], ...data.reportDatas];
    //   this.dataExportService.exportAsExcelFile(array, this.reportName);
    // });
    // this.misReportValues.subscribe((data: any) => {
    let array: any = [[], ...this.doEnggLeaderboardDatas];
    this.dataExportService.exportAsExcelFile(array, "Do Engg Leaderboard");
    // });
  }

}
