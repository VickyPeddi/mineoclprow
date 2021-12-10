export class TrackerRoMaster {
	constructor(
		public auditNo: number,
		public roCode: number,
		public roName: string,
		public planStartDate: string,
		public salesAreaName: string,
		public salesArea: string,
		public salesOffName: string,
		public location: string,
		public actualAuditDate: string
	) { }
}