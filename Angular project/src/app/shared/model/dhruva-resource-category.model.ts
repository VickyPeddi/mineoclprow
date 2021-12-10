import { DhruvaResourceFile } from './dhruva-resource-file.model';

export class DhruvaResourceCategory {
	constructor(
		public categoryId: number,
		public categoryName: string,
		public activeFlag: string,
		public resourceFiles: DhruvaResourceFile[]) {
	}
}