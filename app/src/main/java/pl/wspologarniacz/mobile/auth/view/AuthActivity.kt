package pl.wspologarniacz.mobile.auth.view

import android.os.Bundle
import dagger.android.DaggerActivity
import pl.wspologarniacz.mobile.R

class AuthActivity : DaggerActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

    }

}
