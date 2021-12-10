import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Title, DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { Observable } from 'rxjs';
import { first } from 'rxjs/operators';
import { User } from 'src/app/shared/model/user.model';
import { environment } from 'src/environments/environment';
import { DataProviderService } from '../../shared/data-provider.service';
import { AuthService } from '../auth.service';
import * as JsEncryptModule from 'jsencrypt';


@Component({
	selector: 'app-signin',
	templateUrl: './signin.component.html',
	styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

	user: User = new User('', '', '', '');

	captchaImage: SafeResourceUrl;

	message: string = '';
	redirectURL: string;
	error = '';
	buttonDisable: boolean = false;
	healthInfo: Observable<string>;
	assetUrl: any = environment.assetUrl;
	version: string;
	validMagic: string;

	constructor(protected title: Title, protected router: Router, protected authService: AuthService,
		protected dataProviderService: DataProviderService, private route: ActivatedRoute, private messageService: MessageService, private sanitizer: DomSanitizer) {

		title.setTitle('Sign In - Dhruva 2.0');



		this.dataProviderService.loadCaptcha().subscribe(data => {
			this.user.secret = data.secret;
			this.captchaImage = sanitizer.bypassSecurityTrustResourceUrl('data:image/jpeg;base64, ' + data.captchaImage);

			this.validMagic = data.validMagic;
		}, error => {
			console.error(error);
		}, () => { });

	}

	ngOnInit() {
		this.healthInfo = this.dataProviderService.healthStatus;


		// reset login status
		// this.authService.logout();

		// if (localStorage.getItem('accessToken') != undefined || localStorage.getItem('accessToken') !== '') {
		//   this.router.navigate(['/home']);
		// }
		if (this.authService.accessToken != undefined || this.authService.accessToken !== null) {
			this.router.navigate(['/home/dashboard/state-office/master-dashboard']);
		}
		// get return url from route parameters or default to '/'
		this.redirectURL = this.route.snapshot.queryParams['continue'] || '/home/dashboard/state-office/master-dashboard';
	}

	// performRitual() {
	// 	this.user.password = btoa(this.user.password);
	// }
	enteredPassword: string = '';
	
	// doKeyMagic() {
	// 	this.enteredPassword = this.user.password.length<1?'': this.enteredPassword.concat(this.enteredPassword.length==this.user.password.length?'': this.user.password.substring(this.user.password.length-1));
	// 	console.log(this.enteredPassword);	
	// }

	onSignIn(form: NgForm) {
		this.buttonDisable = true;
		if (form.invalid) {
			this.buttonDisable = false;
			this.messageService.clear('sign');
			this.messageService.add({ key: 'sign', severity: 'error', summary: 'Error', detail: 'Incomplete details provided, Please try again!' });
			return false;
		}

		var encrypt = new JsEncryptModule.JSEncrypt();
		encrypt.setPublicKey(this.validMagic);
		this.user.password = encrypt.encrypt(this.user.password);
		this.authService.login(this.user.userName, this.user.password, this.user.secret, this.user.captchaAnswer).pipe(first())
			.subscribe(
				data => {
					this.buttonDisable = false;

					if (this.authService.dashBoardSaName != undefined) {
						this.redirectURL = "/home/dashboard/sales-area/master-dashboard"
					} else if (this.authService.dashBoardDoName != undefined) {
						this.redirectURL = "/home/dashboard/division-office/master-dashboard"
					}
					this.router.navigate([this.redirectURL]);
				},
				error => {
					this.buttonDisable = false;
					this.messageService.clear('sign');
					this.messageService.add({ key: 'sign', severity: 'error', summary: 'Sign-in failed', detail: error });
					this.error = error;
					return false;
				});
	}
}
