import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'foColorCode'
})
export class FoColorCodePipe implements PipeTransform {

  transform(value: any, args?: any): any {
    if (value != undefined) {
      if (value <= 150) {
        return "os";
      } else if (value > 100 && value <= 400) {
        return "vg";
      } else {
        return "g";
      }
    }
    return null;
  }

}
