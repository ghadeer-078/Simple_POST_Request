package com.example.simple_post_request

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simple_post_request.API.APIClient
import com.example.simple_post_request.API.APIInterface
import com.example.simple_post_request.Model.PeopleDetailed
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewUser : AppCompatActivity() {

    lateinit var name : EditText
    lateinit var savebtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_user)

        name = findViewById(R.id.editText)
        savebtn = findViewById(R.id.button)

        savebtn.setOnClickListener {
            addSingleuser()
        }
    }

    private fun addSingleuser() {

        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
        val progressDialog = ProgressDialog(this@NewUser)
        progressDialog.setMessage("Please wait")
        progressDialog.show()

        if (apiInterface != null) {
            apiInterface.addUser(PeopleDetailed(name.text.toString())).enqueue(object :
                Callback<PeopleDetailed> {
                override fun onResponse(
                    call: Call<PeopleDetailed>,
                    response: Response<PeopleDetailed>
                ) {
                    Toast.makeText(applicationContext, "Save Success!", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss()
                }

                override fun onFailure(call: Call<PeopleDetailed>, t: Throwable) {
                    Toast.makeText(applicationContext, "Error!", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss()

                }
            })
        }

    }

    fun addnew(view: android.view.View) {
        intent = Intent(applicationContext, NewUser::class.java)
        startActivity(intent)
    }

    fun viewusers(view: android.view.View) {
        intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }

}