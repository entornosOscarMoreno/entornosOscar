fun main(args: Array<String>) {
    //Oscar Moreno
    var tamaño = 3
    var capacidad = 200
    var tet = Tet(capacidad)
    var tierra = Array(tamaño) { Array<Cuadrante>(tamaño) { Cuadrante() } }
    var segundo = 0

    generarTierra(tierra, tamaño, tet)
    tet.primerEnvio(tierra)
    println("Se ha completado el primer envio de drones a la tierra")
    while (segundo < 40) {
        if (segundo % 4 == 0) {
            recorrerTierra(tierra, tamaño)
        }
        if (segundo % 10 == 0) {
            var i = 0
            println()
            tet.trabaja(tierra, tamaño, segundo.toString())
            println()
        }
        if (segundo % 20 == 0) {
            println()
            revisionTierra(tierra, tamaño)
            println()
        }
        segundo++

    }
    resumenFinal(tet, tierra, tamaño)


}

fun generarTierra(tierra: Array<Array<Cuadrante>>, tamaño: Int, tet: Tet) {
    var x = 0
    while (x < tamaño) {
        var y = 0
        while (y < tamaño) {
            var c = Cuadrante(x, y, tet)
            tierra[x][y] = c
            y++
        }
        x++
    }

}

fun revisionTierra(tierra: Array<Array<Cuadrante>>, tamaño: Int) {
    var x = 0

    while (x < tamaño) {
        var y = 0
        while (y < tamaño) {
            var c = tierra[x][y]
            c.resuelveOrdenes()
            y++
        }
        x++
    }
}

fun recorrerTierra(tierra: Array<Array<Cuadrante>>, tamaño: Int) {
    var i = 0
    while (i < tamaño) {
        var i2 = 0
        while (i2 < tamaño) {
            tierra[i][i2].recorrerCuadrante()
            i2++
        }
        i++
    }

}

fun resumenFinal(tet: Tet, tierra: Array<Array<Cuadrante>>, tamaño: Int) {
    println()
    println("RESUMEN FINAL:")
    println()

    tet.info()
    var x = 0
    while (x < tierra.size) {
        println()
        var y = 0
        while (y < tamaño) {
            var c = tierra[x][y]
            c.resumen()
            y++
        }
        println()
        x++
    }

}

