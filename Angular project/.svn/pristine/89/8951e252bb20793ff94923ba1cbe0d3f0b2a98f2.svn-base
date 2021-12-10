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
  selector: 'app-dhruva-compliant-dashboard',
  templateUrl: './dhruva-compliant-dashboard.component.html',
  styleUrls: ['./dhruva-compliant-dashboard.component.css']
})
export class DhruvaCompliantDashboardComponent implements OnInit {
  public currentSoData: string = "";
  public showParameterScores: boolean = false;
  public stateDhruvaIndex: StateDhruvaIndex[] = [];
  public isMobile : boolean;
  public barChartOptions: (ChartOptions & { annotation: any }) = {
    responsive: true,
    // We use these empty structures as placeholders for dynamic theming.
    // scales: {
    //   xAxes: [{}], yAxes: [{
    //     ticks: {
    //       suggestedMax: 100,
    //       beginAtZero: true
    //     }
    //   }] },
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
      // public barChartDivisionColors: Color[] = [
        //   {
          //     // borderColor: '#000',
          //     backgroundColor: 'rgba(255, 0, 0, 0.5)',
          //     hoverBackgroundColor: 'rgba(0,18,89,1)'
          //   }
          //   // ,
          //   // {
            //   //   // borderColor: '#000',
            //   //   backgroundColor: 'rgba(0, 200, 0, 0.5)',
            //   //   hoverBackgroundColor: 'rgba(0,18,89,1)'
            //   // }
            //   // ,
            //   // {
              //   //   // borderColor: '#000',
              //   //   backgroundColor: 'rgba(0, 0, 255, 0.5)',
              //   //   hoverBackgroundColor: 'rgba(0,18,89,1)'
              //   // }
              // ];
              
              public barChartStateData: ChartDataSets[] = [
                // { data: [], label: 'Dhruva Index' }
                // ,
                { data: [], label: 'Dhruva Compliant Score' }
                // ,
                // { data: [], label: 'SEVA Score ' }
              ];
              // public barChartDivisionData: ChartDataSets[] = [
                //   { data: [], label: 'Parameter Score' }
                //   // ,
                //   // { data: [], label: 'FIT' },
                //   // { data: [], label: 'Seva' }
                // ];
                
                constructor(protected title: Title, protected dataProviderService: DataProviderService, private authService: AuthService) {
                  this.title.setTitle('Dhruva Compliant Dashboard - Dhruva 2.0');
                }
                
                ngOnInit() {
                  this.dataProviderService.loadStateDhruvaCompliantScoreData().subscribe(data => {
                    this.isMobile = screen.width<600;
                    
                    // let stateNumData: number[] = [];
                    let stateDhruvaCompliantData: number[] = [];
                    // let stateSevaData: number[] = [];
                    data.forEach(index => {
                      this.barChartStateLabels.push(index.soMaster);
                      // stateNumData.push(Math.round(Number(index.finalDhruvaIndex)));
                      stateDhruvaCompliantData.push(Math.round(Number(index.dhruvaCompliant)));
                      // stateSevaData.push(Math.round(Number(index.seva)));
                    });
                    this.barChartStateData[0].data = stateDhruvaCompliantData;
                  });
                  
                  if (this.authService.dashBoardSoName != undefined) {
                    // this.showParameterScores = true;
                    this.currentSoData = this.authService.dashBoardSoName;
                    this.loadAddtionalData(this.authService.dashBoardSoName);
                  }
                }
                
                loadAddtionalData(soName: string) {
    this.currentSoData = soName;
    this.barChartOptions.annotation.annotations[0].value = soName;
    // this.dataProviderService.loadStateLeaderboardData(soName).subscribe(data => {
    //   this.barChartDivisionLabels = ['AWESUM', 'Facility Completion', 'Spot Checks', 'CA Evaluation', 'FIT', 'SEVA', 'CA Training', 'DSA', 'FO Quiz', 'mPower', 'RCA', 'Sau Ka Sankalp', 'Telecall', 'Attainer', 'Xperience'];
    //   this.barChartDivisionData[0].data = [data.awesum, data.facilityCompletion, data.spotCheck, data.caEvaluation, data.fit, data.seva, data.caTraining, data.dsa, data.foQuiz, data.mPower, data.rca, data.sauKaSankalp, data.telecall, data.attainer, data.xperience];
    // });
  }

  // events
  public chartClicked({ event, active }: { event: MouseEvent, active: any }): void {
    if (active.length > 0) {
      // console.log(active);

      // this.showParameterScores = true;
      // this.loadAddtionalData(active[0]._model.label);
    }
  }

  public chartHovered({ event, active }: { event: MouseEvent, active: {}[] }): void {
    console.log(event, active);
  }

}
