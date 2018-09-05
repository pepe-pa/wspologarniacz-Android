package pl.wspologarniacz.mobile.auth.view

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerAppCompatActivity
import pl.wspologarniacz.mobile.R
import pl.wspologarniacz.mobile.auth.viewmodel.AuthViewModel
import pl.wspologarniacz.mobile.common.viewmodel.ViewModelFactory
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<AuthViewModel>

    private val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(AuthViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        viewModel.login()
    }

}
