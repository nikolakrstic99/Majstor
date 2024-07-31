import {Injectable} from '@angular/core';
import {AxiosService} from "./axios.service";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private axiosService: AxiosService) {
  }

  data: string[] = [];

  login(username: string, password: string) {
    const data = {
      username: username,
      password: password
    }
    return this.axiosService.request("POST", "/login", (data));
  }
}
