import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'doColorCode'
})
export class DoColorCodePipe implements PipeTransform {

  transform(value: any, args?: any): any {
    if (value != undefined) {
      if (value <= 15) {
        return "os";
      } else if (value > 15 && value <= 55) {
        return "vg";
      } else {
        return "g";
      }
    }
    return null;
  }

}
