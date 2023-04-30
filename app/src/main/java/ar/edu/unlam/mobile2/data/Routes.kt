package ar.edu.unlam.mobile2.data

sealed class Routes(val route:String){
    object PantallaInicio:Routes("PantallaInicio")
    object PantallaPelea:Routes("PantallaPelea")
    object PantallaColeccionable:Routes("PantallaColeccionable")

}