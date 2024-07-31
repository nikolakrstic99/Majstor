import {BlogStatus} from "./blog";

export class User {
  firstname: string;
  surname: string;
  email: string;
  password: string;
  type: number;//1 - admin, 2 - master
}
