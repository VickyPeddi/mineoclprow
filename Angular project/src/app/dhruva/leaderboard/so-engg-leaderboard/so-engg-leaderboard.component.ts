import { Component, OnInit } from '@angular/core';
import { StateEnggIndex } from 'src/app/shared/model/state-engg-index.model';
import { Title } from '@angular/platform-browser';
import { DataProviderService } from 'src/app/shared/data-provider.service';
import { DataExportService } from 'src/app/shared/data-export.service';

@Component({
  selector: 'app-so-engg-leaderboard',
  templateUrl: './so-engg-leaderboard.component.html',
  styleUrls: ['./so-engg-leaderboard.component.css']
})
export class SoEnggLeaderboardComponent implements OnInit {

  updatedOn: string;
  soEnggLeaderboardDatas: StateEnggIndex[] = [];
  searchText: string;

  constructor(protected title: Title, protected dataProviderService: DataProviderService,protected dataExportService:DataExportService) {

    this.title.setTitle('DO Engg Leaderboard - Dhruva 2.0');
  }

  ngOnInit() {
    this.dataProviderService.loadStateEnggIndex().subscribe(data => {
      
      this.soEnggLeaderboardDatas = data;
      this.updatedOn = data[0].updatedOn;
    });
  }exportAsXLSX(): void {

    // this.misReportValues.subscribe((data: any) => {
    //   let array: any = [...[data.reportHeaders], ...data.reportDatas];
    //   this.dataExportService.exportAsExcelFile(array, this.reportName);
    // });
    // this.misReportValues.subscribe((data: any) => {
    let array: any = [[], ...this.soEnggLeaderboardDatas];
    this.dataExportService.exportAsExcelFile(array, "Do Engg Leaderboard");
    // });
  }

}
