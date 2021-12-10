export class FOAuditMaster {
    constructor(
        public auditNo : number,
        public roCode : number,
        public roName : string,
        public auditSubmissionDate : string,
        public salesAreaName : string,
        public salesOffName : string,
        public soName : string,
        public location : string
    ) { }
}