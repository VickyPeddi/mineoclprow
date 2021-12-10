import { Component, OnInit } from '@angular/core';
import { DhruvaComplianceIndex } from 'src/app/shared/model/dhruva-compliance-points.model';
import { AuthService } from 'src/app/auth/auth.service';
import { DataProviderService } from 'src/app/shared/data-provider.service';

@Component({
	selector: 'app-sa-dashboard',
	templateUrl: './sa-dashboard.component.html',
	styleUrls: ['./sa-dashboard.component.css']
})
export class SaDashboardComponent implements OnInit {

	compliancePoint: DhruvaComplianceIndex = new DhruvaComplianceIndex(-1, -1, -1, -1, -1);

	constructor(private authService: AuthService, private dataProviderService: DataProviderService) { }

	ngOnInit() {

		if (this.authService.dashBoardSaName != undefined) {
			this.dataProviderService.loadSalesAreaIndices(this.authService.dashBoardSaName).subscribe(
				data => {
					this.compliancePoint.awesum = data.awesum;
					this.compliancePoint.compliance = data.compliance;
					this.compliancePoint.fit = data.fit;
					this.compliancePoint.index = data.index;
					this.compliancePoint.seva = data.seva;
				},
				error => { },
				() => { }
			);
		}
	}
}
