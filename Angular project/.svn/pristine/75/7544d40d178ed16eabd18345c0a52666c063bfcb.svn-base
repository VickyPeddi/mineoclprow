import { Component, ElementRef, OnInit } from '@angular/core';
import { NetworkStatusService } from './shared/network-status.service';
import * as $ from 'jquery';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  title = 'dhruva2-ng7-app';

  constructor(private readonly networkStatus: NetworkStatusService,private _elementRef: ElementRef) {
    this.registerToEvents(this.networkStatus);
  }


  ngOnInit() {
    this._elementRef.nativeElement.removeAttribute("ng-version");

    // this.appUpdateService.queryAppplicationVersion();
    // window.addEventListener("beforeunload", function (e) {
    //   var confirmationMessage = "\o/";
    //   e.returnValue = confirmationMessage;     // Gecko, Trident, Chrome 34+
    //   return confirmationMessage;              // Gecko, WebKit, Chrome <34
    // });
    if (top !== self) {
      top.location = self.location;
      location.reload();
    }
    $(function () {
      window.history.pushState(null, "", window.location.href);
      window.onpopstate = function () {
        window.history.pushState(null, "", window.location.href);
      };
    });
    this._elementRef.nativeElement.removeAttribute("ng-version");
  }

  private registerToEvents(networkStatus: NetworkStatusService) {
    networkStatus.isNetworkStateChanged.subscribe(
      online => {
        if (online) {
          console.log('back online');
        } else {
          console.log('went offline'); 
        }
      }
    )
  }
}
