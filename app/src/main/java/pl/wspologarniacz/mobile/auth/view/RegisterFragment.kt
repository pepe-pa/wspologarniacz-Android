package pl.wspologarniacz.mobile.auth.view

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.register_fragment.*
import pl.wspologarniacz.mobile.R

class RegisterFragment : AuthFragment() {

    override fun getLayoutRes() = R.layout.register_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        action.setOnClickListener {
            viewModel.register(email_input.text.toString(),
                    password_input.text.toString(),
                    username_input.text.toString()
            )
        }
    }
}