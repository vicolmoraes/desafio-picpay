package co.idwall.iddog.data

import com.picpay.desafio.android.UserRepository
import org.koin.dsl.module

val userRepositoryModule = module {
 factory { UserRepository() }
}