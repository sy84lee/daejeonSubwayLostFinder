package com.sy.daejeon.finder

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.sy.daejeon.finder.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    lateinit var binding: FragmentDetailBinding
    lateinit var mainActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is MainActivity) mainActivity = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        //Glide.with(mainActivity).load(mainActivity._item?.lostimage).into(binding.imageView)
        binding.textInputEditTextName.setText(mainActivity._item?.name)
        binding.textInputEditTextKeepingplace.setText(mainActivity._item?.keepingplace)
        binding.textInputEditTextPickupdate.setText(mainActivity._item?.pickupdate)
        binding.textInputEditTextPickupplace.setText(mainActivity._item?.pickupplace)
        binding.textInputEditTextRegisterdate.setText(mainActivity._item?.registerdate)
        binding.textInputEditTextStatus.setText(mainActivity._item?.status)
        binding.textInputEditTextComment.setText(mainActivity._item?.comments)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.btnBack.setOnClickListener {
//            mainActivity.goBack()
//        }
    }

}