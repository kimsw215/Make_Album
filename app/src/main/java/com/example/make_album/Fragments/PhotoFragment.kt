package com.example.make_album.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.make_album.Adapter.Photo_GridLayoutAdapter
import com.example.make_album.DataVo.DataVo_Photo
import com.example.make_album.databinding.FragmentPhotoBinding

class PhotoFragment: Fragment() {
    // 사진을 전송하기위해서 데이터 바인딩으로 해야함
    private var _binding: FragmentPhotoBinding? = null
    private val binding get() = _binding!!

    // Adapter
    private lateinit var gAdapter: Photo_GridLayoutAdapter

    // gridManager
    private lateinit var gManager: GridLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPhotoBinding.inflate(inflater,container, false)
        val view = binding.root



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initRecycler() {
        gAdapter = Photo_GridLayoutAdapter()
        gManager =
            GridLayoutManager(requireActivity(), RawCount, LinearLayoutManager.HORIZONTAL, false)
        binding.rvList.apply {
            layoutManager = gManager
            adapter = gAdapter
            setHasFixedSize(true)
        }

        gAdapter.notifyDataSetChanged()

        // 사진 클릭시 그 사진을 자세히 보여줄 수 있는 프래그먼트로 이동
        gAdapter.setOnItemClickListener(
            object : Photo_GridLayoutAdapter.OnItemClickListener {
                override fun onItemClick(v: View, data: DataVo_Photo, pos: Int) {
                    val bundle = Bundle()
                    // 그 데이터 보내서 프래그먼트에 네비게이트 해야함
                }
            }
        )
    }

    companion object {
        const val RawCount = 3
    }
}