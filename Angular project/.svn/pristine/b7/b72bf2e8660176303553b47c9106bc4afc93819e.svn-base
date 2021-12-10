import { Component, OnInit } from '@angular/core';
import { SoManagerDhruvaIndex } from 'src/app/shared/model/state-manager-index.model';
import { Title } from '@angular/platform-browser';
import { DataProviderService } from 'src/app/shared/data-provider.service';
import { WeightageData } from 'src/app/shared/model/weightage-data.model';

@Component({
	selector: 'app-so-manager-leaderboard',
	templateUrl: './so-manager-leaderboard.component.html',
	styleUrls: ['./so-manager-leaderboard.component.css']
})
export class SoManagerLeaderboardComponent implements OnInit {

	updatedOn: string;
	cols: any[];
	weightageData: WeightageData = new WeightageData(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	soManagerLeaderboardDatas: SoManagerDhruvaIndex[] = [];

	constructor(protected title: Title, protected dataProviderService: DataProviderService) {

		this.title.setTitle('Dhruva DO Leaderboard - Dhruva 2.0');
	}

	ngOnInit() {
		this.dataProviderService.loadStateManagerIndex().subscribe(data => {
			this.soManagerLeaderboardDatas = data;
			this.updatedOn = data[0].updatedOn;
		});

		this.cols = [
			{ field: 'soManagerName', header: 'SO Manager Name' },
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
			{ field: 'telecall', header: 'Telecall' },
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
