package com.hmju.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.hmju.presentation.databinding.AMainBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Description : MainActivity
 *
 * Created by juhongmin on 2025. 4. 13.
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: AMainBinding
    private val viewModel: MainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<AMainBinding>(
            this,
            R.layout.a_main
        ).apply {
            lifecycleOwner = this@MainActivity
            reqManager = Glide.with(this@MainActivity)
            vm = viewModel
        }

        with(viewModel) {
            start()
        }
    }
}