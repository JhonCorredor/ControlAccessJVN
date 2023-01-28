import { Pais } from "./Pais";

export interface Empleado{
    
    id:number,
    primerNombre:string,
    primerApellido:string,
    otrosNombres:string,
    paisId : Pais
}
