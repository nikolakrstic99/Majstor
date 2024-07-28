import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class BlogServiceService {

  constructor(private http: HttpClient) {
  }

  uri = 'http://localhost:4000/blog';

  addBlog(heading: string, subHeading: string, details: string, images: string[]) {
    const blog = {
      heading: heading,
      subHeading: subHeading,
      details: details,
      images: images
    };
    return this.http.post(`${this.uri}/add`, blog);
  }

  getAll() {
    const data = {}
    return this.http.get(`${this.uri}/getAll`, data);
  }
}
