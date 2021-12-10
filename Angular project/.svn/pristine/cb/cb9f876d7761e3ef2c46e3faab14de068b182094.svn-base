import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, JsonpInterceptor } from '@angular/common/http';

import { Observable, BehaviorSubject } from 'rxjs';
import { map } from "rxjs/operators";
import { environment } from '../../environments/environment';
import { Router, NavigationStart } from '@angular/router';

@Injectable()
export class AuthService {

	empCode: number;
	empName: string;
	designation: string;
	employeeDhruvaRODatas: string[];
	//Following values are being used dashboard's views
	dashBoardSoName: string;
	dashBoardDoName: string;
	dashBoardSaName: string;
	archetypeWiseSpotCheckModuleNumbers: any;
	spotcheckQuestions: any;
	userLevel: string;
	locInFlag: string;
	public accessTokenSubject: BehaviorSubject<string>;
	public accessToken: string;
	// public maxAuditCount: number;
	sessionId: number;
	isDevelopment: boolean;
	isProduction: boolean;
	isCOISLogin: boolean = false;
	welcomeMessage: string;

	constructor(private http: HttpClient, private router: Router) {
		// this.accessTokenSubject = new BehaviorSubject<string>(localStorage.getItem('accessToken'));
		// this.accessTokenSubject = new BehaviorSubject<string>(this.accessToken);

		// this.accessToken = this.accessTokenSubject.asObservable();
	}

	// public get accessTokenValue(): any {
	//     // return this.accessTokenSubject.value;
	// }

	login(username: string, password: string, secret: string, captchaAnswer: string) {
		const httpOptions = {
			headers: new HttpHeaders({ 'Content-Type': 'application/json;charset=UTF-8' })
		};

		let i: number;
		let zeros: string;
		if (username.length < 8) {
			zeros = "";
			i = 8 - username.length;
			while (i-- > 0) {
				zeros += "0";
			}
			username = zeros + username;
		}

		return this.http.post<any>(`${environment.backEndUrl}/auth/generatetoken`,
			'{ "username": "' + username + '", "password": "' + password + '", "secret": "' + secret + '", "captchaAnswer": "' + captchaAnswer + '" } ', httpOptions)
			.pipe(map(user => {
				// login successful if there's a jwt token in the response
				if (user && user.accessToken) {
					// store user details and jwt token in local storage to keep user logged in between page refreshes
					this.accessToken = user.accessToken;
					this.empCode = user.empCode;
					this.empName = user.empName;
					// this.accessTokenSubject.next(user);
					this.designation = user.designation;
					this.employeeDhruvaRODatas = user.roList;
					this.archetypeWiseSpotCheckModuleNumbers = user.archetypeWiseSpotCheckModuleNumber;
					this.spotcheckQuestions = user.spotcheckQuestions;
					this.dashBoardSoName = user.soName;
					this.dashBoardDoName = user.doName;
					this.dashBoardSaName = user.saName;
					this.userLevel = user.userLevel;
					this.locInFlag = user.locInFlag;
					// this.maxAuditCount = user.maxAuditCount;
					this.sessionId = user.sessionId;
					this.isDevelopment = user.development;
					this.isProduction = user.production;
					this.isCOISLogin = false;
					this.welcomeMessage = user.welcomeMessage;
					// localStorage.setItem('accessToken', user.accessToken);
					// localStorage.setItem("empCode", user.empCode);
					// localStorage.setItem("empName", user.empName);
					// localStorage.setItem("designation", user.designation);
				}
				return user;
			}));
	}

	// loadROData(): Observable<any> {
	//     return this.http.get(`${environment.backEndUrl}/employee`);
	// }

	logout() {
		localStorage.clear();
		// this.accessTokenSubject.next(null);
		this.clearParameters();
		this.router.navigate(['/signin']);
	}

	clearParameters() {
		this.http.get(`${environment.backEndUrl}/auth/log-out/${this.sessionId}`).subscribe(
			// data => console.log(data)
		);
		this.empCode = null;
		this.accessToken = null;
		this.accessTokenSubject = null;
		this.designation = null;
		this.empName = null;
		this.employeeDhruvaRODatas = null;

	}
}