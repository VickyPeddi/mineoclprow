import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Title } from '@angular/platform-browser';
import { DataProviderService } from 'src/app/shared/data-provider.service';
import { AuthService } from 'src/app/auth/auth.service';
import { MessageService } from 'primeng/api';
import { StateDhruvaIndex } from 'src/app/shared/model/state-dhruva-index.model';
import { DataExportService } from 'src/app/shared/data-export.service';
import { WeightageData } from 'src/app/shared/model/weightage-data.model';

@Component({
	selector: 'app-so-leaderboard',
	templateUrl: './so-leaderboard.component.html',
	styleUrls: ['./so-leaderboard.component.css']
})
export class SoLeaderboardComponent implements OnInit {

	searchText: string;
	updatedOn: string;

	soLeaderboardDatas: StateDhruvaIndex[] = [];

	cols: any[];
	weightageData: WeightageData = new WeightageData(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

	constructor(protected http: HttpClient, protected title: Title, protected dataProviderService: DataProviderService,
		protected authService: AuthService, private messageService: MessageService, private dataExportService: DataExportService) {
		this.title.setTitle('Dhruva SO Leaderboard - Dhruva 2.0');
	}

	ngOnInit() {
		this.dataProviderService.loadStateDhruvaIndex().subscribe(data => {
			this.soLeaderboardDatas = data;
			this.updatedOn = data[0].updatedOn;
		});

		this.cols = [
			{ field: 'soMaster', header: 'State Office' },
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
			{ field: 'dsa', header: 'DSA' },
			{ field: 'dsaRank', header: 'DSA Rank' },
			{ field: 'finalDhruvaIndex', header: 'Dhruva Index' }
		];

		this.dataProviderService.loadWeightageData().subscribe(data => {
			this.weightageData = data;
		});
	}

}
