import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
	name: 'fitTrackerStatus'
})
export class FitTrackerStatusPipe implements PipeTransform {

	transform(value: any, args?: any): any {
		// return value == 100 ? 'Pending with Field Officer' : value == 200 ? 'Pending with Division Officer' : 'Approved';
		return value == 100 ? 'Pending with Field Officer' : 'Approved';
	}

}
