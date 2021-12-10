import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/auth/auth.service';
import { DataProviderService } from 'src/app/shared/data-provider.service';
import { DhruvaComplianceIndex } from 'src/app/shared/model/dhruva-compliance-points.model';

@Component({
	selector: 'app-so-dashboard',
	templateUrl: './so-dashboard.component.html',
	styleUrls: ['./so-dashboard.component.css']
})
export class SoDashboardComponent implements OnInit {

	compliancePoint: DhruvaComplianceIndex = new DhruvaComplianceIndex(-1, -1, -1, -1, -1);

	constructor(private authService: AuthService, private dataProviderService: DataProviderService) { }

	ngOnInit() {

		if (this.authService.dashBoardSoName != undefined) {
			this.dataProviderService.loadStateIndices(this.authService.dashBoardSoName).subscribe(
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
