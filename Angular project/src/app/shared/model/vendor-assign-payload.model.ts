export class VendorAssignPayload {
	constructor(
		public vendorCode: number,
		public auditType: string,
		public auditYear: string,
		public auditQuarter: string,
		public startDate: string,
		public endDate: string,
		public roList: number[]) {
	}
}