import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { DataProviderService } from 'src/app/shared/data-provider.service';
import { DhruvaHelpPersonnel } from 'src/app/shared/model/dhruva-help-personnel.model';
import { environment } from 'src/environments/environment';

@Component({
	selector: 'app-help',
	templateUrl: './help.component.html',
	styleUrls: ['./help.component.css']
})
export class HelpComponent implements OnInit {
	assetUrl:string = environment.assetUrl;
	isWaiting: boolean = true;
	// helpPersonnel: DhruvaHelpPersonnel[] = []
	technicalPersonnel: DhruvaHelpPersonnel[] = [];
	functionalPersonnel: DhruvaHelpPersonnel[] = [];

	constructor(protected title: Title, private dataProviderService: DataProviderService) {
		this.title.setTitle('Dhruva Help - Dhruva 2.0');
	}

	ngOnInit() {

		this.dataProviderService.loadDhruvaHelpPersonnel().subscribe(
			data => {
				this.technicalPersonnel = data.filter(filterData => filterData.userType == 'IS');
				this.functionalPersonnel = data.filter(filterData => filterData.userType == 'RS');
			},
			error => { },
			() => {
				this.isWaiting = false;
			}
		);
	}

}
