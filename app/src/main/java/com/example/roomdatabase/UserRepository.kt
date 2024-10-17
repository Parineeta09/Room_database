package com.example.roomdatabase

class UserRepository(private val userDao: UserDao) {

    fun insertUser(user: User) {
        Thread {
            userDao.insertUser(user)
        }.start()
    }

    fun updateUser(user: User) {
        Thread {
            userDao.updateUser(user)
        }.start()
    }

    fun deleteUser(user: User) {
        Thread {
            userDao.deleteUser(user)
        }.start()
    }

    fun getAllUsers(callback: (List<User>) -> Unit) {
        Thread {
            val users = userDao.getAllUsers()
            callback(users)
        }.start()
    }
}