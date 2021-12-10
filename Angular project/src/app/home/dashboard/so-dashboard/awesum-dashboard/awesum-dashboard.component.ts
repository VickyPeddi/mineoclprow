import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
import * as pluginDataLabels from 'chartjs-plugin-datalabels';
import * as pluginAnnotations from 'chartjs-plugin-annotation';
import { Label, Color } from 'ng2-charts';
import { StateDhruvaIndex } from 'src/app/shared/model/state-dhruva-index.model';
import { DataProviderService } from 'src/app/shared/data-provider.service';
import { AuthService } from 'src/app/auth/auth.service';

@Component({
	selector: 'app-awesum-dashboard',
	templateUrl: './awesum-dashboard.component.html',
	styleUrls: ['./awesum-dashboard.component.css']
})
export class AwesumDashboardComponent implements OnInit {

	public currentSoData: string = "";
	public showParameterScores: boolean = false;
	public stateDhruvaIndex: StateDhruvaIndex[] = [];
	public isMobile: boolean;
	public barChartOptions: (ChartOptions & { annotation: any }) = {
		responsive: true,
		// We use these empty structures as placeholders for dynamic theming.
		// scales: { 
		// 	xAxes: [{}], yAxes: [{
		// 	  ticks: {
		// 		 suggestedMax: 100,
		// 		 beginAtZero: true
		// 	  }
		// 	}] },
		annotation: {
			annotations: [
				{
					type: 'line',
					mode: 'vertical',
					scaleID: 'x-axis-0',
					value: '',
					borderColor: 'grey',
					borderWidth: 2,
					label: {
						enabled: true,
						fontColor: 'orange',
						content: 'Your SO Score'
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
	public barChartDivisionType: ChartType = 'horizontalBar';
	public barChartLegend = true;
	public barChartPlugins = [pluginDataLabels, pluginAnnotations];
	public barChartStateColors: Color[] = [
		{
			borderColor: '#000',
			backgroundColor: 'rgba(228, 103, 19)',
			hoverBackgroundColor: 'rgba(0,18,89,1)'
		}
		// ,
		// {
		//   borderColor: '#000',
		//   backgroundColor: 'rgba(0, 100, 0, 0.6)',
		//   hoverBackgroundColor: 'rgba(0,18,89,1)'
		// }
		// ,
		// {
		//   borderColor: '#000',
		//   backgroundColor: 'rgba(0, 0, 150, 0.6)',
		//   hoverBackgroundColor: 'rgba(0,18,89,1)'
		// }
	];
	public barChartDivisionColors: Color[] = [
	  {
			borderColor: 'rgb(228, 103, 19)',
			backgroundColor: 'rgba(0,18,89,1)',
			hoverBackgroundColor: 'rgba(228, 103, 19)'
	  }
	  // ,
	  // {
	  //   // borderColor: '#000',
	  //   backgroundColor: 'rgba(0, 200, 0, 0.5)',
	  //   hoverBackgroundColor: 'rgba(0,18,89,1)'
	  // }
	  // ,
	  // {
	  //   // borderColor: '#000',
	  //   backgroundColor: 'rgba(0, 0, 255, 0.5)',
	  //   hoverBackgroundColor: 'rgba(0,18,89,1)'
	  // }
	];

	public barChartStateData: ChartDataSets[] = [
		// { data: [], label: 'Dhruva Index' }
		// ,
		{ data: [], label: 'AWESUM Score' }
		// ,
		// { data: [], label: 'SEVA Score ' }
	];
	public barChartDivisionData: ChartDataSets[] = [
		{ data: [], label: 'Parameter Score' }
		// ,
		// { data: [], label: 'FIT' },
		// { data: [], label: 'Seva' }
	];

	constructor(protected title: Title, protected dataProviderService: DataProviderService, private authService: AuthService) {
		this.title.setTitle('AWESUM Dashboard - Dhruva 2.0');
	}

	ngOnInit() {
		this.isMobile = screen.width < 600;
		this.dataProviderService.loadStateAWESUMScoreDatas().subscribe(data => {

			let stateAwesumData: number[] = [];
			data.forEach(index => {
				this.barChartStateLabels.push(index.soMaster);
				// stateNumData.push(Math.round(Number(index.finalDhruvaIndex)));
				stateAwesumData.push(Math.round(Number(index.awesum)));
				// stateSevaData.push(Math.round(Number(index.seva)));
			});
			this.barChartStateData[0].data = stateAwesumData;
		});

		if (this.authService.dashBoardSoName != undefined) {
			this.showParameterScores = true;
			this.currentSoData = this.authService.dashBoardSoName;
			this.loadAddtionalData(this.authService.dashBoardSoName);
		}
	}

	loadAddtionalData(soName: string) {
		this.currentSoData = soName;
		this.barChartOptions.annotation.annotations[0].value = soName;
		this.dataProviderService.loadStateAWESUMScoreData(soName).subscribe(data => {
			this.barChartDivisionLabels = ['AIR', 'WATER', 'ENERGY', 'SAFETY', 'UNIFORM', 'MACHINE'];
			this.barChartDivisionData[0].data = [data.air, data.water, data.energy, data.safety, data.uniform, data.machine];
		});
	}

	// events
	public chartClicked({ event, active }: { event: MouseEvent, active: any }): void {
		if (active.length > 0) {
			// console.log(active);

			this.showParameterScores = true;
			this.loadAddtionalData(active[0]._model.label);
		}
	}

	public chartHovered({ event, active }: { event: MouseEvent, active: {}[] }): void {
		console.log(event, active);
	}

}
