import {BlogStatus} from "./blog";

export class User {
  firstName: string;
  lastName: string;
  email: string;
  password: string;
  type: number;//1 - admin, 2 - master
}
