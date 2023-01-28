import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class PaisService {

  private url = environment.url;
  private headers: HttpHeaders = new HttpHeaders({
    "content-type": "application/json"
  })

  constructor(private http: HttpClient) {}

  public getAllPais() {
    return this.http.get<any>(`${this.url}pais`)
  }

  PostPutPais(val: any, id: any) {
    if (id != null && id != undefined) {
      return this.http.put(this.url + '/pais/?id='+id, JSON.stringify(val), {headers: this.headers})
    } else {
      return this.http.post(this.url + '/pais', JSON.stringify(val), {headers: this.headers})
    }
  }

  DeletePais(val: any) {
    return this.http.delete(this.url + '/pais/?id=' + val)
  }
}
