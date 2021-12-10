import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { DataProviderService } from 'src/app/shared/data-provider.service';
import { DivisionDhruvaIndex } from 'src/app/shared/model/division-dhruva-index.model';
import { WeightageData } from 'src/app/shared/model/weightage-data.model';
import { DataExportService } from 'src/app/shared/data-export.service';

@Component({
  selector: 'app-do-leaderboard',
  templateUrl: './do-leaderboard.component.html',
  styleUrls: ['./do-leaderboard.component.css']
})
export class DoLeaderboardComponent implements OnInit {

  updatedOn: string;

  doLeaderboardDatas: DivisionDhruvaIndex[] = [];
  cols: any[];
  weightageData: WeightageData = new WeightageData(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  constructor(protected title: Title, protected dataProviderService: DataProviderService, private dataExportService: DataExportService) {

    this.title.setTitle('Dhruva DO Leaderboard - Dhruva 2.0');
  }

  ngOnInit() {
    this.dataProviderService.loadDivisionDhruvaIndex().subscribe(data => {
      this.doLeaderboardDatas = data;
      this.updatedOn = data[0].updatedOn;
    });

    this.cols = [
      { field: 'soMaster', header: 'State Office' },
      { field: 'doMaster', header: 'Divisional Office' },
      { field: 'rank', header: 'All India Rank' },
      { field: 'totalDhruva', header: 'Dhruva ROs' },
      { field: 'dhruvaCompliant', header: 'Dhruva Compliant' },
      { field: 'dhruvaCompliantRank', header: 'Dhruva Compliant Rank' },
      { field: 'awesum', header: 'Awesum' },
      { field: 'awesumRank', header: 'Awesum Rank' },
      { field: 'facilityCompletion', header: 'Facility Completion' },
      { field: 'facilityCompletionRank', header: 'Facility Completion Rank' },
      { field: 'spotCheck', header: 'Spot Check' },
      { field: 'spotCheckRank', header: 'Spot Check Rank' },
      { field: 'caEvaluation', header: 'CA Evaluation' },
      { field: 'caEvaluationRank', header: 'CA Evaluation Rank' },
      { field: 'activityCompletion', header: 'Activity Completion' },
      { field: 'activityCompletionRank', header: 'Activity Completion Rank' },
      { field: 'mPower', header: 'mPower Plus' },
      { field: 'mPowerRank', header: 'mPower Plus Rank' },
      { field: 'foQuiz', header: 'FO Quiz' },
      { field: 'foQuizRank', header: 'FO Quiz Rank' },
      { field: 'rca', header: 'RCA' },
      { field: 'rcaRank', header: 'RCA Rank' },
      { field: 'caTraining', header: 'CA Training' },
      { field: 'caTrainingRank', header: 'CA Training Rank' },
      { field: 'telecall', header: 'Telecall' },
      { field: 'telecallRank', header: 'Telecall Rank' },
      { field: 'fit', header: 'FIT' },
      { field: 'fitRank', header: 'FIT Rank' },
      { field: 'seva', header: 'SEVA' },
      { field: 'sevaRank', header: 'SEVA Rank' },
      // { field: 'sauKaSankalp', header: '100 Ka Sankalp' },
      // { field: 'sauKaSankalpRank', header: '100 Ka Sankalp Rank' },
      { field: 'attainer', header: 'Attainer' },
      { field: 'attainerRank', header: 'Attainer Rank' },
      { field: 'xperience', header: 'Xperience' },
      { field: 'xperienceRank', header: 'Xperience Rank' },
      { field: 'finalDhruvaIndex', header: 'Dhruva Index' }
    ];

    this.dataProviderService.loadWeightageData().subscribe(data => {
      this.weightageData = data;
    });
  }



}
