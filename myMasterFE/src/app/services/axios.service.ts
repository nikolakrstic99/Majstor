import { Injectable } from '@angular/core';
import axios from "axios";

@Injectable({
  providedIn: 'root'
})
export class AxiosService {

  constructor() {
    axios.defaults.baseURL = 'http://localhost:8080';
    axios.defaults.headers.post['Content-Type'] = 'application/json';
  }

  getAuthToken(): string | null {
    return window.localStorage.getItem("auth_token");
  }

  setAuthToken(token: string | null): void {
    if (token !== null) {
      window.localStorage.setItem("auth_token", token);
    } else {
      window.localStorage.removeItem("auth_token");
    }
  }

  isAdmin():boolean {
    const tokenDecoded = atob(this.getAuthToken().split('.')[1]);
    const jsonToken = JSON.parse(tokenDecoded);
    return jsonToken["status"] === "ADMIN";
  }

  request(method: string, uri: string, data: any): Promise<any> {
    let headers = {};
    if(this.getAuthToken() !== null) {
      headers = {
        Authorization: "Bearer " + this.getAuthToken()
      };
    }
    return axios.request({
      method: method,
      url: uri,
      data: data,
      headers: headers
    });
  }
}
