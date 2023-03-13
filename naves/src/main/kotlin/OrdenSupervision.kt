open class OrdenSupervision : Orden {
    var area: Int = (1..20).random()
    var encontrado = ""

    override fun ejecutarOrden() {
        println("Orden ${this.nombre} completada: ")
        var posibles = arrayOf("Animales", "Vegetales", "Radiacion")
        encontrado = posibles[(0..2).random()]
        println("Se ha encontrado en el area $area : $encontrado")
        realizada = true

    }

    constructor(cuadrante: Cuadrante, fecha: String) {
        this.fecha = fecha
        cuadranteDestino = cuadrante
        numero++
        nombre = numero

    }

    override fun mostrarInfo() {
        println("Orden : ${nombre}")
        println("Fecha : $fecha")
        println("Cuadrante destino : ${(cuadranteDestino.nombre)}")
        print("Realizada : ")
        if (realizada) {
            println("Si")
            println("Area : $area")
            println("Hallazgo : $encontrado")
        } else {
            println("No")
            println("Area : $area")
        }


    }

    open fun info() {

    }

    override fun toString(): String {
        return "OrdenSupervision(area=$area, Hallazgo='$encontrado')"
    }
}