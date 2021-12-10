import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import Dexie from 'dexie';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

declare const window: any;

@Injectable()
export class NetworkStatusService {

    private db: any;

    private networkStateChanged = new Subject<boolean>();

    constructor(private http: HttpClient) {
        this.createDatabase();
        window.addEventListener('online', () => {
            this.updateNetworkState();
            // this.db.telcad.each(data => {
            //     this.syncToBackEnd(data)
            // }).then(() => {
            //     console.log('all done finally');
            // }).catch(error => {
            //     console.log(error);
            // });
        });
        window.addEventListener('offline', () => {
            this.updateNetworkState();
        });
    }

    get isNetworkStateChanged() {
        return this.networkStateChanged.asObservable();
    }

    get isOnline() {
        return !!window.navigator.onLine;
    }

    private updateNetworkState() {
        this.networkStateChanged.next(this.isOnline);
    }

    private createDatabase() {
        this.db = new Dexie('dhruva2-spotcheck');
        this.db.version(1).stores({
            spotcheck: '++id, data'
        })
    }

    // private syncToBackEnd(data: any) {
    //     const httpOptions = {
    //         headers: new HttpHeaders({ 'Content-Type': 'application/json;charset=UTF-8' })
    //     };

    //     this.http.post(`${environment.backEndUrl}/telecall/save-telecall-index`, data.data, httpOptions)
    //         .subscribe(msg => {
    //             console.log("Successfully Saved data to Back-End: " + msg);
    //             this.db.telcad.delete(data.id).then((deleteCount) => {
    //                 console.log("Deleted " + deleteCount + " objects")
    //             })
    //         }, error => {
    //             console.log('error occurred while saving data to Back-End');
    //         });
    // }
}