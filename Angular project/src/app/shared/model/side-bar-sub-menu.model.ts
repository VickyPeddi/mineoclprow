import { SideBarMISMenuItem } from './side-bar-mis-menu-item.model';

export class SideBarSubMenu {
	constructor(public subMenuId: number,
		public menuId: number,
		public subMenuName: string,
		public routePath: any,
		public accessCount: number,
		public newFlag: number,
		public menuItems: SideBarMISMenuItem[]) {

	}
}