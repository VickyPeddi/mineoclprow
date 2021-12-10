import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from '../auth/auth.service';
import { LoaderService } from '../loader/loader.service';


@Injectable()
export class JWTInterceptor implements HttpInterceptor {

  constructor(private authService: AuthService, private loaderService: LoaderService) { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    let currentUser = this.authService.accessToken;
    
    // if (currentUser && localStorage.getItem('empCode')) {
    if (currentUser && this.authService.empCode) {
      request = request.clone({
        setHeaders: {
          // Authorization: `Bearer ${localStorage.getItem('accessToken')}`,
          Authorization: `Bearer ${currentUser}`,
          // 'X-Auth-User': `${localStorage.getItem('empCode')}`
          'X-Auth-User': `${this.authService.empCode}`

        }
      });
    }
    this.onEnd();
    return next.handle(request);
  }

  private onEnd(): void {
    this.hideLoader();
  }
  private showLoader(): void {
    this.loaderService.show();
  }
  private hideLoader(): void {
    this.loaderService.hide();
  }
}