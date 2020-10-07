package br.com.alura.technews.di

import androidx.room.Room
import br.com.alura.technews.database.AppDatabase
import br.com.alura.technews.database.dao.NoticiaDAO
import br.com.alura.technews.repository.NoticiaRepository
import br.com.alura.technews.retrofit.webclient.NoticiaWebClient
import br.com.alura.technews.viewmodel.FormularioNoticiaViewModel
import br.com.alura.technews.viewmodel.ListaNoticiasViewModel
import br.com.alura.technews.viewmodel.VisualizaNoticiaViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

private const val NOME_BANCO_DE_DADOS = "news.db"

val appModules = module {
    single<AppDatabase> { // sera sempre a mesma instancia
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            NOME_BANCO_DE_DADOS
        ).build()
    }

    single<NoticiaDAO> {
        get<AppDatabase>().noticiaDAO
    }

    single<NoticiaWebClient> {
        NoticiaWebClient()
    }

    single<NoticiaRepository> {
        NoticiaRepository(get(), get())
    }

    viewModel<ListaNoticiasViewModel> {
        ListaNoticiasViewModel(get())
    }

    viewModel<VisualizaNoticiaViewModel> { (id: Long) ->
        VisualizaNoticiaViewModel(get(), id)
    }

    viewModel<FormularioNoticiaViewModel> {
        FormularioNoticiaViewModel(get())
    }
}