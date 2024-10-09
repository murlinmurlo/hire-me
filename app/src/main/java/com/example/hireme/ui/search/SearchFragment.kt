package com.example.hireme.ui.search

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hireme.R
import com.example.hireme.models.Address
import com.example.hireme.models.Experience
import com.example.hireme.models.Vacancy


class SearchFragment : Fragment() {

    companion object {
        fun newInstance() = SearchFragment()
    }

    private val viewModel: SearchViewModel by viewModels()
    private lateinit var vacanciesRecycler: RecyclerView
    private lateinit var vacanciesAdapter: VacanciesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        vacanciesRecycler = view.findViewById(R.id.vacancies_recycler)
        vacanciesRecycler.layoutManager = LinearLayoutManager(context)

        // Пример данных
        val vacancies = listOf(
            Vacancy("Программист", Address("Москва"), "Компания А", Experience("2 года"), "01.10", false),
            Vacancy("Дизайнер", Address("Санкт-Петербург"), "Компания Б", Experience("3 года"), "02.10", false),
            Vacancy("Менеджер", Address("Екатеринбург"), "Компания В", Experience("1 год"), "03.10", false)
        )

        vacanciesAdapter = VacanciesAdapter(vacancies) { vacancy ->
            // Обработка клика по вакансии
        }
        vacanciesRecycler.adapter = vacanciesAdapter

        return view
    }
}
