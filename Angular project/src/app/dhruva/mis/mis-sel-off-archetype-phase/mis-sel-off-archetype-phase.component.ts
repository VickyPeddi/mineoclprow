import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Observable } from 'rxjs';
import { FormGroup, FormControl } from '@angular/forms';
import { DataProviderService } from 'src/app/shared/data-provider.service';

@Component({
  selector: 'app-mis-sel-off-archetype-phase',
  templateUrl: './mis-sel-off-archetype-phase.component.html',
  styleUrls: ['./mis-sel-off-archetype-phase.component.css']
})
export class MisSelOffArchetypePhaseComponent implements OnInit {

  @Input() soList: Observable<string[]>;
  @Input() doList: any;
  @Input() saList: any;
  @Input() buttonDisable: boolean;
  @Output() soChange = new EventEmitter();
  @Output() doChange = new EventEmitter();
  @Output() showReport = new EventEmitter();

  misParametersInputForm: FormGroup;

  misArchetypes: string[];
  misPhases: string[];

  constructor(private dataProviderService: DataProviderService) { }

  ngOnInit() {
    this.onResetForm();
    this.dataProviderService.loadMISArchetypes().subscribe(data => this.misArchetypes = data);
    this.dataProviderService.loadMISPhases().subscribe(data => this.misPhases = data);
  }

  onResetForm() {
    this.misParametersInputForm = new FormGroup({
      'salesOrg': new FormControl('0'),
      'salesOff': new FormControl('0'),
      'salesArea': new FormControl('0'),
      'archetype': new FormControl('0'),
      'phase': new FormControl('0')
    });
  }

  onSelectSalesOrg(event: any) {

    this.soChange.emit(event);

    if (event.target.value === "0") {
      this.misParametersInputForm.controls['salesOff'].setValue('0');
      this.misParametersInputForm.controls['salesArea'].setValue('0');
      this.doList = [];
      this.saList = [];
      return;
    }
    this.misParametersInputForm.controls['salesOff'].setValue('0');
    this.misParametersInputForm.controls['salesArea'].setValue('0');
  }

  onSelectSalesOff(event: any) {

    this.doChange.emit(event);

    if (event.target.value === "0") {
      this.misParametersInputForm.controls['salesArea'].setValue('0');
      this.saList = [];
      return;
    }
    this.misParametersInputForm.controls['salesArea'].setValue('0');
  }

  onRequestReport() {
    this.showReport.emit(this.misParametersInputForm.value);
  }

  ngOnDestroy(): void {
    this.soChange.unsubscribe();
    this.doChange.unsubscribe();
    this.showReport.unsubscribe();
  }
}
