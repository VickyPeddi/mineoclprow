import { ValidatorFn, AbstractControl } from '@angular/forms';
import * as moment from 'moment';

export function PresentFutureDateValidator(): ValidatorFn {
    return (control: AbstractControl): { [key: string]: any } | null => {

        return moment().diff(moment(control.value, 'YYYY-MM-DD'), 'days') > 0 ? { 'pastDate': { value: control.value } } : null;
    };
}