export class AuditMaster {
    constructor(
        public auditNo : number,
        public roCode : number,
        public roName : string,
        public actualAuditDate : string,
        public salesAreaName : string,
        public salesOffName : string,
        public soName : string,
        public location : string
    ) { }
}