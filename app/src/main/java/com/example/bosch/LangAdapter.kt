package com.example.bosch

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//viewholder = visiting cards holder = reserve
class LangAdapter(var languages: Array<String>) : RecyclerView.Adapter<VisitingCardHolder>() {

    var TAG = LangAdapter::class.java.simpleName

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VisitingCardHolder {
        Log.i(TAG,"vignesh - bought a visiting card from market and gave it to nnishant")
        var visitingCard = LayoutInflater.from(parent.context).inflate(R.layout.visiting_card_row,parent,false)
        return VisitingCardHolder(visitingCard)
    }

    override fun getItemCount(): Int {
        Log.i(TAG,"rahul counted --"+languages.size)
        return languages.size
    }

    override fun onBindViewHolder(nishantholder: VisitingCardHolder, position: Int) {
        Log.i(TAG,"chitralekha is writing --"+languages.get(position))
        nishantholder.tvRow.setText(languages.get(position))

    }
}

class VisitingCardHolder(visitingCard: View):RecyclerView.ViewHolder(visitingCard) {
    var tvRow:TextView = visitingCard.findViewById(R.id.tv_vcRow)
    init {
        Log.i("LangAdapter","nishant received the visiting card from vignesh")
    }

}
