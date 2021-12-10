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
	selector: 'app-do-awesum-dashboard',
	templateUrl: './do-awesum-dashboard.component.html',
	styleUrls: ['./do-awesum-dashboard.component.css']
})
export class DOAwesumDashboardComponent implements OnInit {
	public isMobile: boolean;
	public currentDoData: string = this.authService.dashBoardDoName;
	public currentSoData: string = this.authService.dashBoardSoName;
	public showParameterScores: boolean = false;
	public stateDhruvaIndex: StateDhruvaIndex[] = [];

	public barChartOptions: (ChartOptions & { annotation: any }) = {
		responsive: true,
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
					borderColor: 'grey',
					borderWidth: 2,
					label: {
						enabled: true,
						fontColor: 'orange',
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

	public barChartStateLabels: Label[];
	public barChartDivisionLabels: Label[] = [];
	public barChartStateType: ChartType = 'bar';
	public barChartDivisionType: ChartType = 'horizontalBar';
	public barChartLegend = true;
	public barChartPlugins = [pluginDataLabels, pluginAnnotations];

	public barChartStateColors: Color[] = [
		{
			borderColor: '#000',
			backgroundColor: 'rgba(228, 103, 19,0.85)',
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


	public barChartStateData: ChartDataSets[] = [
		{ data: [], label: 'AWESUM Score' }
	];
	public barChartDivisionData: ChartDataSets[] = [
		{ data: [], label: 'Parameter Score' }
	];

	constructor(protected title: Title, protected dataProviderService: DataProviderService, private authService: AuthService) {
		this.title.setTitle('AWESUM Dashboard - Dhruva 2.0');
	}

	ngOnInit() {
		this.isMobile = screen.width < 600;
		this.dataProviderService.loadDivisionOfficeAwesumDataBySoName(this.currentSoData).subscribe(data => {
			this.barChartStateLabels = [];
			let doAwesumData: number[] = [];
			data.forEach(index => {
				this.barChartStateLabels.push(index.doMaster);
				doAwesumData.push(Math.round(Number(index.awesum)));
			});
			this.barChartStateData[0].data = doAwesumData;
		});

		if (this.authService.dashBoardDoName != undefined) {
			this.currentDoData = this.authService.dashBoardDoName;
			this.loadAddtionalData(this.authService.dashBoardDoName);
		}
	}

	loadAddtionalData(doName: string) {
		this.currentDoData = doName;
		this.barChartOptions.annotation.annotations[0].value = doName;

		this.dataProviderService.loadDivisionOfficeAwesumDataByDoName(doName).subscribe(data => {
			this.barChartDivisionLabels = ['AIR', 'WATER', 'ENERGY', 'SAFETY', 'UNIFORM', 'MACHINE'];
			this.barChartDivisionData[0].data = [data.air, data.water, data.energy, data.safety, data.uniform, data.machine];
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
