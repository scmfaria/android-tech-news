package br.com.alura.technews.repository

open class Resource<T>(
    val dado: T?,
    val erro: String? = null
)