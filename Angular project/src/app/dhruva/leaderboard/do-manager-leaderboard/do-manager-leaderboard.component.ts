import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/auth/auth.service';
import { DataProviderService } from 'src/app/shared/data-provider.service';
import { Title } from '@angular/platform-browser';
import { WeightageData } from 'src/app/shared/model/weightage-data.model';
import { DoManagerIndex } from 'src/app/shared/model/division-manager-index.model';

@Component({
  selector: 'app-do-manager-leaderboard',
  templateUrl: './do-manager-leaderboard.component.html',
  styleUrls: ['./do-manager-leaderboard.component.css']
})
export class DoManagerLeaderboardComponent implements OnInit {

  searchText: string;
  updatedOn: string;

  doManagerLeaderboardDatas: DoManagerIndex[] = [];
  cols: any[];
  weightageData: WeightageData = new WeightageData(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  constructor( protected title: Title, protected dataProviderService: DataProviderService,
    protected authService: AuthService) {

    this.title.setTitle('DO Manager Leaderboard - Dhruva 2.0');
  }

  ngOnInit() {
    this.dataProviderService.loadDoManagerIndex().subscribe(data => {
      this.doManagerLeaderboardDatas = data;
      this.updatedOn = data[0].updatedOn;
    });
    this.cols = [
      { field: 'doManagerName', header: 'DO Manager Name'},
      // { field: 'doManagerEmpCode', header: 'Employee Code' },
      { field: 'employeeLocation', header: 'Location' },
      { field: 'rank', header: 'All India Rank' },
      { field: 'totalDhruva', header: 'Dhruva ROs' },
      { field: 'dhruvaCompliant', header: 'Dhruva Compliant' },
      { field: 'awesum', header: 'Awesum' },
      { field: 'facilityCompletion', header: 'Facility Completion' },
      { field: 'spotCheck', header: 'Spot Check' },
      { field: 'caEvaluation', header: 'CA Evaluation' },
      { field: 'activityCompletion', header: 'Activity Completion' },
      { field: 'mPower', header: 'mPower Plus' },
      { field: 'foQuiz', header: 'FO Quiz' },
      { field: 'rca', header: 'RCA' },
      { field: 'caTraining', header: 'CA Training' },
      { field: 'fit', header: 'FIT' },
      { field: 'seva', header: 'SEVA' },
      // { field: 'sauKaSankalp', header: '100 Ka Sankalp' },
      { field: 'attainer', header: 'Attainer' },
      { field: 'xperience', header: 'Xperience' },
      { field: 'finalDhruvaIndex', header: 'Dhruva Index' }
    ];

    this.dataProviderService.loadWeightageData().subscribe(data => {
      this.weightageData = data;
    });
  }




}
