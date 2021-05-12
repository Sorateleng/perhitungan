package stta.gabriel.perhitungan_indst

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edt_pnjg: EditText
    private lateinit var edt_lbr: EditText
    private lateinit var edt_tgi: EditText
    private lateinit var btn_hitung: Button
    private lateinit var hsl: TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        edt_pnjg = findViewById(R.id.edt_pnjg)
        edt_lbr = findViewById(R.id.edt_lbr)
        edt_tgi = findViewById(R.id.edt_tgi)
        btn_hitung = findViewById(R.id.btn_hitung)
        hsl = findViewById(R.id.hsl)

        btn_hitung.setOnClickListener(this)

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            hsl.text = result
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT,hsl.text.toString())
    }
    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_hitung) {
            val inputLength = edt_pnjg.text.toString().trim()
            val inputWidth = edt_lbr.text.toString().trim()
            val inputHeight = edt_tgi.text.toString().trim()

            var isEmptyFields = false

            if (inputLength.isEmpty()) {
                isEmptyFields = true
                edt_pnjg.error = "tidak boleh kosong"

            }

            if (inputHeight.isEmpty()) {
                isEmptyFields = true
                edt_tgi.error = "tidak boleh kosong"
            }

            if (inputWidth.isEmpty()) {
                isEmptyFields = true
                edt_lbr.error = "tidak boleh kosong"
            }


            if (!isEmptyFields) {
                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                hsl.text = volume.toString()
            }
        }
    }
}