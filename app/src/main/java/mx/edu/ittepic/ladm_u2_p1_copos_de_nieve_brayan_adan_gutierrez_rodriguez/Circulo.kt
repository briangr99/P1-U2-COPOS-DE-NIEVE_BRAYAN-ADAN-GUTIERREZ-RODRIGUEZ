package mx.edu.ittepic.ladm_u2_p1_copos_de_nieve_brayan_adan_gutierrez_rodriguez



import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import kotlin.random.Random


class Circulo(l:Lienzo) {
    var tamanobola = 0
    val l = l
    var x = 0f
    var y = 0f
    var y2 = 0f
    var y3 = 0f
    var movX = 0f
    var movY = 0f
    var rapi = 0f
    var color = Color.WHITE
    var velocidad = 0f


    init {
        x = rand(720)
        y = rand2(0, 1000)
        y2 = rand2(0, 10)
        y3 = rand2(0, 10)
        //movX = rand(6)+2
        //movY = rand(6)+2
        //  movX = rand(1)+10
        movY = rand(3) + velocidad// VELOCIDAD DE LA BOLITA
        rapi = rand(3) + velocidad

        ///COLORES DE MIS BOLAS
        //color =Color.rgb(rand(255).toInt(), rand(255).toInt(),rand(255).toInt())
        //color =Color.argb(rand(255).toInt(),rand(255).toInt(), rand(255).toInt(),rand(255).toInt())
        color = Color.argb(rand(255).toInt(), 255, 255, 255)

    }

    private fun rand(hasta: Int): Float {
        return Random.nextInt(hasta).toFloat()
    }

    private fun rand2(desde: Int, hasta: Int): Float {
        return Random.nextInt(desde, hasta).toFloat()
    }

    fun mover() {
        // x+=movX
        y += movY + velocidad
        y2 += movY + velocidad

        rapi = velocidad

        if (y < -10 || y > l.height - tamanobola) {
            y = rand(100) + 10
        }

        if (rapi.toInt() < 20) {
            tamanobola = 4
        } else if (rapi.toInt() > 20 && rapi.toInt() < 40) {
            tamanobola = 5
        } else if (rapi.toInt() > 60) {
            tamanobola = 10
        }

    }

    fun pintar(canvas: Canvas) {
        var p = Paint()
        p.color = color
        canvas.drawCircle(x, y, tamanobola.toFloat(), p)
    }

    fun pintar2(canvas: Canvas) {
        // y2=+y2+rand2(100,200)
        if (y < 10) {
            y2 + 20+rand(5)
            x +40+ rand2(10,15)
            var p = Paint()
            p.color = color
            canvas.drawCircle(x, y2, tamanobola.toFloat(), p)
        }
    }

    fun pintar3(canvas: Canvas) {
        // y2=+y2+rand2(100,200)
        //if (y < 10) {
            y3 =y+15+rand2(10,15)
        x +15+ rand2(5,10)
            var p = Paint()
            p.color = color
            canvas.drawCircle(x, y3, tamanobola.toFloat(), p)
        //}
    }
    fun llenar(canvas: Canvas) {
        var p = Paint()
        p.color = color
        canvas.drawCircle(x, 1300f, 60f, p)
        //}
    }
    fun llenar2(canvas: Canvas) {
        var p = Paint()
        p.color =Color.WHITE
        canvas.drawCircle(x, 1200f, 60f, p)
        //}
    }

    fun llenar3(canvas: Canvas) {
        var p = Paint()
        p.color =Color.WHITE
        canvas.drawCircle(x, 1100f, 80f, p)
        //}
    }
}
