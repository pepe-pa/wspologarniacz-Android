package pl.wspologarniacz.mobile.auth.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.reset_password_fragment.*
import pl.wspologarniacz.mobile.R
import pl.wspologarniacz.mobile.common.repository.model.Done
import pl.wspologarniacz.mobile.common.repository.model.Error
import pl.wspologarniacz.mobile.common.repository.model.Idle
import pl.wspologarniacz.mobile.common.repository.model.InProgress

class ResetPasswordFragment : AuthFragment() {

    private val TAG = "ResetPasswordFragment"

    override fun getLayoutRes() = R.layout.reset_password_fragment


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadingState.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Done -> openLoginScreen()
                is Error -> Log.e(TAG, "error ${it.throwable.localizedMessage}", it.throwable)
                is InProgress -> Log.i(TAG, "inprogress")
                is Idle -> Log.i(TAG, "idle")
            }
        })

        action.setOnClickListener {
            viewModel.forgotPassword(email_input.text.toString())
        }
    }

    private fun openLoginScreen() {
        activity?.let {
            Navigation.findNavController(it, R.id.nav_host_fragment).navigateUp()
        }
    }
}