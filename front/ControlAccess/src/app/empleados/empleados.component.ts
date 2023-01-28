import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PageEvent } from '@angular/material/paginator';
import { PaisService } from '../pais/pais.service';

import { EmpleadosService } from './empleados.service';

@Component({
  selector: 'app-empleados',
  templateUrl: './empleados.component.html',
  styleUrls: ['./empleados.component.css']
})
export class EmpleadosComponent implements OnInit {

  public empleados: any = [];
  public paises: any = [];
  empleadosPag: any = [];
  public pageSize=4;
  page = 1;
	collectionSize = this.empleados.length;
  form!: FormGroup;


  constructor(
   private empleadoService : EmpleadosService,
   private paisServcice : PaisService,

   private _formBuilder: FormBuilder,
  ) { }

  ngOnInit(): void {
      this.getEmpleado()
      this.paisServcice.getAllPais().subscribe(data => {
        this.paises = data
      })

    this.buildForm()
  }

  getEmpleado(){
    this.empleadoService.getAllEmpleado().subscribe(data => {
      this.empleados = data
      this.refreshEmpleados(1)
      })
  }

  buildForm() {
    this.form = this._formBuilder.group({
      id: [null],
      primerApellido : [null , [Validators.required]],
      primerNombre : [null , [Validators.required]],
      otrosNombres : [null ],
      pais : [null, [Validators.required]]
    })
  }

  delete(id : any){
    this.empleadoService.DeleteEmpleado(id).subscribe(data => {
      this.getEmpleado()
    })
    
  }

  save(){
    console.log(this.form.value);
    this.empleadoService.PostPutEmpleado(this.form.value,this.form.controls['id'].value).subscribe(data => {
        alert("guardo")
        this.getEmpleado()
        this.form.controls['id'].setValue(0)

      })

    }

    editar(data : any) {
      console.log(data);
      this.form = this._formBuilder.group({
        id: [data.id],
        primerApellido : [data.primerApellido , [Validators.required]],
        primerNombre : [data.primerNombre , [Validators.required]],
        otrosNombres : [data.otrosNombres],
        pais : [data.paisId.id, [Validators.required]]
      })
    }

    refreshEmpleados(page : number ) {
      let paginas = Math.round(this.empleados.length / this.pageSize)
      if( page > 0  && page <= paginas) {
        this.page = page;
        this.empleadosPag = this.empleados.map( (empleado : any) => ( empleado )).slice(
        (this.page - 1) * this.pageSize,
        (this.page - 1) * this.pageSize + this.pageSize,
        );
      }
    }


}
