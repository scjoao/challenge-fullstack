import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UploadXmlService {

  urlApi = "http://localhost:8080/process-xml";

  constructor(private http: HttpClient) {
  }

  register(arquivo: File) {
    const formData: FormData = new FormData();
    formData.append('xml', arquivo);
    return this.http.post<string[]>(this.urlApi, formData);
  }
}
