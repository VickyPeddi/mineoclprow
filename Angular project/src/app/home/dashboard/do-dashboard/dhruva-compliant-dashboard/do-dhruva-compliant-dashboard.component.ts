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
  selector: 'app-do-dhruva-compliant-dashboard',
  templateUrl: './do-dhruva-compliant-dashboard.component.html',
  styleUrls: ['./do-dhruva-compliant-dashboard.component.css']
})
export class DODhruvaCompliantDashboardComponent implements OnInit {
  public isMobile:boolean;
  public currentDoData: string = "";
  public currentSoData: string = this.authService.dashBoardSoName;
  public showParameterScores: boolean = false;
  public stateDhruvaIndex: StateDhruvaIndex[] = [];
  
  public barChartOptions: (ChartOptions & { annotation: any }) = {
    responsive: true,
    // We use these empty structures as placeholders for dynamic theming.
    // scales: {
    //   xAxes: [{}], yAxes: [{
    //     ticks: {
    //       suggestedMax: 100,
    //       beginAtZero: true
    //     }
    //   }]
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
  
  public barChartStateLabels: Label[] = [];
  // public barChartDivisionLabels: Label[] = [];
  public barChartStateType: ChartType = 'bar';
  public barChartLegend = true;
  public barChartPlugins = [pluginDataLabels, pluginAnnotations];
  public barChartStateColors: Color[] = [
    {
      borderColor: '#000',
      backgroundColor: 'rgba(228, 103, 19)',
      hoverBackgroundColor: 'rgba(0,18,89,1)'
    }
  ];
  public barChartStateData: ChartDataSets[] = [
    
    { data: [], label: 'Dhruva Compliant Score' }
    
  ];
  
  
  constructor(protected title: Title, protected dataProviderService: DataProviderService, private authService: AuthService) {
    this.title.setTitle('Dhruva Compliant Dashboard - Dhruva 2.0');
  }
  
  ngOnInit() {
    this.isMobile = screen.width<600;
    this.dataProviderService.loadDivisionDhruvaCompliantScoreData(this.currentSoData).subscribe(data => {
      this.barChartStateLabels =[];
      let stateDhruvaCompliantData: number[] = [];
      data.forEach(index => {
        this.barChartStateLabels.push(index.doMaster);
        stateDhruvaCompliantData.push(Math.round(Number(index.dhruvaCompliant)));
      });
      this.barChartStateData[0].data = stateDhruvaCompliantData;
    });

    if (this.authService.dashBoardDoName != undefined) {
      this.currentDoData = this.authService.dashBoardDoName;
      this.loadAddtionalData(this.authService.dashBoardDoName);
    }
  }

  loadAddtionalData(doName: string) {
    this.currentDoData = doName;
    this.barChartOptions.annotation.annotations[0].value = doName;

  }

  // events
  public chartClicked({ event, active }: { event: MouseEvent, active: any }): void {
    if (active.length > 0) {

    }
  }

  public chartHovered({ event, active }: { event: MouseEvent, active: {}[] }): void {
    console.log(event, active);
  }
  changeSo(soValue : string){
    this.currentSoData = soValue;
    this.ngOnInit();
  }

}
