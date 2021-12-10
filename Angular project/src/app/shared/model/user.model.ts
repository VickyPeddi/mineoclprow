export class User {
    constructor(
        public userName: string="nanda",
        public password: string="nanda",
        public secret: string,
        public captchaAnswer: string
    ) { }
}