package pl.wspologarniacz.mobile.auth.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.login_fragment.*
import pl.wspologarniacz.mobile.R
import pl.wspologarniacz.mobile.common.repository.model.Done
import pl.wspologarniacz.mobile.common.repository.model.Error
import pl.wspologarniacz.mobile.common.repository.model.Idle
import pl.wspologarniacz.mobile.common.repository.model.InProgress

class LoginFragment : AuthFragment() {


    override fun getLayoutRes() = R.layout.login_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadingState.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Done -> Log.i("xd", "done")
                is Error -> Log.i("xd", "error")
                is InProgress -> Log.i("xd", "inprogress")
                is Idle -> Log.i("xd", "idle")
            }
        })

        reset_password.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_resetPasswordFragment)
        )

        action.setOnClickListener {
            viewModel.login(email_input.text.toString(), password_input.text.toString())
        }
    }


}