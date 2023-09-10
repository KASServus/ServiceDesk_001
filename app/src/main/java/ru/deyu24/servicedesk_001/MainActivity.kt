package ru.deyu24.servicedesk_001

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import ru.deyu24.servicedesk_001.dataBase.DbConnect
import ru.deyu24.servicedesk_001.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var textViewList: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        textViewList = binding.textViewList

        // Получение данных из базы данных
        val data = DbConnect()
        val dataList = data.resultData
        // Формирование строки для вывода
        val stringBuilder = StringBuilder()
        for (data in dataList) {
            stringBuilder.append(data).append("\n")
        }

        // Вывод данных в TextView
        textViewList.text = stringBuilder.toString()
        for (data in dataList) {
            stringBuilder.append(data).append("\n")
        }
    }
}
