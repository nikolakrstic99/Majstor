import {Injectable} from '@angular/core';
import {AxiosService} from "./axios.service";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private axiosService: AxiosService) {
  }

  data: string[] = [];

  login(email: string, password: string) {
    const data = {
      username: email,
      password: password
    }
    return this.axiosService.request("POST", "/login", (data));
  }
}
