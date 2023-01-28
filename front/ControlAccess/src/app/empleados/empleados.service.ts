import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment.prod';
import { Observable } from 'rxjs';
import { Pais } from "../Model/Pais";

@Injectable({
  providedIn: 'root'
})
export class EmpleadosService {

  private url = environment.url;
  private headers: HttpHeaders = new HttpHeaders({
    "content-type": "application/json"
  })

  constructor(private http: HttpClient) {}

  public getAllEmpleado() {
    return this.http.get<any>(`${this.url}empleado`)
  }

  PostPutEmpleado(val: any, id: any) {

    let pais : Pais = {id : val.pais , nombre : ""}
    let data = {
      paisId : pais,
      ...val
    }

    if (id != null && id != undefined) {
      return this.http.put(this.url + 'empleado/'+id, data)
    } else {
      return this.http.post(this.url + 'empleado', data)
    }
  }

  DeleteEmpleado(id: any) {
    return this.http.delete(this.url + 'empleado/'+id)
  }
}