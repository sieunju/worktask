package com.hmju.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.hmju.domain.models.MainSectionState
import com.hmju.presentation.databinding.AMainBinding
import com.hmju.presentation.decorations.VerticalLineDecoration
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

        binding.rvContents.addItemDecoration(
            VerticalLineDecoration(
                this,
                setOf(R.layout.vh_section_title_type)
            )
        )

        with(viewModel) {
            uiState.observe(this@MainActivity) {
                if (it is MainSectionState.Error) {
                    showErrorDialog(it)
                }
            }
            start()
        }
    }

    private fun showErrorDialog(state: MainSectionState.Error) {
        AlertDialog.Builder(this)
            .setMessage(state.message)
            .setCancelable(false)
            .setPositiveButton(R.string.txt_confirm, { _, _ ->
                viewModel.start()
            })
            .show()

    }
}