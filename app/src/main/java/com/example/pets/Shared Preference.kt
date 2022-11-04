package com.example.pets

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class SharedPreference : AppCompatActivity() {
    var etnPets: AdminSQLitePets? = null
    lateinit var etEspecie:EditText
    lateinit var etnSexo : EditText
    lateinit var etnHabitada : EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etnPets = findViewById<AdminSQLitePets>()
        etEspecie = findViewById(R.id.et_Especie)
        etnSexo = findViewById(R.id.etn_Sexo)
        etnHabitada = findViewById(R.id.etn_Habitada)

        var pref = getSharedPreferences("_datosPets", MODE_PRIVATE)

        var Pets = pref.getString("Pets","")
        var Especie = pref.getString("Especie","")
        var etnPet1 = etnPets
        etEspecie.setText(etEspecie)
        )

    }

    private fun <T> findViewById(): AdminSQLitePets? {
        TODO("Not yet implemented")
    }

    fun guardar(vista: View){
        var pref = getSharedPreferences(" datos Pets", Context.MODE_PRIVATE)
        var editor = pref.edit()

        editor.putString("apellido",etnPets.toString())
        editor.putString("apellido",etEspecie.text.toString())
        editor.putString("apellido",etnSexo.text.toString())
        editor.putString("apellido",etnHabitada.text.toString())



        editor.commit()
        Toast.makeText(this, "Se ha guardado exitosamente", Toast.LENGTH_LONG).show()
    }
}

private fun View.setText(etnPet: View?) {

}



}
