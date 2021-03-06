package co.idwall.iddog.data

import com.picpay.desafio.android.presentation.UsersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val userViewModelModule = module {
    viewModel{ UsersViewModel(get(), get()) }
}