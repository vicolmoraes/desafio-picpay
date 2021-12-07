package co.idwall.iddog.data

import com.picpay.desafio.android.data.UserRepository
import org.koin.dsl.module

val userRepositoryModule = module {
 factory { UserRepository() }
}