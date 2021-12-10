import { FormGroup, ValidatorFn, AbstractControl } from '@angular/forms';
import * as moment from 'moment';

export function FromToDateCompareValidator(fromControlName: string, toControlName: string): ValidatorFn {
	return (control: AbstractControl): { [key: string]: boolean } => {
		const fromControl = control.get(fromControlName)
		const toControl = control.get(toControlName)

		if (fromControl.errors || toControl.errors) {
			return;
		}

		if (moment(toControl.value, 'YYYY-MM-DD').diff(moment(fromControl.value, 'YYYY-MM-DD'), 'days') > 1095) {
			toControl.setErrors({ mustComply: true });
		} else {
			toControl.setErrors(null);
		}
	}
}