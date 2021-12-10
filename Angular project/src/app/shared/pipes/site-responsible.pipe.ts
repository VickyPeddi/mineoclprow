import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'siteResponsible'
})
export class SiteResponsiblePipe implements PipeTransform {

  transform(value: any, args?: any): string {

    let responsible: string;

    if (value === 'I') {
      responsible = 'IOCL';
    } else if (value === 'D') {
      responsible = 'Dealer';
    } else if (value === 'N') {
      responsible = 'None';
    }
    return '' + responsible + '';
  }

}
