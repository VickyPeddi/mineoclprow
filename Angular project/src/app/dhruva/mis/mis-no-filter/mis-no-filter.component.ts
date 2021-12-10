import { Component, OnInit, Output, EventEmitter, OnDestroy, Input } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-mis-no-filter',
  templateUrl: './mis-no-filter.component.html',
  styleUrls: ['./mis-no-filter.component.css']
})
export class MisNoFilterComponent implements OnInit, OnDestroy {

  @Input() buttonDisable: boolean;
  @Output() showReport = new EventEmitter();

  values = {
    salesOrg: '0',
    salesOff: '0',
    salesArea: '0'
  };

  constructor() { }

  ngOnInit() {
  }

  onRequestReport() {
    this.showReport.emit(this.values);
  }

  ngOnDestroy(): void {
    this.showReport.unsubscribe();
  }

}
