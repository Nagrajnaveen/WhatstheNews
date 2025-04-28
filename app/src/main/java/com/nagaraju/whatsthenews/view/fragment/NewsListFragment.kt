package com.nagaraju.whatsthenews.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.paging.map
import androidx.recyclerview.widget.LinearLayoutManager
import com.nagaraju.whatsthenews.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.nagaraju.whatsthenews.databinding.FragmentNewsListBinding
import com.nagaraju.whatsthenews.view.adapter.NewsListAdapter
import com.nagaraju.whatsthenews.viewmodel.NewsListViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class NewsListFragment : Fragment() {

    private lateinit var binding: FragmentNewsListBinding
    private val viewmodel : NewsListViewModel by viewModel()
    private lateinit var adapter: NewsListAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment using data binding
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = NewsListAdapter()
        binding.recyclerview.layoutManager = LinearLayoutManager(context)
        binding.recyclerview.adapter = adapter

        lifecycleScope.launch {
            viewmodel.newsFlow.collectLatest { pagingData ->
                adapter.submitData(pagingData)
            }

        }
    }



}