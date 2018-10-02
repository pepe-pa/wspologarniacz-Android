package pl.wspologarniacz.mobile.group.view

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import pl.wspologarniacz.mobile.R

class GroupActivity : DaggerAppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.group_activity)
    }
}