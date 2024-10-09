package com.example.hireme.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hireme.R
import com.example.hireme.models.Vacancy

class VacanciesAdapter(private val vacancies: List<Vacancy>, private val onClick: (Vacancy) -> Unit) : RecyclerView.Adapter<VacanciesAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.vacancy_title)
        val city: TextView = view.findViewById(R.id.vacancy_city)
        val company: TextView = view.findViewById(R.id.vacancy_company)
        val experience: TextView = view.findViewById(R.id.vacancy_experience)
        val publishedDate: TextView = view.findViewById(R.id.vacancy_date)
        val applyButton: Button = view.findViewById(R.id.apply_button)
        val favoriteIcon: ImageView = view.findViewById(R.id.favorite_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_vacancy, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val vacancy = vacancies[position]
        holder.title.text = vacancy.title
        holder.city.text = vacancy.address.town
        holder.company.text = vacancy.company
        holder.experience.text = vacancy.experience.previewText
        holder.publishedDate.text = "Опубликовано ${vacancy.publishedDate}"

        // Обработка клика по карточке
        holder.itemView.setOnClickListener { onClick(vacancy) }

        // Обработка клика по избранному
        holder.favoriteIcon.setImageResource(if (vacancy.isFavorite) R.drawable.ic_favorite else R.drawable.ic_favorite_border)
        holder.favoriteIcon.setOnClickListener {
            vacancy.isFavorite = !vacancy.isFavorite
            notifyItemChanged(position)
        }
    }

    override fun getItemCount() = vacancies.size
}
