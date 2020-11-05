package com.example.fitnessapptechugo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessapptechugo.R
import com.example.fitnessapptechugo.data.models.Cupons

class CouponAdapter(private val couponList: ArrayList<Cupons>) :
    RecyclerView.Adapter<CouponAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(coupon: Cupons) {
            val txtCouponTitle = itemView.findViewById<TextView>(R.id.txtCouponTitle)
            val txtCouponDesc = itemView.findViewById<TextView>(R.id.txtCouponDesc)
            val txtCouponRate = itemView.findViewById<TextView>(R.id.txtCouponRate)

            txtCouponTitle.text = coupon.title
            txtCouponDesc.text = coupon.description
            txtCouponRate.text = coupon.price.toString()
        }

    }

    override fun getItemCount(): Int {
        return couponList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItem(couponList[position])
    }


}