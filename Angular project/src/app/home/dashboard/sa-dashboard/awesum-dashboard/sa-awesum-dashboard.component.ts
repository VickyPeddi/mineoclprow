import { Component, OnInit } from '@angular/core';
import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
import * as pluginDataLabels from 'chartjs-plugin-datalabels';
import * as pluginAnnotations from 'chartjs-plugin-annotation';
import { Label, Color } from 'ng2-charts';
import { DataProviderService } from 'src/app/shared/data-provider.service';
import { AuthService } from 'src/app/auth/auth.service';
import { Title } from '@angular/platform-browser';

@Component({
	selector: 'app-sa-awesum-dashboard',
	templateUrl: './sa-awesum-dashboard.component.html',
	styleUrls: ['./sa-awesum-dashboard.component.css']
})
export class SaAwesumDashboardComponent implements OnInit {

	public isMobile: boolean;
	public currentSaData: string = "";
	public showParameterScores: boolean = false;
	public saDhruvaIndex: FieldDhruvaIndex[] = [];
	public currentDoData: string = this.authService.dashBoardDoName;
	public doListforDropDown: any = [];
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
						content: 'Your SA Score'
					}
				},
			],
		},
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
		this.dataProviderService.loadDoNames().subscribe(data => {
			this.doListforDropDown = data;
		});
		this.loadChartValues();

	}
	loadChartValues() {
		this.barChartStateLabels = [];
		this.dataProviderService.loadSaAwesumDataByDoName(this.currentDoData).subscribe(data => {
			let doAwesumData: number[] = [];
			data.forEach(index => {
				this.barChartStateLabels.push(index.saMaster);
				doAwesumData.push(Math.round(Number(index.awesum)));
			});
			this.barChartStateData[0].data = doAwesumData;
		});

		if (this.authService.dashBoardDoName != undefined) {
			this.currentSaData = this.authService.dashBoardSaName;
			this.loadAddtionalData(this.authService.dashBoardSaName);
		}
	}

	loadAddtionalData(saName: string) {
		this.currentSaData = saName;
		this.barChartOptions.annotation.annotations[0].value = saName;

		this.dataProviderService.loadSaAwesumDataBySaName(saName).subscribe(data => {
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
	public changeDo(doName: string) {
		this.currentDoData = doName;
		this.loadChartValues();
	}

}
