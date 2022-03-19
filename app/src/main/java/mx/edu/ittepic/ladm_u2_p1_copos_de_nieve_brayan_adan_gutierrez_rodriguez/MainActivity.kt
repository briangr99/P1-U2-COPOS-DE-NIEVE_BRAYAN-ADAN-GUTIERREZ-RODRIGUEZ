package mx.edu.ittepic.ladm_u2_p1_copos_de_nieve_brayan_adan_gutierrez_rodriguez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(Lienzo(this))
    }
}