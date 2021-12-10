import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'colorCode'
})
export class ColorCodePipe implements PipeTransform {

  transform(value: any, args?: any): any {

    if (value != undefined) {
      if (value < 35) {
        return "below35";
      } else if (value >= 35 && value < 70) {
        return "between35to70";
      } else {
        return "above70";
      }
    }
    return null;
  }

}
