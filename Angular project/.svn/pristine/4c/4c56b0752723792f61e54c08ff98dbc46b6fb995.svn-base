import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'soColorCode'
})
export class SoColorCodePipe implements PipeTransform {

  transform(value: any, args?: any): any {
    if (value != undefined) {
      if (value <= 3) {
        return "os";
      } else if (value > 3 && value <= 12) {
        return "vg";
      } else {
        return "g";
      }
    }
    return null;  }

}
