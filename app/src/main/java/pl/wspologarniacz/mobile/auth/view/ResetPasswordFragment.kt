package pl.wspologarniacz.mobile.auth.view

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.reset_password_fragment.*
import pl.wspologarniacz.mobile.R

class ResetPasswordFragment : AuthFragment() {

    override fun getLayoutRes() = R.layout.reset_password_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        action.setOnClickListener {
            viewModel.forgotPassword(email_input.text.toString())
        }
    }
}