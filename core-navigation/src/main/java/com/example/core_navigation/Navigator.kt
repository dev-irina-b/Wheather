package com.example.core_navigation

interface Navigator {
    fun navigate(destination: Destination, popUpTo: Destination? = null, inclusive: Boolean = false)
    fun replaceAll(destination: Destination)
    fun popBack()
}