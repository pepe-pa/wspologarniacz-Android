package pl.wspologarniacz.mobile.auth.view

import android.content.Intent
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
import pl.wspologarniacz.mobile.group.view.GroupActivity

class LoginFragment : AuthFragment() {

    private val TAG = "LoginFragment"

    override fun getLayoutRes() = R.layout.login_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadingState.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Done -> openMainActivity()
                is Error -> Log.i(TAG, "error")
                is InProgress -> Log.i(TAG, "inprogress")
                is Idle -> Log.i(TAG, "idle")
            }
        })

        reset_password.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_resetPasswordFragment)
        )

        action.setOnClickListener {
            viewModel.login(email_input.text.toString(), password_input.text.toString())
        }
    }

    private fun openMainActivity() {
        startActivity(Intent(context, GroupActivity::class.java))
    }


}