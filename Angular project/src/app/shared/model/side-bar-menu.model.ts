import { SideBarSubMenu } from './side-bar-sub-menu.model';

export class SideBarMenu {
	constructor(public menuId: number,
		public menuName: string,
		public routePath: string,
		public accessCount: number,
		public newFlag: number,
		public subMenus: SideBarSubMenu[]) {

	}
}