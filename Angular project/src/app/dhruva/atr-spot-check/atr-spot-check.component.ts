import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';

@Component({
  selector: 'app-atr-spot-check',
  templateUrl: './atr-spot-check.component.html',
  styleUrls: ['./atr-spot-check.component.css']
})
export class AtrSpotCheckComponent implements OnInit {

  constructor(private title: Title) {
    this.title.setTitle('ATR on Spot Check - Dhruva 2.0');
  }

  ngOnInit() {
  }

}
