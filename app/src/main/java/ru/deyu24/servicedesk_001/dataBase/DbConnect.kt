package ru.deyu24.servicedesk_001.dataBase

import java.sql.Connection
import java.sql.DriverManager

class DbConnect() {

    val resultData = mutableListOf<String>()
    val dbUrl = "jdbc:postgresql://192.168.0.44:5432/tcn_pg_demo"
    val userName = "postgres"
    val pass = "postgres"
    val sql = "SELECT * FROM tsn_demo.my_books"

    val connection = DriverManager.getConnection(dbUrl, userName, pass)

    val statement = connection.createStatement()
    val resultSet = statement.executeQuery(sql)

    private fun fetchDataFromDataBase(): List<String> {
        while (resultSet.next()) {
            val data = resultSet.getString("id")
            resultData.add(data)
        }
        // Закрытие ресурсов
        resultSet.close()
        statement.close()
        connection.close()

        return resultData
    }



}