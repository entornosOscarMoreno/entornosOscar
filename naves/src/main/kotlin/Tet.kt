class Tet {

    var almacenDrones=ArrayList<Dron>(0)
    var listaOrdenes=ArrayList<Orden>()

    fun crearAlmacen(max:Int){
        while (almacenDrones.size!=max){
            var d=Dron()
            almacenDrones.add(d)
        }

    }
    constructor()
    constructor(capacidad:Int){
        crearAlmacen(capacidad)
    }

    fun enviarDron():Dron {

            var dronEnviar = almacenDrones[0]
            almacenDrones.removeAt(0)
            println("Dron enviado")
            println("Drones disponibles: "+almacenDrones.size)
            return dronEnviar

    }

    fun compruebaAlmacen():Boolean{
        if (almacenDrones.isEmpty()){
            println("El almacen de drones esta vacio")
        }else{
            println("Hay disponibles "+almacenDrones.size+" drones")
        }
        return almacenDrones.isNotEmpty()
    }
    fun generarOrden(cuadrante: Cuadrante,dron: Dron,fecha:String):OrdenReparacion{
               var orden = OrdenReparacion(cuadrante,dron,fecha)
        println("Se ha generado una orden de reparacion")
                listaOrdenes.add(orden)
               return orden
    }
    fun generarOrden(cuadrante: Cuadrante,fecha:String):OrdenSupervision{
        var orden = OrdenSupervision(cuadrante,fecha)
        listaOrdenes.add(orden)
        println("Se ha generado una orden de supervision")
        return orden
    }
    fun enviarOrden(cuadrante:Cuadrante,orden: Orden){
        cuadrante.añadirOrden(orden)
        println(" Se ha enviado la orden ${orden.nombre} al cuadrante ${cuadrante.nombre}")
    }
    fun trabaja(tierra:Array<Array<Cuadrante>>,tamaño:Int,fecha:String){
        var x=0
        var max=10
        var min=5
        println("El tet va en busca de drones estropeados")
        println()
        while (x<tamaño){
            var y=0

            while (y<tamaño){
                println()
                println("El tet va revisar el cuadrante ${x+1}, ${y+1}")
                var c=tierra[x][y]
                revisarDrones(c,fecha)
                y++
                println()
            }
            x++
        }

        var ordenesDeSupervision=(min..max).random()
        while (ordenesDeSupervision!=0){
            var c=tierra[(0..(tamaño-1)).random()][(0..(tamaño-1)).random()]
          var o=generarOrden(c,fecha)
            enviarOrden(c,o)
            ordenesDeSupervision--
        }

    }
    fun revisarDrones(cuadrante: Cuadrante,fecha: String){
        var n=0
        println("En este cuadrante hay ${cuadrante.dimeNDrones()} drones")
        println("Revisando drones")
        var i =0
        while (i<cuadrante.dimeNDrones()){
            var d=cuadrante.dameDron(i)
            if (d.dimeEstado()){
                println("No hay que repararlo")
            }else{
                println("Se ha detectado un dron inactivo")
                var o=generarOrden(cuadrante, d,fecha)
                enviarOrden(cuadrante,o)
                n++
            }
            i++
        }
        println("Se han detectado en total $n dron/es inactivos en este cuadrante")
    }

    fun recorrerTierra(tierra: Array<Array<Cuadrante>>, tamaño: Int){
        var i=0
        while (i<tamaño){
            var i2=0
            while (i2<tamaño){
                tierra[i][i2].recorrerCuadrante()
                i2++
            }
            i++
        }
    }

fun primerEnvio(tierra:Array<Array<Cuadrante>>){
    var i=0
    while (i<tierra.size){

        var i2=0
        while (i2<tierra[i].size){
            var n=(1..3).random()
            println("Se han asignado $n dron/es al cuadrante ${i+1}, ${i2+1}")
            while (n!=0){
                tierra[i][i2].añadirDron(enviarDron())
            n--
            }
            i2++
        }
        i++
    }
}
fun contarOrdenes(t:Int):Int{
    var n=0
    var i=0
    when (t){
        1->{
            while (i<listaOrdenes.size){
                if (listaOrdenes[i].realizada){
                    n++
                }
                i++
            }
        }
        2->{
            while (i<listaOrdenes.size){
                if (!listaOrdenes[i].realizada){
                    n++
                }
                i++
            }
        }
    }
    return n
}
    fun info(){
        println("Cantidad de drones en el almacen : ${almacenDrones.size}")
        println("Ordenes Totales asignadas : ${listaOrdenes.size}")
        println("Ordenes realizadas :"+contarOrdenes(1))
        println("Ordenes pendientes :"+contarOrdenes(2))
    }
}