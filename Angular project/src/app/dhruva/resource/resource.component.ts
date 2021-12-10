import { Component, OnInit } from '@angular/core';
import { DataProviderService } from 'src/app/shared/data-provider.service';
import { DhruvaResourceCategory } from 'src/app/shared/model/dhruva-resource-category.model';
import { MessageService } from 'primeng/api';
import { Title } from '@angular/platform-browser';
import { DhruvaResourceFile } from 'src/app/shared/model/dhruva-resource-file.model';

@Component({
	selector: 'app-resource',
	templateUrl: './resource.component.html',
	styleUrls: ['./resource.component.css']
})
export class ResourceComponent implements OnInit {

	resourcesDatas: DhruvaResourceCategory[] = [];

	isWaiting: boolean = true;
	isFileLoading: boolean = false;

	constructor(private messageService: MessageService, private dataProviderService: DataProviderService, private title: Title) {
		this.title.setTitle('Dhruva Resources - Dhruva 2.0');
	}

	ngOnInit() {

		this.dataProviderService.loadDhruvaResourceDatas().subscribe(
			data => {
				this.resourcesDatas = data;
			},
			error => {
			},
			() => {
				this.isWaiting = false;
			}
		);
	}

	downloadResourceFile(resourcesData: DhruvaResourceFile) {
		this.messageService.add({ key: 'dhruva-resource', severity: 'success', summary: 'Please Wait!!', detail: 'Loading resource...' });
		this.isFileLoading = true;
		this.dataProviderService.loadDhruvaResourceFile(resourcesData.resourceId).subscribe(
			(response) => {
				let file: Blob = new Blob();
				if (resourcesData.resourceFileExtension == 'pdf') {
					file = new Blob([response], { type: 'application/pdf' });
				} else if (resourcesData.resourceFileExtension == 'zip') {
					file = new Blob([response], { type: 'application/zip' });
				}
				var fileURL = URL.createObjectURL(file);
				window.open(fileURL);
			},
			error => {
				this.isFileLoading = false;
				this.messageService.clear();
			},
			() => {
				this.isFileLoading = false;
				this.messageService.clear();
			});
	}

}
