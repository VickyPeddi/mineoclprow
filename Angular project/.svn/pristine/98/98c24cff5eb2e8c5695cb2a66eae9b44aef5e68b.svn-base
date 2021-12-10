import { Component, OnInit, OnDestroy } from '@angular/core';
import { AuthService } from '../auth/auth.service';
import { Router, NavigationStart } from '@angular/router';
import { Observable, Subscription } from 'rxjs';
import { environment } from '../../environments/environment';
import { DataProviderService } from '../shared/data-provider.service';
import { AuditorMenuItem } from '../shared/model/auditor-menu.model';
import { MessageService } from 'primeng/api';
import { SideBarMenu } from '../shared/model/side-bar-menu.model';
import * as $ from 'jquery';

@Component({
	selector: 'app-home',
	templateUrl: './home.component.html',
	styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

	userName: string;
	designation: string;
	isExpanded: boolean = false;
	sideBarInputMenus: Observable<string>;
	sideBarMISMenus: Observable<string>;
	sideBarLeaderboardMenus: Observable<string>;
	sideBarAuditorMenus: Observable<AuditorMenuItem[]>;

	sideBarMenus: SideBarMenu[] = [];

	subscription: Subscription;
	browserRefresh: boolean = false;
	assetUrl: string;
	isCOISAccess: boolean;
	welcomeMessage: string[];

	constructor(public authService: AuthService, private router: Router, protected dataProviderService: DataProviderService, private messageService: MessageService) {

		this.subscription = router.events.subscribe((event) => {
			if (event instanceof NavigationStart) {
				this.browserRefresh = !router.navigated;
			}
		});
		this.assetUrl = environment.assetUrl;
		this.isCOISAccess = this.authService.isCOISLogin;
	}

	ngOnInit() {
		this.userName = this.authService.empName;
		this.designation = this.authService.designation;
		this.loadMenus();

		if (this.authService.isDevelopment) {
			this.messageService.clear();
			this.messageService.add({ key: 'app', life: 5000, severity: 'warn', summary: 'Attention', detail: 'This is a Test URL for User Testing. Please don\'t use this for normal Dhruva activities.' });
		} else if (this.authService.isProduction) {
			// this.messageService.add({ key: 'app', severity: 'info', summary: 'Custom Toast', detail: 'With a Gradient' });
		}

		if (!this.isCOISAccess && this.authService.welcomeMessage != undefined) {

			this.welcomeMessage = this.authService.welcomeMessage.split('###');
			document.getElementById('modal-button').click();
		}
	}

	private loadMenus() {
		// this.sideBarInputMenus = this.dataProviderService.loadSideBarInputMenus();
		// this.sideBarMISMenus = this.dataProviderService.loadSideBarMISMenus();
		// this.sideBarLeaderboardMenus = this.dataProviderService.loadSideBarLeaderboardMenus();
		// this.sideBarAuditorMenus = this.dataProviderService.loadSideBarAuditorMenus();
		this.dataProviderService.loadSideBarMenus().subscribe(data => {
			this.sideBarMenus = data;
		}, error => { }, () => { });
	}

	toggleCollapsed(): void {
		this.isExpanded = !this.isExpanded;
	}

	onSignOut() {
		this.authService.logout();
		this.router.navigate(['/signin']);
	}

	onModalFocusOut() {
		// (document.getElementById('video1') as any).pause();
	}

	onRefresh() {
		this.loadMenus();
	}

}
