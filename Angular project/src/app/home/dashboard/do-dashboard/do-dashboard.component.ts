import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/auth/auth.service';
import { DhruvaComplianceIndex } from 'src/app/shared/model/dhruva-compliance-points.model';
import { DataProviderService } from 'src/app/shared/data-provider.service';

@Component({
	selector: 'app-do-dashboard',
	templateUrl: './do-dashboard.component.html',
	styleUrls: ['./do-dashboard.component.css']
})
export class DoDashboardComponent implements OnInit {

	compliancePoint: DhruvaComplianceIndex = new DhruvaComplianceIndex(-1, -1, -1, -1, -1);

	constructor(private authService: AuthService, private dataProviderService: DataProviderService) { }

	ngOnInit() {

		if (this.authService.dashBoardDoName != undefined) {
			this.dataProviderService.loadDivisionIndices(this.authService.dashBoardDoName).subscribe(
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
