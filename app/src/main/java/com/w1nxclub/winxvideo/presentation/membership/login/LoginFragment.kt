package com.w1nxclub.winxvideo.presentation.membership.login

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.w1nxclub.winxvideo.R
import com.w1nxclub.winxvideo.core.base.BaseFragment
import com.w1nxclub.winxvideo.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(
    FragmentLoginBinding::inflate
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnTikla.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_feedFragment)
        }
    }

}