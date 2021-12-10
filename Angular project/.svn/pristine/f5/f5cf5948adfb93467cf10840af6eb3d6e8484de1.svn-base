import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { AuthService } from './auth.service';

@Injectable()
export class AuthGuard implements CanActivate {

	constructor(private authService: AuthService, private router: Router) { }

	canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {

		const accessToken = this.authService.accessToken;
		// if (localStorage.getItem("accessToken")) {
		if (accessToken !== "" && accessToken != null) {
			return true;
		}

		this.router.navigate(['/signin'], { queryParams: { continue: state.url } });
		return false;
	}
}