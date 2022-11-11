package com.example.pets

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

@Suppress("UNUSED_LAMBDA_EXPRESSION")
class MainActivity : AppCompatActivity() {
    private lateinit var etnPets: EditText
    private lateinit var etEspecie: EditText
    private lateinit var etnSexo: EditText
    private lateinit var etnHabitada: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etnPets = findViewById(R.id.etn_Pets)
        etEspecie = findViewById(R.id.et_Especie)
        etnSexo = findViewById(R.id.etn_Sexo)
        etnHabitada = findViewById(R.id.etn_Habitada)
    }

    fun registrar(vista: View) {
        //se crea la conexion a las base de datos
        val admin = AdminSQLitePets(this, "Tienda Online", null, 1)
        val baseDeDatos: SQLiteDatabase = admin.writableDatabase

        val Pets = etnPets.text.toString()
        val Especie = etEspecie.text.toString()
        val Sexo = etnSexo.text.toString()
        val Habitada = etnHabitada.text.toString()

        if (!Pets.isEmpty() && !Especie.isEmpty() && !Sexo.isEmpty() && !Habitada.isEmpty()) {
            //codigoPets.toInt()
            //Especie.toDouble()
            val registro = ContentValues()
            val codigoPets = "codigoPets"

            registro.put("codigoPets", codigoPets)
            registro.put("Especie", Especie)
            registro.put("Sexo", Sexo)
            registro.put("Habitada", Habitada)

            baseDeDatos.insert(" Pets ", null, registro)
            baseDeDatos.close()
            etnPets.setText("")
            etEspecie.setText("")
            etnSexo.setText("")
            etnHabitada.setText("")

            Toast.makeText(this, "Registro Pets exitoso", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun buscar(vista: View) {
        //se crea la conexion a las base de datos
        val admin = AdminSQLitePets(this, "Tienda Online", null, 1)
        val baseDeDatos: SQLiteDatabase = admin.writableDatabase

        val codigoPets = etnPets.text.toString()

        if (!codigoPets.isEmpty()) {
            //verificar si esta el codigo Pets
            val CodigoPet = "CodigoPet"
            val fila = baseDeDatos.rawQuery(
                "select Pet, Especie from sexo where CodigoPet=${CodigoPet}",
                null
            )
            if (fila.moveToFirst()) {
                etEspecie.setText(fila.getString(0))
                etnSexo.setText(fila.getString(1))
                etEspecie.setText(fila.getString(1))
                etnHabitada.setText(fila.getString(1))
                baseDeDatos.close()
            } else {
                Toast.makeText(this, "No existe Animales", Toast.LENGTH_SHORT).show()
                baseDeDatos.close()
            }
        } else {
            Toast.makeText(this, "Debes ingresar un codigoPets ", Toast.LENGTH_LONG).show()
        }

    }

    fun modificar(vista: View) {
        //se crea la conexion a las base de datos
        val admin = AdminSQLitePets(this, "Tienda Online", null, 1)
        val baseDeDatos: SQLiteDatabase = admin.writableDatabase

        val Pets = etnPets.text.toString()
        val Especie = etEspecie.text.toString()
        val Sexo = etnSexo.text.toString()
        val Habitada = etnHabitada.text.toString()

        fun eliminar(vista: View) {
            //se crea la conexion a las base de datos
            val admin = AdminSQLitePets(this, "Tienda Online", null, 1)
            val baseDeDatos: SQLiteDatabase = admin.writableDatabase

            val codigo = etnPets.text.toString()

            if (!codigo.isEmpty()) {
                //verificar si esta el codigo del produc
                val cantidad: Int = baseDeDatos.delete("Tienda Online", "codigo=${codigo}", null)
                baseDeDatos.close()
                etnPets.setText("")
                etEspecie.setText("")
                etnSexo.setText("")
                etnHabitada.setText("")

                if (cantidad == 1) {
                    Toast.makeText(this, " Especie eliminado", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "No existe Pets", Toast.LENGTH_SHORT).show()
                    baseDeDatos.close()
                }

            } else {
                Toast.makeText(this, "Debes ingresar un codigoPets", Toast.LENGTH_LONG).show()
            }
        }

        fun siguiente(vista: View) {
            val ventana: Intent = Intent(applicationContext, SharedPreference::class.java)
            startActivity(ventana)
        }


    }
}
