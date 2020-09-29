package br.com.alura.technews.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import br.com.alura.technews.model.Noticia
import br.com.alura.technews.repository.NoticiaRepository
import br.com.alura.technews.repository.Resource

class ListaNoticiasViewModel(private val repository: NoticiaRepository) : ViewModel() {

//    LiveData -> dados imutaveis (so acesso a leitura)
//    MutableLiveData -> acesso tanto a leitura quanto a escrita

    fun buscaTodos() : LiveData<Resource<List<Noticia>?>> {
        return repository.buscaTodos()
    }
}