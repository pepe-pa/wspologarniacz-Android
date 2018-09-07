package pl.wspologarniacz.mobile.auth.view

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.login_fragment.*
import pl.wspologarniacz.mobile.R

class LoginFragment : AuthFragment() {


    override fun getLayoutRes() = R.layout.login_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        reset_password.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_resetPasswordFragment)
        )
        action.setOnClickListener {
            viewModel.login(email_input.text.toString(), password_input.text.toString())
        }
    }


}