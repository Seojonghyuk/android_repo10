package com.example.intentsevensolutionpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.intentsevensolutionpro.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //1단계 액티비티 전환
        //2단계 데이타 받기 id,pwd
        if(intent.hasExtra("no")){
            when(intent.getIntExtra("no",0)){
                //2단계 데이타 보내기
                0 -> {
                    if (intent.hasExtra("id").equals("") && intent.hasExtra("pwd").equals("") ){
                        Toast.makeText(this,"id와 pwd가 없습니다.",Toast.LENGTH_SHORT).show()
                        finish()
                    }else{
                        val id = intent.getStringExtra("id")
                        val pwd = intent.getStringExtra("pwd")
                        Toast.makeText(this,"${id}와 ${pwd}가 없습니다.",Toast.LENGTH_SHORT).show()
                    }
                }
                //3단계 데이타객체로보내기 (serializable)
                3 ->{
                    val loginData = intent.getSerializableExtra("loginData") as LoginData
                    Toast.makeText(this,"${loginData.id}와 ${loginData.pwd} .",Toast.LENGTH_SHORT).show()
                }
                4 ->{
                    val loginDataParcela = intent.getParcelableExtra<LoginDataParcel>("loginDataParcel",)
                    Toast.makeText(this,"${loginDataParcela?.id}와 ${loginDataParcela?.pwd} .",Toast.LENGTH_SHORT).show()
                }
                5 ->{
                    val loginDataParcelaList = intent.getParcelableArrayListExtra<LoginDataParcel>("loginDataParcelList")
                    Toast.makeText(this,"${loginDataParcelaList?.get(2)?.id}와 ${loginDataParcelaList?.get(2)?.pwd} .",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }//end of onCreate
}