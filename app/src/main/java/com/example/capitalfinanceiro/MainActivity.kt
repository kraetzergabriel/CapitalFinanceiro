package com.example.capitalfinanceiro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import androidx.appcompat.app.AlertDialog
import com.example.capitalfinanceiro.classes.Calc

class MainActivity : AppCompatActivity() {

    private lateinit var button : Button;
    private lateinit var edCapital : EditText;
    private lateinit var edTaxa : EditText;
    private lateinit var sbMeses : SeekBar;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.button = findViewById(R.id.btCalcular)
        this.edCapital = findViewById(R.id.edCapital)
        this.edTaxa = findViewById(R.id.edTaxaJuros)
        this.sbMeses = findViewById(R.id.sbMeses)

        button.setOnClickListener(){
            var valorFuturo = Calc( edTaxa.text.toString().toDouble(),
                                    edCapital.text.toString().toDouble(),
                                    sbMeses.progress).calc()

            AlertDialog.Builder(this)
                .setTitle(R.string.valorFuturo)
                .setMessage(String.format("%.2f",valorFuturo))
                .setPositiveButton(R.string.btOk) { dialog, which ->
                    dialog.dismiss()
            }
        }
    }
}
