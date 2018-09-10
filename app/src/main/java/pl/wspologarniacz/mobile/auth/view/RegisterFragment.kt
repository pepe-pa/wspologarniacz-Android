package pl.wspologarniacz.mobile.auth.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.register_fragment.*
import pl.wspologarniacz.mobile.R
import pl.wspologarniacz.mobile.common.repository.model.Done
import pl.wspologarniacz.mobile.common.repository.model.Error
import pl.wspologarniacz.mobile.common.repository.model.Idle
import pl.wspologarniacz.mobile.common.repository.model.InProgress

class RegisterFragment : AuthFragment() {

    override fun getLayoutRes() = R.layout.register_fragment


    private fun openLoginScreen() {
        activity?.let {
            Navigation.findNavController(it, R.id.nav_host_fragment).navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel.loadingState.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Done -> openLoginScreen()
                is Error -> Log.i("xd", "error ${it.throwable.localizedMessage}")
                is InProgress -> Log.i("xd", "inprogress")
                is Idle -> Log.i("xd", "idle")
            }
        })
        return super.onCreateView(inflater, container, savedInstanceState)
    }

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