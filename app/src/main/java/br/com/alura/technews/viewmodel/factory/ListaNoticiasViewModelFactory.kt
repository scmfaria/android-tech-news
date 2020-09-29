package br.com.alura.technews.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.alura.technews.repository.NoticiaRepository
import br.com.alura.technews.viewmodel.ListaNoticiasViewModel

class ListaNoticiasViewModelFactory(
    private val repository: NoticiaRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListaNoticiasViewModel(repository) as T
    }

}