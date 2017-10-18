package com.example.denero.ambercard.model

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.denero.ambercard.R
import com.example.denero.ambercard.Repository.POJO.NPagePOJO
import com.example.denero.ambercard.View.PlaceActivity


/**
 * Created by DENERO on 17.10.2017.
 */
class RecyclerAdapter(dataset: NPagePOJO, context: Context): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private var mDataset: NPagePOJO
    private var mContext = context
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var mTextViewTitle: TextView
        var mTextViewDescr:TextView

        init {
            mTextViewTitle = v.findViewById(R.id.point_title)
            mTextViewDescr = v.findViewById(R.id.point_descr)
        }
    }


   init {
        mDataset = dataset
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): RecyclerAdapter.ViewHolder {

        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.point_item, parent, false)



        return ViewHolder(v)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.mTextViewTitle.text = mDataset.points!!.get(position).name
        holder.mTextViewDescr.text = mDataset.points!!.get(position).description
        holder.itemView.setOnClickListener {
            var intent= Intent(mContext,PlaceActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("id",mDataset.points!!.get(position).id)

            (0 until mDataset.categories!!.size).forEach {
               if(mDataset.categories!!.get(it).id == mDataset.points!!.get(position).categoryId!!.get(0))
               {
                   intent.putExtra("picture",mDataset.categories!!.get(it).picture)
                   intent.putExtra("name",mDataset.categories!!.get(it).name)
                   intent.putExtra("icon",mDataset.categories!!.get(it).icon)
               }
            }
            mContext.startActivity(intent)
        }

    }


    override fun getItemCount(): Int {
        if(mDataset.points!!.size!=null)
        return mDataset.points!!.size
        else
            return 10
    }
}