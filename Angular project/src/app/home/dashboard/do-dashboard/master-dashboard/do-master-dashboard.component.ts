import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
import * as pluginDataLabels from 'chartjs-plugin-datalabels';
import * as pluginAnnotations from 'chartjs-plugin-annotation';
import { Label, Color } from 'ng2-charts';
import { StateDhruvaIndex } from 'src/app/shared/model/state-dhruva-index.model';
import { DivisionDhruvaIndex } from 'src/app/shared/model/division-dhruva-index.model';
import { DataProviderService } from 'src/app/shared/data-provider.service';
import { AuthService } from 'src/app/auth/auth.service';
@Component({
	selector: 'app-do-master-dashboard',
	templateUrl: './do-master-dashboard.component.html',
	styleUrls: ['./do-master-dashboard.component.css']
})
export class DOMasterDashboardComponent implements OnInit {
	public isMobile: boolean;
	public currentDoData: string = "";
	public currentSoData: string = this.authService.dashBoardSoName;
	public showParameterScores: boolean = false;
	public stateDhruvaIndex: StateDhruvaIndex[] = [];
	public divisionDhruvaIndex: DivisionDhruvaIndex[] = [];

	public barChartOptions: (ChartOptions & { annotation: any }) = {
		// responsive: true,
		// maintainAspectRatio: true,
		// We use these empty structures as placeholders for dynamic theming.
		// scales: {
		// 	xAxes: [{}], yAxes: [{
		// 		ticks: {
		// 			suggestedMax: 100,
		// 			beginAtZero: true
		// 		}
		// 	}]
		// },
		annotation: {
			annotations: [
				{
					type: 'line',
					mode: 'vertical',
					scaleID: 'x-axis-0',
					value: '',
					height: '10%',
					borderColor: 'grey',
					borderWidth: 2,
					label: {
						enabled: true,
						fontColor: 'white',
						content: 'Your DO Score'
					}
				},
			],
		}
		,
		plugins: {
			datalabels: {
				anchor: 'end',
				align: 'end',
			}
		},
	};
	public barChartStateLabels: Label[] = [];
	public barChartDivisionLabels: Label[] = [];
	public barChartStateType: ChartType = 'bar';
	public barChartDivisionType: ChartType = 'bar';
	public barChartLegend = true;
	public barChartPlugins = [pluginDataLabels, pluginAnnotations];
	public barChartStateColors: Color[] = [
		{
			borderColor: '#000',
			backgroundColor: 'rgba(228, 103, 19)',
			hoverBackgroundColor: 'rgba(0,18,89,1)'
		}
	];
	public barChartDivisionColors: Color[] = [
		{
			borderColor: 'rgb(228, 103, 19)',
			backgroundColor: 'rgba(0,18,89,1)',
			hoverBackgroundColor: 'rgba(228, 103, 19)'
		}
	];

	public barChartStateData: ChartDataSets[];
	public barChartDivisionData: ChartDataSets[];

	constructor(protected title: Title, protected dataProviderService: DataProviderService, private authService: AuthService) {
		this.title.setTitle('DO Master Dashboard - Dhruva 2.0');
		this.isMobile = screen.width < 600;
	}

	ngOnInit() {
		this.barChartStateLabels = [];
		this.barChartStateData = [
			{ data: [], label: 'Dhruva Index' }
		];
		this.barChartDivisionData = [
			{ data: [], label: 'Parameter Score' }
		];
		if (this.currentSoData) {
			this.dataProviderService.loadDivisionDhruvaIndexByState(this.currentSoData).subscribe(data => {
				let stateNumData: number[] = [];
				data.forEach(index => {
					this.barChartStateLabels.push(index.doMaster);
					stateNumData.push(Math.round(Number(index.finalDhruvaIndex)));
				});
				this.barChartStateData[0].data = stateNumData;
			});
		}
		if (this.authService.dashBoardSoName != undefined) {
			this.currentDoData = this.authService.dashBoardDoName;
			this.showParameterScores = true;
			this.loadAddtionalData(this.authService.dashBoardDoName);
		}
	}
	loadAddtionalData(doName: string) {
		this.barChartOptions.annotation.annotations[0].value = this.currentDoData;
		this.currentDoData = doName;
		this.dataProviderService.loadDivisionLeaderboardDataByDoName(doName).subscribe(data => {
			this.barChartDivisionLabels = ['AWESUM', 'Facility Completion', 'Activities Completion', 'Spot Checks', 'CA Evaluation', 'FIT', 'SEVA', 'CA Training', 'FO Quiz', 'mPower', 'RCA', 'Telecall', 'Attainer', 'Xperience'];
			this.barChartDivisionData[0].data = [data.awesum, data.facilityCompletion, data.activityCompletion, data.spotCheck, data.caEvaluation, data.fit, data.seva, data.caTraining, data.foQuiz, data.mPower, data.rca, data.telecall, data.attainer, data.xperience];
		});
	}
	// events
	public chartClicked({ event, active }: { event: MouseEvent, active: any }): void {
		if (active.length > 0) {
			this.showParameterScores = true;
			this.loadAddtionalData(active[0]._model.label);
		}
	}
	public chartHovered({ event, active }: { event: MouseEvent, active: {}[] }): void {
		console.log(event, active);
	}
	changeSo(soValue: string) {
		this.currentSoData = soValue;
		this.ngOnInit();
	}
}
