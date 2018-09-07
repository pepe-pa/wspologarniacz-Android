package pl.wspologarniacz.mobile.auth.view

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_auth.*
import pl.wspologarniacz.mobile.R
import pl.wspologarniacz.mobile.auth.viewmodel.AuthViewModel
import pl.wspologarniacz.mobile.common.viewmodel.ViewModelFactory
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<AuthViewModel>

    private lateinit var viewModel: AuthViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(AuthViewModel::class.java)

        action_chooser.setOnClickListener {

            val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
            val currentItem = navController.currentDestination?.id

            val id = when (currentItem) {
                R.id.loginFragment -> {
                    switchActionText(R.string.sign_in_chooser_text, R.string.sign_in_text)
                    R.id.action_loginFragment_to_registerFragment
                }
                R.id.registerFragment -> {
                    switchActionText(R.string.sign_up_chooser_text, R.string.sign_up_text)
                    R.id.action_registerFragment_to_loginFragment
                }

                R.id.resetPasswordFragment -> {
                    switchActionText(R.string.sign_in_chooser_text, R.string.sign_in_text)
                    R.id.action_resetPasswordFragment_to_registerFragment
                }
                else -> 0
            }


            Navigation.findNavController(this, R.id.nav_host_fragment).navigate(id)
        }
    }

    private fun switchActionText(actionChooserText: Int, actionChooser: Int) {
        action_chooser_text.setText(actionChooserText)
        action_chooser.setText(actionChooser)
    }
}
