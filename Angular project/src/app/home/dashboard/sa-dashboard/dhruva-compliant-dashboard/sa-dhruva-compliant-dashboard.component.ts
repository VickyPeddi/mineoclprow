import { Component, OnInit } from '@angular/core';
import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
import * as pluginDataLabels from 'chartjs-plugin-datalabels';
import * as pluginAnnotations from 'chartjs-plugin-annotation';
import { Label, Color } from 'ng2-charts';
import { DataProviderService } from 'src/app/shared/data-provider.service';
import { AuthService } from 'src/app/auth/auth.service';
import { Title } from '@angular/platform-browser';


@Component({
  selector: 'app-sa-dhruva-compliant-dashboard',
  templateUrl: './sa-dhruva-compliant-dashboard.component.html',
  styleUrls: ['./sa-dhruva-compliant-dashboard.component.css']
})
export class SaDhruvaCompliantDashboardComponent implements OnInit {

  public currentSaData: string = "";
  public showParameterScores: boolean = false;
  public saDhruvaIndex: FieldDhruvaIndex[] = [];
  public currentDoData: string = this.authService.dashBoardDoName;
  public doListforDropDown:any =[];
  public isMobile:boolean;
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
            content: 'Your SA Score'
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
    this.dataProviderService.loadDoNames().subscribe(data=>{
      this.doListforDropDown = data;
    })
    this.loadChartValues();
    
  }
  loadChartValues(){
    this.barChartStateLabels=[];
    this.dataProviderService.loadSaDhruvaCompliantDataByDoName(this.currentDoData).subscribe(data => {
      let doDhruvaCompliantData: number[] = [];
      data.forEach(index => {
        this.barChartStateLabels.push(index.saMaster);
        doDhruvaCompliantData.push(Math.round(Number(index.dhruvaCompliant)));
      });
      this.barChartStateData[0].data = doDhruvaCompliantData;
    });

    if (this.authService.dashBoardDoName != undefined) {
      this.currentSaData = this.authService.dashBoardSaName;
      this.loadAddtionalData(this.authService.dashBoardSaName);
    }
  }

  loadAddtionalData(saName: string) {
    this.currentSaData = saName;
    this.barChartOptions.annotation.annotations[0].value = saName;
  
  }

  // events
  public chartClicked({ event, active }: { event: MouseEvent, active: any }): void {
    if (active.length > 0) {
     
    }
  }

  public chartHovered({ event, active }: { event: MouseEvent, active: {}[] }): void {
    console.log(event, active);
  }

  public changeDo(doName:string){
    this.currentDoData = doName;
    this.loadChartValues();
  }
}
