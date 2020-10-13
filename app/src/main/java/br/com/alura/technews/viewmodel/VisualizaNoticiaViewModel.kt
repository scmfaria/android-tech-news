package br.com.alura.technews.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.alura.technews.repository.NoticiaRepository
import br.com.alura.technews.repository.Resource

class VisualizaNoticiaViewModel(
    private val repository: NoticiaRepository,
    id: Long) : ViewModel()  {

    val noticiaEcnontrada = repository.buscaPorId(id)

    fun remove(): LiveData<Resource<Void?>> {
        return noticiaEcnontrada.value?.run { // dentro desse escopo encontra uma noticia que nao é nula
            repository.remove(this)
        } ?: MutableLiveData<Resource<Void?>>().also { // se for nulo vai executar o codigo depois de ?:
            it.value = Resource(null, "Noticia nao encontrada") // essa linha já é o proprio return
        }
    }
}